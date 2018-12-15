import parser
import re
import mail
import serial # pip install pyserial
import serial.tools.list_ports
import time
import sys


class GSMModem:
    def __init__(self, config):
        self.config = config
        self.ser = serial.Serial()


        flag = self.connectPhoneWithConfigPort(config["com_port_modem"])
        if flag != 1:
            port = self.auto_finder_ports()
            if port != 0:
                self.connectPhone(port)
            else:
                print("Нет подходящих устройств(модем не подключён или не видит SIM)")
                sys.exit()





    def connectPhone(self,port):
        try:
            self.ser = serial.Serial(port, 38400, timeout=1) # открывакм порт
            time.sleep(0.1)

            self.flushing()
            time.sleep(0.1)

            # self.ser.write(b'ATZ\r') #сброс натроек модема
            # time.sleep(0.5)


            self.ser.write(b'AT+CMGF=1\r') # установка текстового режима режима
            time.sleep(0.1)

            self.ser.write(b'AT+CPMS="ME","ME","ME"\r')  # изменить память для всех секторов
            time.sleep(0.1)
            #print(self.ser.readall().rsplit())


            self.ser.write(b'ATE0\r')  # отключение эхо
            time.sleep(0.1)

            self.ser.write(b'AT^CURC=0\r')  # отключаем отладочные сообщения для Huawei
            time.sleep(0.1)



            self.ser.write(b'AT+CSCS="UCS2"\r\n') # выбираем кодировку близкую к utf-8
            time.sleep(0.1)

        except Exception:
            print("Порт был найден, но не был открыт")
            my_mail = mail.Mail()
            my_mail.send_Mail("Error connect to modem by port")
            my_mail.close_mail()
            sys.exit()



    def disconnectPhone(self):
        self.ser.close()
        time.sleep(1)

    def getLevelSignal(self):
        self.flushing()
        s = self.ser.write(b'AT+CSQ\r') # уровень сигнала модема
        print("Signal: " + str(self.ser.readall().rsplit()))

        self.flushing()
        self.ser.write(b'AT+COPS?\r')     # какой оператор у SIM
        print("Operator: " + str(self.ser.readall().rsplit()))

        self.ser.write(b'AT+CSCA?\r')     # ответ call центра
        self.flushing()
        print("Answer from call-center: " + str(self.ser.readall().rsplit()))

        self.ser.write(b'AT+CREG?\r')  # регистрация в сети
        self.flushing()
        print("Reg in network: " + str(self.ser.readall().rsplit()))

    def receiveSMS(self):
        self.flushing()

        time.sleep(0.3)
        self.ser.write(b'AT+CMGL="ALL"\r\n') # чтение СМС
        data = self.ser.readall().decode()
        if data.find("OK") == -1:
             print("ОШИБКА: Модем не видит SIM")
        else:
            data = re.sub('\r', '', data)
            data = data.split(',')
            if len(data) == 1:
                print("Новых сообщениий нет")
            else:
                par = parser.Parser().parser_reseiveSMS_Read(data, self.config)
                self.delete_SMS()


    def flushing(self):
        self.ser.flushInput()
        self.ser.flushOutput()

    def delete_SMS(self):
        self.flushing()
        self.ser.write(b'AT+CMGD=0,1\r\n')  # удаление всех смс , сначала перевести в PDU режим.
        #print(self.ser.readall().rsplit())




    def section_SMS(self):
        # Секции хранения СМС
        # - первая для просмотра, чтения и удаления сообщений
        # - вторая для сохранения и отправки исходящия сообщений
        # - третья для только что полученных  сообщений
        time.sleep(1)
        self.flushing()
        time.sleep(1)
        #self.ser.write(b'AT+CPMS="ME","ME","ME"\r')  # изменить память для всех секторов
        self.ser.write(b'AT+CPMS?\r') # какую память(SIM или модема) используют сектора (SM - SIM, ME - modem, MT - SM+ME)

        print(self.ser.readall().rsplit())



    def auto_finder_ports(self):
        ports = list(serial.tools.list_ports.comports())
        print(ports)

        if len(ports) == 0:
            print("Система не обнаружила доступные COM - порты")
            # отправка на мыло
            sys.exit()
        else:
            for p in ports:
                ser = serial.Serial()
                ser.port = p.device
                print(p.device)
                ser.baudrate = 38400
                ser.timeout = 1
                try:
                    ser.open()
                    if ser.isOpen():
                        print("Посылка команд на порту: "+p.device)
                        ser.flushInput()
                        ser.flushOutput()
                        ser.write(b'AT\r')
                        if ser.readall().decode().find("OK") != -1:
                            ser.write(b'ATE0\r')  # отключение эхо
                            time.sleep(0.2)

                            print("Порт содержит AT модем " + p.device)
                            ser.flushInput()
                            ser.flushOutput()
                            ser.write(b'AT+CIMI\r')
                            buf = ser.readall().decode()
                            if buf.find("OK") != -1:
                                print("Модем содержит SIM " + p.device)
                                buf = buf.split()
                                print (buf[0])
                                print (self.config["sim_IMSI"])
                                if buf[0] == self.config["sim_IMSI"]:
                                    print("IMSI  SIM на" + p.device + " " + buf[0])
                                    ser.close()
                                    return p.device
                            ser.close()
                        ser.close()
                except:
                    print("Порт занят " + p.device)


        return 0


    def connectPhoneWithConfigPort(self,port):
        self.ser.port = port
        print(port)
        self.ser.baudrate = 38400
        self.ser.timeout = 1
        try:
            self.ser.open()
            if self.ser.isOpen():
                print("Посылка команд на порту: " + port)
                self.ser.flushInput()
                self.ser.flushOutput()
                self.ser.write(b'AT\r')
                time.sleep(0.05)
                if self.ser.readall().decode().find("OK") != -1:
                    self.ser.write(b'ATE0\r')  # отключение эхо
                    time.sleep(0.2)

                    print("Порт содержит AT модем " + port)
                    self.ser.flushInput()
                    self.ser.flushOutput()
                    self.ser.write(b'AT+CIMI\r')
                    buf = self.ser.readall().decode()
                    if buf.find("OK") != -1:
                        print("Модем содержит SIM " + port)
                        buf = buf.split()
                        print(buf[0])
                        print(self.config["sim_IMSI"])
                        if buf[0].find(self.config["sim_IMSI"]) != -1:
                            self.flushing()
                            time.sleep(0.1)

                            self.ser.write(b'AT+CMGF=1\r')  # установка текстового режима режима
                            time.sleep(0.1)

                            self.ser.write(b'AT+CPMS="ME","ME","ME"\r')  # изменить память для всех секторов
                            time.sleep(0.1)
                            #print(self.ser.readall().rsplit())

                            self.ser.write(b'AT+CSCS="UCS2"\r\n')  # выбираем кодировку близкую к utf-8
                            time.sleep(0.1)

                            self.ser.write(b'AT^CURC=0\r')  # отключаем отладочные сообщения для Huawei
                            time.sleep(0.1)
                            return 1
                    self.ser.close()
                self.ser.close()
        except:
            print("К порту по умолчанию не удалось подключиться(занят или отсутствует) " + port)
            self.ser = serial.Serial()

        return 0










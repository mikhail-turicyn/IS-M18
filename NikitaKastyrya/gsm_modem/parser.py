import re
import file_work
#from config import config


class Parser:

    def __init__(self):
        self.number = ''
        self.date = ''
        self.message = ''


    def parser_reseiveSMS_Read(self, data, config):
            countSMS = ((len(data) - 6) / 5) + 1
            for i in range(0,int(countSMS)):
                self.number = re.sub('"', '', data[2 + 5*i])
                self.number = self.decode_SMS(self.number)
                #print("from: " + self.number )

                buf = data[5 + 5*i].split('\n')
                self.message = self.decode_SMS(buf[1])
                #print("message: " + self.message)

                self.date = data[4 + 5*i] + " " + buf[0]
                self.date = re.sub('"', '', self.date)
                #print("date: " + self.date)

                self.write_in_file(config["path_common_log_file"],config)


                flag = 1
                if flag:
                    for j in config["words_security"]:
                        if self.message.lower().find(j) != -1:
                            self.write_in_file(config["path_security_log_file"],config)
                            flag = 0
                            break

                if flag:
                    for j in config["words_fire"]:
                        if self.message.lower().find(j) != -1:
                            self.write_in_file(config["path_fire_log_file"],config)
                            flag = 0
                            break
                if flag:

                    for j in config["words_autotest"]:
                        if self.message.lower().find(j) != -1:
                            self.write_in_file(config["path_autotest_log_file"],config)
                            flag = 0
                            break

                if flag:
                    for key, value in config["words_electro"].items():
                        if self.message.lower().find(key) != -1:
                            self.message = str(value)
                            self.write_in_file(config["path_electro_log_file"],config)
                            break




                #print("\n")


    def decode_SMS(self,txt):
        return ''.join(chr(int(txt[i:i + 4], 16)) for i in range(0, len(txt), 4))

    def write_in_file(self, path, config):
        try:
            fw = file_work.FileWork(path)
            fw.writeInFile(self.date + '  '+ self.number + '  '+config["sim_number"] + '  ' + self.message + '\n')
            fw.closenFile()
        except:
            print("Запись в файл не была произведена: " + path )


import datetime
d = datetime.datetime.now()

# настройки модема
com_port_modem = '/dev/ttyACM1'         # порт подключения модема
sim_IMSI = '250015892016662'                   # уникальный идентифитаро SIM
sim_number = "+79105901064"

# пути к файлам
path_common_log_file = "G:\\ModemBase\\"+str(d.year)+"_"+sim_number+"_"+"_SMS_ALL.txt"
path_security_log_file = "G:\\ModemBase\\"+str(d.year)+"_"+sim_number+"_"+"_SMS_AOS.txt"
path_fire_log_file = "G:\\ModemBase\\"+str(d.year)+"_"+sim_number+"_"+"_SMS_APS.txt"
path_autotest_log_file = "G:\\ModemBase\\"+str(d.year)+"_"+sim_number+"_"+"_SMS_AUTOTEST.txt"
path_electro_log_file = "G:\\ModemBase\\"+str(d.year)+"_"+sim_number+"_"+"_SMS_ELECTRO.txt"

# эталонные слова для парсера
words_security = ['злодей', 'постановка', 'взлом', 'снятие']
words_fire = ['пожар','задымление']
words_autotest = ['автотест']
words_electro = {'основное': 1, 'резервное': 0}

# настройки для почты
sender_e_mail = 'kastyrya@rpatyphoon.ru'              # отправитель e-mail
recipient_e_mail = 'kastyrya@rpatyphoon.ru'           # получатель e-mail






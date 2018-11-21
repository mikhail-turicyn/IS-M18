import smtplib
import datetime
import config
class Mail:
    def __init__(self):
        try:
            # self.server = poplib.POP3('mail.typhoon.lan', '110')
            # self.server.user("op")
            # self.server.pass_("lamb)9")
            self.server = smtplib.SMTP('mail.typhoon.lan', '25')
            self.server.connect('mail.typhoon.lan', '25')
        except:
            print("Не удалось подключиться к серверу почты")


    def send_Mail(self, e_message):
        try:
            sent_from = config.sender_e_mail
            to = config.recipient_e_mail
            date = datetime.datetime.now().strftime( "%d/%m/%Y %H:%M" )
            msg = "From: %s\nTo: %s\nSubject: %s\nDate: %s\n\n%s"%(sent_from, to, "Modem Error", date, e_message)
            self.server.sendmail(sent_from, to, msg)
            print('Сообщение отправлено')
        except:
            print('Сообщение не отправлено')

    def close_mail(self):
        try:
            self.server.close()
        except:
            print('Сервер почты не был открыт')









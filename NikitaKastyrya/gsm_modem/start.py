#!/usr/bin/env python
import gsm_modem as GSM_M

#запуск программы
if __name__ == '__main__':
    config = {}
    exec(open(("config.py"), encoding='utf8').read(), config)

    sms = GSM_M.GSMModem(config)
    #sms.connectPhone('COM5')
    #sms.sendMessage()
    #sms.getLevelSignal()
    sms.receiveSMS()
    #sms.delete_SMS()
    #sms.section_SMS()

    #sms.auto_finder_ports()

    sms.disconnectPhone()

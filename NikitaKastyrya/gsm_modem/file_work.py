

class FileWork:
    def __init__(self,path):
        self.f = open(path, 'a')

    def writeInFile(self,data):
        self.f.write(data)

    def closenFile(self):
        self.f.close()


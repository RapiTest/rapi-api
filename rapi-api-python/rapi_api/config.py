import json

def createConfig(filePath):
    with open(filePath) as f:
        data = json.load(f)
    return Config(data["input"], data["play"], data["webdriver"], data["report"])


class Config:
    def __init__(self, input, play, webdriver, report):
        self.__config = {}
        self.__config['input'] = input
        self.__config['play'] = play
        self.__config['report'] = report
        self.__config['webdriver'] = webdriver

    def toStr(self):
        return json.dumps(self.__config)

    def getReportType(self):
        return self.__config["report"]["type"]

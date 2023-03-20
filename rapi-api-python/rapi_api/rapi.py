from .config import Config
from .proc import RapiProc
import sys
import json


class RapiReport:
    def __init__(self, jsonData, htmlData) -> None:
        self.json: dict = json.loads(jsonData)
        self.html: str = htmlData

class Rapi:
    def __init__(self,  runnerPath: str, config: Config):
        self.__config = config
        self.runnerPath = runnerPath

    def run(self) -> RapiReport:
        """The function will run the test depend on the config you set, after finish the test it will pass the report back

        Returns:
            RapiReport: The test report
        """
        service = RapiProc(self.runnerPath)
        data = service.run(self.__config)
        if data["status"] != 0:
            print(data["err"], file=sys.stderr)
        report = self.__parseReport(data["out"])
        return report

    def __parseReport(self, report: str) -> RapiReport:
        jsonStartToken = "INFO Start to send json report to api\n"
        jsonEndToken = "INFO End of sending json report to api\n"
        htmlStartToken = "INFO Start to send html report to api\n"
        htmlEndToken = "INFO End of sending html report to api\n"
        reportType = self.__config.getReportType()
        htmlReport = None
        jsonReport = None
        if reportType == "json" or reportType == "all":
            jsonReport = report[report.find(jsonStartToken) +
                                len(jsonStartToken):report.rfind(jsonEndToken)]
        if reportType == "html" or reportType == "all":
            htmlReport = report[report.find(htmlStartToken) +
                                len(htmlStartToken):report.rfind(htmlEndToken)]
        return RapiReport(jsonReport, htmlReport)



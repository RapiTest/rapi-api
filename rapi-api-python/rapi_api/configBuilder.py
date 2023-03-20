from enum import Enum
from .config import Config


class PlaybackType(int, Enum):
    PLAY_CASE = 0
    PLAY_SUITE = 1,
    PLAY_ALL_SUITES = 2


class SnapshotStatus(int, Enum):
    NO_SNAPSHOT = 0
    SNAPSHOT_ON_ERRORS = 1,
    ALWAYS_SNAPSHOT = 2


class Status(int, Enum):
    NO_SENDING = 0
    SENDING_ON_ERRORS = 1,
    ALWAYS_SENDING = 2


DEFAULFREPORT = {
    "type": "json",
    "snapshot": SnapshotStatus.NO_SNAPSHOT.value,
}


class ConfigBuilder:
    def __init__(self) -> None:
        self.__input = {}
        self.__play = {}
        self.__report = DEFAULFREPORT
        self.__webdriver = {"configs": [], "i18n": {}}

    def setPlay(self, mode=None, speed=None, entry=None, autoWaitTimeout=None, period=None, noLog=None):
        """Set play config

        Args:
            mode (int, optional): The mode of playback. 
            speed (int, optional): The speed of the playback. 
            entry (string, optional): The entry test case or test suite when running. 
            If mode=0, this field should be set to a full name of test case, e.g. testsuite1.testcase1. 
            If mode=1, this field should be set to a test suite, e.g. testsuite2. 
            If mode=2, this field will be ignored. 
            autoWaitTimeout (int, optional): The timeout before executing the next command. 
            period (dict, optional): The duration and the maximum number of times of the periodical running. 
            noLog (bool, optional): Set to true to disable the log.. 

        Returns:
            ConfigBuilder: The object itself
        """
        if (mode is not None):
            self.__play['mode'] = mode
        if (speed is not None):
            self.__play['speed'] = speed
        if (entry is not None):
            self.__play['entry'] = entry
        if (autoWaitTimeout is not None):
            self.__play['mode'] = autoWaitTimeout
        if (period is not None):
            self.__play['period'] = period
        if (noLog is not None):
            self.__play['noLog'] = noLog
        return self

    def setTestSuites(self, testSuites: list):
        """Set the file paths to the test suites

        Args:
            testSuites (list): A string path array

        Returns:
            ConfigBuilder: The object itself
        """
        self.__input['testSuites'] = testSuites
        return self

    def setVariables(self, variables: list):
        """Set the file paths to the variable files. Only accept json and csv files.

        Args:
            variables (list): A string array

        Returns:
            ConfigBuilder: The object itself
        """
        self.__input['variables'] = variables
        return self

    def setDataDriven(self, dataDriven: list):
        """Set the file paths to the dataDriven files.

        Args:
            dataDriven (list): A string array

        Returns:
            ConfigBuilder: The object itself
        """
        self.__input['dataDriven'] = dataDriven
        return self

    def setReport(self, snapshot=None, snapshotQuality=None, type: SnapshotStatus = None):
        """Set the Report

        Args:
            snapshot (int, optional): Playback with snapshots. 0: No snapshot (default). 1: Capture snapshots on errors. 2: Always capture snapshots  
            snapshotQuality (int, optional):Snapshot quality ranging from 1 to 100. 100 is the highest quality. A higher quality value will require more disk space.
            type (SnapshotStatus, optional): The type of the test report. 

        Returns:
            ConfigBuilder: The object itself
        """
        if (snapshot is not None):
            self.__report['snapshot'] = snapshot
        if (snapshotQuality is not None):
            self.__report['snapshotQuality'] = snapshotQuality
        if (type is not None):
            self.__report['type'] = type.value
        return self

    def setWebdriverI18n(self, i18n):
        """Language codes and files paths. All the language codes can be
        found in the Option page of SideeX Recorder. All the languages
        set here will be run in order. See Internationalization (i18n)
        Testing Using SideeX for more information.

        Args:
            i18n (dict): _description_

        Returns:
            ConfigBuilder: The object itself
        """
        self.__webdriver['i18n'] = i18n
        return self

    def setWebdriverConfig(self, webdriverConfig: list):
        """Set the server information to run on.

        Args:
            webdriverConfig (list): 

        Returns:
            ConfigBuilder: The object itself
        """
        self.__webdriver['configs'] = webdriverConfig
        return self

    def addBrowser(self, serverUrl: str, capability: dict, type: str = "selenium", keepSessionAlive: bool = False):
        """Add the webdriver information to run on

        Args:
            serverUrl (str): The URL of the WebDriver server.
            capability (dict): Capability follow W3C WebDriver Capability spec.
            type (str, optional): The type of the WebDriver server. Defaults to "selenium".
            keepSessionAlive (bool, optional): Set true to keep the webdriver sessionId alive.

        Returns:
            ConfigBuilder: The object itself
        """
        self.__webdriver["configs"].append({
            "serverUrl": serverUrl,
            "type": type,
            "browsers": [
                {
                    "active": True,
                    "capability": capability,
                    "keepSessionAlive": keepSessionAlive,
                }
            ]
        })
        return self

    def addSessions(self, serverUrl: str, sessionId: str, type: str = "selenium", keepSessionAlive: bool = False):
        """Add the webdriver information to run on

        Args:
            serverUrl (str): The URL of the WebDriver server.
            sessionId (str): The existed session id on the webdriver.
            type (str, optional): The type of the WebDriver server. Defaults to "selenium".
            keepSessionAlive (bool, optional): Set true to keep the webdriver sessionId alive.

        Returns:
            ConfigBuilder: The object itself
        """
        self.__webdriver["configs"].append({
            "serverUrl": serverUrl,
            "type": type,
            "sessions": [
                {
                    "sessionId": sessionId,
                    "keepSessionAlive": keepSessionAlive,
                }
            ]
        })
        return self

    def build(self) -> Config:
        return Config(input=self.__input, play=self.__play, report=self.__report, webdriver=self.__webdriver)

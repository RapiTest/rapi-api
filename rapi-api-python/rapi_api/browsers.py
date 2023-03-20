class Browser():
    FIREFOX = {
        "active": True,
        "capability": {
            "browserName": "firefox",
        },
        "keepSessionAlive": False,
    }

    EDGE = {
        "active": True,
        "capability": {
            "browserName": "MicrosoftEdge",
        },
        "keepSessionAlive": False,
    }

    CHROME = {
        "active": True,
        "capability": {
            "browserName": "chrome",
        },
        "keepSessionAlive": False,
    }

    SAFARI = {
        "active": True,
        "capability": {
            "browserName": "safari",
            "platformName": "mac",
        },
        "keepSessionAlive": False,
    }

import rapi_api
from rapi_api import ConfigBuilder, Rapi
config = ConfigBuilder()    \
    .setTestSuites(["test1.json"])   \
    .addBrowser("http://localhost:4444", {
        "browserName": "firefox",
    }).build()

rapi = Rapi(
    "../../rapi-runner/rapi-runner-linux", config)
report = rapi.run()
print(report.json)

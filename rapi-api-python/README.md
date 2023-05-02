# rapi-api-nodejs
## Quick Start
```python 
import rapi_api
from rapi_api import ConfigBuilder, Rapi
config = ConfigBuilder()    \
    .setTestSuites(["test1.json"])   \
    .addBrowser("http://url.to.selenium.server", {
        "browserName": "firefox",
    }).build()

rapi = Rapi(
    "path/to/rapi/runner", config)
report = rapi.run()
print(report.json)
```
## Documentation
[Python](https://hackmd.io/@Rapi/BJins7t72)
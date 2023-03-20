# rapi-api-java
## Quick Start
```java
Config config = new Config();
ArrayList<String> testSuites = new ArrayList<>();
testSuites.add("path/to/testSuites");
config.getInput().setTestSuites(testSuites);

Browser browser = new Browser();
Map<String, Object> caps = new HashMap<>();
caps.put("browserName", "firefox");
browser.setCapability(caps);
ArrayList<Browser> browsers = new ArrayList<Browser>();
browsers.add(browser);
WebDriverConfig webDriverConfig = new WebDriverConfig();
webDriverConfig.setBrowsers(browsers);
webDriverConfig.setServerUrl("http://url.to.selenium.server");
ArrayList<WebDriverConfig> webDriverConfigs = new ArrayList<WebDriverConfig>();
webDriverConfigs.add(webDriverConfig);

config.getInput().setTestSuites(testSuites);
config.getWebdriver().setConfigs(webDriverConfigs);

Rapi rapi = new Rapi("path/to/rapi/runner", config);
RapiReport report = rapi.run();
System.out.println(report.getJson());
```
## Documentation
[Java]()
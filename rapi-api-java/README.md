# rapi-api-java
## Quick Start
```java
                ArrayList<String> testSuites = new ArrayList<>();
                testSuites.add("src/test/java/io/rapi/api/test1.json");
                Input input = Input.builder().withTestSuites(testSuites).build();

                Map<String, Object> caps = new HashMap<>();
                caps.put("browserName", "firefox");
                ArrayList<WebDriverCommonConfig> service = new ArrayList<WebDriverCommonConfig>();
                service.add(
                                WebDriverBrowserConfig.builder()
                                                .withBrowsers(Browser.builder().withCapability(caps).build())
                                                .withServerUrl("http://127.0.0.1:4444").build());

                Config config = Config.builder().withInput(input)
                                .withWebdriver(WebDriver.builder().withConfigs(service).build()).build();
                System.out.println(config.toString());
                Rapi rapi = new Rapi("../rapi-runner/rapi-runner-linux", config);
                RapiReport report = rapi.run();
                System.out.println(report.getJson());
```
## Documentation
[Java]()
package io.github.rapitest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.github.rapitest.config.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws Exception
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException, InterruptedException, Exception
    {
        ArrayList<String> testSuites = new ArrayList<>();
        testSuites.add("src/test/java/io/github/rapitest/test1.json");
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
        Rapi rapi = new Rapi("/home/fourcolor/Documents/rapi/rapi-runner-linux", config);
        RapiReport report = rapi.run();
        System.out.println(report.getJson());
    }
}

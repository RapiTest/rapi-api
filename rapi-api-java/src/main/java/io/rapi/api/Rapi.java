package io.rapi.api;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.rapi.api.config.Browser;
import io.rapi.api.config.Config;
import io.rapi.api.config.WebDriverConfig;

public class Rapi {
    private Config config;
    private String runnerPath;

    /**
     * 
     * @param runnerPath The rapi runner file path
     * @param config     The config about input, report, play, webdricer setting
     */
    public Rapi(String runnerPath, Config config) {
        this.runnerPath = runnerPath;
        this.config = config;
    }

    /**
     * The function will run the test depend on the config you set, after finish the
     * test it will pass the report back
     * 
     * @return RapiReport
     * @throws IOException
     * @throws InterruptedException
     * @throws Exception
     */
    public RapiReport run() throws IOException, InterruptedException, Exception {
        Proc proc = new Proc(runnerPath);
        ProcResult result = proc.run(config.toString());
        System.err.println(result.getStderr());
        return new RapiReport(result.getStdout(), config.getReport().getType());
    }
}

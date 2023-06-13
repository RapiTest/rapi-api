package io.github.rapitest;

import java.io.IOException;
import io.github.rapitest.config.Config;

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

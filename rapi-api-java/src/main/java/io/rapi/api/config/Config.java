package io.rapi.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {
    private Input input = new Input();
    private Report report = new Report();
    private WebDriver webdriver = new WebDriver();
    private Play play = new Play();

    public Config() {
    }

    public Config(Input input, Report report, WebDriver webdriver, Play play) {
        this.setInput(input);
        this.setPlay(play);
        this.setReport(report);
        this.setWebdriver(webdriver);
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void setWebdriver(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public Input getInput() {
        return input;
    }

    public Report getReport() {
        return report;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public Play getPlay() {
        return play;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

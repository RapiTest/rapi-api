package io.rapi.api.config;

import java.util.ArrayList;

public class WebDriverConfig {
    private String type = "selenium";
    private String serverUrl = "";
    private ArrayList<Browser> browsers = new ArrayList<Browser>();
    private ArrayList<Session> sessions = new ArrayList<Session>();

    /**
     * @param browsers
     */
    public void setBrowsers(ArrayList<Browser> browsers) {
        this.browsers = browsers;
    }

    /**
     * @param serverUrl The URL of the WebDriver server.
     */
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    /**
     * @param sessions
     */
    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    /**
     * @param type The type of the WebDriver server.
     */
    public void setType(String type) {
        if (type.equals("selenium") || type.equals("appium"))
            this.type = type;
        else {
            throw new Error("Unknown support webDriver config type " + type);
        }
    }

    /**
     * @return ArrayList<Browser>
     */
    public ArrayList<Browser> getBrowsers() {
        return browsers;
    }

    /**
     * @return String
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * @return ArrayList<Session>
     */
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    /**
     * @return String
     */
    public String getType() {
        return type;
    }
}

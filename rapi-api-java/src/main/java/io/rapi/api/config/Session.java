package io.rapi.api.config;

public class Session {
    private String sessionId = "";
    private boolean keepSessionAlive = false;

    /**
     * @param keepSessionAlive Set true to keep the webdriver sessionId alive.
     * @return
     */
    public void setKeepSessionAlive(boolean keepSessionAlive) {
        this.keepSessionAlive = keepSessionAlive;
    }

    /**
     * @param sessionId The existed session id on the webdriver.
     * @return
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @return
     */
    public boolean getKeepSessionAlive() {
        return keepSessionAlive;
    }
}

package io.rapi.api.config;

import java.util.Collections;
import java.util.Map;

public class Browser {
    private final boolean active = true;
    private boolean keepSessionAlive = false;
    private Map<String, Object> capability = Collections.emptyMap();

    /**
     * @param capability Capability follow W3C WebDriver Capability spec.
     */
    public void setCapability(Map<String, Object> capability) {
        this.capability = capability;
    }

    /**
     * @param keepSessionAlive Set true to keep the webdriver sessionId alive.
     */
    public void setKeepSessionAlive(boolean keepSessionAlive) {
        this.keepSessionAlive = keepSessionAlive;
    }

    /**
     * @return Map<String, Object>
     */
    public Map<String, Object> getCapability() {
        return capability;
    }

    /**
     * @return boolean
     */
    public boolean getKeepSessionAlive() {
        return keepSessionAlive;
    }
}

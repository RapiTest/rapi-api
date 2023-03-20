package io.rapi.api.config;

public class Play {
    private int mode = 2;
    private String entry = "";
    private int autoWaitTimeout = 30;
    private int speed = 5;
    private Period period = new Period();

    /**
     * @param autoWaitTimeout The timeout before executing the next command.
     */
    public void setAutoWaitTimeout(int autoWaitTimeout) {
        this.autoWaitTimeout = autoWaitTimeout;
    }

    /**
     * @param entry The entry test case or test suite when running.
     *              If mode=0, this field should be set to a full name of test case,
     *              e.g. testsuite1.testcase1.
     *              If mode=1, this field should be set to a test suite, e.g.
     *              testsuite2.
     *              If mode=2, this field will be ignored.
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }

    /**
     * @param mode The mode of playback.
     */
    public void setMode(int mode) {
        if (mode >= 0 || mode <= 2)
            this.mode = mode;
        else {
            throw new Error("Unknown mode value " + mode);
        }
    }

    /**
     * @param period
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

    /**
     * @param speed The speed of the playback. 5 is the fast speed.
     */
    public void setSpeed(int speed) {
        if (speed >= 0 || speed <= 5)
            this.speed = speed;
        else {
            throw new Error("Unknown speed value " + speed);
        }
    }

    /**
     * @return int
     */
    public int getAutoWaitTimeout() {
        return autoWaitTimeout;
    }

    /**
     * @return String
     */
    public String getEntry() {
        return entry;
    }

    /**
     * @return int
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return Period
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * @return int
     */
    public int getSpeed() {
        return speed;
    }
}

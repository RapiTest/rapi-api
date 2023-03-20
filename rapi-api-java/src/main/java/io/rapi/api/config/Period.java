package io.rapi.api.config;

public class Period {
    private int time = -1;
    private int maxNum = 1;

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getTime() {
        return time;
    }
}

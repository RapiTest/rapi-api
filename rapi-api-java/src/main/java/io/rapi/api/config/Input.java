package io.rapi.api.config;

import java.util.ArrayList;

public class Input {
    private ArrayList<String> testSuites = new ArrayList<String>();
    private ArrayList<String> variables = new ArrayList<String>();
    private ArrayList<String> dataDriven = new ArrayList<String>();

    /**
     * Set the file paths to the test suites
     * 
     * @param testSuites A string array
     */
    public void setTestSuites(ArrayList<String> testSuites) {
        this.testSuites = testSuites;
    }

    /**
     * Set the file paths to the variable files. Only accept json and csv files.
     * 
     * @param variables A string array
     */
    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }

    /**
     * Set the file paths to the dataDriven files.
     * 
     * @param dataDriven A string array
     */
    public void setDataDriven(ArrayList<String> dataDriven) {
        this.dataDriven = dataDriven;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getDataDriven() {
        return dataDriven;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getTestSuites() {
        return testSuites;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getVariables() {
        return variables;
    }
}

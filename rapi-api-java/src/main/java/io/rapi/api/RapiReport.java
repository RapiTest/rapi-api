package io.rapi.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.JsonNode;

public class RapiReport {
    private JsonNode json;
    private String html;

    RapiReport(String stdout, String reportType) throws JsonProcessingException {
        parseReport(stdout, reportType);
    }

    private void parseReport(String input, String reportType) throws JsonProcessingException {
        String jsonStartToken = "INFO Start to send json report to api";
        String jsonEndToken = "INFO End of sending json report to api";
        String htmlStartToken = "INFO Start to send html report to api";
        String htmlEndToken = "INFO End of sending html report to api";
        if (reportType == "all" || reportType == "json") {
            int start = input.indexOf(jsonStartToken) + jsonStartToken.length();
            int end = input.indexOf(jsonEndToken, start);
            if (start != -1) {
                String jsonStr = input.substring(start, end);
                ObjectMapper objectMapper = new ObjectMapper();
                this.json = objectMapper.readTree(jsonStr.toString());
            } else {
                this.json = null;
            }
        }
        if (reportType == "all" || reportType == "html") {
            int start = input.indexOf(htmlStartToken) + htmlStartToken.length();
            int end = input.indexOf(htmlEndToken, start);
            if (start != -1) {
                String htmlStr = input.substring(start, end);
                this.html = htmlStr;
            } else {
                this.html = null;
            }
        }
    }

    public JsonNode getJson() {
        return json;
    }

    public String getHtml() {
        return html;
    }
}

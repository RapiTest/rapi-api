package io.rapi.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Config {
    @Builder.Default
    private Input input = new Input();
    @Builder.Default
    private Report report = new Report();
    @Builder.Default
    private WebDriver webdriver = new WebDriver();
    @Builder.Default
    private Play play = new Play();

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

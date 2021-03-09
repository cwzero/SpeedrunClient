package com.liquidforte.speedrun.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class User {
    private String id;
    private String name;
    private String pronouns;
    private String weblink;
    private String role;
    private Date signup;
    private String country;

    @JsonProperty("names")
    private void setNames(Map<String, String> names) {
        name = names.get("international");
    }

    @JsonProperty("location")
    @SuppressWarnings("unchecked")
    private void setLocation(Map<String, Object> location) {
        if (location != null && location.containsKey("country")) {
            Map<String, Object> c = (Map<String, Object>) location.get("country");
            Map<String, String> names = (Map<String, String>) c.get("names");
            country = names.get("international");
        }
    }
}

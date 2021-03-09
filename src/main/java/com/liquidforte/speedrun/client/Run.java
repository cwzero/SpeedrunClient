package com.liquidforte.speedrun.client;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Run {
    private String id;
    private String weblink;
    private String game;
    private String level;
    private String category;
    private String comment;
    private Date date;
    private Date submitted;
    private List<Link> players = new ArrayList<>();
    private Times times;
    private boolean verified = false;
    private String platform;
    private boolean emulated = false;

    private void setSystem(Map<String, Object> system) {
        this.platform = (String) system.get("platform");
        this.emulated = (Boolean) system.get("emulated");
    }

    private void setStatus(Map<String, Object> status) {
        verified = status.containsKey("status") && status.get("status").equals("verified");
    }

    public String getPlayer() {
        return players.stream().filter(it -> it.getRel().equals("user")).findFirst().map(it -> it.getId()).orElse("");
    }
}

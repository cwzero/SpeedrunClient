package com.liquidforte.speedrun.client;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs2.JAXRSClient;
import feign.slf4j.Slf4jLogger;

public class SpeedrunClient {
    private Speedrun api;

    public Speedrun getApi() {
        if (api == null) {
            api = Feign.builder()
                    .client(new JAXRSClient())
                    .logger(new Slf4jLogger(Speedrun.class))
                    .logLevel(Logger.Level.FULL)
                    .decoder(new JacksonDecoder())
                    .encoder(new JacksonEncoder())
                    .target(Speedrun.class, "https://www.speedrun.com/api/v1");
        }

        return api;
    }
}

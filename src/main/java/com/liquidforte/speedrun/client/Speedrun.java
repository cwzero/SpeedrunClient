package com.liquidforte.speedrun.client;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface Speedrun {
    @RequestLine("GET /runs")
    Wrapper<List<Run>> getRuns();

    @RequestLine("GET /runs?offset={offset}")
    Wrapper<List<Run>> getRuns(@Param("offset") long offset);

    @RequestLine("GET /runs/{id}")
    Wrapper<Run> getRun(@Param("id") String id);

    @RequestLine("GET /users")
    Wrapper<List<User>> getUsers();

    @RequestLine("GET /users?offset={offset}")
    Wrapper<List<User>> getUsers(@Param("offset") long offset);

    @RequestLine("GET /users/{id}")
    Wrapper<User> getUser(@Param("id") String id);

    @RequestLine("GET /games")
    Wrapper<List<Game>> getGames();

    @RequestLine("GET /games?offset={offset}")
    Wrapper<List<Game>> getGames(@Param("offset") long offset);

    @RequestLine("GET /games/{id}")
    Wrapper<Game> getGame(@Param("id") String id);

    @RequestLine("GET /categories/{id}")
    Wrapper<Category> getCategory(@Param("id") String id);
}

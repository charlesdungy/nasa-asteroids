package com.nasa_asteroids.project;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Config {

    private final Map<String, String> configMap;

    public Config(File file) {
        this.configMap = readConfig(file);
    }

    private Map<String, String> readConfig(File file) {
        Map<String, String> mapForConfig = new HashMap<>();
        try (
            Scanner s = new Scanner(file)
        ) {
            mapForConfig.put("API_KEY", s.next());
            mapForConfig.put("DB_USER", s.next());
            mapForConfig.put("DB_PASSWORD", s.next());
            mapForConfig.put("DB_PATH", s.next());
            mapForConfig.put("TWITTER_API_KEY", s.next());
            mapForConfig.put("TWITTER_API_KEY_SECRET", s.next());
            mapForConfig.put("TWITTER_BEARER_TOKEN", s.next());
            mapForConfig.put("TWITTER_ACCESS_TOKEN", s.next());
            mapForConfig.put("TWITTER_ACCESS_TOKEN_SECRET", s.next());
            mapForConfig.put("HASHTAG_FILE", s.next());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapForConfig;
    }

    public String getAPIKey() {
        return configMap.get("API_KEY");
    }

    public String getDbUser() {
        return configMap.get("DB_USER");
    }

    public String getDbPassword() {
        return configMap.get("DB_PASSWORD");
    }

    public String getDbPath() {
        return configMap.get("DB_PATH");
    }

    public String getTwitterAPIKey() {
        return configMap.get("TWITTER_API_KEY");
    }

    public String getTwitterAPIKeySecret() {
        return configMap.get("TWITTER_API_KEY_SECRET");
    }

    public String getTwitterAccessToken() {
        return configMap.get("TWITTER_ACCESS_TOKEN");
    }

    public String getTwitterAccessTokenSecret() {
        return configMap.get("TWITTER_ACCESS_TOKEN_SECRET");
    }

    public String getTwitterBearerToken() {
        return configMap.get("TWITTER_BEARER_TOKEN");
    }

    public String getHashtagFile() {
        return configMap.get("HASHTAG_FILE");
    }
}
package com.nasa_asteroids.project;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Config {

    private Map<String, String> configMap = new HashMap<>();

    public Config(File file) {
        readConfig(file);
    }

    private void readConfig(File file) {
        try (
            Scanner s = new Scanner(file)
        ) {
            configMap.put("API_KEY", s.next());
            configMap.put("DB_USER", s.next());
            configMap.put("DB_PASSWORD", s.next());
            configMap.put("DB_PATH", s.next());
            configMap.put("TWITTER_API_KEY", s.next());
            configMap.put("TWITTER_API_KEY_SECRET", s.next());
            configMap.put("TWITTER_BEARER_TOKEN", s.next());
            configMap.put("TWITTER_ACCESS_TOKEN", s.next());
            configMap.put("TWITTER_ACCESS_TOKEN_SECRET", s.next());
            configMap = Collections.unmodifiableMap(configMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
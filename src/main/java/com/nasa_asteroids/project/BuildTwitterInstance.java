package com.nasa_asteroids.project;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class BuildTwitterInstance {

    private final String consumerKey;
    private final String consumerSecret;
    private final String accessToken;
    private final String accessTokenSecret;
    private TwitterFactory tf = null;
    
    public BuildTwitterInstance(String key, String secret, String token, String tokenSecret) {
        this.consumerKey = key;
        this.consumerSecret = secret;
        this.accessToken = token;
        this.accessTokenSecret = tokenSecret;
    }

    public void buildConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret(consumerSecret)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessTokenSecret);
        tf = new TwitterFactory(cb.build());
    }

    public void postTweet(String tweet) {
        Twitter twitter = tf.getInstance();
        try {
            twitter.updateStatus(tweet);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
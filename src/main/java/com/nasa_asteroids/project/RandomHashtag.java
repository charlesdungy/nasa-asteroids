package com.nasa_asteroids.project;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomHashtag {
    
    private final String finalHashtag;
    private final List<String> hashtags;

    public RandomHashtag(String path) {
        this.hashtags = readFile(path);
        this.finalHashtag = setFinalHashTag();
    }

    public String getFinalHashtag() {
        return finalHashtag;
    }

    private List<String> readFile(String filename) {
        List<String> hashtagList = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {
                hashtagList.add(s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashtagList;
    }

    private String setFinalHashTag() {
        if (!hashtags.isEmpty()) {
            Collections.shuffle(hashtags);
            Random random = new Random();
            int index = random.nextInt(hashtags.size());
            return hashtags.get(index);
        } else {
            return null;
        }
    }
}
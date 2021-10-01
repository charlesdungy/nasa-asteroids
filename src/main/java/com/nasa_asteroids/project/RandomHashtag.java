package com.nasa_asteroids.project;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomHashtag {
    
    private String finalHashtag;
    private List<String> hashtags = new ArrayList<>();

    public RandomHashtag(String path) {
        readFile(path);
        setFinalHashTag();
    }

    public String getFinalHashtag() {
        return finalHashtag;
    }

    private void readFile(String filename) {
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {
                hashtags.add(s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFinalHashTag() {
        Collections.shuffle(hashtags);
        Random random = new Random();
        int index = random.nextInt(hashtags.size());
        finalHashtag = hashtags.get(index);
    }
}
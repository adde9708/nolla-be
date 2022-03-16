package com.nolla.nollatweeterapi.controller;
import com.nolla.nollatweeterapi.dao.Dao;
import com.nolla.nollatweeterapi.models.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
public class TweetController {

    private final Dao tweetDao;

    public TweetController(Dao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @GetMapping("/fetchTweet")
    public List<Model> fetchTweet() {
        return tweetDao.getTweets();
    }
    @PostMapping("/fetchTweet")
    public String insertTweet(String tweet) {
        tweetDao.addTweet(tweet);
        return tweet;
    }

    @PostMapping("/saveTweet")
    public String saveTweet(@RequestBody String tweet) {
        System.out.println("Received: " + tweet);
        tweetDao.addTweet(tweet);
        return "ok";
    }
}
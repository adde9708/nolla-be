package com.nolla.nollatweeterapi.dao;
import java.util.*;
import com.nolla.nollatweeterapi.models.Tweet;
public interface TweetDao {
    Optional<Tweet> findById(Long tweetId);

}

package com.nolla.nollatweeterapi.dao;

import com.nolla.nollatweeterapi.models.Model;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Component;

@Component
public class Dao {
    final String INSERT_QUERY = "INSERT INTO tweets(usr_id, content_twt) VALUES (:usr_id, :tweet)";
    final String SELECT_QUERY = "SELECT * FROM tweets ORDER BY created_twt DESC LIMIT 2";
    public Dao(NamedParameterJdbcTemplate template) { this.template = template;}
    NamedParameterJdbcTemplate template;
    public int addTweet (String message){
        System.out.println("Message received: " + message);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tweet", message);
        paramMap.put("usr_id", 12L);
        return template.update(INSERT_QUERY, paramMap);
    }
    public List<Model> getTweets(){
        System.out.println("Messages");
        return template.query(SELECT_QUERY, BeanPropertyRowMapper.newInstance(Model.class));
    }
}

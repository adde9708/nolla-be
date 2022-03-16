package com.nolla.nollatweeterapi.dao;

import com.nolla.nollatweeterapi.models.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public class TweetDaoImpl implements TweetDao {
    //columns
    private static final String TWT_ID = "twt_id";
    private static final String USR_ID = "usr_id";
    private static final String UPDATED_TWT = "updated_twt";
    private static final String LIKES_TWT = "likes_twt";
    private static final String CONTENT_TWT = "content_twt";
    private static final String CREATED_TWT = "created_twt";

    //queries
    private static final String FIND_BY_TWT_ID = "SELECT * FROM tweets WHERE twt_id = (:twt_id)";

    //mappers
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final RowMapper<Tweet> TWEET_ROW_MAPPER = ((rs, rowNum) ->
            new Tweet(rs.getLong(TWT_ID),
                    rs.getLong(USR_ID),
                    rs.getTimestamp(UPDATED_TWT).toLocalDateTime(),
                    rs.getTimestamp(CREATED_TWT).toLocalDateTime(),
                    rs.getLong(LIKES_TWT),
                    rs.getArray(CONTENT_TWT)

            )
    );
    @Autowired
    public TweetDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tweet> findById(Long tweetId) {
        return namedParameterJdbcTemplate.query(FIND_BY_TWT_ID, new MapSqlParameterSource(TWT_ID, tweetId), TWEET_ROW_MAPPER).stream().findFirst();

    }
}

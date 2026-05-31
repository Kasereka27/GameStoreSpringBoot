package edu.upc.gamestore.repository;

import ch.qos.logback.core.util.StringUtil;
import edu.upc.gamestore.models.VideoGame;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import io.micrometer.common.util.StringUtils;

@Repository
public class VideoGameRepository implements VideoGameRepositoryInterface {
    @Autowired
    private JdbcClient jdbcClient;

    private static final ResultSetExtractorImpl<VideoGame> rsExtr = JdbcTemplateMapperFactory.newInstance()
            .addKeys("id")
            .ignorePropertyNotFound()
            .newResultSetExtractor(VideoGame.class);
    @Override
    public List<VideoGame> getGame(String keyword) {

        String query;
        Object[] params;

        if(StringUtils.isNotBlank(keyword)){
            query = "SELECT * FROM video_games WHERE (title LIKE ? OR plateform LIKE ?) ORDER BY title ASC";

            String _keyword = "%".concat(keyword).concat("%");

            params = new Object[] {_keyword, _keyword};
        } else {
            query = "SELECT * FROM video_games ORDER BY title ASC";
            params = new Object[] {};
        }

        return jdbcClient.sql(query).params(params).query(rsExtr);
    }

}

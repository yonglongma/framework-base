/**
 * <p>Title: UserDao.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.helloworld.dao;

import com.yonglongma.helloworld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MaYongLong
 * @date 2017-11-21 15:36
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String MATCH_COUNT_SQL = "select count(*) from t_user where user_name=? and password = ?";
    private final static String FIND_USER_BY_NAME = "select * from t_user where user_name =? limit 1";
    private final static String UPDATE_LOGIN_INFO_SQL = "update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";

    public int getMatchCount(String userName,String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[]{userName,password},Integer.class);
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(FIND_USER_BY_NAME, new Object[]{userName}, new RowCallbackHandler() {
            //匿名类方式实现的回调函数
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}

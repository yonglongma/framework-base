/**
 * <p>Title: LoginLogDao.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.sample.dao;

import com.yonglongma.sample.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author MaYongLong
 * @date 2017-11-21 15:47
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //保存登录日志
    private final static String INSERT_LOGIN_LOG_SQL = "insert into t_login_log(user_id,ip,login_datetime) values (?,?,?)";

    public void insertLoginLog(LoginLog loginLog){
        Object[] args = {loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,args);
    }
}

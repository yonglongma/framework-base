/**
 * <p>Title: UserService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.sample.service;

import com.yonglongma.sample.dao.LoginLogDao;
import com.yonglongma.sample.dao.UserDao;
import com.yonglongma.sample.domain.LoginLog;
import com.yonglongma.sample.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MaYongLong
 * @date 2017-11-21 16:05
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Service//将UserService标注为一个服务层的bean
public class UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount>0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}

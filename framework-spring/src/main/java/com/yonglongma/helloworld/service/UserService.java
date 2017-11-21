/**
 * <p>Title: UserService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.helloworld.service;

import com.yonglongma.helloworld.dao.LoginLogDao;
import com.yonglongma.helloworld.dao.UserDao;
import com.yonglongma.helloworld.domain.LoginLog;
import com.yonglongma.helloworld.domain.User;
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


    private UserDao userDao;

    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

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

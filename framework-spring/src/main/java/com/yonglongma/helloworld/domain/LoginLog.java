/**
 * <p>Title: LoginLog.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.helloworld.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MaYongLong
 * @date 2017-11-21 15:20
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class LoginLog implements Serializable {

    private int loginLogId;

    private int userId;

    private String ip;

    private Date loginDate;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}

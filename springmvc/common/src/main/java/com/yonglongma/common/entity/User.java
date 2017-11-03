/**
 * <p>Title: User.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.common.entity;

/**
 * @author MaYongLong
 * @date 2017-10-01 23:50
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class User extends BaseEntity {

    private Long userId;

    private String userName;

    private String mobile;

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

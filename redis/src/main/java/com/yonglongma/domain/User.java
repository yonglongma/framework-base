package com.yonglongma.domain;

import java.io.Serializable;

/**
 * Author MaYongLong
 * Create in 20:02 2017/9/7
 * Description
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6011241820070393952L;

    private String id;

    private String name;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

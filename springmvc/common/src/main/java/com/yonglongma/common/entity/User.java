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

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * <p>Title: BaseEntity.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.common.entity;

import java.io.Serializable;

/**
 * @author MaYongLong
 * @date 2017-10-01 23:50
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class BaseEntity implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

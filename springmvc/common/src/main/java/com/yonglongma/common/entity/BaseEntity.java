/**
 * <p>Title: BaseEntity.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MaYongLong
 * @date 2017-10-01 23:50
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class BaseEntity implements Serializable{

    private Long id;

    private Date createDate;

    private Long createBy;

    private Date updateDate;

    private Long updateBy;

    private Boolean delete;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

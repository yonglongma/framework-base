package com.yonglongma.common.dao;

import com.yonglongma.common.model.SysUser;
import java.util.List;

public interface SysUserMapper {

    int insert(SysUser record);

    List<SysUser> findUser();

}
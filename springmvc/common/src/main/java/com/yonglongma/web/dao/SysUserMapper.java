package com.yonglongma.web.dao;

import com.yonglongma.web.model.SysUser;
import java.util.List;

public interface SysUserMapper {

    int insert(SysUser record);

    List<SysUser> findUser();

}
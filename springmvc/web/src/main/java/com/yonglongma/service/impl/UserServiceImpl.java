/**
 * <p>Title: UserServiceImpl.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.service.impl;

import com.yonglongma.common.dao.SysUserMapper;
import com.yonglongma.common.model.SysUser;
import com.yonglongma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author MaYongLong
 * @date 2017-10-02 0:02
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    public void createUser(SysUser user) {
        userMapper.insert(user);
    }

    public List<SysUser> findUser() {
        return userMapper.findUser();
    }
}

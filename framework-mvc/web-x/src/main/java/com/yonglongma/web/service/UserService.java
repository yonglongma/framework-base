/**
 * <p>Title: UserService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.web.service;

import com.yonglongma.web.model.SysUser;
import java.util.List;

/**
 * @author MaYongLong
 * @date 2017-10-02 0:01
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public interface UserService {

    void createUser(SysUser user);

    List<SysUser> findUser();

}

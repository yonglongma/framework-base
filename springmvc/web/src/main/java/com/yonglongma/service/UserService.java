/**
 * <p>Title: UserService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.service;

import com.yonglongma.common.entity.User;
import java.util.List;

/**
 * @author MaYongLong
 * @date 2017-10-02 0:01
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public interface UserService {

    void addUser(User user);

    List<User> findUser();

}

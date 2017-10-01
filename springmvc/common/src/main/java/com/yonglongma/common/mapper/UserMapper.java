/**
 * <p>Title: UserMapper.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.common.mapper;

import com.yonglongma.common.entity.User;
import java.util.List;

/**
 * @author MaYongLong
 * @date 2017-10-01 23:54
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public interface UserMapper {

    void add(User user);

    void delete(Long id);

    User get(Long id);

    void update(User user);

    List<User> find();
}

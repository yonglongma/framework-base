package com.yonglongma.dao;

import com.yonglongma.domain.User;
import java.util.List;

/**
 * Author MaYongLong
 * Create in 19:54 2017/9/7
 * Description
 */
public class IUserDaoImpl extends AbstractBaseRedisDao<String,User> implements IUserDao{

    public boolean add(User user) {
        return false;
    }

    public boolean add(List<User> list) {
        return false;
    }

    public void delete(String key) {

    }

    public void delete(List<String> keys) {

    }

    public boolean update(User user) {
        return false;
    }

    public User get(String keyId) {
        return null;
    }
}

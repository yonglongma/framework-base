package com.yonglongma.dao;

import com.yonglongma.entity.User;
import java.util.List;

/**
 * Author MaYongLong
 * Create in 20:06 2017/9/7
 * Description
 */
public interface IUserDao {

    //新增
    boolean add(User user);

    //批量新增 使用pipeline方式
    boolean add(List<User> list);

    //删除
    void delete(String key);

    //批量删除
    void delete(List<String> keys);

    //更新
    boolean update(User user);

    //通过key获取
    User get(String keyId);
}

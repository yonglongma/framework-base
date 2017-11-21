/**
 * <p>Title: TestUserService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.helloword.service;

import com.yonglongma.helloworld.domain.User;
import com.yonglongma.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author MaYongLong
 * @date 2017-11-21 16:43
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@ContextConfiguration("classpath*:/aop-context.xml")//启动spring容器
public class TestUserService extends AbstractTransactionalTestNGSpringContextTests{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","1111");
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        System.out.println(user);
    }
}

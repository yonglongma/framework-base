/**
 * <p>Title: LoginController.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.sample.web;

import com.yonglongma.sample.domain.User;
import com.yonglongma.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author MaYongLong
 * @date 2017-11-22 12:36
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@RestController//springmvc提供用于创建rest服务
@EnableAutoConfiguration//boot提供用于对spring框架进行自动配置
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index.html"})//可以配置多个映射路径
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand command){
        boolean isValidUser = userService.hasMatchUser(command.getUserName(),command.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","用户名或密码错误");
        }else{
            User user = userService.findUserByUserName(command.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }

}

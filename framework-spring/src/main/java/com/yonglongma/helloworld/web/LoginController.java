/**
 * <p>Title: LoginController.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.helloworld.web;

import com.yonglongma.helloworld.domain.User;
import com.yonglongma.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author MaYongLong
 * @date 2017-11-21 21:47
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
    @Autowired
    private UserService userService;

    //负责处理/index.html的请求
    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    //负责处理/loginCheck.html的请求
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

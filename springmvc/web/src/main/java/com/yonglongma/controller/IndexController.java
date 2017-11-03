/**
 * <p>Title: IndexController.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.controller;

import com.yonglongma.web.model.SysUser;
import com.yonglongma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author MaYongLong
 * @date 2017-09-28 16:29
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 测试
     */
    @RequestMapping(value = "/test")
    public ModelAndView hello() {
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");
        String me = "Hello World, Spring 3.0!";
        return new ModelAndView("user","message",me);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView findUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysUser> users = userService.findUser();
        modelAndView.addObject("userList",users);
        modelAndView.setViewName("user");
        return modelAndView;
    }

}

/**
 * <p>Title: IndexController.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 测试
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public void hello() {
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");
    }

}

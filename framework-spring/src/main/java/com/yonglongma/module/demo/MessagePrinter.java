/**
 * <p>Title: MessagePrinter.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MaYongLong
 * @date 2017-11-17 22:49
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
@Component
public class MessagePrinter {

    @Autowired
    private MessageService service;

    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}

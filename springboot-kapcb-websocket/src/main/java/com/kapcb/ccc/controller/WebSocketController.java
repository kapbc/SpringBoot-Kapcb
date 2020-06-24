package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.RequestMessage;
import com.kapcb.ccc.common.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:WebSocketController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/14 21:44
 */
@Controller
public class WebSocketController {

    /**
     * @param requestMessage RequestMessage
     * @return ResponseMessage
     * @MessageMapping注解和我们之前使用的@RequestMapping类似
     * @SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息。
     */
    @MessageMapping("/hello")
    @SendTo("/topic/getResponse")
    public ResponseMessage saySomeThing(RequestMessage requestMessage) {
        System.out.println(requestMessage);
        return new ResponseMessage("Hello" + requestMessage.getName() + "!");
    }

}

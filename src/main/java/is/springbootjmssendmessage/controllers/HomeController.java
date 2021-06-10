package is.springbootjmssendmessage.controllers;

import is.springbootjmssendmessage.listener.ResponseListener;
import is.springbootjmssendmessage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class HomeController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ResponseListener listener;


    @GetMapping("send")
    public String sendMsg(@RequestParam String message, @RequestParam Integer age) {
        Message msg = new Message(message, age);
        try {
            jmsTemplate.convertAndSend("DEV.QUEUE.1", msg);
            return "OK. send msg: " + msg.toString();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @GetMapping("get")
    public CopyOnWriteArrayList<Message> getMsg() {
        try {
            return listener.getMsgList();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

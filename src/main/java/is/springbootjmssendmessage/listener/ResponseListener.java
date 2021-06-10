package is.springbootjmssendmessage.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class ResponseListener {

    private final CopyOnWriteArrayList<is.springbootjmssendmessage.model.Message> msgList = new CopyOnWriteArrayList();

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receive(Message message) throws JMSException {
        if (message != null) {
            is.springbootjmssendmessage.model.Message msg = message.getBody(is.springbootjmssendmessage.model.Message.class);
            msgList.add(msg);
            log.info(msg.toString());
        }
    }

    public CopyOnWriteArrayList<is.springbootjmssendmessage.model.Message> getMsgList() {
        return msgList;
    }
}

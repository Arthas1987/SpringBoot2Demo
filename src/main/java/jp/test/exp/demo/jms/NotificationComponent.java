package jp.test.exp.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NotificationComponent {

    @Autowired
    protected JmsTemplate defaultJmsTemplate;

    public void thumbnailComplete(ThumbnailResult result) throws IOException {
        defaultJmsTemplate.convertAndSend("test-queue-result",
                result.toJSON());
    }

}

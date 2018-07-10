package jp.test.exp.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.io.IOException;

@Service
public class TestService {

    @Autowired
    private NotificationComponent notification;

    @JmsListener(destination = "test-queue")
    public void createThumbnail(String requestJSON) throws JMSException {
        System.out.println("Received");
        try {
            ThumbnailRequest request=ThumbnailRequest.fromJSON(requestJSON);
            notification.thumbnailComplete(new ThumbnailResult(request.getImageUrl()));
        } catch (IOException ex) {
            System.out.println("Encountered error while parsing message.");
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}

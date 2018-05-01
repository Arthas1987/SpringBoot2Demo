package jp.test.exp.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * POJO Files for testing properties file
 * <br/>
 * 注意：intelljの「transparent native to ascii」をONにしないと、文字化け
 */
@Component
public class BlogProperties {
    @Value("${jp.test.exp.demo.title}")
    public String blogTitle;

    @Value("${jp.test.exp.demo.author}")
    public String blogAuthor;

}

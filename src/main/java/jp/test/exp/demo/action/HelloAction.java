package jp.test.exp.demo.action;

import jp.test.exp.demo.beans.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Actionという名前は本当に必要か？
 * </br>
 * まだformへのバインドができていない
 */
@Component
public class HelloAction {
    @Autowired
    BlogProperties blogProperties;

    public String index() {
        return new StringBuilder(blogProperties.blogAuthor)
                    .append("\n")
                    .append(blogProperties.blogTitle)
                    .toString();
    }

}

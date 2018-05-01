package jp.test.exp.demo;

import jp.test.exp.demo.action.HelloAction;
import jp.test.exp.demo.beans.BlogProperties;
import jp.test.exp.demo.consts.UrlConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @Autowired
    HelloAction helloAction;

    @Autowired
    BlogProperties blogProperties;

    @RequestMapping(UrlConsts.HELLO_WORLD)
    public String index() {
        return helloAction.index();
    }

}

package jp.test.exp.demo;

import jp.test.exp.demo.consts.UrlConsts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @RequestMapping(UrlConsts.HELLO_WORLD)
    public String index() {
        return "Hello World";
    }

}

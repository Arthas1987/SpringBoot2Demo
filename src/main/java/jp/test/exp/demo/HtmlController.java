package jp.test.exp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/testHtml")
    public String testHtml() {
        return "streamTest";
    }
}

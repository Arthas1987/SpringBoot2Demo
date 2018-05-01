package jp.test.exp.demo;

import jp.test.exp.demo.beans.BlogProperties;
import jp.test.exp.demo.consts.UrlConsts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
@WebAppConfiguration
public class DemoApplicationTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    BlogProperties blogProperties;

    @Before
    public void setUp() {
        // TODO: mockMvcは、standaloneとwebAppContextSteupの二種類ある。コントローラへのテストをする時、webappcontextを利用すべき？
        //mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build(); //これだと、controllerのautowiredはできない
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getHello() throws Exception {
        String answer = new StringBuilder(blogProperties.blogAuthor)
                                .append("\n")
                                .append(blogProperties.blogTitle)
                                .toString();

        mvc.perform(MockMvcRequestBuilders.get(UrlConsts.HELLO_WORLD).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(answer)));
    }
}

package ma.oga.microsystemes.myservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = NotificationApplication.class)
public class NotificationController {
   @Autowired
   private WebApplicationContext webApplicationContext;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

   private MockMvc mockMvc;

   @Before
   public void setUp(){
       this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
               .addFilter(springSecurityFilterChain)
               .build();
   }

   @Test
   public void test() throws Exception {

   }
}

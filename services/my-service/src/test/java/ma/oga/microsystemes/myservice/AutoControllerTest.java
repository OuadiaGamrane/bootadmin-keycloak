package ma.oga.microsystemes.myservice;

import ma.oga.microsystemes.myservice.NotificationApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NotificationApplication.class)
public class AutoControllerTest {

//    @InjectMocks
//    @Autowired
//    private AutoController autoController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp(){
//        this.mockMvc = MockMvcBuilders.standaloneSetup(autoController)
//                .build();
//    }
//
//    @Test
//    public void loadInsuranceCost_GET_OK() throws Exception {
//
//        // Given
//
//        // When
//        MvcResult mvcResult = this.mockMvc.perform(get("/insurance"))
//                .andExpect(request().asyncStarted())
//                .andReturn();
//
//        // then
//        mockMvc.perform(asyncDispatch(mvcResult))
//                .andExpect(status().isOk());
//
//    }

}
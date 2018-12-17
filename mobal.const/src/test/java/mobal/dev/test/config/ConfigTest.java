package mobal.dev.test.config;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import mobalDev.MobalConstApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MobalConstApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public abstract class ConfigTest {

}

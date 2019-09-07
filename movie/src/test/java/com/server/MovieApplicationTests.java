package com.server;

import com.server.bean.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Beans;

@SpringApplicationConfiguration(classes = {MovieApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
public class MovieApplicationTests {

    @Test
    public void contextLoads() {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(MovieApplication.class);
        Car car = applicationContext.getBean("myCar", Car.class);
        System.out.println(car.getColor());
    }

}

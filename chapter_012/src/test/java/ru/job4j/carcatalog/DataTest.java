package ru.job4j.carcatalog;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Class for data testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.12.2017.
 */
public class DataTest {
    @Test
    public void test() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-data-context.xml");
//        CarDataRepository repository = context.getBean(CarDataRepository.class);

//        Car car1 = new Car(new Body(13), new Producer(19), new Engine(8, new Fuel(19)), new Transmission(14));
//        assertThat(repository.findOne(car1.getId()), is(car1));

    }
}

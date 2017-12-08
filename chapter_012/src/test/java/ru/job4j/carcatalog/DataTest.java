package ru.job4j.carcatalog;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.carcatalog.models.Car;
import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Fuel;
import ru.job4j.carcatalog.modules.Producer;
import ru.job4j.carcatalog.modules.Transmission;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for data testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.12.2017.
 */
public class DataTest {
    /**
     * Test.
     * @throws Exception - exception.
     */
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-data-context.xml");
        CarDataRepository repository = context.getBean(CarDataRepository.class);
        Car car1 = new Car(new Body(13), new Producer(19), new Engine(8, new Fuel(19)), new Transmission(13));
        Car car = repository.save(car1);

        Car result = new Car();
        result.setBody(new Body("Sedan"));
        result.setProducer(new Producer("VW"));
        Engine engine = new Engine();
        engine.setVolume("1.8");
        result.setEngine(engine);
        result.setTransmission(new Transmission("Mechanics"));
        result.setId(car.getId());

        assertThat((repository.findOne(car.getId())).getBody().getType(), is(result.getBody().getType()));



    }
}

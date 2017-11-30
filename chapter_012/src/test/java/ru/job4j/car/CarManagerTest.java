package ru.job4j.car;


import org.junit.Test;
import ru.job4j.carcatalog.Car;
import ru.job4j.carcatalog.CarManager;
import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Producer;
import ru.job4j.carcatalog.modules.Transmission;
import ru.job4j.carcatalog.modules.Fuel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing car manager.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
public class CarManagerTest {
    /**
     * Add fuel test.
     */
    @Test
    public void whenAddFuelThenItAddedToDB() {
        Fuel gasolin = new Fuel("Gasolin");
        gasolin.setId(19);
        Fuel disel = new Fuel("Disel");
        disel.setId(20);

        CarManager manager = new CarManager();

        manager.addFuel(gasolin);
        manager.addFuel(disel);

        String result = manager.getSession().get(Fuel.class, 19).getType();
        assertThat(result, is("Gasolin"));

        manager.closeSession();

    }

    /**
     * Add transmission test.
     */
    @Test
    public void whenTransmissionThenItAddedToDB() {
        Transmission mechanics = new Transmission("Mechanics");
        mechanics.setId(13);
        Transmission automatic = new Transmission("Automatic");
        automatic.setId(14);

        CarManager manager = new CarManager();

        manager.addTransmission(mechanics);
        manager.addTransmission(automatic);

        String result = manager.getSession().get(Transmission.class, 14).getType();
        assertThat(result, is("Automatic"));
        manager.closeSession();
    }

    /**
     * Add body test.
     */
    @Test
    public void whenBodyThenItAddedToDB() {
        Body sedan = new Body("Sedan");
        sedan.setId(13);
        Body hatchback = new Body("Hatchback");
        hatchback.setId(14);

        CarManager manager = new CarManager();

        manager.addBody(sedan);
        manager.addBody(hatchback);

        String result = manager.getSession().get(Body.class, 14).getType();
        assertThat(result, is("Hatchback"));
        manager.closeSession();
    }

    /**
     * Add producer test.
     */
    @Test
    public void whenProducerThenItAddedToDB() {
        Producer vw = new Producer("VW");
        vw.setId(19);
        Producer toyota = new Producer("Toyota");
        toyota.setId(20);
        Producer vaz = new Producer("VAZ");
        vaz.setId(21);

        CarManager manager = new CarManager();

        manager.addProducer(vw);
        manager.addProducer(vaz);
        manager.addProducer(toyota);

        String result = manager.getSession().get(Producer.class, 20).getMark();
        assertThat(result, is("Toyota"));
        manager.closeSession();
    }

    /**
     * Add engine test.
     */
    @Test
    public void whenEngineThenItAddedToDB() {
        Engine v8 = new Engine("1.8", new Fuel(19));
        v8.setId(8);
        Engine v6 = new Engine("1.6", new Fuel(19));
        v6.setId(9);
        Engine v4 = new Engine("1.4", new Fuel(20));
        v4.setId(10);

        CarManager manager = new CarManager();

        manager.addEngine(v8);
        manager.addEngine(v6);
        manager.addEngine(v4);

        String result = manager.getSession().get(Engine.class, 8).getVolume();
        assertThat(result, is("1.8"));
        manager.closeSession();
    }

    /**
     * Get car test.
     */
    @Test
    public void whenCarThenItAddedToDB() {
        Car car1 = new Car(new Body(13), new Producer(19), new Engine(8), new Transmission(13));
        Car car2 = new Car(new Body(14), new Producer(21), new Engine(9), new Transmission(14));
        Car car3 = new Car(new Body(13), new Producer(21), new Engine(10), new Transmission(13));

        CarManager manager = new CarManager();

        manager.addCar(car1);
        manager.addCar(car2);
        manager.addCar(car3);
        String carBody = manager.getCar(1).getBody().getType();
        assertThat(carBody, is("Sedan"));

        manager.closeSession();
    }

}

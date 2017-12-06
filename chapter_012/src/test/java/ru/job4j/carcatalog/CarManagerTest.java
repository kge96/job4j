package ru.job4j.carcatalog;


import org.junit.Test;
import ru.job4j.carcatalog.models.Car;
import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Producer;
import ru.job4j.carcatalog.modules.Transmission;
import ru.job4j.carcatalog.modules.Fuel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing carcatalog manager.
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
        CarManager manager = new CarManager();
        Fuel gasolin = new Fuel("Gasolin");
        Fuel disel = new Fuel("Disel");

        manager.addFuel(gasolin);
        manager.addFuel(disel);

        String result = manager.getSession().get(Fuel.class, 1).getType();
        assertThat(result, is("Gasolin"));

        manager.closeSession();

    }

    /**
     * Add transmission test.
     */
    @Test
    public void whenTransmissionThenItAddedToDB() {
        CarManager manager = new CarManager();
        Transmission mechanics = new Transmission("Mechanics");
        Transmission automatic = new Transmission("Automatic");

        manager.addTransmission(mechanics);
        manager.addTransmission(automatic);

        String result = manager.getSession().get(Transmission.class, 2).getType();
        assertThat(result, is("Automatic"));
        manager.closeSession();
    }

    /**
     * Add body test.
     */
    @Test
    public void whenBodyThenItAddedToDB() {
        CarManager manager = new CarManager();

        Body sedan = new Body("Sedan");
        Body hatchback = new Body("Hatchback");

        manager.addBody(sedan);
        manager.addBody(hatchback);

        String result = manager.getSession().get(Body.class, 2).getType();
        assertThat(result, is("Hatchback"));
        manager.closeSession();
    }

    /**
     * Add producer test.
     */
    @Test
    public void whenProducerThenItAddedToDB() {
        CarManager manager = new CarManager();
        Producer vw = new Producer("VW");
        Producer toyota = new Producer("Toyota");
        Producer vaz = new Producer("VAZ");

        manager.addProducer(vw);
        manager.addProducer(vaz);
        manager.addProducer(toyota);

        String result = manager.getSession().get(Producer.class, 3).getMark();
        assertThat(result, is("Toyota"));
        manager.closeSession();
    }

    /**
     * Add engine test.
     */
    @Test
    public void whenEngineThenItAddedToDB() {
        CarManager manager = new CarManager();

        Fuel gasolin = new Fuel("Gasolin");
        Fuel disel = new Fuel("Disel");
        manager.addFuel(gasolin);
        manager.addFuel(disel);

        Engine v8 = new Engine("1.8", new Fuel(1));
        Engine v6 = new Engine("1.6", new Fuel(1));
        Engine v4 = new Engine("1.4", new Fuel(2));

        manager.addEngine(v8);
        manager.addEngine(v6);
        manager.addEngine(v4);

        String result = manager.getSession().get(Engine.class, 1).getVolume();
        assertThat(result, is("1.8"));
        manager.closeSession();
    }

    /**
     * Get carcatalog test.
     */
    @Test
    public void whenCarThenItAddedToDB() {
        CarManager manager = new CarManager();

        Fuel gasolin = new Fuel("Gasolin");
        Fuel disel = new Fuel("Disel");
        manager.addFuel(gasolin);
        manager.addFuel(disel);

        Body sedan = new Body("Sedan");
        Body hatchback = new Body("Hatchback");
        manager.addBody(sedan);
        manager.addBody(hatchback);

        Transmission mechanics = new Transmission("Mechanics");
        Transmission automatic = new Transmission("Automatic");
        manager.addTransmission(mechanics);
        manager.addTransmission(automatic);

        Producer vw = new Producer("VW");
        Producer toyota = new Producer("Toyota");
        Producer vaz = new Producer("VAZ");
        manager.addProducer(vw);
        manager.addProducer(vaz);
        manager.addProducer(toyota);

        Engine v8 = new Engine("1.8", new Fuel(1));
        Engine v6 = new Engine("1.6", new Fuel(1));
        Engine v4 = new Engine("1.4", new Fuel(2));
        manager.addEngine(v8);
        manager.addEngine(v6);
        manager.addEngine(v4);

        Car car1 = new Car(new Body(1), new Producer(2), new Engine(1), new Transmission(2));
        Car car2 = new Car(new Body(2), new Producer(1), new Engine(1), new Transmission(2));
        Car car3 = new Car(new Body(1), new Producer(3), new Engine(2), new Transmission(1));

        manager.addCar(car1);
        manager.addCar(car2);
        manager.addCar(car3);
        Car result = manager.getCar(3);
        assertThat(result, is(car3));

        manager.closeSession();
    }

}

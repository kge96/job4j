package ru.job4j.carcatalog;

import org.junit.Test;
import ru.job4j.carcatalog.models.Car;
import ru.job4j.carcatalog.modules.Body;
import ru.job4j.carcatalog.modules.Engine;
import ru.job4j.carcatalog.modules.Fuel;
import ru.job4j.carcatalog.modules.Transmission;
import ru.job4j.carcatalog.modules.Producer;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing carcatalog filter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 01.12.2017.
 */
public class CarFilterTest {
    /**
     * Test when get all cars.
     */
    @Test
    public void whenGetAllCarsThenReturnAllCars() {
        CarFilter filter = new CarFilter();
        createStructure();
        List<Car> carList = filter.getAllCars();
        assertThat(carList.size(), is(7));
    }

    /**
     * Test when get carcatalog by id.
     */
    @Test
    public void whenGetCarById2ThenReturnVW() {
        CarFilter filter = new CarFilter();
        createStructure();
        Car car = filter.getCarById(2);
        assertThat(car.getProducer().getMark(), is("VW"));
    }

    /**
     * Test when get cars by body type.
     */
    @Test
    public void whenGetCarsByBodyNameThenReturnSedan() {
        CarFilter filter = new CarFilter();
        createStructure();
        List<Car> carList = filter.getCarsByBody("Sedan");
        assertThat(carList.size(), is(2));
    }

    /**
     * Test when get carcatalog by producer name.
     */
    @Test
    public void whenGetCarsByProducerNameThenReturnVW() {
        CarFilter filter = new CarFilter();
        createStructure();
        List<Car> carList = filter.findCarsByProducer("Toyota");
        assertThat(carList.size(), is(3));
    }

    /**
     * Test when get carcatalog by parameters.
     */
    @Test
    public void whenGetCarsByParamThenReturnSameCarsList() {
        CarFilter filter = new CarFilter();
        createStructure();
        List<Car> carList = filter.getCarsByParam("Sedan", "Toyota", "1.8", "Gasolin", "Automatic");
        assertThat(carList.size(), is(1));
    }

    /**
     * Create structure at database.
     */
    private void createStructure() {
        CarManager manager = new CarManager();

        Fuel gasolin = new Fuel("Gasolin");
        Fuel disel = new Fuel("Disel");
        manager.addFuel(gasolin);
        manager.addFuel(disel);

        Body sedan = new Body("Sedan");
        Body hatchback = new Body("Hatchback");
        Body vagon = new Body("Vagon");
        manager.addBody(sedan);
        manager.addBody(hatchback);
        manager.addBody(vagon);

        Transmission mechanics = new Transmission("Mechanics");
        Transmission automatic = new Transmission("Automatic");
        manager.addTransmission(mechanics);
        manager.addTransmission(automatic);

        Producer vw = new Producer("VW");
        Producer toyota = new Producer("Toyota");
        Producer vaz = new Producer("VAZ");
        manager.addProducer(vw);
        manager.addProducer(toyota);
        manager.addProducer(vaz);

        Engine v8 = new Engine("1.8", new Fuel(1));
        Engine v6 = new Engine("1.6", new Fuel(1));
        Engine v4 = new Engine("1.4", new Fuel(2));
        manager.addEngine(v8);
        manager.addEngine(v6);
        manager.addEngine(v4);

        Car car1 = new Car(new Body(1), new Producer(2), new Engine(1), new Transmission(2));
        Car car2 = new Car(new Body(2), new Producer(1), new Engine(1), new Transmission(2));
        Car car3 = new Car(new Body(3), new Producer(3), new Engine(2), new Transmission(1));
        Car car4 = new Car(new Body(1), new Producer(1), new Engine(1), new Transmission(2));
        Car car5 = new Car(new Body(2), new Producer(2), new Engine(2), new Transmission(1));
        Car car6 = new Car(new Body(3), new Producer(3), new Engine(1), new Transmission(2));
        Car car7 = new Car(new Body(2), new Producer(2), new Engine(2), new Transmission(1));

        manager.addCar(car1);
        manager.addCar(car2);
        manager.addCar(car3);
        manager.addCar(car4);
        manager.addCar(car5);
        manager.addCar(car6);
        manager.addCar(car7);
    }
}

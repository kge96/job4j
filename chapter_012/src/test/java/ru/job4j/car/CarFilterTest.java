package ru.job4j.car;

import org.junit.Test;
import ru.job4j.carcatalog.Car;
import ru.job4j.carcatalog.CarFilter;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing car filter.
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
        List<Car> carList = filter.getAllCars();
        assertThat(carList.size(), is(18));
    }

    /**
     * Test when get car by id.
     */
    @Test
    public void whenGetCarById5ThenReturnVAZ() {
        CarFilter filter = new CarFilter();
        Car car = filter.getCarById(5);
        assertThat(car.getProducer().getMark(), is("VAZ"));
    }

    /**
     * Test when get cars by body type.
     */
    @Test
    public void whenGetCarsByBodyNameThenReturnSedan() {
        CarFilter filter = new CarFilter();
        List<Car> carList = filter.getCarsByBody("Sedan");
        assertThat(carList.size(), is(12));
    }

    /**
     * Test when get car by producer name.
     */
    @Test
    public void whenGetCarsBProducerNameThenReturnVW() {
        CarFilter filter = new CarFilter();
        List<Car> carList = filter.findCarsByProducer("VW");
        assertThat(carList.get(0).getProducer().getMark(), is("VW"));
    }

    /**
     * Test when get car by parameters.
     */
    @Test
    public void whenGetCarsByParamThenReturnSameCarsList() {
        CarFilter filter = new CarFilter();
        List<Car> carList = filter.getCarsByParam("Hatchback", "VAZ", "1.6", "Gasolin", "Automatic");
        assertThat(carList.get(0).getProducer().getMark(), is("VAZ"));
    }
}

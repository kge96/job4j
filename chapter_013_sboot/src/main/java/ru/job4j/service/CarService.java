package ru.job4j.service;

import ru.job4j.domain.Car;

import java.util.List;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 08.12.2017.
 */
public interface CarService {
    List<Car> getAll();
    Car add(Car car);
}

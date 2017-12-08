package ru.job4j.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Car;
import ru.job4j.repository.CarDataRepository;

import java.util.List;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 08.12.2017.
 */
@Service
public class CarServiceImpl implements CarService {

    private final CarDataRepository repository;

    @Autowired
    public CarServiceImpl(CarDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> getAll() {
        return Lists.newArrayList(this.repository.findAll());
    }

    @Override
    public Car add(Car car) {
        return this.repository.save(car);
    }
}

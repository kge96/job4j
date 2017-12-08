package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.Car;

/**
 * Interface for realize carcatalog data repository.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.12.2017.
 */
@Repository
public interface CarDataRepository extends CrudRepository<Car, Integer> {
}

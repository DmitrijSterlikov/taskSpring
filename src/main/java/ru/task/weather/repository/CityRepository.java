package ru.task.weather.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.task.weather.models.City;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}

package ru.task.weather.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.task.weather.models.Temperature;

import java.util.List;

@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
    @Query("SELECT * FROM temperature WHERE id_city = :idCity")
    public List<Temperature> receiveTemperatureIdCity(@Param("idCity") Long idCity);
}


package ru.task.weather.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("temperature")
public class Temperature implements Comparable<Temperature> {

    @Id
    private Long idTemperature;
    private Long idCity;
    private float temperature;
    private Date date;

    public Temperature() {
    }

    public Temperature(Long idTemperature, Long idCity, float temperature, Date date) {
        this.idTemperature = idTemperature;
        this.idCity = idCity;
        this.temperature = temperature;
        this.date = date;
    }

    public Long getIdTemperature() {
        return idTemperature;
    }

    public void setIdTemperature(Long idTemperature) {
        this.idTemperature = idTemperature;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Temperature temperature) {
        return this.date.compareTo(temperature.date);
    }
}

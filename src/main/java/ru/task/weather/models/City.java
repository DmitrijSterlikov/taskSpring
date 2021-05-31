package ru.task.weather.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("city")
public class City {

    @Id
    private Long idCity;
    private String nameCity;

    @MappedCollection(idColumn = "id_city", keyColumn = "date")
    private List<Temperature> list = new ArrayList<>();

    @PersistenceConstructor
    public City(Long idCity, String nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    public List<Temperature> getList() {
        return list;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}

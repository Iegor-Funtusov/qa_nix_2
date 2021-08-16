package ua.com.alevel.service;

import ua.com.alevel.db.CarDB;
import ua.com.alevel.entity.Car;

import java.util.List;

public class CarService implements CrudService<Car> {

    private CarDB carDB = CarDB.getInstance();

    @Override
    public void create(Car car) {
        carDB.create(car);
    }

    @Override
    public void update(Car car) {
        carDB.update(car);
    }

    @Override
    public void delete(String id) {
        carDB.delete(id);
    }

    @Override
    public Car findById(String id) {
        return carDB.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return carDB.findAll();
    }
}

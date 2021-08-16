package ua.com.alevel.db;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarDB {

    private List<Car> cars = new ArrayList<>();
    private static final CarDB instance = new CarDB();

    private CarDB() {}

    public static CarDB getInstance() {
        return instance;
    }

    public void create(Car car) {
        car.setId(generateId());
        cars.add(car);
    }

    public void update(Car car) {
        Car current = cars.stream().filter(u -> u.getId().equals(car.getId())).findFirst().get();
    }

    public void delete(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public void linkOwner(String ownerId, String carId) {
        Car current = cars.stream().filter(u -> u.getId().equals(carId)).findFirst().get();
        current.setOwnerId(ownerId);
    }

    public void unlinkOwner(String carId) {
        Car current = cars.stream().filter(u -> u.getId().equals(carId)).findFirst().get();
        current.setOwnerId(null);
    }

    public Car findById(String id) {
        return cars.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public List<Car> findAll() {
        return cars;
    }

    public List<Car> findAllByOwners(String ownerId) {
        return cars.stream()
                .filter(car -> car.getOwnerId() != null)
                .filter(car -> car.getOwnerId().equals(ownerId)).collect(Collectors.toList());
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (cars.stream().anyMatch(car -> car.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}

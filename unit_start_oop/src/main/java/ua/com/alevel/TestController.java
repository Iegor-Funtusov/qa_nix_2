package ua.com.alevel;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.entity.type.CarType;
import ua.com.alevel.service.CarService;
import ua.com.alevel.service.OwnerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestController {

    private CarService carService = new CarService();
    private OwnerService ownerService = new OwnerService();

    public void start() {
//        Owner owner = new Owner();
//        owner.setName("test1");
//        ownerService.create(owner);
//        List<Owner> owners = ownerService.findAll();
//        owners.forEach(System.out::println);
//
//        Car car = new Car();
//        car.setCarType(CarType.AUDI);
//        carService.create(car);
//        List<Car> cars = carService.findAll();
//        cars.forEach(System.out::println);
//
//        String carId = cars.get(0).getId();
//        String ownerId = owners.get(0).getId();
//        ownerService.linkCar(ownerId, carId);
//
//        car = new Car();
//        car.setCarType(CarType.MERSEDES);
//        carService.create(car);
//        cars = carService.findAll();
//        carId = cars.get(1).getId();
//        ownerService.linkCar(ownerId, carId);
//
//        owners = ownerService.findAll();
//        owners.forEach(System.out::println);
//        cars = carService.findAll();
//        cars.forEach(System.out::println);
//
//        ownerService.delete(ownerId);
//
//        System.out.println("after delete");
//        owners = ownerService.findAll();
//        owners.forEach(System.out::println);
//        cars = carService.findAll();
//        cars.forEach(System.out::println);

        List<BaseEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int r = random.nextInt(2);
            if (r == 0) {
                list.add(new Owner());
            } else {
                list.add(new Car());
            }
        }

        for (BaseEntity baseEntity : list) {
            System.out.println("baseEntity = " + baseEntity.getClass().getSimpleName());
            if (baseEntity instanceof Owner) {
                Owner owner = (Owner) baseEntity;
                System.out.println("owner = " + owner);
            }
            if (baseEntity instanceof Car) {
                Car car = (Car) baseEntity;
                System.out.println("car = " + car);
            }
        }
    }
}

package ua.com.alevel.entity;

import ua.com.alevel.entity.type.CarType;

public class Car extends BaseEntity {

    private CarType carType;
    private String ownerId;

    public Car() {}

    public Car(CarType carType) {
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", carType=" + carType +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}

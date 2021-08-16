package ua.com.alevel.entity;

import java.util.ArrayList;
import java.util.List;

public class Owner extends BaseEntity {

    private String name;
    private List<String> carIds = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<String> carIds) {
        this.carIds = carIds;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", carIds=" + carIds +
                '}';
    }
}

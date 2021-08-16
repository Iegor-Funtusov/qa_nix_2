package ua.com.alevel.db;

import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerDB {

    private List<Owner> owners = new ArrayList<>();

    public void create(Owner owner) {
        owner.setId(generateId());
        owners.add(owner);
    }

    public void update(Owner owner) {
        Owner current = owners.stream().filter(u -> u.getId().equals(owner.getId())).findFirst().get();
        current.setName(owner.getName());
    }

    public boolean existCar(String ownerId, String carId) {
        Owner current = owners.stream().filter(u -> u.getId().equals(ownerId)).findFirst().get();
        return current.getCarIds().stream().anyMatch(id -> id.equals(carId));
    }

    public void linkCar(String ownerId, String carId) {
        Owner current = owners.stream().filter(u -> u.getId().equals(ownerId)).findFirst().get();
        List<String> carIds = current.getCarIds();
        carIds.add(carId);
    }

    public void delete(String id) {
        owners.removeIf(user -> user.getId().equals(id));
    }

    public Owner findById(String id) {
        return owners.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public List<Owner> findAll() {
        return owners;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (owners.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}

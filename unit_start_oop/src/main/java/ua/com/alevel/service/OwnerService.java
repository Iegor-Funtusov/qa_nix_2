package ua.com.alevel.service;

import ua.com.alevel.db.CarDB;
import ua.com.alevel.db.OwnerDB;
import ua.com.alevel.entity.Owner;

import java.util.List;

public class OwnerService implements CrudService<Owner> {

    private OwnerDB ownerDB = new OwnerDB();
    private CarDB carDB = CarDB.getInstance();

    @Override
    public void create(Owner owner) {
        ownerDB.create(owner);
    }

    public void linkCar(String ownerId, String carId) {
        if (!ownerDB.existCar(ownerId, carId)) {
            ownerDB.linkCar(ownerId, carId);
            carDB.linkOwner(ownerId, carId);
        }
    }

    @Override
    public void update(Owner owner) {
        ownerDB.update(owner);
    }

    @Override
    public void delete(String id) {
        Owner owner = findById(id);
        for (String carId : owner.getCarIds()) {
            carDB.unlinkOwner(carId);
        }
        ownerDB.delete(id);
    }

    @Override
    public Owner findById(String id) {
        return ownerDB.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerDB.findAll();
    }
}

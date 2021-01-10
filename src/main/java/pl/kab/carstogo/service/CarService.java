package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.CarEntity;
import pl.kab.carstogo.model.BodyType;
import pl.kab.carstogo.model.Brand;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.model.Status;
import pl.kab.carstogo.repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll().stream()
                .map(CarEntity::mapToCar)
                .collect(Collectors.toList());
    }

    public Car addCar (Car car) {
        CarEntity carEntity = carRepository.save(car.mapToCarEntity());
        return carEntity.mapToCar();
    }

    public Car findByID(Integer id) {
        return carRepository.findById(id).orElseThrow().mapToCar();
    }

    public void remove (Integer id) {
        carRepository.deleteById(id);
    }

    public Car update(Integer id, Car car){
        CarEntity carEntity = carRepository.findById(id).orElseThrow();
        Optional.ofNullable(car.getBody()).ifPresent(carEntity::setBody);
        Optional.ofNullable(car.getBrand()).ifPresent(carEntity::setBrand);
        Optional.ofNullable(car.getColor()).ifPresent(carEntity::setColor);
        Optional.ofNullable(car.getMileage()).ifPresent(carEntity::setMileage);
        Optional.ofNullable(car.getModel()).ifPresent(carEntity::setModel);
        Optional.ofNullable(car.getProductionYear()).ifPresent(carEntity::setProductionYear);
        Optional.ofNullable(car.getRent()).ifPresent(carEntity::setRent);
        Optional.ofNullable(car.getStatus()).ifPresent(carEntity::setStatus);
        carRepository.save(carEntity);
        return carEntity.mapToCar();
    }

    public Car patchCar(Integer id, String field, String value) {
        CarEntity foundCar = carRepository.findById(id).orElseThrow();
        if(field.equalsIgnoreCase("bodyType")){
            foundCar.setBody(BodyType.valueOf(value));
        } else if (field.equalsIgnoreCase("brand")) {
            foundCar.setBrand(Brand.valueOf(value));
        } else if (field.equalsIgnoreCase("color")) {
            foundCar.setColor(value);
        } else if (field.equalsIgnoreCase("mileage")) {
            foundCar.setMileage(Integer.valueOf(value));
        } else if (field.equalsIgnoreCase("model")) {
            foundCar.setModel(value);
        } else if (field.equalsIgnoreCase("productionYear")) {
            foundCar.setProductionYear(Integer.valueOf(value));
        } else if (field.equalsIgnoreCase("rent")) {
            foundCar.setRent(Double.valueOf(value));
        } else if (field.equalsIgnoreCase("status")) {
            foundCar.setStatus(Status.valueOf(value));
        }
        carRepository.save(foundCar);
        return foundCar.mapToCar();
    }
}

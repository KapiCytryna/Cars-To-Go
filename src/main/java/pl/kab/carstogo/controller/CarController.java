package pl.kab.carstogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Integer id) {
        carService.remove(id);
    }
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
        return carService.update(id,car);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchCar(@PathVariable("id") Integer id,
                                           @RequestParam("field") String field,
                                           @RequestParam("value") String value) {
        try {
            return new ResponseEntity<>(carService.patchCar(id, field, value), HttpStatus.ACCEPTED);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Bad format for value/field try again", HttpStatus.BAD_REQUEST);
        }
    }
}

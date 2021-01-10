package pl.kab.carstogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.service.CarService;

@Controller
@RequestMapping("/car")
public class CarViewController {
    private final CarService carService;

    @Autowired
    public CarViewController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String allCars(final Model model) {
        model.addAttribute("carList", carService.findAll());
        return "car/list";
    }

    @GetMapping("/add")
    public String addCar(final Model model){
        model.addAttribute("carForm", new Car());
        return "car/form";
    }

    @PostMapping("/add")
    public String addCarFromProcess(@ModelAttribute("carForm") Car car) {
        carService.addCar(car);
        return "redirect:/car/all";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("carForm", carService.findByID(id));
        return "car/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editCarFormProcess(@ModelAttribute Car car, @PathVariable("id") Integer id) {
        carService.update(id, car);
        return "redirect:/car/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteCarProcess(@PathVariable("id") Integer id){
        carService.remove(id);
        return "redirect:/car/all";
    }
}

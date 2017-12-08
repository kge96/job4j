package ru.job4j.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.domain.Car;
import ru.job4j.service.CarService;

/**
 * Class for creating carcatalog controller.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
@Controller
public class CarController {
    /**
     * Car manager.
     */
    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    /**
     * Get method..
     * @return ModelAndView.
     */
    @GetMapping("/cars")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("cars");
        model.addObject("cars", this.service.getAll());
        return model;
    }

    /**
     * Post method.
     * @param car - carcatalog.
     * @return String.
     */
   @PostMapping("/cars")
    public String add(@ModelAttribute Car car) {
       //todo:realize add car to db.
       return "redirect:cars";
   }
}

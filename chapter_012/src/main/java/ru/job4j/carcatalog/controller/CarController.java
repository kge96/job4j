package ru.job4j.carcatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.carcatalog.models.Car;
import ru.job4j.carcatalog.CarFilter;
import ru.job4j.carcatalog.CarManager;

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
    private CarManager manager = new CarManager();
    /**
     * Car filter.
     */
    private CarFilter filter = new CarFilter();

    /**
     * Get method.
     * @param model - model.
     * @return String.
     */
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String showCars(ModelMap model) {
        model.addAttribute("cars", this.filter.getAllCars());
        return "cars";
    }

    /**
     * Post method.
     * @param car - carcatalog.
     * @return String.
     */
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car) {
        this.manager.addCar(car);
        return "redirect:cars.do";
    }
}

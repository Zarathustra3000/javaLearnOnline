package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {
    private static List<Car> cars = new CarServiceImp().listCar();;

    @RequestMapping(value = { "/cars" }, method = RequestMethod.GET)
    public String carList(ModelMap model) {

        model.addAttribute("cars", cars);

        return "cars";
    }
}

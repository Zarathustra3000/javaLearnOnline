package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    @Override
    public List<Car> listCar() {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Car("1-" + i, i ,10*(5+i)));
        }
        return list;
    }
}

package ru.prkis.lab.auto.service;

import org.springframework.stereotype.Service;
import ru.vyatgu.prkis.lab.auto.Cars;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsService {
    private static List<Cars> testCars;

    private List<Cars> getTestCars() {
        if(testCars != null) {
            return testCars;
        }
        testCars = new ArrayList<>();
        for(long i = 1; i <= 10; i++) {
            Cars testCar = new Cars();
            testCar.setIdCar(i);
            testCar.setIdManufacturer(i);
            testCar.setIdBody(i);
            testCar.setYear(i);
            testCar.setPrice(i);
            testCar.setQuantity(i);
            testCar.setDefective(i);
            testCars.add(testCar);
        }
        return testCars;
    }

    public List<Cars> getAll() {
        return getTestCars();
    }

    public Cars addCars(Cars newCars) {
        getTestCars().add(newCars);
        return newCars;
    }

    public Cars getById(Long id) {
        for(Cars n : testCars){
            if(n.getIdCar() == id)
            {
                return n;
            }
        }
        return null;
    }
}
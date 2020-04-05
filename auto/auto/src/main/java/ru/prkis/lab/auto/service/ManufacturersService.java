package ru.prkis.lab.auto.service;

import org.springframework.stereotype.Service;
import ru.vyatgu.prkis.lab.auto.Manufacturers;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturersService {
    private static List<Manufacturers> testManufacturers;

    private List<Manufacturers> getTestManufacturers() {
        if(testManufacturers != null) {
            return testManufacturers;
        }
        testManufacturers = new ArrayList<>();
        for(long i = 1; i <= 10; i++) {
            Manufacturers testManufacturer = new Manufacturers();
            testManufacturer.setIdManufacturer(i);
            testManufacturer.setName("Наименование производителя " + i);
            testManufacturer.setCountry("Страна " + i);
            testManufacturers.add(testManufacturer);
        }
        return testManufacturers;
    }

    public List<Manufacturers> getAll() {
        return getTestManufacturers();
    }

    public Manufacturers addManufacturers(Manufacturers newManufacturers) {
        getTestManufacturers().add(newManufacturers);
        return newManufacturers;
    }

    public Manufacturers getById(Long id) {
        for(Manufacturers n : testManufacturers){
            if(n.getIdManufacturer() == id)
            {
                return n;
            }
        }
        return null;
    }
}
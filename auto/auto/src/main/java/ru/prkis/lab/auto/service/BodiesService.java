package ru.prkis.lab.auto.service;

import org.springframework.stereotype.Service;
import ru.vyatgu.prkis.lab.auto.Bodies;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodiesService {
    private static List<Bodies> testBodies;

    private List<Bodies> getTestBodies() {
        if(testBodies != null) {
            return testBodies;
        }
        testBodies = new ArrayList<>();
        for(long i = 1; i <= 10; i++) {
            Bodies testBody = new Bodies();
            testBody.setIdBody(i);
            testBody.setName("Наименование кузова " + i);
            testBody.setDescription("Описание кузова " + i);
            testBodies.add(testBody);
        }
        return testBodies;
    }

    public List<Bodies> getAll() {
        return getTestBodies();
    }

    public Bodies addBodies(Bodies newBodies) {
        getTestBodies().add(newBodies);
        return newBodies;
    }

    public Bodies getByID(Long id) {
        for(Bodies n : testBodies){
            if(n.getIdBody() == id)
            {
                return n;
            }
        }
        return null;
    }
}
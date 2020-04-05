package ru.prkis.lab.auto.service;

import ru.vyatgu.prkis.lab.auto.Stats;

import java.util.ArrayList;
import java.util.List;

public class StatsService {

    private static List<Stats> testStats;

    public List<Stats> getAll() {
        return getTestStats();
    }
    private List<Stats> getTestStats() {
        if(testStats != null) {
            return testStats;
        }
        testStats = new ArrayList<>();
        for(long i = 1; i <= 10; i++) {
            Stats testStat = new Stats();
            testStat.setId(i);
            testStat.setIdBody(i);
            testStat.setYear(i);
            testStats.add(testStat);
        }
        return testStats;
    }

    public Stats addStats(Stats newStats) {
        getTestStats().add(newStats);
        return newStats;
    }

    public Stats getById(Long id) {
        for(Stats n : testStats){
            if(n.getId() == id)
            {
                return n;
            }
        }
        return null;
    }


}

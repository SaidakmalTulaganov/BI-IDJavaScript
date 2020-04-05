package ru.prkis.lab.auto.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.prkis.lab.auto.service.StatsService;
import ru.vyatgu.prkis.lab.auto.*;

@Endpoint
public class StatsEndpoint {
    private static final String NAMESPACE_URI = "http://vyatgu.ru/prkis/lab/auto";

    private final StatsService statsService;

    @Autowired
    public StatsEndpoint(StatsService statsService) {
        this.statsService = statsService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddStatsRequest")
    @ResponsePayload
    public GetAddStatsResponse getAllStats(@RequestPayload GetAddStatsRequest request) throws Exception {
        GetAddStatsResponse response = new GetAddStatsResponse();
        response.setStats(statsService.addStats(request.getStats()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStatsByIdRequest")
    @ResponsePayload
    public GetStatsByIdResponse getAllStats(@RequestPayload GetStatsByIdRequest request) throws Exception {
        GetStatsByIdResponse response = new GetStatsByIdResponse();
        response.setStats(statsService.getById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStatsRequest")
    @ResponsePayload
    public GetAllStatsResponse getAllCars(@RequestPayload GetAllStatsRequest request) throws Exception {
        GetAllStatsResponse response = new GetAllStatsResponse();
        response.getStats().addAll(statsService.getAll());
        return response;
    }
}

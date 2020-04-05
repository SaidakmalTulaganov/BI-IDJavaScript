package ru.prkis.lab.auto.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.prkis.lab.auto.service.BodiesService;
import ru.vyatgu.prkis.lab.auto.*;

@Endpoint
public class BodiesEndpoint {
    private static final String NAMESPACE_URI = "http://vyatgu.ru/prkis/lab/auto";

    private final BodiesService bodiesService;

    @Autowired
    public BodiesEndpoint(BodiesService bodiesService) {
        this.bodiesService = bodiesService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddBodiesRequest")
    @ResponsePayload
    public GetAddBodiesResponse getAllBodies(@RequestPayload GetAddBodiesRequest request) throws Exception {
        GetAddBodiesResponse response = new GetAddBodiesResponse();
        response.setBodies(bodiesService.addBodies(request.getBodies()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBodiesByIdRequest")
    @ResponsePayload
    public GetBodiesByIdResponse getAllBodies(@RequestPayload GetBodiesByIdRequest request) throws Exception {
        GetBodiesByIdResponse response = new GetBodiesByIdResponse();
        response.setBodies(bodiesService.getByID(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBodiesRequest")
    @ResponsePayload
    public GetAllBodiesResponse getAllBodies(@RequestPayload GetAllBodiesRequest request) throws Exception {
        GetAllBodiesResponse response = new GetAllBodiesResponse();
        response.getBodies().addAll(bodiesService.getAll());
        return response;
    }
}

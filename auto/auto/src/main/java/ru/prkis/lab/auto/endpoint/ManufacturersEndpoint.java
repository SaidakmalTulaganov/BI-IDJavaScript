package ru.prkis.lab.auto.endpoint;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.ws.server.endpoint.annotation.Endpoint;
        import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
        import org.springframework.ws.server.endpoint.annotation.RequestPayload;
        import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
        import ru.prkis.lab.auto.service.ManufacturersService;
        import ru.vyatgu.prkis.lab.auto.*;

@Endpoint
public class ManufacturersEndpoint {
    private static final String NAMESPACE_URI = "http://vyatgu.ru/prkis/lab/auto";

    private final ManufacturersService manufacturersService;

    @Autowired
    public ManufacturersEndpoint(ManufacturersService manufacturersService) {
        this.manufacturersService = manufacturersService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddManufacturersRequest")
    @ResponsePayload
    public GetAddManufacturersResponse getAllManufacturers(@RequestPayload GetAddManufacturersRequest request) throws Exception {
        GetAddManufacturersResponse response = new GetAddManufacturersResponse();
        response.setManufacturers(manufacturersService.addManufacturers(request.getManufacturers()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getManufacturersByIdRequest")
    @ResponsePayload
    public GetManufacturersByIdResponse getAllManufacturers(@RequestPayload GetManufacturersByIdRequest request) throws Exception {
        GetManufacturersByIdResponse response = new GetManufacturersByIdResponse();
        response.setManufacturers(manufacturersService.getById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllManufacturersRequest")
    @ResponsePayload
    public GetAllManufacturersResponse getAllManufacturers(@RequestPayload GetAllManufacturersRequest request) throws Exception {
        GetAllManufacturersResponse response = new GetAllManufacturersResponse();
        response.getManufacturers().addAll(manufacturersService.getAll());
        return response;
    }
}
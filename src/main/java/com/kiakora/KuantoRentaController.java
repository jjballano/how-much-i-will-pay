package com.kiakora;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/")
public class KuantoRentaController {

    private static final Logger LOG = LoggerFactory.getLogger(KuantoRentaController.class);

    private final TaxesCalculationsService taxesCalculationsService;

    public KuantoRentaController(TaxesCalculationsService taxesCalculationsService) {
        this.taxesCalculationsService = taxesCalculationsService;
    }

    @Get("/ping")
    public String index() {
        return "{\"pong\":true, \"graal\": true}";
    }

    @Post(uri="/kuanto-renta", processes = MediaType.APPLICATION_JSON)
    public KuantoRentaResponse apply(KuantoRentaRequest request) {
        LOG.error("Function requested for region "+request.getRegion());
        return taxesCalculationsService.calculate(request);
    }

}


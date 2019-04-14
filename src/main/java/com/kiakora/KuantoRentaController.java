package com.kiakora;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
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

    @Post(uri = "/kuantorenta", consumes = MediaType.APPLICATION_JSON)
    public KuantoRentaResponse calculate(@Body KuantoRentaRequest request) {
        LOG.error("Function requested for region "+request.getRegion());
        return taxesCalculationsService.calculate(request);
    }

}


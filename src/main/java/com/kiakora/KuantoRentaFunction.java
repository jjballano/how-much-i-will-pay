package com.kiakora;

import io.micronaut.function.FunctionBean;
import io.micronaut.function.executor.FunctionInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Function;

@FunctionBean("kuanto-renta")
public class KuantoRentaFunction extends FunctionInitializer implements Function<KuantoRentaRequest, KuantoRentaResponse> {

    private static final Logger LOG = LoggerFactory.getLogger(KuantoRentaFunction.class);

    private final TaxesCalculationsService taxesCalculationsService;

    public KuantoRentaFunction(TaxesCalculationsService taxesCalculationsService) {
        LOG.info("Function created");
        this.taxesCalculationsService = taxesCalculationsService;
    }

    @Override
    public KuantoRentaResponse apply(KuantoRentaRequest request) {
        LOG.info("Function requested for region "+request.getRegion());
        return taxesCalculationsService.calculate(request);
    }

}


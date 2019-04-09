package com.kiakora;

import io.micronaut.function.FunctionBean;
import io.micronaut.function.executor.FunctionInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Function;

@FunctionBean("kuanto-renta")
public class KuantoRentaFunction extends FunctionInitializer implements Function<KuantoRentaRequest, KuantoRentaResponse> {

    private static final Logger LOG = LoggerFactory.getLogger(KuantoRentaFunction.class);

    @Inject
    private TaxesCalculationsService taxesCalculationsService;

    @Override
    public KuantoRentaResponse apply(KuantoRentaRequest request) {
        LOG.info("Function requested for region "+request.getRegion());
        return taxesCalculationsService.calculate(request);
    }

    /**
     * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar
     * where the argument to echo is the JSON to be parsed.
     */
    public static void main(String...args) throws IOException {
        KuantoRentaFunction function = new KuantoRentaFunction();
        function.run(args, (context)-> function.apply(context.get(KuantoRentaRequest.class)));
    }


}


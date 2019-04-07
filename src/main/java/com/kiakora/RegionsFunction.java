package com.kiakora;

import io.micronaut.function.FunctionBean;
import io.micronaut.function.executor.FunctionInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@FunctionBean("kuanto-renta")
public class RegionsFunction extends FunctionInitializer implements Function<Void, List<Region>> {

    private final RegionService regionService;

    public RegionsFunction(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public List<Region> apply(Void aVoid) {
        return regionService.allRegions();
    }

}


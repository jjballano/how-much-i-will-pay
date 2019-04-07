package com.kiakora;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface KuantoRentaClient {

    @Named("kuanto-renta")
    Single<KuantoRentaResponse> apply(@Body KuantoRentaRequest body);

}

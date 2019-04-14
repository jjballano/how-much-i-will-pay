package com.kiakora;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Named;

@FunctionClient
public interface KuantoRentaClient {

    @Named("kuanto-renta")
    KuantoRentaResponse apply(@Body KuantoRentaRequest request);

}

package com.kiakora;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("/kuanto-renta")
public interface KuantoRentaClient {

    @Post()
    KuantoRentaResponse apply(@Body KuantoRentaRequest request);

}

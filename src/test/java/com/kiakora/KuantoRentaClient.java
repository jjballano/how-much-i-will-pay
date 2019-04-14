package com.kiakora;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface KuantoRentaClient {

    @Post("/kuantorenta")
    KuantoRentaResponse calculate(@Body KuantoRentaRequest request);

}

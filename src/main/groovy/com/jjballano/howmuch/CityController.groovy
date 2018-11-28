package com.jjballano.howmuch

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.Property
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/cities")
class CityController {

    @Property(name = 'irpf.tables.2018')
    protected Map cities

    @Get("/")
    List<String> index() {
        cities.findAll {it.key != 'spain' }.keySet() as List<String>
    }

}

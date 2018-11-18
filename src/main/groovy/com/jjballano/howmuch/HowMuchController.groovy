package com.jjballano.howmuch

import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.validation.Valid

@CompileStatic
@Controller("/howmuch")
class HowMuchController {

    Calculator calculator
    HowMuchController(Calculator calculator){
        this.calculator = calculator
    }

    @Get("/{?command*}")
    @Produces(MediaType.APPLICATION_JSON)
    Map calculates(@Valid RequestCalculation command){
        calculator.calculate(command)?.toMap()
    }
}
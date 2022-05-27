package com.example.javareactivo.operadores;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.model.Venta;
import com.example.javareactivo.util.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class OperadoresCondicionales {

    private final Flux<Persona> fx1 = Flux.fromIterable(Constantes.personas1);
    private final Flux<Persona> fx2 = Flux.fromIterable(Constantes.personas2);
    private final Flux<Venta> fx3 = Flux.fromIterable(Constantes.ventas);

    private final Logger Log = LoggerFactory.getLogger(OperadoresCondicionales.class);

    public void defaultIfEmpty() {
        /*
            Devuelve un valor por defecto si el flujo entero está vacío
            Sirve para Mono y Flux
        */
        fx1.concatWith(Mono.empty())
                .defaultIfEmpty(new Persona(0, "XYZ", 99))
                .subscribe(x -> Log.info(x.toString()));
    }

    public void takeUntil() {
        /*
            Devuelve flujos hasta que se cumpla la condición que se le
            pasa como parámetro (se toma la primera coincidencia)
        */
        fx1.concatWith(Mono.empty())
                .takeUntil(p -> p.getEdad() > 19)
                .subscribe(x -> Log.info(x.toString()));
    }

    public void timeOut() {
        /*
            El delayElements hace que los elementos se demoren 3 seg en llegar
            El timeout lanza una excepción de tipo TimeOutException,
            si se demoran más de dos segundos en llegar
        */
        fx1.delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> Log.info(x.toString()));
    }
}

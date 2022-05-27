package com.example.javareactivo.operadores;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.model.Venta;
import com.example.javareactivo.util.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ControlDeErrores {

    private final Flux<Persona> fx1 = Flux.fromIterable(Constantes.personas1);
    private final Flux<Persona> fx2 = Flux.fromIterable(Constantes.personas2);
    private final Flux<Venta> fx3 = Flux.fromIterable(Constantes.ventas);

    private final Logger Log = LoggerFactory.getLogger(ControlDeErrores.class);

    public void retry() {
        /*
            Si encuentra un error vuelve a intentarlo las veces que se le
            pase como parámetro, pero lanza la excepción
        */
        fx1.concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .retry(1)
                .doOnNext(x -> Log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        /*
            Si encuentra un error, retorna lo que se le pase como parámetro,
            en lugar de la excepción
         */
        fx1.concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorReturn(new Persona(0, "", 99))
                .subscribe(x -> Log.info(x.toString()));
    }

    public void errorResume() {
        /*
            Recibe una función como parámetro, esta función va a contener la excepción
            así que se puede acceder a los métodos de Exception o retornar algún flujo
            de un solo elemento con valor por defecto
         */
        fx1.concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0, "", 99)))
                .subscribe(x -> Log.info(x.toString()));
    }

    public void errorMap() {
        /*
            Recibe una función como parámetro, esta función va a contener la excepción
            así que se puede acceder a los métodos de Exception o retornar una excepción
            personalizada
         */
        fx1.concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> Log.info(x.toString()));
    }
}

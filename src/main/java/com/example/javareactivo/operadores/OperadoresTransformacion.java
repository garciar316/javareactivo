package com.example.javareactivo.operadores;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.util.Constantes;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@NoArgsConstructor
public class OperadoresTransformacion {

    private final Logger Log = LoggerFactory.getLogger(OperadoresTransformacion.class);

    public void map() {
        Flux.fromIterable(Constantes.personas1)
                .map(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return p;
                })
                .subscribe(p -> Log.info(p.toString()));

        Flux<Integer> fx = Flux.range(0, 10);
        //Retorna una copia del objeto con los cambios aplicados (sin modificar el original)
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> Log.info("X: " +  x));
    }

    public void flatMap() {
        //Retorna un nuevo flujo de datos, del objeto con los cambios aplicados
        Flux.fromIterable(Constantes.personas1)
                .flatMap(persona -> {
                    persona.setEdad(persona.getEdad() + 10);
                    return Mono.just(persona);
                })
                .subscribe(persona -> Log.info(persona.toString()));
    }

    public void groupBy() {
        //Devuelve un flujo por cada grupo que coincida con la condición dada
        Flux.fromIterable(Constantes.personas1)
                .groupBy(Persona::getId)
                .flatMap(Flux::collectList)
                .subscribe(p -> Log.info(p.toString()));
    }
}

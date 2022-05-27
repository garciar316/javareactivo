package com.example.javareactivo.operadores;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.util.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collectors;

public class OperadoresMatematicos {

    private Logger Log = LoggerFactory.getLogger(OperadoresMatematicos.class);
    private Flux<Persona> fx1 = Flux.fromIterable(Constantes.personas1);

    public void average() {
        /*
            Devuelve el promedio de las edades
         */
        fx1.collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(p -> Log.info(p.toString()));
    }

    public void count() {
        /*
            Devuelve el número de elementos que tiene el flujo
         */
        fx1.count()
                .subscribe(p -> Log.info(String.format("Cantidad: %s", p)));
    }

    public void min() {
        /*
            Devuelve la persona con la menor edad
         */
        fx1.collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(p -> Log.info(p.orElseThrow().toString()));
    }

    public void sum() {
        /*
            Devuelve la suma de las edades
         */
        fx1.collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(p -> Log.info(String.format("Suma: %s", p)));
    }

    public void summarizing() {
        /*
            Devuelve el conteo, la suma, el mínimo, el promedio, el maximo de las edades
            como un objeto
         */
        fx1.collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe(p -> Log.info(String.format("Resumen: %s", p)));
    }
}

package com.example.javareactivo.operadores;

import com.example.javareactivo.util.Constantes;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

@NoArgsConstructor
public class OperadoresFiltrado {

    private final Logger Log = LoggerFactory.getLogger(OperadoresFiltrado.class);

    public void filter() {
        Flux.fromIterable(Constantes.personas1)
                .filter(p -> p.getEdad() > 22)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void distinct() {
        /*
            Devuelve los valores sin repetidos
            Para validar si un objeto está repetido es necesario modificar el equals and hashcode,
            ya que java por defecto compara la dirección en memoria
        */
        Flux.fromIterable(Constantes.personas1)
                .distinct()
                .subscribe(p -> Log.info(p.toString()));
    }

    public void take() {
        //Toma el valor que le asigna como parámetro, tomando el número 1 como el primero
        Flux.fromIterable(Constantes.personas1)
                .take(2)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void takeLast() {
        //Toma el valor que le asigna como parámetro, tomando el número 1 como el último
        Flux.fromIterable(Constantes.personas1)
                .takeLast(1)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void skip() {
        //Toma todos los valores, ignorando el que se le pasa como parámetro,
        //tomando el número 1 como el primero
        Flux.fromIterable(Constantes.personas1)
                .skip(1)
                .subscribe(p -> Log.info(p.toString()));
    }
    public void skipLast() {
        //Toma todos los valores, ignorando el que se le pasa como parámetro,
        //tomando el número 1 como el último
        Flux.fromIterable(Constantes.personas1)
                .skipLast(1)
                .subscribe(p -> Log.info(p.toString()));
    }
}

package com.example.javareactivo.operadores;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.model.Venta;
import com.example.javareactivo.util.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class OperadoresCombinacion {

    private final Flux<Persona> fx1 = Flux.fromIterable(Constantes.personas1);
    private final Flux<Persona> fx2 = Flux.fromIterable(Constantes.personas2);
    private final Flux<Venta> fx3 = Flux.fromIterable(Constantes.ventas);

    private final Logger Log = LoggerFactory.getLogger(OperadoresFiltrado.class);

    public void merge() {
        //Combina los flujos, es indiferente del tipo de dato
        Flux.merge(fx1, fx2, fx3)
                .subscribe(persona -> Log.info(persona.toString()));
    }

    public void zip() {
        /*
            Combina los flujos y como último parámetro una función que recibe
            los flujos, el zip retorna lo que la función retorne
         */
        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(Log::info);

        //Solo concatena, pero espera que todos los flujos tengan al menos un elemento
        Flux.zip(fx1, fx2, fx3)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void zipWith() {
        //Es como el zip, pero se usa desde un Flux y no con la clase flux (como estático)
        fx1.zipWith(fx1, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(Log::info);
    }
}

package com.example.javareactivo.util;

import com.example.javareactivo.model.Persona;
import com.example.javareactivo.model.Venta;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Constantes {

    public static final List<Persona> personas1 = Arrays.asList(
            new Persona(1, "Juan", 24),
            new Persona(1, "Pedro", 22),
            new Persona(3, "Daniel", 20)
    );

    public static final List<Persona> personas2 = Arrays.asList(
            new Persona(3, "Sergio", 24),
            new Persona(4, "Carolina", 22),
            new Persona(5, "Sebastian", 20)
    );

    public static final List<Venta> ventas = Arrays.asList(
            new Venta(1, LocalDateTime.now())
    );
}

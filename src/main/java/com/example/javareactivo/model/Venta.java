package com.example.javareactivo.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Venta {

    private Integer id;
    private LocalDateTime fecha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id.equals(venta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

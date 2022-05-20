package co.com.sofkau.operacion.entitys.liderO;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generi.values.*;

import java.util.Objects;

public class Lider extends Entity<LiderId> {

    private Nombre nombre;
    private Nacionalidad nacionalidad;
    private Edad edad;
    private Rango rango;
    private Genero genero;

    public Lider(LiderId entityId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango = rango;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = Objects.requireNonNull(nacionalidad);
    }
    public Edad edad() {
        return edad;
    }

    public void actualizarEdad(Edad edad) {
        this.edad = Objects.requireNonNull(edad);
    }

    public Rango rango() {
        return  rango;
    }

    public void actualizarRango(Rango rango) {
        this.rango = Objects.requireNonNull(rango);
    }

    public Genero genero() {
        return genero;
    }

    public void actualizarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }
}

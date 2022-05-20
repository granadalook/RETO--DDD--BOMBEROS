package co.com.sofkau.unidadmedica.entitys.VictimaR;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generi.values.Genero;
import co.com.sofkau.generi.values.Nacionalidad;
import co.com.sofkau.generi.values.Nombre;

import co.com.sofkau.generi.values.EdadVictima;

public class Victima extends Entity<VictimaId> {
    private Nombre nombre;
    private Nacionalidad nacionalidad;
    private EdadVictima edad;
    private Genero genero;

    public Victima(VictimaId entityId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edad, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public EdadVictima edad() {
        return edad;
    }

    public void actualizarEdad(EdadVictima edad) {
        this.edad = edad;
    }

    public Genero genero() {
        return genero;
    }

    public void actualizarGenero(Genero genero) {
        this.genero = genero;
    }
}

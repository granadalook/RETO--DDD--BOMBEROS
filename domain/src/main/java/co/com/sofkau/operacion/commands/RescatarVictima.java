package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.generi.values.Genero;
import co.com.sofkau.generi.values.Nacionalidad;
import co.com.sofkau.generi.values.Nombre;

public class RescatarVictima extends Command {
    private final OperacionId operacionId;
    private final VictimaId victimaId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final EdadVictima edad;
    private final Genero genero;

    public RescatarVictima(OperacionId operacionId, VictimaId victimaId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edad, Genero genero) {
        this.operacionId = operacionId;
        this.victimaId = victimaId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public VictimaId getVictimaId() {
        return victimaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public EdadVictima getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }
}

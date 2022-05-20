package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.generi.values.Nombre;

public class ActualizarNombre extends Command {
    private final OperacionId operacionId;
    private final Nombre nombre;

    public ActualizarNombre(OperacionId operacionId, Nombre nombre) {
        this.operacionId = operacionId;
        this.nombre = nombre;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
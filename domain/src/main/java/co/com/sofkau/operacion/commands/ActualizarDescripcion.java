package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.values.Descripcion;
/**
 * Comando  ActualizarDescripcion
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class ActualizarDescripcion extends Command {
    private final OperacionId operacionId;
    private final Descripcion descripcion;

    public ActualizarDescripcion(OperacionId operacionId, Descripcion descripcion) {
        this.operacionId = operacionId;
        this.descripcion = descripcion;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}

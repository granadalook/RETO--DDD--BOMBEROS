package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.unidadusar.UnidadUsarId;

public class AsignarUnidadRescatista  extends Command {
    private final OperacionId operacionId;
    private final UnidadUsarId unidadUsarId;

    public AsignarUnidadRescatista(OperacionId operacionId, UnidadUsarId unidadUsarId) {
        this.operacionId = operacionId;
        this.unidadUsarId = unidadUsarId;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

}

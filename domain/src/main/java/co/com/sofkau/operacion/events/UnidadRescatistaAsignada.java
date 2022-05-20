package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.UnidadUsarId;

public class UnidadRescatistaAsignada extends DomainEvent {
    private final UnidadUsarId unidadUsarId;

    public UnidadRescatistaAsignada(UnidadUsarId unidadUsarId) {
        super("sofkau.operacion.events.inidadrescatistaasignada");
        this.unidadUsarId = unidadUsarId;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }
}


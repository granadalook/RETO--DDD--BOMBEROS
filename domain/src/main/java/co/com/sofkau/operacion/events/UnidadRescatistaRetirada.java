package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.UnidadUsarId;

public class UnidadRescatistaRetirada extends DomainEvent {
    private final UnidadUsarId unidadUsarId;

    public UnidadRescatistaRetirada(UnidadUsarId unidadUsarId) {
        super("sofkau.operacion.events.inidadrescatistaretirada");
        this.unidadUsarId = unidadUsarId;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }
}

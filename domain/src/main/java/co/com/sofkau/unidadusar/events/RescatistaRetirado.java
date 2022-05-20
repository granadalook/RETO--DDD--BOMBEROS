package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;

public class RescatistaRetirado extends DomainEvent {

    private final RescatistaId rescatistaId;

    public RescatistaRetirado(RescatistaId rescatistaId) {
        super("sofkau.unidadusar.events.rescatistaretirado");
        this.rescatistaId = rescatistaId;

    }
    public RescatistaId RescatistaId() {
        return rescatistaId;
    }
}

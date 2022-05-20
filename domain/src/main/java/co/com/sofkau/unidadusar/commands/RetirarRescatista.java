package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;

public class RetirarRescatista extends Command{
    private final UnidadUsarId unidadUsarId;
    private final RescatistaId rescatistaId;

    public RetirarRescatista(UnidadUsarId unidadUsarId, RescatistaId rescatistaId) {
        this.unidadUsarId = unidadUsarId;
        this.rescatistaId = rescatistaId;
    }

    public UnidadUsarId unidadUsarId() {
        return unidadUsarId;
    }

    public RescatistaId rescatistaId() {
        return rescatistaId;
    }
}

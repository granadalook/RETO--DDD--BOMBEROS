package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.values.TipoEquipo;

public class EquiposAgregados extends DomainEvent {
    private final EquiposId equiposId;
    private final TipoEquipo tipoEquipo;

    public EquiposAgregados(EquiposId equiposId, TipoEquipo tipoEquipo) {
        super("sofkau.unidadusar.events.equiposagregados");
        this.equiposId = equiposId;
        this.tipoEquipo = tipoEquipo;
    }

    public EquiposId equiposId() {
        return equiposId;
    }

    public TipoEquipo tipoEquipo() {
        return tipoEquipo;
    }
}

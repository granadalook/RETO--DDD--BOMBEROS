package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.values.PropositoCamion;
import co.com.sofkau.unidadusar.values.TipoCamion;

public class CamionAsignado extends DomainEvent {
    private final CamionId camionId;
    private final TipoCamion tipoCamion;
    private final PropositoCamion propositoCamion;

    public CamionAsignado(CamionId camionId, TipoCamion tipoCamion, PropositoCamion propositoCamion) {
        super("sofkau.unidadusar.events.camionasignado");
        this.camionId = camionId;
        this.tipoCamion = tipoCamion;
        this.propositoCamion = propositoCamion;
    }

    public CamionId CamionId() {
        return camionId;
    }

    public TipoCamion TipoCamion() {
        return tipoCamion;
    }

    public PropositoCamion PropositoCamion() {
        return propositoCamion;
    }
}


package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.values.Descripcion;

public class DescripcionActualizada extends DomainEvent {
    private final Descripcion descripcion;
    public DescripcionActualizada(Descripcion descripcion) {
        super("sofkau.operacion.events.descripcionactualizada");
        this.descripcion=descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}

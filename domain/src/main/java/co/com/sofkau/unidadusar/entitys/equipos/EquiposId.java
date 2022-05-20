package co.com.sofkau.unidadusar.entitys.equipos;

import co.com.sofka.domain.generic.Identity;

public class EquiposId extends Identity {
    public EquiposId(String uuid) {
        super(uuid);
    }

    public EquiposId() {
    }

    public static EquiposId of(String id){
        return new  EquiposId(id);
    }
}

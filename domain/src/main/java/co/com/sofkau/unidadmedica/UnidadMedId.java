package co.com.sofkau.unidadmedica;

import co.com.sofka.domain.generic.Identity;


public class UnidadMedId extends Identity {
    public UnidadMedId(String uuid) {
        super(uuid);
    }

    public UnidadMedId() {

    }

    public static UnidadMedId of(String id) {
        return new UnidadMedId(id);
    }
}



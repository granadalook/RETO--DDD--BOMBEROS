package co.com.sofkau.unidadusar.entitys.camion;

import co.com.sofka.domain.generic.Identity;

public class CamionId extends Identity {
    public CamionId(String uuid) {
        super(uuid);
    }

    public CamionId() {
    }

    public static CamionId of(String id) {
        return new CamionId(id);
    }
}

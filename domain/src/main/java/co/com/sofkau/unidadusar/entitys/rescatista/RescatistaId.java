package co.com.sofkau.unidadusar.entitys.rescatista;

import co.com.sofka.domain.generic.Identity;

public class RescatistaId extends Identity {
    public RescatistaId(String uuid) {
        super(uuid);
    }

    public RescatistaId() {
    }

    public static RescatistaId of(String id){
        return new RescatistaId(id);
    }
}

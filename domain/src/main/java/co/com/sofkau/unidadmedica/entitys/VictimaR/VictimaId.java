package co.com.sofkau.unidadmedica.entitys.VictimaR;

import co.com.sofka.domain.generic.Identity;

public class VictimaId extends Identity {
    public VictimaId(String uuid) {
        super(uuid);
    }

    public VictimaId() {
    }
    public  static  VictimaId of(String id){
        return new VictimaId(id);
    }

}
package co.com.sofkau.unidadusar;

import co.com.sofka.domain.generic.Identity;

public class UnidadUsarId extends Identity {
    public  UnidadUsarId(String uuid){
        super(uuid);
    }
    public UnidadUsarId(){

    }
    public static UnidadUsarId of(String id){
        return new  UnidadUsarId(id);
    }
}

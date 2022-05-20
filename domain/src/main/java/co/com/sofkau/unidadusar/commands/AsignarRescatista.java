package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;

public class AsignarRescatista extends Command {
    private final UnidadUsarId unidadUsarId;
    private final RescatistaId rescatistaId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public AsignarRescatista(UnidadUsarId unidadUsarId, RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad,
                          Edad edad, Rango rango, Genero genero) {
        this.unidadUsarId = unidadUsarId;
        this.rescatistaId = rescatistaId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango = rango;
        this.genero = genero;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }

    public RescatistaId getRescatistaId() {
        return rescatistaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Edad getEdad() {
        return edad;
    }

    public Rango getRango() {
        return rango;
    }

    public Genero getGenero() {
        return genero;
    }
}

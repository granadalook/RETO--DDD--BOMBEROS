package co.com.sofkau.unidadusar;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.*;

public class UnidadUsarChange extends EventChange {
    public UnidadUsarChange(UnidadUsar unidadUsar) {
        apply((EquiposAgregados event)->{
            unidadUsar.equipos.add(new Equipos(event.equiposId(),event.tipoEquipo()));
        });

        apply((EncargadoAsignado event)->{
            unidadUsar.encargado= new Rscatista(event.rescatistaId(),event.nombre(), event.nacionalidad(), event.edad(), event.rango(), event.genero());
        });
        apply((RscatistaAsignado event)->{
            unidadUsar.rscatistas.add(new Rscatista(event.rescatistaId(),event.nombre(), event.nacionalidad(), event.edad(), event.rango(), event.genero()));
        });
        apply((RescatistaRetirado event)->{
            var numeroRescatistas = unidadUsar.rscatistas.size();
            if (numeroRescatistas<=1)
                throw new IllegalArgumentException("No puedes dejar una unidad sin rescatistras");
            unidadUsar.rscatistas.removeIf(rescatista -> rescatista.identity().equals(event.RescatistaId()));
        });
        apply((TipoUnudadActualizada event)->{
            unidadUsar.tipoUnidad= event.tipoUnidad();
        });
        apply((UnidadRescatistaCreada event)->{
            unidadUsar.tipoUnidad= event.tipoUnidad();
            unidadUsar.rscatistas= event.rscatistas();
            unidadUsar.encargado=event.encargado();
            unidadUsar.equipos=event.equipos();
            unidadUsar.camions=event.camions();
        });
        apply((CamionAsignado event)->{
            unidadUsar.camions.add(new Camion(event.CamionId(), event.TipoCamion(),event.PropositoCamion()));
        });
    }
}

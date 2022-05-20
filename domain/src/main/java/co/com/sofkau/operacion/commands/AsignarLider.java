package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
/**
 * Comando  AsignarLider
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class AsignarLider extends Command {
    private final OperacionId operacionId;
    private final LiderId liderId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public AsignarLider(OperacionId operacionId, LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        this.operacionId = operacionId;
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango = rango;
        this.genero = genero;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public LiderId getLiderId() {
        return liderId;
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

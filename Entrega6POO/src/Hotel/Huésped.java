package Hotel;
import java.util.*;

/**
 * Clase que define un huésped del hotel.
 */
public class Huésped {
    private String nombres;
    private String apellidos;
    private int documentoIdentidad;
    private Date fechaIngreso;
    private Date fechaSalida;

    public Huésped(String nombres, String apellidos, int documentoIdentidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setFechaSalida(Date fecha) {
        fechaSalida = fecha;
    }

    public void setFechaIngreso(Date fecha) {
        fechaIngreso = fecha;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public int obtenerDíasAlojamiento() {
        // Resta la fecha de ingreso de la fecha de salida utilizando getTime (milisegundos)
        // 86400000 es la cantidad de milisegundos en un día
        int días = (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / 86400000);
        return días;
    }
}
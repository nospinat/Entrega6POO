package Hotel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase que define el hotel y gestiona las habitaciones.
 */
public class Hotel {
    // Vector de habitaciones (usando la clase con tilde Habitación)
    public static Vector<Habitación> listaHabitaciones;

    public Hotel() {
        listaHabitaciones = new Vector<Habitación>();

        // Se crean las 10 habitaciones según el enunciado
        // Las primeras 5 a 120000, las siguientes 5 a 160000
        Habitación habitación1 = new Habitación(1, true, 120000);
        Habitación habitación2 = new Habitación(2, true, 120000);
        Habitación habitación3 = new Habitación(3, true, 120000);
        Habitación habitación4 = new Habitación(4, true, 120000);
        Habitación habitación5 = new Habitación(5, true, 120000);
        Habitación habitación6 = new Habitación(6, true, 160000);
        Habitación habitación7 = new Habitación(7, true, 160000);
        Habitación habitación8 = new Habitación(8, true, 160000);
        Habitación habitación9 = new Habitación(9, true, 160000);
        Habitación habitación10 = new Habitación(10, true, 160000);

        listaHabitaciones.add(habitación1);
        listaHabitaciones.add(habitación2);
        listaHabitaciones.add(habitación3);
        listaHabitaciones.add(habitación4);
        listaHabitaciones.add(habitación5);
        listaHabitaciones.add(habitación6);
        listaHabitaciones.add(habitación7);
        listaHabitaciones.add(habitación8);
        listaHabitaciones.add(habitación9);
        listaHabitaciones.add(habitación10);
    }

    public String buscarFechaIngresoHabitación(int número) {
        for(int i = 0; i < listaHabitaciones.size(); i++) {
            Habitación habitación = (Habitación) listaHabitaciones.elementAt(i);
            if (habitación.getNúmeroHabitación() == número) {
                Date fecha = habitación.getHuésped().getFechaIngreso();
                DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                return formatoFecha.format(fecha);
            }
        }
        return "";
    }

    public boolean buscarHabitaciónOcupada(int número) {
        for(int i = 0; i < listaHabitaciones.size(); i++) {
            Habitación habitación = (Habitación) listaHabitaciones.elementAt(i);
            if (habitación.getNúmeroHabitación() == número && !habitación.getDisponible()) {
                return true; // La habitación está ocupada
            }
        }
        return false; // La habitación está libre
    }
}
package ventanacontacto;

import java.time.LocalDate;

/**
 * Clase que define un contacto para una agenda.
 */
public class Contacto {
    String nombres;
    String apellidos;
    LocalDate fechaNacimiento;
    String dirección;
    String teléfono;
    String correo;

    /**
     * Constructor de la clase Contacto
     */
    public Contacto(String nombres, String apellidos, LocalDate fechaNacimiento, String dirección, String teléfono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.correo = correo;
    }
}
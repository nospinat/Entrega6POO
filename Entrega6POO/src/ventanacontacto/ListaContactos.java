package ventanacontacto;

import java.util.Vector;

/**
 * Clase que define una lista de objetos de tipo Contacto.
 */
public class ListaContactos {
    Vector<Contacto> lista;

    /**
     * Constructor de la clase ListaContactos
     */
    public ListaContactos() {
        lista = new Vector<Contacto>();
    }

    /**
     * Método que agrega un contacto a la lista
     */
    public void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }
}
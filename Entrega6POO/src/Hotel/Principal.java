package Hotel;

/**
 * Clase principal que ejecuta el programa.
 */
public class Principal {
    public static void main(String[] args) {
        // Ejecución en el hilo de despacho de eventos de Swing para seguridad
        javax.swing.SwingUtilities.invokeLater(() -> {
            Hotel hotel = new Hotel();
            VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal(hotel);
            miVentanaPrincipal.setVisible(true);
        });
    }
}
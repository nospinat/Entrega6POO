package Nómina;

/**
 * Clase principal que inicia la aplicación.
 */
public class Principal {
    public static void main(String[] args) {
        // Se utiliza invokeLater para buenas prácticas en Swing (gestión de hilos de interfaz)
        javax.swing.SwingUtilities.invokeLater(() -> {
            Nómina.VentanaPrincipal miVentanaPrincipal = new Nómina.VentanaPrincipal();
            miVentanaPrincipal.setVisible(true);
        });
    }
}
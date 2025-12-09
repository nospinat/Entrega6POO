package Hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuOpciones;
    private JMenuItem itemMenu1;
    private JMenuItem itemMenu2;
    private Hotel hotel;

    public VentanaPrincipal(Hotel hotel) {
        this.hotel = hotel;
        inicio();
        setTitle("Hotel");
        setSize(280,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        barraMenu = new JMenuBar();
        menuOpciones = new JMenu("Menú");
        itemMenu1 = new JMenuItem("Consultar habitaciones");
        itemMenu2 = new JMenuItem("Salida de huéspedes");

        menuOpciones.add(itemMenu1);
        menuOpciones.add(itemMenu2);
        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        itemMenu1.addActionListener(this);
        itemMenu2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == itemMenu1) {
            VentanaHabitaciones ventanaHabitaciones = new VentanaHabitaciones(hotel);
            ventanaHabitaciones.setVisible(true);
        }
        if (evento.getSource() == itemMenu2) {
            try {
                String númeroHabitación = JOptionPane.showInputDialog(null,
                        "Ingrese número de habitación", "Salida de huéspedes",
                        JOptionPane.QUESTION_MESSAGE);

                if (númeroHabitación != null) { // Validación por si cancelan el input
                    int número = Integer.valueOf(númeroHabitación);

                    if (número < 1 || número > 10) {
                        JOptionPane.showMessageDialog(this, "El número de habitación debe estar entre 1 y 10",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
                    } else if (hotel.buscarHabitaciónOcupada(número)) {
                        VentanaSalida ventanaSalida = new VentanaSalida(hotel, número);
                        ventanaSalida.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "La habitación ingresada no ha sido ocupada",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
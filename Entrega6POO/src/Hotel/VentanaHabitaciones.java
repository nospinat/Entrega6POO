package Hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaHabitaciones extends JFrame implements ActionListener {
    private Container contenedor;
    // Etiquetas de cada habitación y disponibilidad
    private JLabel habitación1, habitación2, habitación3, habitación4, habitación5;
    private JLabel habitación6, habitación7, habitación8, habitación9, habitación10;
    private JLabel disponibleHab1, disponibleHab2, disponibleHab3, disponibleHab4, disponibleHab5;
    private JLabel disponibleHab6, disponibleHab7, disponibleHab8, disponibleHab9, disponibleHab10;

    private JLabel habitaciónSeleccionada;
    private JSpinner campoHabitaciónSeleccionada;
    private SpinnerNumberModel modeloSpinner;
    private JButton botónAceptar;
    private Hotel hotel;

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        inicio();
        setTitle("Habitaciones");
        setSize(760,260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        Habitación habitación;

        // --- Configuración manual de las 10 habitaciones ---

        // Hab 1
        habitación1 = new JLabel("Habitación 1");
        habitación1.setBounds(20, 30, 130, 23);
        disponibleHab1 = new JLabel("Disponible");
        disponibleHab1.setBounds(20, 50, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(0);
        if (!habitación.getDisponible()) disponibleHab1.setText("No disponible");

        // Hab 2
        habitación2 = new JLabel("Habitación 2");
        habitación2.setBounds(160, 30, 130, 23);
        disponibleHab2 = new JLabel("Disponible");
        disponibleHab2.setBounds(160, 50, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(1);
        if (!habitación.getDisponible()) disponibleHab2.setText("No disponible");

        // Hab 3
        habitación3 = new JLabel("Habitación 3");
        habitación3.setBounds(300, 30, 130, 23);
        disponibleHab3 = new JLabel("Disponible");
        disponibleHab3.setBounds(300, 50, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(2);
        if (!habitación.getDisponible()) disponibleHab3.setText("No disponible");

        // Hab 4
        habitación4 = new JLabel("Habitación 4");
        habitación4.setBounds(440, 30, 130, 23);
        disponibleHab4 = new JLabel("Disponible");
        disponibleHab4.setBounds(440, 50, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(3);
        if (!habitación.getDisponible()) disponibleHab4.setText("No disponible");

        // Hab 5
        habitación5 = new JLabel("Habitación 5");
        habitación5.setBounds(580, 30, 135, 23);
        disponibleHab5 = new JLabel("Disponible");
        disponibleHab5.setBounds(580, 50, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(4);
        if (!habitación.getDisponible()) disponibleHab5.setText("No disponible");

        // Hab 6
        habitación6 = new JLabel("Habitación 6");
        habitación6.setBounds(20, 120, 130, 23);
        disponibleHab6 = new JLabel("Disponible");
        disponibleHab6.setBounds(20, 140, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(5);
        if (!habitación.getDisponible()) disponibleHab6.setText("No disponible");

        // Hab 7
        habitación7 = new JLabel("Habitación 7");
        habitación7.setBounds(160, 120, 130, 23);
        disponibleHab7 = new JLabel("Disponible");
        disponibleHab7.setBounds(160, 140, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(6);
        if (!habitación.getDisponible()) disponibleHab7.setText("No disponible");

        // Hab 8
        habitación8 = new JLabel("Habitación 8");
        habitación8.setBounds(300, 120, 130, 23);
        disponibleHab8 = new JLabel("Disponible");
        disponibleHab8.setBounds(300, 140, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(7);
        if (!habitación.getDisponible()) disponibleHab8.setText("No disponible");

        // Hab 9
        habitación9 = new JLabel("Habitación 9");
        habitación9.setBounds(440, 120, 130, 23);
        disponibleHab9 = new JLabel("Disponible");
        disponibleHab9.setBounds(440, 140, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(8);
        if (!habitación.getDisponible()) disponibleHab9.setText("No disponible");

        // Hab 10
        habitación10 = new JLabel("Habitación 10");
        habitación10.setBounds(580, 120, 135, 23);
        disponibleHab10 = new JLabel("Disponible");
        disponibleHab10.setBounds(580, 140, 100, 23);
        habitación = (Habitación) hotel.listaHabitaciones.elementAt(9);
        if (!habitación.getDisponible()) disponibleHab10.setText("No disponible");

        // --- Selección ---
        habitaciónSeleccionada = new JLabel("Habitación a reservar:");
        habitaciónSeleccionada.setBounds(250, 180, 135, 23);

        campoHabitaciónSeleccionada = new JSpinner();
        modeloSpinner = new SpinnerNumberModel();
        modeloSpinner.setMinimum(1);
        modeloSpinner.setMaximum(10);
        modeloSpinner.setValue(1);
        campoHabitaciónSeleccionada.setModel(modeloSpinner);
        campoHabitaciónSeleccionada.setBounds(380, 180, 40, 23);

        botónAceptar = new JButton("Aceptar");
        botónAceptar.setBounds(500, 180, 100, 23);

        // Añadir componentes
        contenedor.add(habitación1); contenedor.add(disponibleHab1);
        contenedor.add(habitación2); contenedor.add(disponibleHab2);
        contenedor.add(habitación3); contenedor.add(disponibleHab3);
        contenedor.add(habitación4); contenedor.add(disponibleHab4);
        contenedor.add(habitación5); contenedor.add(disponibleHab5);
        contenedor.add(habitación6); contenedor.add(disponibleHab6);
        contenedor.add(habitación7); contenedor.add(disponibleHab7);
        contenedor.add(habitación8); contenedor.add(disponibleHab8);
        contenedor.add(habitación9); contenedor.add(disponibleHab9);
        contenedor.add(habitación10); contenedor.add(disponibleHab10);
        contenedor.add(habitaciónSeleccionada);
        contenedor.add(campoHabitaciónSeleccionada);
        contenedor.add(botónAceptar);

        botónAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botónAceptar) {
            int habitación = (int) campoHabitaciónSeleccionada.getValue();
            if (!hotel.buscarHabitaciónOcupada(habitación)) {
                VentanaIngreso ventanaIngreso = new VentanaIngreso(hotel, habitación);
                setVisible(false);
                ventanaIngreso.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "La habitación está ocupada",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }
    }
}
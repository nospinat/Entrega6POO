package Hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

public class VentanaSalida extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel habitación;
    private JLabel fechaIngreso, fechaSalida, cantidadDías;
    private JTextField campoFechaSalida;
    private JLabel totalPago;
    private JButton calcular, registrarSalida;
    private Hotel hotel;
    private int númeroHabitación;
    private int posiciónHabitación;
    private Habitación habitaciónOcupada;

    public VentanaSalida(Hotel hotel, int número) {
        this.hotel = hotel;
        this.númeroHabitación = número;
        inicio();
        setTitle("Salida huéspedes");
        setSize(260,260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3,3,3,3);

        habitación = new JLabel("Habitación: " + númeroHabitación);
        c.gridx = 0; c.gridy = 0;
        contenedor.add(habitación, c);

        String fecha = hotel.buscarFechaIngresoHabitación(númeroHabitación);
        fechaIngreso = new JLabel("Fecha de ingreso: " + fecha);
        c.gridx = 0; c.gridy = 1;
        contenedor.add(fechaIngreso, c);

        fechaSalida = new JLabel("Fecha de salida (aaaa-mm-dd): ");
        c.gridx = 0; c.gridy = 2;
        contenedor.add(fechaSalida, c);

        campoFechaSalida = new JTextField();
        c.gridx = 0; c.gridy = 3;
        contenedor.add(campoFechaSalida, c);

        calcular = new JButton("Calcular");
        c.gridx = 0; c.gridy = 4;
        contenedor.add(calcular, c);
        calcular.addActionListener(this);

        cantidadDías = new JLabel("Cantidad de días: ");
        c.gridx = 0; c.gridy = 5;
        contenedor.add(cantidadDías, c);

        totalPago = new JLabel("Total: $");
        c.gridx = 0; c.gridy = 6;
        contenedor.add(totalPago, c);

        registrarSalida = new JButton("RegistrarSalida");
        c.gridx = 0; c.gridy = 7;
        contenedor.add(registrarSalida, c);
        registrarSalida.setEnabled(false);
        registrarSalida.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            String fechaS = campoFechaSalida.getText();
            for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
                habitaciónOcupada = (Habitación) hotel.listaHabitaciones.elementAt(i);
                if (habitaciónOcupada.getNúmeroHabitación() == this.númeroHabitación) {
                    try {
                        posiciónHabitación = i;
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha2 = formatoFecha.parse(fechaS);

                        habitaciónOcupada.getHuésped().setFechaSalida(fecha2);
                        Date fecha1 = habitaciónOcupada.getHuésped().getFechaIngreso();

                        if (fecha1.compareTo(fecha2) < 0) {
                            int cantidad = habitaciónOcupada.getHuésped().obtenerDíasAlojamiento();
                            cantidadDías.setText("Cantidad de días: " + cantidad);
                            double valor = cantidad * habitaciónOcupada.getPrecioDía();
                            totalPago.setText("Total: $" + valor);
                            registrarSalida.setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "La fecha de salida es menor que la de ingreso",
                                    "Mensaje", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this, "La fecha no está en el formato solicitado",
                                "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (evento.getSource() == registrarSalida) {
            habitaciónOcupada.setHuésped(null);
            habitaciónOcupada.setDisponible(true);
            hotel.listaHabitaciones.set(posiciónHabitación, habitaciónOcupada);
            JOptionPane.showMessageDialog(this, "Se ha registrado la salida del huésped",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            setVisible(false);
        }
    }
}
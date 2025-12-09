package Hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class VentanaIngreso extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel habitación;
    private JButton aceptar, cancelar;
    private JLabel nombre, apellidos, documentoIdentidad;
    private JLabel huésped;
    private JTextField campoNombre, campoApellidos, campoDocumentoIdentidad;
    private JLabel fechaIngreso;
    private JTextField campoFechaIngreso;
    private int númeroHabitaciónReservada;
    private Hotel hotel;
    private Habitación habitaciónReservada;

    public VentanaIngreso(Hotel hotel, int númeroHabitaciónReservada) {
        this.hotel = hotel;
        this.númeroHabitaciónReservada = númeroHabitaciónReservada;
        inicio();
        setTitle("Ingreso");
        setSize(290,250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3,3,3,3);

        habitación = new JLabel("Habitación: " + númeroHabitaciónReservada);
        c.gridx = 0; c.gridy = 0;
        contenedor.add(habitación, c);

        fechaIngreso = new JLabel("Fecha (aaaa-mm-dd):");
        c.gridx = 0; c.gridy = 1;
        contenedor.add(fechaIngreso, c);

        campoFechaIngreso = new JTextField();
        c.gridx = 1; c.gridy = 1;
        contenedor.add(campoFechaIngreso, c);

        huésped = new JLabel("Huésped");
        c.gridx = 0; c.gridy = 2;
        contenedor.add(huésped, c);

        nombre = new JLabel("Nombre: ");
        c.gridx = 0; c.gridy = 3;
        contenedor.add(nombre, c);

        campoNombre = new JTextField();
        c.gridx = 1; c.gridy = 3;
        contenedor.add(campoNombre, c);

        apellidos = new JLabel("Apellidos: ");
        c.gridx = 0; c.gridy = 4;
        contenedor.add(apellidos, c);

        campoApellidos = new JTextField();
        c.gridx = 1; c.gridy = 4;
        contenedor.add(campoApellidos, c);

        documentoIdentidad = new JLabel("Doc. Identidad: ");
        c.gridx = 0; c.gridy = 5;
        contenedor.add(documentoIdentidad, c);

        campoDocumentoIdentidad = new JTextField();
        c.gridx = 1; c.gridy = 5;
        contenedor.add(campoDocumentoIdentidad, c);

        aceptar = new JButton("Aceptar");
        c.gridx = 0; c.gridy = 6;
        contenedor.add(aceptar, c);
        aceptar.addActionListener(this);

        cancelar = new JButton("Cancelar");
        c.gridx = 1; c.gridy = 6;
        contenedor.add(cancelar, c);
        cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == aceptar) {
            for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
                Habitación habitación = (Habitación) hotel.listaHabitaciones.elementAt(i);
                if (habitación.getNúmeroHabitación() == this.númeroHabitaciónReservada) {
                    try {
                        String fechaIngresada = campoFechaIngreso.getText();
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = formatoFecha.parse(fechaIngresada);

                        Huésped huésped = new Huésped(nombre.getText(), apellidos.getText(),
                                Integer.parseInt(campoDocumentoIdentidad.getText()));
                        huésped.setFechaIngreso(fecha);

                        habitación.setHuésped(huésped);
                        habitación.setDisponible(false);

                        hotel.listaHabitaciones.set(i, habitación);

                        JOptionPane.showMessageDialog(this, "El huésped ha sido registrado",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
                        setVisible(false);
                        break;
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this, "La fecha no está en el formato solicitado",
                                "Mensaje", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (evento.getSource() == cancelar) {
            setVisible(false);
        }
    }
}
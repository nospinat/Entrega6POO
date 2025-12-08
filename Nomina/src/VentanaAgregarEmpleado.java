package Nómina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase corregida: VentanaAgregarEmpleado
 * Se han eliminado tildes en nombres de variables y corregido comillas.
 */
public class VentanaAgregarEmpleado extends JFrame implements ActionListener {
    private Container contenedor;
    private ListaEmpleados lista;

    // Variables de interfaz (sin tildes en los nombres para evitar errores)
    private JLabel nombre, apellidos, cargo, salarioDia, numeroDias,
            genero, otrosIngresos, aportesSalud, pensiones;

    private JTextField campoNombre, campoApellidos,
            campoSalarioDia, campoOtrosIngresos, campoAportesSalud,
            campoPensiones;

    private ButtonGroup grupoGenero;
    private JRadioButton masculino, femenino;
    private JComboBox<String> campoCargo; // Se añade <String> para seguridad de tipos
    private JSpinner campoNumeroDias;
    private SpinnerNumberModel modeloSpinner;
    private JButton agregar, limpiar;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Agregar Empleado");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Nombre
        nombre = new JLabel("Nombre:");
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(160, 20, 100, 23);

        // Apellidos
        apellidos = new JLabel("Apellidos:");
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(160, 50, 100, 23);

        // Cargo
        cargo = new JLabel("Cargo:");
        cargo.setBounds(20, 80, 135, 23);
        campoCargo = new JComboBox<>();
        campoCargo.addItem("Directivo");
        campoCargo.addItem("Estratégico");
        campoCargo.addItem("Operativo");
        campoCargo.setBounds(160, 80, 100, 23);

        // Género
        genero = new JLabel("Género:");
        genero.setBounds(20, 110, 100, 30);
        grupoGenero = new ButtonGroup();

        masculino = new JRadioButton("Masculino", true);
        masculino.setBounds(160, 110, 100, 30);
        grupoGenero.add(masculino);

        femenino = new JRadioButton("Femenino");
        femenino.setBounds(160, 140, 100, 30);
        grupoGenero.add(femenino);

        // Salario por día
        salarioDia = new JLabel("Salario por día:");
        salarioDia.setBounds(20, 170, 135, 23);
        campoSalarioDia = new JTextField();
        campoSalarioDia.setBounds(160, 170, 100, 23);

        // Días trabajados
        numeroDias = new JLabel("Días trabajados al mes:");
        numeroDias.setBounds(20, 200, 135, 23);
        campoNumeroDias = new JSpinner();
        modeloSpinner = new SpinnerNumberModel(30, 1, 31, 1);
        campoNumeroDias.setModel(modeloSpinner);
        campoNumeroDias.setBounds(160, 200, 40, 23);

        // Otros ingresos
        otrosIngresos = new JLabel("Otros ingresos:");
        otrosIngresos.setBounds(20, 230, 135, 23);
        campoOtrosIngresos = new JTextField();
        campoOtrosIngresos.setBounds(160, 230, 100, 23);

        // Pagos por salud
        aportesSalud = new JLabel("Pagos por salud:");
        aportesSalud.setBounds(20, 260, 135, 23);
        campoAportesSalud = new JTextField();
        campoAportesSalud.setBounds(160, 260, 100, 23);

        // Aportes pensiones
        pensiones = new JLabel("Aportes pensiones:");
        pensiones.setBounds(20, 290, 135, 23);
        campoPensiones = new JTextField();
        campoPensiones.setBounds(160, 290, 100, 23);

        // Botones
        agregar = new JButton("Agregar");
        agregar.setBounds(20, 320, 100, 23);
        agregar.addActionListener(this);

        limpiar = new JButton("Borrar");
        limpiar.setBounds(160, 320, 80, 23);
        limpiar.addActionListener(this);

        // Añadir componentes
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(cargo);
        contenedor.add(campoCargo);
        contenedor.add(genero);
        contenedor.add(masculino);
        contenedor.add(femenino);
        contenedor.add(salarioDia);
        contenedor.add(campoSalarioDia);
        contenedor.add(numeroDias);
        contenedor.add(campoNumeroDias);
        contenedor.add(otrosIngresos);
        contenedor.add(campoOtrosIngresos);
        contenedor.add(aportesSalud);
        contenedor.add(campoAportesSalud);
        contenedor.add(pensiones);
        contenedor.add(campoPensiones);
        contenedor.add(agregar);
        contenedor.add(limpiar);
    }

    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoSalarioDia.setText("");
        campoNumeroDias.setValue(30);
        campoOtrosIngresos.setText("");
        campoAportesSalud.setText("");
        campoPensiones.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == agregar) {
            anadirEmpleado();
        }
        if (evento.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    private void anadirEmpleado() {
        TipoCargo tipoC;
        String itemSeleccionado = (String) campoCargo.getSelectedItem();

        if ("Directivo".equals(itemSeleccionado)) {
            tipoC = TipoCargo.DIRECTIVO;
        } else if ("Estratégico".equals(itemSeleccionado)) {
            tipoC = TipoCargo.ESTRATÉGICO;
        } else {
            tipoC = TipoCargo.OPERATIVO;
        }

        TipoGénero tipoG;
        if (masculino.isSelected()) {
            tipoG = TipoGénero.MASCULINO;
        } else {
            tipoG = TipoGénero.FEMENINO;
        }

        try {
            String nombre = campoNombre.getText();
            String apellidos = campoApellidos.getText();
            double salario = Double.parseDouble(campoSalarioDia.getText());
            int dias = (int) campoNumeroDias.getValue();
            double ingresos = Double.parseDouble(campoOtrosIngresos.getText());
            double salud = Double.parseDouble(campoAportesSalud.getText());
            double pension = Double.parseDouble(campoPensiones.getText());

            // Crea el empleado usando las variables limpias y el constructor actualizado
            Empleado e = new Empleado(nombre, apellidos, tipoC, tipoG,
                    salario, dias, ingresos, salud, pension);

            lista.agregarEmpleado(e);

            JOptionPane.showMessageDialog(this, "El empleado ha sido agregado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en formato de número. Verifique los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
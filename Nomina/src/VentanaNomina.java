package Nómina;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase corregida: Se ha eliminado la tilde del nombre de la clase
 * para coincidir con el archivo VentanaNomina.java
 */
public class VentanaNomina extends JFrame {
    private Container contenedor;
    private ListaEmpleados lista;
    private JLabel empleados, nómina;
    private JTable tabla;

    public VentanaNomina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina de Empleados");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        empleados = new JLabel("Lista de empleados:");
        empleados.setBounds(20, 10, 135, 23);

        String[][] datos = lista.obtenerMatriz();
        String[] titulos = {"NOMBRE", "APELLIDOS", "SUELDO"};

        DefaultTableModel model = new DefaultTableModel(datos, titulos);
        tabla = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 40, 310, 100);

        nómina = new JLabel();
        nómina.setText("Total nómina mensual = $ " + String.format("%.2f", lista.totalNómina));
        nómina.setBounds(20, 160, 250, 23);

        contenedor.add(empleados);
        contenedor.add(scrollPane);
        contenedor.add(nómina);
    }
}
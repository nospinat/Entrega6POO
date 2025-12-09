package Nómina;

import java.util.*;

/**
 * Clase corregida: Ahora calcula correctamente el total de la nómina
 * dentro del método obtenerMatriz().
 */
public class ListaEmpleados {
    public Vector lista;
    public double totalNómina = 0;

    public ListaEmpleados() {
        lista = new Vector();
    }

    public void agregarEmpleado(Empleado a) {
        lista.add(a);
    }

    public double calcularTotalNómina() {
        totalNómina = 0;
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = (Empleado) lista.elementAt(i);
            totalNómina = totalNómina + e.calcularNómina();
        }
        return totalNómina;
    }

    /**
     * Método corregido: Ahora acumula el totalNómina mientras crea la matriz
     */
    public String[][] obtenerMatriz() {
        String datos[][] = new String[lista.size()][3];

        // ¡IMPORTANTE! Reiniciamos el total antes de recalcularlo
        totalNómina = 0;

        for (int i = 0; i < lista.size(); i++) {
            Empleado e = (Empleado) lista.elementAt(i);
            double sueldo = e.calcularNómina(); // Calculamos el sueldo individual

            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = String.format("%.2f", sueldo); // Formato bonito con 2 decimales

            // Esta es la línea que faltaba: Sumamos al total acumulado
            totalNómina = totalNómina + sueldo;
        }
        return datos;
    }

    public String convertirTexto() {
        calcularTotalNómina(); // Nos aseguramos de tener el total actualizado
        String texto = "";
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = (Empleado) lista.elementAt(i);
            texto = texto + "Nombre = " + e.getNombre() + "\n" +
                    "Apellidos = " + e.getApellidos() + "\n" +
                    "Cargo = " + e.getCargo() + "\n" +
                    "Género = " + e.getGénero() + "\n" +
                    "Salario = $" + e.getSalarioDía() + "\n" +
                    "Días trabajados = " + e.getDíasTrabajados() + "\n" +
                    "Otros ingresos = $" + e.getOtrosIngresos() + "\n" +
                    "Pagos salud = $" + e.getPagosSalud() + "\n" +
                    "Aportes pensiones = $" + e.getAportePensiones() +
                    "\nSuledo Mensual = $" + String.format("%.2f", e.calcularNómina()) +
                    "\n---------\n";
        }
        texto = texto + "Total nómina = $" + String.format("%.2f", totalNómina);
        return texto;
    }
}
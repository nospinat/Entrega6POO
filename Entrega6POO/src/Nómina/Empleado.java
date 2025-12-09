package Nómina;

/**
 * Esta clase denominada Empleado modela un empleado de una
 * empresa. Se han quitado las tildes en los nombres de las variables
 * para evitar errores de codificación.
 * @version 1.2/2020
 */
public class Empleado {
    private String nombre;
    private String apellidos;
    // Variable sin tilde: salarioDia
    private double salarioDia;
    private double otrosIngresos;
    private double pagosSalud;
    private double aportePensiones;
    // Variable sin tilde: diasTrabajados
    private int diasTrabajados;
    private TipoCargo cargo;
    // Variable sin tilde: genero
    private TipoGénero genero;

    /**
     * Constructor de la clase Empleado
     */
    public Empleado(String nombre, String apellidos, TipoCargo cargo,
                    TipoGénero genero, double salarioDia, int diasTrabajados,
                    double otrosIngresos, double pagosSalud,
                    double aportePensiones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.genero = genero;
        this.salarioDia = salarioDia;
        this.diasTrabajados = diasTrabajados;
        this.otrosIngresos = otrosIngresos;
        this.pagosSalud = pagosSalud;
        this.aportePensiones = aportePensiones;
    }

    // Métodos Getters corregidos (sin tilde en la variable local)
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public TipoCargo getCargo() { return cargo; }
    public TipoGénero getGénero() { return genero; }
    public double getSalarioDía() { return salarioDia; }
    public int getDíasTrabajados() { return diasTrabajados; }
    public double getOtrosIngresos() { return otrosIngresos; }
    public double getPagosSalud() { return pagosSalud; }
    public double getAportePensiones() { return aportePensiones; }

    /**
     * Método que calcula el salario mensual de un empleado
     * @return Salario mensual de un empleado
     */
    public double calcularNómina() {
        // Cálculo de nómina usando los nuevos nombres de variables sin tilde
        return ((salarioDia * diasTrabajados) + otrosIngresos - pagosSalud - aportePensiones);
    }
}
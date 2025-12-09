package ventanacontacto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

/**
 * Clase principal que crea la ventana para agregar contactos.
 */
public class VentanaContacto extends Application {

    // Etiquetas
    Label nombres = new Label("Nombres:");
    Label apellidos = new Label("Apellidos:");
    Label fechaNacimiento = new Label("Fecha nacimiento:");
    Label dirección = new Label("Dirección:");
    Label correo = new Label("Correo:");
    Label teléfono = new Label("Teléfono:");

    // Campos de texto y componentes
    TextField campoNombres = new TextField();
    TextField campoApellidos = new TextField();
    DatePicker campoFechaNacimiento = new DatePicker();
    TextField campoDirección = new TextField();
    TextField campoCorreo = new TextField();
    TextField campoTeléfono = new TextField();

    // Lista gráfica y lógica
    ListView<String> lista = new ListView<>();
    ListaContactos listaContactos = new ListaContactos(); // Instancia global para no perder datos

    // Botón
    Button agregar = new Button("Agregar");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Establece un grid para los componentes gráficos
        GridPane grid = new GridPane();

        // Establece espacios entre filas y columnas
        grid.setHgap(5);
        grid.setVgap(5);

        // Coloca los controles en el grid (Columna, Fila)
        grid.add(nombres, 0, 0);
        grid.add(apellidos, 0, 1);
        grid.add(fechaNacimiento, 0, 2);
        grid.add(dirección, 0, 3);
        grid.add(teléfono, 0, 4);
        grid.add(correo, 0, 5);

        grid.add(campoNombres, 1, 0);
        grid.add(campoApellidos, 1, 1);
        grid.add(campoFechaNacimiento, 1, 2);
        grid.add(campoDirección, 1, 3);
        grid.add(campoTeléfono, 1, 4);
        grid.add(campoCorreo, 1, 5);

        // Lista visual que ocupa varias filas
        grid.add(lista, 2, 0, 1, 7);

        // Configuración del botón
        VBox buttonBox = new VBox(agregar);
        agregar.setMaxWidth(Double.MAX_VALUE);
        grid.add(buttonBox, 0, 6, 2, 1);

        // Acción del botón
        agregar.setOnAction(e -> mostrarDatos());

        // Estilos CSS para el Grid
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: green;");

        Scene scene = new Scene(grid, 600, 300);
        stage.setScene(scene);
        stage.setTitle("Detalles del contacto");
        stage.show();
    }

    /**
     * Captura datos, valida y agrega a la lista.
     */
    private void mostrarDatos() {
        // Captura los datos ingresados
        String nombre = campoNombres.getText();
        String apellido = campoApellidos.getText();
        LocalDate nacimiento = campoFechaNacimiento.getValue();
        String dir = campoDirección.getText();
        String tel = campoTeléfono.getText();
        String email = campoCorreo.getText();

        // Validación básica: comprueba que no haya campos vacíos
        // Nota: nacimiento puede ser null si no se selecciona nada
        if (nombre.isEmpty() || apellido.isEmpty() || dir.isEmpty() ||
                tel.isEmpty() || email.isEmpty() || nacimiento == null) {

            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Mensaje");
            mensaje.setHeaderText("Error en ingreso de datos");
            mensaje.setContentText("No se permiten campos vacíos");
            mensaje.showAndWait();
        } else {
            // Crear el objeto contacto
            Contacto contacto = new Contacto(nombre, apellido, nacimiento, dir, tel, email);

            // Agregar al vector lógico
            listaContactos.agregarContacto(contacto);

            // Formatear cadena para la lista visual
            String data = nombre + " - " + apellido + " - " + nacimiento + " - " + dir + " - " + tel + " - " + email;

            // Agregar a la lista gráfica
            lista.getItems().add(data);

            // Limpiar campos
            campoNombres.setText("");
            campoApellidos.setText("");
            campoFechaNacimiento.setValue(null);
            campoDirección.setText("");
            campoTeléfono.setText("");
            campoCorreo.setText("");
        }
    }
}
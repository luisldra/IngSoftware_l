import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/*
 * Clase leerArchivo
 * En esta clase se realiza todo el proceso de lectura del archivo inicial .csv
 * se tiene un try catch donde se busca el correcto funcionamiento del programa
   y se busca la mejor comunicacion posible entre el usuario y este
 * Si el archivo se encunentra y se almacena con exito se creara el JSON en otra clase
 */
public class leerArchivo {

    public List<String[]> leer(String archivoCSV) {
        String linea;
        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV, StandardCharsets.UTF_8))) {
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                datos.add(campos);
            }

            crearJson creadorJSON = new crearJson();
            creadorJSON.crearJSON(datos, archivoCSV);

        } catch (IOException e) {
            System.err.println("No se encuentra ese archivo.");
        }

        return datos;
    }
}
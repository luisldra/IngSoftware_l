import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * Clase crearJson
 * Se inicia obteniendo la direccion del archivo inicial .csv donde se guardara igualmente este archivo JSON
 * Se crea un arreglo que tendra varios objetos que son los atributos iniciales y con ese arreglo se creara el JSON final 
 * Se tiene un try catch para la creacion del archivo JSON buscando una correcta comunicacion entre el usuaario y el programa
 */

public class crearJson {

    public void crearJSON(List<String[]> datos, String rutaArchivoCSV) {
        // Obtener la ruta del directorio del archivo CSV
        Path directorioCSV = Paths.get(rutaArchivoCSV).getParent();

        // Crear un JSONArray para almacenar los datos
        JSONArray jsonArray = new JSONArray();

        for (String[] fila : datos) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", fila[0]);
            jsonObject.put("Nombre", fila[1]);
            jsonObject.put("Apellido", fila[2]);
            jsonArray.add(jsonObject);
        }
        
        String nombreArchivoJSON = "datos.json";
        String rutaCompletaJSON = directorioCSV.resolve(nombreArchivoJSON).toString();

        // Escribir el JSON en un archivo
        try (FileWriter fileWriter = new FileWriter(rutaCompletaJSON, StandardCharsets.UTF_8)) {
            fileWriter.write(jsonArray.toString());
            System.out.println("Archivo JSON creado correctamente en: " + rutaCompletaJSON);
        } catch (IOException e) {
            System.out.println("Archivo JSON no pudo ser creado correctamente en: " + rutaCompletaJSON);
        }
    }
}

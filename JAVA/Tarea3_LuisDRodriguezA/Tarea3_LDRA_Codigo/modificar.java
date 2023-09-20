import java.util.Scanner;

/*
 * Clase Modificar
 * Sera el main de este proyecto, donde se llamara a la clase leer
   para almacenar los valores que se encuentran en el archivo .csv
   y posteriormente se creara el archivo JSON
 * En esta clase se pide al usuario que ingrese la ruta del archivo
 */
public class modificar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// "D:\\Usuarios\\Luisda\\Descargas\\U\\Ingenieria de Software 23-2\\IngSoftware_l\\JAVA\\Tarea3_LuisDRodriguezA\\Tarea3_LDRA_Archivos\\estudiantes.csv"

        System.out.print("Ingrese la ruta del archivo CSV: ");
        String rutaArchivoCSV = scanner.nextLine();

        leerArchivo lector = new leerArchivo();
        lector.leer(rutaArchivoCSV);

        scanner.close();
    }

}

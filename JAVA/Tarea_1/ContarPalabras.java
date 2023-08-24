package Tarea_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContarPalabras {
    String carpeta;
    String palabra;

    public void recibirRuta (){
        Scanner scan = new Scanner(System.in);
    
        // D:\\Usuarios\\Luisda\\Descargas\\U\\Ingenieria de Software\\Java\\Tarea_1\\pruebas\\pruebas1
    
        System.out.println("Ingrese la ubicacion de la carpeta:");
        carpeta = scan.nextLine();
    
        System.out.println("Ingrese la palabra a buscar:");
        palabra = scan.nextLine();
        scan.close();
    }

    public void encontrarCarpeta (){

        recibirRuta();

        File dir = new File(carpeta);
        int contador = 0;
        int total = 0;
        boolean esTexto = false;

        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile() && file.getName().matches(".*\\.(txt|xml|json|csv)")) {
                    esTexto = true;
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNext()) {
                            String linea = scanner.nextLine();
                            contador += contarPalabras(linea, palabra);
                            total += contarPalabras(linea, palabra);
                        }
                        System.out.println(file.getName() + "   -   " + contador);
                        contador = 0;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } 
            }

            if(esTexto){
                System.out.println("La palabra \"" + palabra + "\" aparece " + total);
    
            }else{
                System.out.println("No se encontraron archivos de texto en la carpeta");
            }

        } else {
            System.out.println("La carpeta no existe");
        }
    }

    public int contarPalabras(String linea, String palabra) {
        int contador = 0;
        String[] palabras = linea.split("[^\\p{L}0-9']+");
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }
}

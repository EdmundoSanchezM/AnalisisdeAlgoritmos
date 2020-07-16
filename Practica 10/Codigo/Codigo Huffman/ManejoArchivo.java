import java.io.*;

/**
 */
public class ManejoArchivo {

    public String LecturaArchivo(String nombreArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String TodoContenido = "";
        try {
            archivo = new File(nombreArchivo + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                TodoContenido += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return TodoContenido;
    }

    public void EscrituraArchivo(String Codificacion, String NombreArchivoOriginal) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Codificacion " + NombreArchivoOriginal + " Java.txt");
            pw = new PrintWriter(fichero);
            pw.println(Codificacion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void CompararArchivos(String NombreArchivoOriginal) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        File archivo2 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        try {
            Boolean iguales = true;
            archivo = new File("Codificacion " + NombreArchivoOriginal + " Java.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            archivo2 = new File("Codificacion " + NombreArchivoOriginal + " C++.txt");
            fr2 = new FileReader(archivo2);
            br2 = new BufferedReader(fr2);
            String linea = br.readLine();
            String linea2 = br2.readLine();

            while ((linea != null) && (linea2 != null) && iguales) {
                if (!linea.equals(linea2)) {
                    iguales = false;
                }
                linea = br.readLine();
                linea2 = br2.readLine();
            }
            if ((iguales) && (linea == null) && (linea2 == null)) {
                System.out.println("Los ficheros son iguales");
            } else {
                System.out.println("Los ficheros son diferentes");
            }
        } catch (Exception e) {
            System.out.println("No se pudo abrir un archivo");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
                if (null != fr2) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import java.io.*;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class ManejoArchivoMatriz {

    public DatosMatriz LecturaArchivo(String nombreArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int Columnas = 0;
        int Filas = 0;
        String TodoContenido = "";
        try {
            archivo = new File("Matrices/" + nombreArchivo + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int Bandera = 1;
            while ((linea = br.readLine()) != null) {
                Filas++;
                String Datos[] = linea.split(" ");
                for (int i = 0; i < Datos.length; i++) {
                    TodoContenido = TodoContenido + "," + Datos[i];
                    if (Bandera == 1) {
                        Columnas++;
                    }
                }
                Bandera = 0;
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
        //CreacionMatriz
        Matriz matriz = new Matriz(Filas, Columnas);
        String Datos[] = TodoContenido.split(",");
        int BanderaFila = 0;
        int BanderaColumna = 0;
        //Inicia con espacio
        for (int i = 1; i < Datos.length; i++) {
            matriz.addElemento(BanderaFila, BanderaColumna, Integer.parseInt(Datos[i]));
            BanderaColumna++;
            if (BanderaColumna == Columnas) {
                BanderaColumna = 0;
                BanderaFila++;
            }
        }
        //Creacion objeto
        return new DatosMatriz(Columnas, Filas, matriz);
    }

    public void DatosArchivos() {
        System.out.println("Datos de los archivos: ");
        System.out.println("Introduzca el numero de los archivos a usar (Disponibles del 1-15: ");
        for (int i = 1; i <= 15; i++) {
            DatosMatriz objDM = LecturaArchivo("Matriz" + i);
            System.out.println("Las dimensiones del archivo Matriz" + i + " son: " + objDM.getNumFilas() + "x" + objDM.getNumColumnas());
        }
    }

}

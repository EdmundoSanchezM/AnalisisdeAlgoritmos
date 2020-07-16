/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import java.util.Scanner;

/**
 * @author sdelaot
 */
public class ProbadorDeSecuenciaMatricial {

    public static void main(String[] args) {
        ManejoArchivoMatriz objLeer = new ManejoArchivoMatriz();
        int miN = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.print("Cuantas matrices quiere usar? : ");
        miN = teclado.nextInt();
//        System.out.println("Introduzca los ordenes de cada matriz : ");
//        
        int[] numArchivos = new int[miN];
        System.out.println("Introduzca el numero de los archivos a usar (Disponibles del 1-9): ");
        for (int i = 0; i < miN; i++) {
            System.out.println("Indice del archivo "+(i+1)+": ");
            numArchivos[i] = teclado.nextInt();
        }
//        int[] p = new int[miN + 1];
//        for (int i = 0; i < miN + 1; i++) {
//            System.out.print("p[" + i + "] = ");
//            p[i] = teclado.nextInt();
//        }
        int[] p = new int[miN + 1];
        int indiceArchivo = 0;
        for (int i = 0; i < miN + 1 ; i++) {
            DatosMatriz objDatosMatriz = objLeer.LecturaArchivo("Matriz" + numArchivos[indiceArchivo]);
            if(i==0){
                p[i] = objDatosMatriz.getNumFilas();
                p[i+1] = objDatosMatriz.getNumColumnas();
                i++;
            }else
                p[i] = objDatosMatriz.getNumColumnas();
            indiceArchivo++;
        }
        System.out.println();
        SecuenciaMatricial secuenciaM = new SecuenciaMatricial();
        secuenciaM.ejecutarAlgoritmo(miN, p);
    }
}

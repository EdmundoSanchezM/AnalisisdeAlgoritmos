/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author sdelaot
 */
public class ProbadorDeStrassen {

    private Strassen strassen = new Strassen(0, 0);

    public void ImprimirMatrizResultante(int[][] matriz) {
        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }

    public int[][] MatriztoArreglo2d(DatosMatriz objDatosMatriz) {
        int[][] Arreglo = new int[objDatosMatriz.getNumFilas()][objDatosMatriz.getNumColumnas()];
        for (int i = 0; i < objDatosMatriz.getNumFilas(); i++) {
            for (int j = 0; j < objDatosMatriz.getNumColumnas(); j++) {
                Arreglo[i][j] = objDatosMatriz.getMatriz().getElemento(j, i);
            }
        }
        return Arreglo;
    }

    public void MetodoSinOrden(ArrayList<int[][]> Matrices2D) {
        System.out.println("Calculos sin orden optimo");
        double TiempoInicio = 0;
        double TiempoFin = 0;
        TiempoInicio = System.nanoTime();
        int[][] MatrizFinal = strassen.multiplicar(Matrices2D.get(0), Matrices2D.get(1));
        for (int i = 2; i < Matrices2D.size(); i++) {
            MatrizFinal = strassen.multiplicar(MatrizFinal, Matrices2D.get(i));
        }
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos sin secuencia optima algoritmo de multiplicacion de matrices, orden n^3:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(MatrizFinal);
        System.out.println("***********************************************************");
        System.out.println("Pasando las matrices a matrices cuadradas");
        TiempoInicio = System.nanoTime();
        MatrizFinal = strassen.ejecutarStrassen(Matrices2D.get(0), Matrices2D.get(1));
        for (int i = 2; i < Matrices2D.size(); i++) {
            MatrizFinal = strassen.ejecutarStrassen(MatrizFinal, Matrices2D.get(i));
        }
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos sin secuencia optima algoritmo de Strassen, orden n^2.8:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(MatrizFinal);
        System.out.println("***********************************************************");
    }

    public void MetodoConOrdenOptimo(int miN, ArrayList<int[][]> Matrices2D) {
        double TiempoInicio = 0;
        double TiempoFin = 0;
        //Sacamos el orden optimo
        int[] p = new int[miN + 1];
        int indiceMatrices2D = 0;
        for (int i = 0; i < miN + 1; i++) {
            if (i == 0) {
                p[i] = Matrices2D.get(indiceMatrices2D).length;
                p[i + 1] = Matrices2D.get(indiceMatrices2D)[0].length;
                i++;
            } else {
                p[i] = Matrices2D.get(indiceMatrices2D)[0].length;
            }
            indiceMatrices2D++;
        }
        SecuenciaMatricial secuenciaM = new SecuenciaMatricial();
        int[] ordenMulti = secuenciaM.ejecutarAlgoritmo2(miN, p);
        int[][] MatrizFinal = strassen.multiplicar(Matrices2D.get(ordenMulti[0]), Matrices2D.get(ordenMulti[1]));
        for (int i = 2; i < ordenMulti.length; i++) {
            MatrizFinal = strassen.multiplicar(MatrizFinal, Matrices2D.get(ordenMulti[i]));
        }
        TiempoFin = System.nanoTime();
        System.out.println("\nTiempo de ejecucion en milisegundos con secuencia optima algoritmo de multiplicacion de matrices, orden n^3:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(MatrizFinal);
        System.out.println("***********************************************************");
        System.out.println("Pasando las matrices a matrices cuadradas");
        TiempoInicio = System.nanoTime();
        MatrizFinal = strassen.ejecutarStrassen(Matrices2D.get(ordenMulti[0]), Matrices2D.get(ordenMulti[1]));
        for (int i = 2; i < ordenMulti.length; i++) {
            MatrizFinal = strassen.ejecutarStrassen(MatrizFinal, Matrices2D.get(ordenMulti[i]));
        }
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos con secuencia optima algoritmo de Strassen, orden n^2.8:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(MatrizFinal);
        System.out.println("***********************************************************");
    }

    public void InicioStrassen() {
        ManejoArchivoMatriz objManejoArchivo = new ManejoArchivoMatriz();
        int miN = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.print("Cuantas matrices quiere usar? : ");
        miN = teclado.nextInt();
        objManejoArchivo.DatosArchivos();
        int[] numArchivos = new int[miN];
        for (int i = 0; i < miN; i++) {
            System.out.println("Indice del archivo " + (i + 1) + ": ");
            numArchivos[i] = teclado.nextInt();
        }
        ArrayList<int[][]> Matrices2D = new ArrayList<int[][]>();
        for (int i = 0; i < miN; i++) {
            Matrices2D.add(MatriztoArreglo2d(objManejoArchivo.LecturaArchivo("Matriz" + numArchivos[i])));
        }
        Matrices2D = strassen.CumplirCondiconesdeArreglo(Matrices2D);
        MetodoSinOrden(Matrices2D);
        MetodoConOrdenOptimo(miN, Matrices2D);
    }
}

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
public class ProbadorDeMatriz {

    private AritmeticaMatricial am = new AritmeticaMatricial();

    public void ImprimirMatrizResultante(Matriz matriz) {
        if (matriz != null) {
            for (int i = 0; i < matriz.length()[0]; i++) {
                for (int j = 0; j < matriz.length()[1]; j++) {
                    System.out.print(matriz.getElemento(j, i) + " ");
                }
                System.out.print("\n");
            }
        }
    }

    public void MetodoSinOrden(DatosMatriz[] objDatosMatriz) {
        double TiempoInicio = 0;
        double TiempoFin = 0;
        TiempoInicio = System.nanoTime();
        Matriz M3 = am.multiplicar(objDatosMatriz[0].getMatriz(), objDatosMatriz[1].getMatriz());
        for (int i = 2; i < objDatosMatriz.length; i++) {
            M3 = am.multiplicar(M3, objDatosMatriz[i].getMatriz());
        }
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos sin secuencia optima:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(M3);
        System.out.println("***********************************************************");
    }

    public void MetodoConOrdenOptimo(int miN,DatosMatriz[] objDatosMatriz) {
        double TiempoInicio = 0;
        double TiempoFin = 0;
        //Sacamos el orden optimo
        int[] p = new int[miN + 1];
        int indiceDatosM = 0;
        for (int i = 0; i < miN + 1; i++) {
            if (i == 0) {
                p[i] = objDatosMatriz[indiceDatosM].getNumFilas();
                p[i + 1] = objDatosMatriz[indiceDatosM].getNumColumnas();
                i++;
            } else {
                p[i] = objDatosMatriz[indiceDatosM].getNumColumnas();
            }
            indiceDatosM++;
        }
        SecuenciaMatricial secuenciaM = new SecuenciaMatricial();
        int[] ordenMulti = secuenciaM.ejecutarAlgoritmo2(miN, p);
        TiempoInicio = System.nanoTime();
        Matriz M3 = am.multiplicar(objDatosMatriz[ordenMulti[0]].getMatriz(), objDatosMatriz[ordenMulti[1]].getMatriz());
        for (int i = 2; i < ordenMulti.length; i++) {
            M3 = am.multiplicar(M3, objDatosMatriz[ordenMulti[i]].getMatriz());
        }
        TiempoFin = System.nanoTime();
        System.out.println("\nTiempo de ejecucion en milisegundos con secuencia optima:" + (TiempoFin - TiempoInicio) / 1000000);
        ImprimirMatrizResultante(M3);
    }

    public void InicioMatriz() {
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
        DatosMatriz[] objDatosMatriz = new DatosMatriz[miN];
        for (int i = 0; i < miN; i++) {
            objDatosMatriz[i] = objManejoArchivo.LecturaArchivo("Matriz" + numArchivos[i]);
        }
        MetodoSinOrden(objDatosMatriz);
        System.out.println("Calculos con orden optimo");
        MetodoConOrdenOptimo(miN, objDatosMatriz);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import java.util.ArrayList;

/**
 * @author sdelaot
 */
public class Strassen {

    private final int COL;
    private final int FIL;

    public Strassen(int fil, int col) {
        FIL = fil;
        COL = col;
    }

    public ArrayList<int[][]> CumplirCondiconesdeArreglo(ArrayList<int[][]> Matrices) {
        int n = -1;
        for (int i = 0; i < Matrices.size(); i++) {
            if (n <= Matrices.get(i).length || n <= Matrices.get(i)[0].length) {
                if (i == 0) {
                    n *= -1;
                }
                while (n <= Matrices.get(i).length || n <= Matrices.get(i)[0].length) {
                    n *= 2;
                }

            }
        }
        ArrayList<int[][]> C = new ArrayList<int[][]>();
        int[][] MatrizTemporal = new int[n][n];
        for (int h = 0; h < Matrices.size(); h++) {
            for (int i = 0; i < Matrices.get(h).length; i++) {
                for (int j = 0; j < Matrices.get(h)[0].length; j++) {
                    MatrizTemporal[i][j] = Matrices.get(h)[i][j];
                }
            }
            C.add(MatrizTemporal);
            MatrizTemporal = new int[n][n];
        }
        return C;
    }

    public void ejecutarAlgoritmo(int sel) {
        int[][] A = new int[FIL][COL];
        int[][] B = new int[FIL][COL];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                switch (sel) {
                    case 0: // asignacion determinada
                        A[i][j] = i + 1;
                        B[i][j] = i + 1;
                        break;
                    case 1: // asignacion aleatoria
                        A[i][j] = (int) (Math.random() * 100);
                        B[i][j] = (int) (Math.random() * 100);
                        break;
                }
            }
        }
        System.out.println(
                "****************************************************");
        System.out.println("Matriz A:");
        imprimir(A);
        System.out.println(
                "****************************************************");
        System.out.println(
                "****************************************************");
        System.out.println("Matriz B:");
        imprimir(B);
        System.out.println(
                "****************************************************");
//sum(A,B);
//rest(A,B);
        System.out.println(
                "****************************************************");
        System.out.println(
                "Algoritmo de Multiplicacion de matrices, orden n^3:");
        int[][] multResult = multiplicar(A, B);
        imprimir(multResult);
        System.out.println(
                "****************************************************");
        System.out.println();
        ejecutarStrassen(A, B);
    }

    public int[][] sumar(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }

        }
//imprime(C);
        return C;
    }

    public int[][] restar(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
//imprime(C);
        return C;
    }

    public int[][] multiplicar(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
//imprime(C);
        return C;
    }

    public void imprimir(int[][] arreglo2d) {
        for (int i = 0; i < arreglo2d.length; i++) {
            for (int j = 0; j < arreglo2d.length; j++) {
                if (arreglo2d[i][j] < 10) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 10 && arreglo2d[i][j] < 100) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 100 && arreglo2d[i][j] < 1000) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 1000 && arreglo2d[i][j] < 10000) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 10000 && arreglo2d[i][j] < 100000) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 100000 && arreglo2d[i][j] < 1000000) {
                    System.out.print(" ");
                } else if (arreglo2d[i][j] >= 1000000 && arreglo2d[i][j] < 10000000) {
                    System.out.print(" ");
                }
                System.out.print(arreglo2d[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] ejecutarStrassen(int[][] A, int[][] B) {
        int mitad = A.length / 2;
        int[][] A11 = new int[mitad][mitad];
        int[][] A12 = new int[mitad][mitad];
        int[][] A21 = new int[mitad][mitad];
        int[][] A22 = new int[mitad][mitad];
        int[][] B11 = new int[mitad][mitad];
        int[][] B12 = new int[mitad][mitad];
        int[][] B21 = new int[mitad][mitad];
        int[][] B22 = new int[mitad][mitad];
        for (int i = 0; i < mitad; i++) {
            for (int j = 0; j < mitad; j++) {
                A11[i][j] = A[i][j];
                B11[i][j] = B[i][j];
                A12[i][j] = A[i][mitad + j];
                B12[i][j] = B[i][mitad + j];
                A21[i][j] = A[mitad + i][j];
                B21[i][j] = B[mitad + i][j];
                A22[i][j] = A[mitad + i][mitad + j];
                B22[i][j] = B[mitad + i][mitad + j];
            }
        }
        int[][] M1 = multiplicar((sumar(A11, A22)), (sumar(B11, B22)));
        int[][] M2 = multiplicar((sumar(A21, A22)), (B11));
        int[][] M3 = multiplicar((A11), (restar(B12, B22)));
        int[][] M4 = multiplicar((A22), (restar(B21, B11)));
        int[][] M5 = multiplicar((sumar(A11, A12)), (B22));
        int[][] M6 = multiplicar((restar(A21, A11)), (sumar(B11, B12)));
        int[][] M7 = multiplicar((restar(A12, A22)), (sumar(B21, B22)));
        int[][] C11 = sumar((sumar(M1, restar(M4, M5))), M7);
        int[][] C12 = sumar(M3, M5);
        int[][] C21 = sumar(M2, M4);
        int[][] C22 = sumar((sumar(restar(M1, M2), M3)), M6);
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < mitad; i++) {
            for (int j = 0; j < mitad; j++) {
                C[i][j] = C11[i][j];
                C[i][mitad + j] = C12[i][j];

                C[mitad + i][j] = C21[i][j];
                C[mitad + i][mitad + j] = C22[i][j];
            }
        }
//        System.out.println(
//                "****************************************************");
//        System.out.println("Algoritmo de Strassen, orden n^2.8:");
//        imprimir(C);
//        System.out.println(
//                "****************************************************");
        return C;
    }

}

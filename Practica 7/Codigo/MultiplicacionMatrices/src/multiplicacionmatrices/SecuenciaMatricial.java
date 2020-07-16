/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 *
 * @author sdelaot
 */
public class SecuenciaMatricial {

    private int[] ArregloOrden;
    private int k=0;
    private int[][] MM;
    private int[][] SS;
    private int miN;
    private final int infinity;

    public SecuenciaMatricial() {
        this.infinity = Integer.MAX_VALUE;
        miN = 0;
        MM = null;
        SS = null;
    }

    void ejecutarAlgoritmo(int miN, int[] p) {
        this.miN = miN;
        crearMatrices();
        procesarMatricesSecuencialesDeOrden(p);
        ArregloOrden = new int[miN];
        imprimirMatrices();
        System.out.println("La secuencia optima de multiplicacion es:");
        imprimirSecuenciaOptimaMaticial(0, miN - 1, SS, miN);
        System.out.println("\n");
    }
    
    public int[] ejecutarAlgoritmo2(int miN, int[] p) {
        this.miN = miN;
        crearMatrices();
        procesarMatricesSecuencialesDeOrden(p);
        ArregloOrden = new int[miN];
        System.out.println("La secuencia optima de multiplicacion es:");
        return imprimirSecuenciaOptimaMaticial(0, miN - 1, SS, miN);
    }

    public void crearMatrices() {
        MM = new int[miN][];
        for (int i = 0; i < miN; i++) {
            MM[i] = new int[miN];
        }
        SS = new int[miN][];//new intP[n];
        for (int i = 0; i < miN; i++) {
            SS[i] = new int[miN];
        }
        for (int row = 0; row < miN; row++) {
            for (int col = 0; col < miN; col++) {
                MM[row][col] = -1;
            }
        }
        for (int row = 0; row < miN; row++) {
            for (int col = 0; col < miN; col++) {
                SS[row][col] = -1;
            }
        }
    }

    public void imprimirMatrices() {
        System.out.println("M = ");
        for (int row = 0; row < miN; row++) {
            for (int col = 0; col < miN; col++) {
                System.out.print(MM[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("S = ");
        for (int row = 0; row < miN; row++) {
            for (int col = 0; col < miN; col++) {
                System.out.print(SS[row][col] + " ");
            }
            System.out.println();
        }
    }

    public int multiplicarCosto(int i, int k, int j, int[] p) {
        return p[i] * p[k + 1] * p[j + 1];
    }

    public void procesarMatricesSecuencialesDeOrden(int[] p) {
        for (int i = 0; i < miN; i++) {
            MM[i][i] = 0;
        }
        for (int l = 2; l <= miN; l++) {
            for (int i = 0; i < (miN - l + 1); i++) {

                int j = i + l - 1;
                MM[i][j] = infinity;
                for (int k = i; k <= j - 1; k++) {
                    int q = MM[i][k] + MM[k + 1][j]
                            + multiplicarCosto(i, k, j, p);
                    if (q < MM[i][j]) {
                        MM[i][j] = q;
                        SS[i][j] = k;
                    }
                }
            }
        }
    }

    public  int [] imprimirSecuenciaOptimaMaticial(int i, int j, int[][] s,int N) {
        if (j > i) {
            System.out.print("(");
            imprimirSecuenciaOptimaMaticial(i, s[i][j], s, N);
            System.out.print(" ");
            imprimirSecuenciaOptimaMaticial(s[i][j] + 1, j, s, N);
            System.out.print(")");
        } else {
            System.out.print("A[" + i + "]");
            ArregloOrden[k] = i;
            k++;
        }
        return ArregloOrden;
    }
            
}

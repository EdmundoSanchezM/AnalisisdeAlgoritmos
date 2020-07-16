import java.util.ArrayList;

/**
 * @author sdelaot
 */
public class AlgoritmoLCS {

    private final int MAX_X;
    private final int MAX_Y;
    private char[][] b;
    private int[][] c;

    public AlgoritmoLCS(String cadenaA, String cadenaB) {
        this.MAX_X = cadenaB.length() + 1;
        this.MAX_Y = cadenaA.length() + 1;
        this.c = new int[MAX_Y][MAX_X];
        this.b = new char[MAX_Y][MAX_X];
    }

    void ejecutarAlgoritmoLCS(char X[], char Y[]) {
        int m, n, i, j;
        m = X.length - 1;
        n = Y.length - 1;
        for (i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        for (j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (X[i] == Y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '/';
                } else {
                    if (c[i - 1][j] >= c[i][j - 1]) {
                        c[i][j] = c[i - 1][j];
                        b[i][j] = '|';
                    } else {
                        c[i][j] = c[i][j - 1];
                        b[i][j] = '-';
                    }
                }
            }
        }
    }

    void llenarVector(char M[], String cadena) {
        int i;
        char a;
        i = 1;
        while (i <= cadena.length()) {
            a = cadena.charAt(i - 1);
            M[i] = a;
            i++;
        }
    }

    void imprimirLCS(int tamA, int tamB, char [] A) {
        int i = tamA;
        int j = tamB;
        ArrayList<Character> ImprimirSubsecuencia = new ArrayList();
        while (i  >= 0 && j >= 0) {
            if (b[i][j] == '/') {
                ImprimirSubsecuencia.add(A[i]);
                i--;
                j--;
            } else if (b[i][j] == '|') {
                i--;
            } else {
                j--;
            }
        }
        for (int k = ImprimirSubsecuencia.size() - 1; 0<=k; k--) {
            System.out.print(ImprimirSubsecuencia.get(k));

        }
    }

    void ejecutarAlgoritmo(String cadenaA, String cadenaB) {
        char A[] = new char[MAX_Y];
        char B[] = new char[MAX_X];
        int tamA, tamB;
        llenarVector(A, cadenaA);
        llenarVector(B, cadenaB);
        tamA = A.length;
        tamB = B.length;
        ejecutarAlgoritmoLCS(A, B);
        System.out.println();
        System.out.println("Se omite la tabla dinamica por razones de tamanio");
        System.out.println();
        System.out.println(
                " ==> La Subsecuencia comun mas larga B en A: \n");
        System.out.print(" ==> { ");
        imprimirLCS(tamA - 1, tamB - 1,A);
        System.out.println(" }");
        System.out.println();
        System.out.print(" ==> El numero de ocurrencia es: ");
        System.out.println(c[tamA - 1][tamB - 1] + "\n\n");
    }
}

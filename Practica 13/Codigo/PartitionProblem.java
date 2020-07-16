/**
 *
 * @author Edmundo J Sanchez M Solucion usando progrmacion dinamica
 */
public class PartitionProblem {

    static boolean Particion(int S[]) {
        int K = 0;
        int i, j;
        int n = S.length;
        //Suma de todos los terminos
        for (i = 0; i < n; i++) {
            K += S[i];
        }

        if (K % 2 != 0) {
            return false;
        }

        boolean P[][] = new boolean[K / 2 + 1][n + 1];

        // Inicializamos la primera fila (P(0,x)) de P como True
        for (i = 0; i <= n; i++) {
            P[0][i] = true;
        }

        // Inicializamos la primera columna(P(x, 0)) de P como True, excepto P(0, 0) como True
        for (i = 1; i <= K / 2; i++) {
            P[i][0] = false;
        }

        for (i = 1; i <= K / 2; i++) {
            for (j = 1; j <= n; j++) {
                P[i][j] = P[i][j - 1];
                if (i >= S[j - 1]) {
                    P[i][j] = P[i][j]
                            || P[i - S[j - 1]][j - 1];
                }
            }
        }
        return P[K / 2][n];
    }

    public static void main(String[] args) {
        int S[] = {3, 1, 10, 2, 2, 1};
        if (Particion(S) == true) {
            System.out.println("Puede ser dividido en dos subconjuntos de sumas iguales");
        } else {
            System.out.println("No puede ser dividido en dos subconjuntos de sumas iguales");
        }

    }
}

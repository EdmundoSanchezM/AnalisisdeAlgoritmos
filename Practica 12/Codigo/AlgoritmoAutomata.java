/**
 *
 * @author Edmundo J Sanchez M
 */
public class AlgoritmoAutomata {

    static int maxCaracteres = 256;

    public int obtenerSiguienteEstado(char[] P, int m,
            int q, int x) {
        if (q < m && x == P[q]) {
            return q + 1;
        }
        int ns, i;
        for (ns = q; ns > 0; ns--) {
            if (P[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++) {
                    if (P[i] != P[q - ns + 1 + i]) {
                        break;
                    }
                }
                if (i == ns - 1) {
                    return ns;
                }
            }
        }
        return 0;
    }

    public void calcularFuncionDeTransicion(char[] P, int m, int delta[][]) {
        for (int q = 0; q <= m; q++) {
            for (int a = 0; a < maxCaracteres; a++) {
                delta[q][a] = obtenerSiguienteEstado(P, m, q, a);
            }
        }
    }

    public void igualarCadenaConAutomataFinito(char[] P, char[] T) {
        int M = P.length;
        int N = T.length;
        int[][] delta = new int[M + 1][maxCaracteres];
        calcularFuncionDeTransicion(P, M, delta);
        int i, q = 0;
        for (i = 0; i < N; i++) {
            q = delta[q][T[i]];
            if (q == M) {
                System.out.println("El patron ocurrio en el cambio: " + (i - M + 1));
            }
        }
    }

}

/**
 *
 * @author Edmundo J Sanchez M
 */
public class AlgoritmoRabinKarp {

    public void ejecutarAlgoritmoRabinKarp(String T, String P, int q, int d) {
        int n = T.length();
        int m = P.length();
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        int p = 0;
        int t = 0;
        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t = (d * t + T.charAt(i)) % q;
        }
        for (int s = 0; s <= n - m; s++) {
            if (p == t) {
                for (int j = 0; j < m; j++) {
                    if (T.charAt(s + j) == P.charAt(j)) {
                        System.out.println("Ocurrencia de patrón con cambio: " + s);
                    }
                }
            }
            if (s < n - m) {
                t = (d * (t - T.charAt(s) * h) + T.charAt(s + m)) % q;
                //Podriamos obtener un valor negativo de t,
                //este if lo convierte a positivo
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

}

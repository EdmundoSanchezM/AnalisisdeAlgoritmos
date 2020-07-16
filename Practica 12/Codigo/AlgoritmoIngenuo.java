/**
 *
 * @author Edmundo J Sanchez M
 */
public class AlgoritmoIngenuo {

    public void Algoritmo(String T, String P) {
        int n = T.length();
        int m = P.length();
        for (int s = 0; s <= n - m; s++) {
            int j;
            for (j = 0; j < m; j++) {
                if (T.charAt(s + j) == P.charAt(j)) {
                    System.out.println("Ocurrencia de patrón con cambio: " + s);
                } else {
                    break;
                }
            }
        }

    }
}

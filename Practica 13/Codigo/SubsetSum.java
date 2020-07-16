/**
 *
 * @author Edmundo J Sanchez M
 */
public class SubsetSum {

    static boolean subsetSum(int set[], int sum) {
        int n = set.length;
        boolean subset[][] = new boolean[sum + 1][n + 1];
        // Si la suma es 0, entonces la respuesta es verdadera
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        // Si la suma no es 0 y el valor de set esta vacio entonces es falso
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
                }
            }
        }
        System.out.println("Tabla que se forma con los valores\n");
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(subset[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println(" ");
        return subset[sum][n];
    }
    public static void main(String args[]) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 21;
        if (subsetSum(set, sum) == true) {
            System.out.println("Se encontro un subconjunto que da la suma");
        } else {
            System.out.println("No Se encontro un subconjunto que da la suma");
        }
    }

}

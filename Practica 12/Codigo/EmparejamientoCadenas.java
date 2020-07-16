import java.util.Scanner;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class EmparejamientoCadenas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Inresar texto");
        String T = teclado.next();
        System.out.println("Inresar patron a buscar en el texto");
        String P = teclado.next();
        System.out.println("***************************** Algoritmo Ingenuo *****************************");
        AlgoritmoIngenuo Algoritmo1 = new AlgoritmoIngenuo();
        Algoritmo1.Algoritmo(T, P);
        System.out.println("***************************** Algoritmo usando un AF *****************************");
        AlgoritmoAutomata Algoritmo2 = new AlgoritmoAutomata();
        Algoritmo2.igualarCadenaConAutomataFinito(P.toCharArray(), T.toCharArray());
        System.out.println("***************************** Algoritmo Knuth-Morris-Pratt (KMP) *****************************");
        AlgoritmoKnuthMorrisPratt Algoritmo3 = new AlgoritmoKnuthMorrisPratt();
        Algoritmo3.igualarCadenaConKMP(P, T);
        System.out.println("***************************** Algoritmo Rabin Karp *****************************");
        //Usualemnte se usa 256 para poder ingresar cualquier texto, aunque puede
        //modificarse 
        AlgoritmoRabinKarp Algoritmo4 = new AlgoritmoRabinKarp();
        int q=13;
        Algoritmo4.ejecutarAlgoritmoRabinKarp(T,P, q, 256);
    }

}

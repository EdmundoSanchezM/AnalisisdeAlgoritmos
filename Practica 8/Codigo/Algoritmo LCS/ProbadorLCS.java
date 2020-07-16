import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 */
public class ProbadorLCS {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n");
        System.out.println(" ======== -- -- ------------ ----- === ----- --- ------------ ======== ");
        System.out.println(" | Problema de la SubSecuencia Comun Mas Larga Con Programacion Dinamica |");
        System.out.println(" ======== -- -- ------------ ----- === ----- --- ------------ ======== ");
        System.out.println();
        System.out.print("\t==> Ingrese la Cadena A: ");
        String cadenaA = teclado.readLine();
        System.out.print("\t==> Ingrese la Cadena B: ");
        String cadenaB = teclado.readLine();
        AlgoritmoLCS aLcs = new AlgoritmoLCS(cadenaA, cadenaB);
        aLcs.ejecutarAlgoritmo(cadenaA, cadenaB);
    }
}

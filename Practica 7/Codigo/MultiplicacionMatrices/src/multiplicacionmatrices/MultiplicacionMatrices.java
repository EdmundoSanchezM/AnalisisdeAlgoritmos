/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class MultiplicacionMatrices {

    public static void main(String[] args) {
        System.out.println("**********Inicio algoritmo Multiplicacion matricial normal**********");
        ProbadorDeMatriz objMatriz = new ProbadorDeMatriz();
        objMatriz.InicioMatriz();
        System.out.println("***********Fin algoritmo Multiplicacion matricial normal***********");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("**********Inicio algoritmo Multiplicacion matricial Strassen**********");
        ProbadorDeStrassen objStrassen = new ProbadorDeStrassen();
        objStrassen.InicioStrassen();
        System.out.println("***********Fin algoritmo Multiplicacion matricial Strassen***********");
    }
}

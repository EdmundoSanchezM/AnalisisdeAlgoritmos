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
public class AritmeticaMatricial {

    private Matriz matriz;

    public Matriz sumar(Matriz M1, Matriz M2) {
        int[] xy1 = M1.length();
        int[] xy2 = M2.length();
        if (xy1[0] != xy2[0] || xy1[1] != xy2[1]) {
            System.out.println("Las matrices no pueden sumarse\n"
                    + " No son de la misma dimension " + xy1[0] + " x " + xy1[1]
                    + " y " + xy2[0] + " x " + xy2[1]);
            return null;
        }
        matriz = new Matriz(xy1[0], xy1[1]);
        for (int y = 0; y < xy1[0]; y++) {
            for (int x = 0; x < xy1[1]; x++) {
                int valor = M1.getElemento(x, y) + M2.getElemento(x, y);
                matriz.addElemento(y, x, valor);
            }
        }
        return matriz;
    }

    public Matriz restar(Matriz M1, Matriz M2) {
        int[] xy1 = M1.length();
        int[] xy2 = M2.length();
        if (xy1[0] != xy2[0] || xy1[1] != xy2[1]) {
            System.out.println("Las matrices no pueden restarse\n"
                    + " No son de la misma dimension " + xy1[0] + " x " + xy1[1]
                    + " y " + xy2[0] + " x " + xy2[1]);
            return null;
        }
        matriz = new Matriz(xy1[0], xy1[1]);

        for (int y = 0; y < xy1[0]; y++) {
            for (int x = 0; x < xy1[1]; x++) {
                int valor = M1.getElemento(x, y) - M2.getElemento(x, y);
                matriz.addElemento(y, x, valor);
            }
        }
        return matriz;
    }

    public Matriz multiplicarPorEscalar(Matriz M1, int escalar) {
        int[] xy = M1.length();
        matriz = new Matriz(xy[0], xy[1]);
        for (int y = 0; y < xy[0]; y++) {
            for (int x = 0; x < xy[1]; x++) {
                int valor = M1.getElemento(x, y) * escalar;
                matriz.addElemento(y, x, valor);
            }
        }
        return matriz;
    }

    public Matriz obtenerTranspuesta(Matriz M1) {
        int[] xy = M1.length();
        matriz = new Matriz(xy[1], xy[0]);
        for (int y = 0; y < xy[0]; y++) {
            for (int x = 0; x < xy[1]; x++) {
                int valor = M1.getElemento(x, y);
                matriz.addElemento(x, y, valor);
            }
        }
        return matriz;
    }

    public Matriz multiplicar(Matriz M1, Matriz M2) {
        int[] xy1 = M1.length();
        int[] xy2 = M2.length();
        if (xy1[1] != xy2[0]) {
            System.out.println("No se puede realizar la multiplicacion de ");
            System.out.println(M1 + " y " + M2);
            return null;
        }
        matriz = new Matriz(xy1[0], xy2[1]);
        for (int y = 0; y < xy1[0]; y++) {
            for (int x = 0; x < xy2[1]; x++) {
                int valor = 0;
                for (int k = 0; k < xy1[1]; k++) {
                    valor += (M1.getElemento(k, y) * M2.getElemento(x,k));
//System.out.println( M1.getElemento(k, x) + " " +
// M2.getElemento(y, k) + " " + valor );
                }
//System.out.println( valor );
                matriz.addElemento(y, x, valor);
            }
        }
        return matriz;
    }
}

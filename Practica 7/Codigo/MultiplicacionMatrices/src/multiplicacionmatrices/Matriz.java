/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 * @author sdelaot
 */
public class Matriz {

    private Vector[] matriz;

    public Matriz(int y, int x) {
        this(new Vector[y], x);
    }

    public Matriz(Vector[] matriz, int x) {
        this.matriz = matriz;
        for (int y = 0; y < matriz.length; y++) {
            matriz[y] = new Vector(x);
        }
    }

    public Matriz(Matriz m1) {
        this.matriz = m1.matriz;
    }

    public void addElemento(int y, int x, int valor) {
        if (x < 0 || y < 0) {
            System.out.println("Imposible asignar " + valor
                    + " indice x o y negativo");
            return;
        }
        matriz[y].setElemento(x, valor);
    }

    public int getElemento(int x, int y) {
        if (x < 0 || y < 0) {
            System.out.println(
                    "Imposible devolver valor indice x o y negativo");
            return 0;
        }
        return matriz[y].getElemento(x);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int y = 0; y < matriz.length; y++) {
            resultado.append(matriz[y]);
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public int[] length() {
        int[] xy = {
            matriz.length, // filas y
            matriz[0].length() // columnas x
        };
        return xy;
    }
}

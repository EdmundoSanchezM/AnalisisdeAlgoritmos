/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 * @author sdelaot
 */
public class Vector {

    private int[] vector;

    public Vector(int cuantos) {
        this(new int[cuantos]);
    }

    public Vector(int[] vector) {
        this.vector = vector;
    }

    public void setElemento(int x, int valor) {
        if (x < 0 || x >= vector.length) {
            System.out.println("Imposible asignar " + valor
                    + " indice " + x + " es negativo");
        } else {
            vector[x] = valor;
        }
    }

    public int getElemento(int x) {
        if (x < 0) {
            System.out.println("Imposible devolver valor indice "
                    + x + " es negativo");
            return 0;
        }
        return vector[x];
    }

    @Override
    public String toString() {
        StringBuffer resultado = new StringBuffer();
        for (int n = 0; n < vector.length; n++) {
            switch (calcularLongitudDe(vector[n])) {
                case 1:
                    resultado.append(" ");
                    break;
                case 2:
                    resultado.append(" ");
                    break;
                case 3:
                    resultado.append(" ");
                    break;
                case 4:
                    resultado.append(" ");
                    break;
            }
            resultado.append(vector[n]);
        }
        return resultado.toString();
    }

    public int length() {
        return vector.length;
    }

    private int calcularLongitudDe(int numero) {
        String numeroStr = "" + numero;
        return numeroStr.length();
    }
}
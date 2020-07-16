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
public class DatosMatriz {
    private int numColumnas;
    private int numFilas;
    private Matriz matriz;

    public DatosMatriz(int numColumnas, int numFilas, Matriz matriz) {
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        this.matriz = matriz;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
    
}

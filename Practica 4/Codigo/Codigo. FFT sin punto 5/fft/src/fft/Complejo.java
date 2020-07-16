/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

/**
 *
 * @author sdelaot
 */
public class Complejo {

    private double real;
    private double imaginario;

    public Complejo() {
        this(0.0, 0.0);
    }

    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public void setComplejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public Complejo getComplejo() {
        return this;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginario() {
        return imaginario;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    public double calcularMagnitud() {
        return Math.sqrt(Math.pow(real, 2.0) + Math.pow(imaginario, 2.0));
    }

    public double calcularArgumento() {
        return Math.atan2(imaginario, real);
    }

    public Complejo conjugar() {
        return new Complejo(real, (-1) * imaginario);
    }

    @Override
    public String toString() {
        return "(" + real + ", i " + imaginario + ')';
    }
}

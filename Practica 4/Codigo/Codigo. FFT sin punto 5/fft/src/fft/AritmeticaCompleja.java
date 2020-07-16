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
public class AritmeticaCompleja {

    private Complejo z;

    public Complejo sumar(Complejo z1, Complejo z2) {
        z = new Complejo(z1.getReal() + z2.getReal(),
                z1.getImaginario() + z2.getImaginario());
        return z;
    }

    public Complejo restar(Complejo z1, Complejo z2) {
        z = new Complejo(z1.getReal() - z2.getReal(),
                z1.getImaginario() - z2.getImaginario());
        return z;
    }

    public Complejo multiplicar(Complejo z1, Complejo z2) {
        z = new Complejo(z1.getReal() * z2.getReal()
                - z1.getImaginario() * z2.getImaginario(),
                z1.getReal() * z2.getImaginario()
                + z1.getImaginario() * z2.getReal());
        return z;
    }

    public Complejo dividir(Complejo z1, Complejo z2) {
        double potencia = Math.pow(z2.getReal(), 2.0)
                + Math.pow(z2.getImaginario(), 2.0);
        double zReal = z1.getReal() * z2.getReal()
                + z1.getImaginario() * z2.getImaginario();
        double zImaginario = z1.getImaginario() * z2.getReal()
                - z1.getReal() * z2.getImaginario();
        z = new Complejo(zReal / potencia, zImaginario / potencia);
        return z;
    }
}

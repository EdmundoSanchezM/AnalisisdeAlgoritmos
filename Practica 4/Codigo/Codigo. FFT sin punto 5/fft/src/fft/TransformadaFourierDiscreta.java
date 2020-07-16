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
public class TransformadaFourierDiscreta {

    private Complejo[] dft;
    private AritmeticaCompleja aritmetica;

    public TransformadaFourierDiscreta(int N) {
        dft = new Complejo[N];
        aritmetica = new AritmeticaCompleja();
    }

    Complejo[] calcularTransformadaDirecta(Complejo[] f) {
        int N = dft.length;
        if (N != f.length) {
            return null;
        }
        Complejo e;
        Complejo sumatoria = new Complejo();
        for (int k = 0; k < N; k++) {
            sumatoria.setComplejo(0.0, 0.0);
            // DEBUG
            //System.out.println( sumatoria );
            for (int n = 0; n < N; n++) {
                double x = (2.0 * Math.PI * k * n) / N;
                e = new Complejo(Math.cos(x), -1.0 * Math.sin(x));
                Complejo multiplica = aritmetica.multiplicar(f[n], e);
                sumatoria = aritmetica.sumar(sumatoria, multiplica);
            }
            // DEBUG
            //System.out.println( sumatoria );
            double real = sumatoria.getReal();
            double imag = sumatoria.getImaginario();
            if (Math.abs(real) < 1.25e-10) {
                real = 0.0;
            }
            if (Math.abs(imag) < 1.25e-10) {
                imag = 0.0;
            }
            dft[k] = new Complejo(real, imag);
        }
        return dft;
    }
}

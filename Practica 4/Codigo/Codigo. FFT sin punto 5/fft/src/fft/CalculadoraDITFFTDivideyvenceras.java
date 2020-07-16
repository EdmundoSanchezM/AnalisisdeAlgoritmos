/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

/**
 * + Clase para probar la FFT DIT
 *
 * @author Edmundo J Sanchez M
 */
public class CalculadoraDITFFTDivideyvenceras {

    public static void main(String[] args) {
        int N = 16;
        Complejo[] f = { // Pulso cuadrado
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(1.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0)
        };
        Complejo[] fs = { // senoidal cos(nwT), w=2*PI*f
            new Complejo(Math.cos(0.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(1.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(2.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(3.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(4.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(5.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(6.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(7.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(8.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(9.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(10.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(11.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(12.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(13.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(14.0 * 2.0 * Math.PI / N), 0.0),
            new Complejo(Math.cos(15.0 * 2.0 * Math.PI / N), 0.0)
        };

        Complejo[] fi = { // Inpulso delta
            new Complejo(1.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0),
            new Complejo(0.0, 0.0)
        };
        Complejo[] fr = { // rampa
            new Complejo(0.125, 0.0),
            new Complejo(0.250, 0.0),
            new Complejo(0.375, 0.0),
            new Complejo(0.500, 0.0),
            new Complejo(0.625, 0.0),
            new Complejo(0.750, 0.0),
            new Complejo(0.875, 0.0),
            new Complejo(1.000, 0.0),
            new Complejo(0.125, 0.0),
            new Complejo(0.250, 0.0),
            new Complejo(0.375, 0.0),
            new Complejo(0.500, 0.0),
            new Complejo(0.625, 0.0),
            new Complejo(0.750, 0.0),
            new Complejo(0.875, 0.0),
            new Complejo(1.000, 0.0)
        };
        System.out.println("========USANDO DITFFT DIVIDE Y VENCERAS========");
        TransformadaDITFFT transformada = new TransformadaDITFFT();
        System.out.println("\nPulso cuadrado");
        for (Complejo z : f) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Pulso cuadrado");
        Complejo[] dft = transformada.recursivoTransformada(N, f);
        for (Complejo z : dft) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Magnitud pulso");
        for (Complejo z : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }
        System.out.println();
        System.out.println("\nFuncion senoidal");
        for (Complejo z : fs) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT senoidal");
        dft = transformada.recursivoTransformada(N, fs);
        for (Complejo z : dft) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Magnitud Senoidal");
        for (Complejo z : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }
        System.out.println();
        System.out.println("\nImpulso delta");
        for (Complejo z : fi) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Impulso delta");
        dft = transformada.recursivoTransformada(N, fi);
        for (Complejo z : dft) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Magnitud delta");
        for (Complejo z : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }
        System.out.println();
        System.out.println("\nRampa");
        for (Complejo z : fr) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Rampa");
        dft = transformada.recursivoTransformada(N, fr);
        for (Complejo z : dft) {
            System.out.print(" " + z);
        }
        System.out.println("\nFFT Magnitud Rampa");
        for (Complejo z : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }
        System.out.println();
    }
}

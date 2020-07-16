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
public class CalculadoraDFT1 {

    public static void main(String[] args) {
        int N = 16;
        Complejo[] f = { // Pulso cuadradonew Complejo(1.0, 0.0),
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
        TransformadaFourierDiscreta transformada
                = new TransformadaFourierDiscreta(f.length);

        System.out.println(
                "\nPulso cuadrado");
        for (Complejo z
                : f) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nDFT Pulso cuadrado");
        Complejo[] dft = transformada.calcularTransformadaDirecta(f);
        for (Complejo z
                : dft) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nMagnitud Pulso cuadrado");
        for (Complejo z
                : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }

        System.out.println();

        System.out.println(
                "\nDelta de dirac");
        for (Complejo z
                : fi) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nDFT Delta de dirac");
        dft = transformada.calcularTransformadaDirecta(fi);
        for (Complejo z
                : dft) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nMagnitud delta dirac");
        for (Complejo z
                : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }

        System.out.println();

        System.out.println(
                "\nSenoidal");
        for (Complejo z
                : fs) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nDFT Senoidal");
        dft = transformada.calcularTransformadaDirecta(fs);
        for (Complejo z
                : dft) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nMagnitud Senoidal");
        for (Complejo z
                : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }

        System.out.println();

        System.out.println(
                "\nRampa");
        for (Complejo z
                : fr) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nDFT Rampa");
        dft = transformada.calcularTransformadaDirecta(fr);
        for (Complejo z
                : dft) {
            System.out.print(" " + z);
        }

        System.out.println(
                "\nMagnitud Rampa");
        for (Complejo z
                : dft) {
            System.out.print(" " + z.calcularMagnitud());
        }
    }
}

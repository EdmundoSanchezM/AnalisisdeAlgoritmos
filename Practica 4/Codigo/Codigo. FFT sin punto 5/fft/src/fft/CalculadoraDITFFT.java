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
public class CalculadoraDITFFT {
 int N = 16;
    Complejo[] Cuadrado = { // Pulso cuadradonew Complejo(1.0, 0.0),
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
    Complejo[] Senoidal = { // senoidal cos(nwT), w=2*PI*f
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

    Complejo[] Delta = { // Inpulso delta
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
    Complejo[] Rampa = { // rampa
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
}
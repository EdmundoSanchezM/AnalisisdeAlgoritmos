/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

import java.util.ArrayList;

/**
 * Implementacion de FFF DIT
 *
 * @author Edmundo J Sanchez M
 */
public class TransformadaDITFFT {

    /**
     * Para realizar la arirmetica compleja en los calculos de la FFT
     */
    AritmeticaCompleja aritmetica;

    /**
     * Constructor de la clase
     */
    public TransformadaDITFFT() {
        aritmetica = new AritmeticaCompleja();
    }

    /**
     * Calcula la FFT por decimacion o diezmo en tiempo
     *
     * @param N tamanio de las muestras de entrada
     * @param a arreglo de tamanio N Complejos
     * @param w contiene las raices de la unidad tambien complejos
     * @return devuelve la transformada discreta de los valores que antes
     * contenia "a" (Complejos)
     */
    public Complejo[] calcularTransformada(int N, Complejo[] a,
            Complejo[] w) {
        int paresEnGrupo = N / 2;
        int numeroDeGrupos = 1;
        int Distancia = N / 2;
        int bitBinario = (int) Math.round(Math.log(N) / Math.log(2));//Se ocupa para conseguir el bit inverso m como es de 16 el numero debe tener 4-bits
        while (numeroDeGrupos < N) {
            for (int K = 0; K < numeroDeGrupos; K++) {
                int jPrimero = 2 * K * paresEnGrupo;
                int jUltimo = jPrimero + paresEnGrupo;
                int jGirar = K;
                for (int J = jPrimero; J < jUltimo; J++) {
                    Complejo W = w[invertirBit(jGirar, 2, bitBinario - 1)];
                    Complejo Temp = aritmetica.multiplicar(W,a[J + Distancia]);
                    a[J + Distancia] = aritmetica.restar(a[J], Temp);
                    a[J] = aritmetica.sumar(a[J], Temp);
                }
            }
            paresEnGrupo = paresEnGrupo / 2;
            numeroDeGrupos = numeroDeGrupos * 2;
            Distancia = Distancia / 2;
        }
        return invertirBits(a);
    }
    
    /**
     *Calcula el bit inverso correspondiente de acuerdo al bit de entrada
     * @param numeroJGirar es el numero a invertir
     * @param radix basicamente es el radix que se esta ocuoando en la FFT
     * en este caso 2
     * @param tamaño es el numero de bits que tendra ese numero
     * @return devuelve el bit ya invertido
     */
    public int invertirBit(int numeroJGirar, int radix, int tamaño){
        int i, bitinvertido;
        int cantidadMov = (int) Math.round(Math.log(radix) / Math.log(2));//Cantidad de desplazamientos
        for (i = 0, bitinvertido = 0; i < tamaño; i++) {
            bitinvertido <<= cantidadMov;
            bitinvertido |= numeroJGirar & ((1 << cantidadMov) - 1);
            numeroJGirar >>= cantidadMov;
        }
        return bitinvertido;
    }
    
    /**
     * Funcion recursiva de DITFFT usando dividir y vence
     * la gran diferencia es que en esta ocasion la salida de la funcion
     * ya esta debidamente ordenada, por lo que no es necesario el uso
     * de invertirbits
     * @N tamanio del problema
     * @a arreglo de numeros complejos a calcular su transformada
     * @return devuelvela transformada discretade los valores de a, no sin antes
     * acomoadar las partes izquierda y derecha
     */

    public Complejo[] recursivoTransformada(int N, Complejo[] a) {
        if (N == 1) {
            Complejo y[] = {a[0]};
            return y;
        } else {
            int nh = N / 2;
            Complejo b[];
            Complejo c[];
            Complejo izq[] = new Complejo[nh];
            Complejo der[] = new Complejo[nh];
            for (int k = 0, j = 0; j < nh; k += 2, j++) {
                izq[j] = a[k];// Miembros de izquierda PAR
                der[j] = a[k + 1]; // Miembros de derecha IMPA
            }
            b = recursivoTransformada(nh, izq);
            c = recursivoTransformada(nh, der);
            c = calcularraicesdivyvencer(c, nh);
            Complejo[] y = new Complejo[N];//Arreglo de union de Izq y der
            for (int k = 0; k < nh; k++) {
                y[k] = aritmetica.sumar(b[k], c[k]);
                y[k + nh] = aritmetica.restar(b[k], c[k]);
            }
            return y;
        }
    }

    /**
     * Esta funcion es analoga junto con calcularRaices, la diferencia principal
     * es que esta calcula los w_{N}^{r} conjugados de cada subproblema que
     * obtenemos usando divide y venceras
     * @param a arreglo de complejos a calcular su w_{N}^{r}
     * @param N tamaño subproblema
     */
    public Complejo[] calcularraicesdivyvencer(Complejo[] a, int n) {
        double partearriba = 2 * Math.PI * .5 / n;
        double elementoasumar = 0.0;
        for (int k = 1; k < n; ++k) // k==0 skipped
        {
            elementoasumar += partearriba;
            Complejo wk = new Complejo(Math.cos(elementoasumar), Math.sin(elementoasumar));
            a[k] = aritmetica.multiplicar(a[k], wk);
        }
        return a;
    }

    /**
     * La funcion calcula las raices de la unidad necesarias para aplicar en un
     * algoritmo de FFT, es decir, los w__{N}^{r} conjugados
     *
     * @param N tamanio de la FFT
     * @return devuelve w que contiene las raices complejas ordenadas para
     * emplearlas cuando se requieran en el algoritmo FFT
     */
    public Complejo[] calcularRaices(int N) {
        double theta = 2.0 * Math.PI / (double) N;
        double[] wCos = new double[N];
        double[] wSen = new double[N];
        double s = Math.sin(theta);
        double c = 1.0 - 2.0 * Math.pow(Math.sin(theta / 2.0), 2.0);
        //double c = Math.sqrt( 1.0 - s*s );
        wCos[0] = 1.0;
        wSen[0] = 0.0;
        //System.out.println( "0 0 " + wCos[0] + " " + wSen[0] );
        for (int k = 0; k < N / 8; k++) {
            wCos[k + 1] = c * wCos[k] - s * wSen[k];
            wSen[k + 1] = s * wCos[k] + c * wSen[k];
            //System.out.println( (k+1) + " " + (k+1) + " " + wCos[k+1] + " " + wSen[k+1] );
        }
        //System.out.println();
        int L = N / 8;
        wCos[L] = Math.sqrt(2.0) / 2.0;
        wSen[L] = Math.sqrt(2.0) / 2.0;
        for (int k = 1; k <= N / 8; k++) {
            wCos[L + k] = wSen[L - k];
            wSen[L + k] = wCos[L - k];
            //System.out.println( (k+L) + " " + (k+L) + " " + wCos[k+L] + " " + wSen[L+k]);
        }
        //System.out.println();
        L = N / 4;
        wCos[L] = 0.0;
        wSen[L] = 1.0;
        for (int k = 1; k < N / 4; k++) {
            wCos[L + k] = -wCos[L - k];
            wSen[L + k] = wSen[L - k];
            //System.out.println( (k+L) + " " + (k+L) + " " + wCos[k+L] + " " + wSen[L+k]);
        }
        //System.out.println();
        Complejo[] w = new Complejo[N];
        //System.out.println( "PRIMER FOR" );
        for (int n = 0; n < N / 2; n++) {
            double real = wCos[n];
            double imag = wSen[n];
            if (imag != 0.0) {
                imag *= (-1.0);
            }
            w[n] = new Complejo(real, imag);
            //System.out.println( n + " " + w[n] );
        }
        //System.out.println( "SEGUNDO FOR" );
        for (int n = N / 2; n < N; n++) {
            //System.out.println( wCos[n-N/2] + " " + wSen[n-N/2] );
            double real = wCos[n - N / 2];
            double imag = wSen[n - N / 2];
            if (real != 0.0) {
                real *= (-1.0);
            }
            //System.out.println( real + " " + imag );
            w[n] = new Complejo(real, imag);
            //System.out.println( n + " " + w[n] );
        }
        return w;
    }

    /**
     * Ordena los elementos de la FFT
     *
     * @param a arreglo complejo desordenado
     * @return devuelve el arreglo complejo ordenado
     */
    public Complejo[] invertirBits(Complejo[] a) {
        int N = a.length;
        Complejo[] fftTemp = new Complejo[N];
        for (int n = 0; n < N; n++) {
            fftTemp[n] = a[n];//new Complejo(a[n]);
        }
        int[] bitInverso = new int[N];
        int p = 1;
        for (int q = 0; q < N; q++) {
            bitInverso[q] = q;
        }
        while (p < N) {
            for (int q = 0; q < p; q++) {
                bitInverso[q] = bitInverso[q] * 2;
                bitInverso[q + p] = bitInverso[q] + 1;
            }
            p = p * 2;
        }
        for (int n = 0; n < N; n++) {
            a[bitInverso[n]] = fftTemp[n]; //fft_out FFT ordenada.
        }
        return a;
    }
}

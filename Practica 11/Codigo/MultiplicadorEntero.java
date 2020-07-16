import java.math.BigInteger;

/**
 *
 * @author Saul De La O Torres
 */
public class MultiplicadorEntero {

    /**
     * @param u primer numero a multiplicar (int)
     * @param v segundo numero a multiplicar (int)
     * @return regresa la multiplicacion de los numeros
     */
    public int multiplicar(int u, int v) {
        int w, x, y, z;
        int n = obtenerMayorEnTamanioDeDigitos(u, v);
        if (esPequenio(n)) {
            return u * v;
        }
        // Dividir
        int s = n / 2;
        double temporal = Math.pow(10, s);
        w = u / (int) temporal;
        x = u % (int) temporal;
        y = v / (int) temporal;
        z = v % (int) temporal;
        // combinar
        return multiplicar(w, y) * (int) Math.pow(10, 2 * s)
                + (multiplicar(w, z) + multiplicar(x, y)) * (int) Math.pow(10, s)
                + multiplicar(x, z);
    }

    /**
     * Metodo sobrecargado de multiplicar
     *
     * @param u primer numero a multiplicar (long)
     * @param v segundo numero a multiplicar (long)
     * @return regresa la multiplicacion de los numeros
     */
    public long multiplicar(long u, long v) {
        long w, x, y, z;
        int n = obtenerMayorEnTamanioDeDigitos(u, v);
        if (esPequenio(n)) {
            return u * v;
        }
        // Dividir
        long s = n / 2;
        double temporal = Math.pow(10, s);
        w = u / (long) temporal;
        x = u % (long) temporal;
        y = v / (long) temporal;
        z = v % (long) temporal;
        // combinar
        return multiplicar(w, y) * (int) Math.pow(10, 2 * s)
                + (multiplicar(w, z) + multiplicar(x, y)) * (int) Math.pow(10, s)
                + multiplicar(x, z);
    }

    /**
     * Metodo sobrecargado de multiplicar
     *
     * @param u primer numero a multiplicar (BigInteger)
     * @param v segundo numero a multiplicar (BigInteger)
     * @return regresa la multiplicacion de los numeros
     */
    public static BigInteger multiplicar(BigInteger u, BigInteger v) {
        BigInteger w, x, y, z;
        int posiciones = Math.max(u.bitLength(), v.bitLength());
        if (posiciones <= 1000) {
            return u.multiply(v);
        }
        posiciones = posiciones / 2;
        w = u.shiftRight(posiciones);
        x = u.subtract(w.shiftLeft(posiciones));
        y = v.shiftRight(posiciones);
        z = v.subtract(y.shiftLeft(posiciones));
        BigInteger r = multiplicar(x.add(w), z.add(y));
        BigInteger z1 = r.subtract(multiplicar(w, y)).subtract(multiplicar(x, z));
        return multiplicar(w, y).shiftLeft(2 * posiciones).add(z1.shiftLeft(posiciones)).add(multiplicar(x, z));
    }

    /**
     * @param x primer numero a multiplicar (int)
     * @param y segundo numero a multiplicar (int)
     * @return regresa el tamaño del digito mayor
     */
    private int obtenerMayorEnTamanioDeDigitos(BigInteger x, BigInteger y) {
        String xString = "" + x;
        String yString = "" + y;
        if (xString.length() >= yString.length()) {
            return xString.length();
        }
        return yString.length();
    }

    /**
     * Metodo sobrecargado de obtenerMayorEnTamanioDeDigitos
     *
     * @param x primer numero a multiplicar (long)
     * @param y segundo numero a multiplicar (long)
     * @return regresa el tamaño del digito mayor
     */
    private int obtenerMayorEnTamanioDeDigitos(long x, long y) {
        String xString = "" + x;
        String yString = "" + y;
        if (xString.length() >= yString.length()) {
            return xString.length();
        }
        return yString.length();
    }

    /**
     * El numero es pequenio si es de un digito
     *
     * @param x el entero donde se verifica el numero de digitos que tiene
     *
     * @return devuelve true si es pequeño y false en caso contrario
     */
    private boolean esPequenio(int numero) {
        String xString = "" + numero;
        return xString.length() <= 1;
    }

    /**
     * Metodo sobre cargado de esPequenio
     *
     * @param x el entero tipo long donde se verifica el numero de digitos que
     * tiene
     *
     * @return devuelve true si es pequeño y false en caso contrario
     */
    private boolean esPequenio(long numero) {
        String xString = "" + numero;
        return xString.length() <= 1;
    }
}

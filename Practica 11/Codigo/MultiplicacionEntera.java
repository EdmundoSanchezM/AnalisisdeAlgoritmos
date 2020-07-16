import java.util.Scanner;
import java.math.BigInteger;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class MultiplicacionEntera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        MultiplicadorEntero f = new MultiplicadorEntero();
        int x;
        int y;
        System.out.println("Multiplicacion usando el dato primitivo: int");
        System.out.println("Ingrese el primer numero a multiplicar");
        x = teclado.nextInt();
        System.out.println("Ingrese el segundo numero a multiplicar");
        y = teclado.nextInt();
        double TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion como lo hace Java: " + x * y);
        double TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion usando dividir y vencer: " + f.multiplicar(x, y));
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        System.out.println("********************************************************************");
        long xl;
        long yl;
        System.out.println("Multiplicacion usando el dato primitivo: long");
        System.out.println("Ingrese el primer numero a multiplicar");
        xl = teclado.nextLong();
        System.out.println("Ingrese el segundo numero a multiplicar");
        yl = teclado.nextLong();
        TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion como lo hace Java: " + xl * yl);
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion usando dividir y vencer: " + f.multiplicar(xl, yl));
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        System.out.println("********************************************************************");
        BigInteger xBI;
        BigInteger yBI;
        System.out.println("Multiplicacion usando el dato primitivo: BigInteger");
        System.out.println("Ingrese el primer numero a multiplicar");
        xBI = teclado.nextBigInteger();
        System.out.println("Ingrese el segundo numero a multiplicar");
        yBI = teclado.nextBigInteger();
        TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion como lo hace la clase BigInteger: " + xBI.multiply(yBI));
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        TiempoInicio = System.nanoTime();
        System.out.println("Multiplicacion usando dividir y vencer: " + f.multiplicar(xBI, yBI));
        TiempoFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion en milisegundos:" + (TiempoFin - TiempoInicio) / 1000000);
        
    }

}

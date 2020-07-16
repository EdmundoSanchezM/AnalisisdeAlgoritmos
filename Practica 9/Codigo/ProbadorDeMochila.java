/**
 * @author sdelaot
 */
public class ProbadorDeMochila {

    public static void main(String[] args) {
        int[] p = {2, 5, 3, 6, 1};
        int[] b = {28, 33, 5, 12, 20};
        ObjetoDeMochila[] objetos = {
            new ObjetoDeMochila(p[0], b[0]),
            new ObjetoDeMochila(p[1], b[1]),
            new ObjetoDeMochila(p[2], b[2]),
            new ObjetoDeMochila(p[3], b[3]),
            new ObjetoDeMochila(p[4], b[4]),};
        int M = 10;
        int i = p.length;
        System.out.println("Algoritmo 1");
        Mochila mochila = new Mochila();
        System.out.println(mochila.insertarObjetosEnMochila(i, M, p, b));
        System.out.println(mochila.getObjetos());
        Mochila mochilaObj = new Mochila();
        System.out.println(mochilaObj.insertarObjetosEnMochila(i, M, objetos));
        System.out.println(mochilaObj.getObjetos());
        System.out.println("Algoritmo 2");
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD(p, b, M));
        System.out.println(mochilaObj.getObjetos());
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD(M, objetos));
        System.out.println(mochilaObj.getObjetos());
        System.out.println("Algoritmo 3");
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD2(p, b, M));
        System.out.println(mochilaObj.getObjetos());
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD2(M, objetos));
        System.out.println(mochilaObj.getObjetos());
        System.out.println("Algoritmo 4");
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD3(p, b, M) + ")");
        System.out.println(mochilaObj.getObjetos());
        System.out.println(mochilaObj.insertarObjetosEnMochilaPD3(M, objetos) + ")");
        System.out.println(mochilaObj.getObjetos());
        System.out.println(" Algoritmo 5 ");
        DatosMochila ED = new DatosMochila();
        ED = mochilaObj.insertarObjetosEnMochilaPD4(p, b, M);
        System.out.println("[" + ED.getMaximoBeneficio() + ", " + mochilaObj.CrearStringSolucion(ED.getSolucion()) + "]");
        System.out.println(mochilaObj.getObjetos());´
        ED = mochilaObj.insertarObjetosEnMochilaPD4(M, objetos);
        System.out.println("[" + ED.getMaximoBeneficio() + ", " + mochilaObj.CrearStringSolucion(ED.getSolucion()) + "]");
        System.out.println(mochilaObj.getObjetos());
    }
}

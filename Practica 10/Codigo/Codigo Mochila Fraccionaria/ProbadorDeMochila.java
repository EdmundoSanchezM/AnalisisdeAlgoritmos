import java.util.LinkedList;

/**
 */
public class ProbadorDeMochila {

    public static void main(String[] args) {
        float[] pesos = {60, 40, 20, 30, 10, 50};// = 100
        float[] beneficios = {50, 40, 30, 66, 20, 60};// = 155
        ObjetoDeMochila[] objetos = {
            new ObjetoDeMochila(pesos[0], beneficios[0]),
            new ObjetoDeMochila(pesos[1], beneficios[1]),
            new ObjetoDeMochila(pesos[2], beneficios[2]),
            new ObjetoDeMochila(pesos[3], beneficios[3]),
            new ObjetoDeMochila(pesos[4], beneficios[4]),
            new ObjetoDeMochila(pesos[5], beneficios[5])
        };
        MochilaVoraz mochila = new MochilaVoraz();
        int n = pesos.length;
        int M = 100;
        System.out.println("Arreglo sin ordenar");
        mochila.insertarObjetosEnMochilaFraccionaria(n, M, objetos);
        LinkedList<ObjetoDeMochila> objetosInsertados = mochila.getObjetos();
        for (ObjetoDeMochila odm : objetosInsertados) {
            System.out.println(odm);
        }
        objetosInsertados.clear();
        System.out.println("Ordenando por beneficio de mayor a menor");
        mochila.QuickSort(objetos, 0, beneficios.length - 1, 0);
        mochila.insertarObjetosEnMochilaFraccionaria(n, M, objetos);
        objetosInsertados = mochila.getObjetos();
        for (ObjetoDeMochila odm : objetosInsertados) {
            System.out.println(odm);
        }
        objetosInsertados.clear();
        System.out.println("Ordenando por peso de menor a mayor");
        mochila.QuickSort(objetos, 0, beneficios.length - 1, 1);
        mochila.insertarObjetosEnMochilaFraccionaria(n, M, objetos);
        LinkedList<ObjetoDeMochila> objetosInsertadosd = mochila.getObjetos();
        for (ObjetoDeMochila odm : objetosInsertadosd) {
            System.out.println(odm);
        }
        objetosInsertados.clear();
        System.out.println("Ordenando por rentabilidad de mayor a menor");
        mochila.QuickSort(objetos, 0, beneficios.length - 1, 2);
        mochila.insertarObjetosEnMochilaFraccionaria(n, M, objetos);
        for (ObjetoDeMochila odm : objetosInsertados) {
            System.out.println(odm);
        }
    }
}

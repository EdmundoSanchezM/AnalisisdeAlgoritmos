import java.util.Arrays;
import java.util.Scanner;

/**
 * Se opto por usar el algoritmo de Floyd-Warshall Este nos permite poder
 * seleccionar cualquier nodo de un grafo dirigido con peso
 * y dirigirnos a cualquier otro nodo El programa esta basado en la progrmacion
 * dinamica ya que se descompone un problema en subproblemas
 * Usando recursividad hacia adelante
 * Usando recursividad hacia adelante y atras
 * @author Edmundo J Sanchez M
 */
public class ProgramacionDinamicaII{

    /*
    * @param numVertices numero de vertices del grafo
    * @param NombreEstadoa nombre de los estados ordenados ordenados de acuerdo a los nodos
     */
    static final int numVertices = 21;
    static final String []NombreEstados ={"CDMX","Iztapalapa","Gustavo a Madero","Alvaro Obregon","Puebla","Ciudad Neza",
                                         "Ecatepec","Tlanepantla","Naucalpan","Merida","San Luis Potosi","Guanajuato","Guadalupe",
                                         "Monterrey","Guadalajara","Zapopan","Aguascalientes","Chihuahua","Culiacan","Cd.Juarez","Tijuana"};
    
    /**Funcion para pasar del nombre de los estados al numero del nodo correspondiente
     */
    static int Nombretonumeronodo(String Nodo) {
        for (int i = 0; i < numVertices; i++) {
            if (NombreEstados[i].equalsIgnoreCase(Nodo)) {
                return i;
            }
        }
        return 99;
    }
    /**Definimos un arreglo de tal forma que
    *{numero de nodo, numero del nodo siguiente, peso de esa transicion}
    * Busca el camino mas corto
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[][] pesos = {
            {1, 2, 7},
            {1, 3, 4},
            {1, 4, 7},
            {1, 6, 7},
            {2, 5, 59},
            {3, 7, 8},
            {3, 8, 6},
            {4, 9, 9},
            {5, 10,572},
            {6, 10,618},
            {7, 11,215},
            {8, 11,214},
            {9, 11,216},
            {9, 12,168},
            {11, 13,247},
            {11, 14,247},
            {11, 17,85},
            {12, 15,89},
            {12, 16,140},
            {12, 17,139},
            {13, 18,412},
            {14, 18,409},
            {15, 19,382},
            {16, 19,379},
            {17, 18,523},
            {17, 19,380},
            {18, 20,214},
            {18, 21,701},
            {19, 20,482},
            {19, 21,788},
        };
        String InicioNodo="",FinNodo="";
        System.out.println("Estados Disponibles:");
        for(int i =0;i<numVertices;i++)
            System.out.println(i+".-"+NombreEstados[i]);
        System.out.println("Ingrese el nombre del estado de origen");
        InicioNodo += leer.nextLine();
        int valor = Nombretonumeronodo(InicioNodo);
        if(valor==99){
            System.out.println("Ingreso mal el nombre");
            System.exit(0);
        }
        System.out.println("Ingrese el nombre del estado de destino");
        FinNodo += leer.nextLine();
        int valor1 = Nombretonumeronodo(FinNodo);
        if(valor==99){
            System.out.println("Ingreso mal el nombre");
            System.exit(0);
        }
        System.out.println("Ingrese el metodo:\n1.- Avance \n2.- Retroceso");
        int Metodo = leer.nextInt();
        Nodos objetoN = new Nodos(valor,valor1);
        FloydWarshall Objeto = new FloydWarshall(objetoN,numVertices,pesos,Metodo);
        Objeto.floydWarshall();
    }
}

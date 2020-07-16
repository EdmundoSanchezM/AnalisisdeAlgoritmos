import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para la implementacion del algoritmo de Floyd-Warshal
 *
 * @author Edmundo J Sanchez M
 */
public class FloydWarshall {

    /**
    * @param numVertices numero de vertices del grafo
    * @param dist arreglo de tamanio numVertices para guardar la distancia de un nodo a otro
    * @param nodosVisit arreglo de tamanio numVertices para guardar los nodos visitados para llegar a un nodo determinado
    * @param InicioNodo nodo de inicio
    * @param FinNodo nodo fin
    * @param NombreEstados nombre de los estados ordenados ordenados de acuerdo a los nodos
     */
    static int numVertices;
    static final String[] NombreEstados = {"CDMX", "Iztapalapa", "Gustavo a Madero", "Alvaro Obregon", "Puebla", "Ciudad Neza",
        "Ecatepec", "Tlanepantla", "Naucalpan", "Merida", "San Luis Potosi", "Guanajuato", "Guadalupe",
        "Monterrey", "Guadalajara", "Zapopan", "Aguascalientes", "Chihuahua", "Culiacan", "Cd.Juarez", "Tijuana"};
    private int[][] dist;
    private int[][] nodosVisit;
    private int InicioNodo;
    private int FinNodo;
    private int Metodo;

    /**Funcion para obtener el minimo de las rutas posibles
    * @param nodosgt nodo del problema siguiente
    * @param nodoInicio nodo del problema inicial
    * @param rutasgt numero de ruta a analizar de un nodo
     */
    public void minimo(int nodosgt, int nodoInicio, int rutasgt) {
        if (Metodo == 1) {
            if (rutasgt < numVertices) {
                if (dist[nodosgt][nodoInicio] + dist[nodoInicio][rutasgt] < dist[nodosgt][rutasgt]) {
                    dist[nodosgt][rutasgt] = dist[nodosgt][nodoInicio] + dist[nodoInicio][rutasgt];
                    nodosVisit[nodosgt][rutasgt] = nodosVisit[nodosgt][nodoInicio];
                }
                minimo(nodosgt, nodoInicio, rutasgt + 1);
            }
        } else {
            if (rutasgt >= 0) {
                if (dist[nodosgt][nodoInicio] + dist[nodoInicio][rutasgt] < dist[nodosgt][rutasgt]) {
                    dist[nodosgt][rutasgt] = dist[nodosgt][nodoInicio] + dist[nodoInicio][rutasgt];
                    nodosVisit[nodosgt][rutasgt] = nodosVisit[nodosgt][nodoInicio];
                }
                minimo(nodosgt, nodoInicio, rutasgt - 1);
            }
        }
    }

    /**Funcion para obtener el subproblema siguiente del problema inicial y se llama a minimo
    * @param nodosgt nodo del problema siguiente
    * @param nodoInicio nodo del problema inicial
     */
    public void subpsigt(int nodoInicio, int nodosgt) {
        if (Metodo == 1) {
            if (nodosgt < numVertices) {
                minimo(nodosgt, nodoInicio, 0);
                subpsigt(nodoInicio, nodosgt + 1);
            }
        } else {
            if (nodosgt >= 0) {
                minimo(nodosgt, nodoInicio, numVertices - 1);
                subpsigt(nodoInicio, nodosgt - 1);
            }
        }
    }

    /**Funcion para obtener el subproblema inicial se llama a subpsigt
    * @param nodoInicio nodo del problema inicial
     */
    public void subpinicial(int nodoInicio) {
        if (Metodo == 1) {
            if (nodoInicio < numVertices) {
                subpsigt(nodoInicio, 0);
                subpinicial(nodoInicio + 1);
            }
        } else {

            if (nodoInicio >= 0) {
                subpsigt(nodoInicio, numVertices - 1);
                subpinicial(nodoInicio - 1);
            }
        }
    }

    /**En esta clase se realiza el llenado de una matriz en donde se pone el
    *peso de cada transicion entre nodos y aquellos donde un nodo no puede ir 
    *a otro nodo directamente se colocaran como INFINITO(9999) es util por 
    *definicion de un grafo dirigido con peso, esto se hace con los 2 primeros
    *ciclos for El ultimo for es para llenar la matriz con los valores de 0 a 
    *numVertices-1 en cada linea, exceptuando donde existe el nodo (u,u) donde
    *u=u es el mismo numero de nodo esto se hace ya que en este tipo de grafos
    *un nodo no puede ir con el mismo directamente
     * @param objeto Objeto que contiene los nodos
     * @param numVertices numero de vertices del grafo
     * @param pesos arreglo de dos dimensiones de las conexiones directas entre
     * nodos
     *
     */
    public FloydWarshall(Nodos objeto, int numVertices, int[][] pesos, int Metodo) {
        this.numVertices = numVertices;
        dist = new int[numVertices][numVertices];
        nodosVisit = new int[numVertices][numVertices];
        for (int[] row : dist) {
            Arrays.fill(row, 9999);
        }
        for (int[] w : pesos) {
            dist[w[0] - 1][w[1] - 1] = w[2];
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    nodosVisit[i][j] = j + 1;
                }
            }
        }
        this.InicioNodo = objeto.getNodoInicial();
        this.FinNodo = objeto.getNodoFinal();
        this.Metodo = Metodo;
    }
    
    
    public void floydWarshall() {
        if (this.Metodo == 1) {
            subpinicial(this.InicioNodo);
        } else {
            subpinicial(this.FinNodo);
        }
        printCamino(this.dist, this.nodosVisit);
    }

    /*
     *Funcion para imprimir el camnio mas corto de los nodos seleccionados
     */
    public void printCamino(int[][] grafo, int[][] rutas) {
        int u = InicioNodo + 1;
        int v = FinNodo + 1;
        String path = "";
        int bandera = 0;
        if (grafo[InicioNodo][FinNodo] != 9999 && FinNodo > InicioNodo) {
            bandera = 1;
            path = "Distancia total: " + grafo[InicioNodo][FinNodo] + "          Ruta  mas corta: " + NombreEstados[u - 1];
        } else if (FinNodo > InicioNodo || grafo[InicioNodo][FinNodo] == 9999) {
            System.out.println("No hay ruta ya que la definicion del grafo usado no lo permite" + "       " + NombreEstados[u - 1] + " -> " + NombreEstados[v - 1]);
        }
        do {
            u = rutas[u - 1][v - 1];
            path = path + " -> " + NombreEstados[u - 1];
        } while (u != v);
        System.out.println((bandera == 1) ? path : " ");
    }

}

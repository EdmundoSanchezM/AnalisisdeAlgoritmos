/**
 *
 * @author Edmundo J Sanchez M
 *
 */
public class HamiltonianCircuit {

    final int NumV = 5;
    int[] camino;

    boolean esValido(int v, int[][] grafo, int camino[], int pos) {
        if (grafo[camino[pos - 1]][v] == 0) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            if (camino[i] == v) {
                return false;
            }
        }

        return true;
    }

    boolean cicloEncontrado(int[][] grafo, int camino[], int pos) {
        if (pos == NumV) {
            if (grafo[camino[pos - 1]][camino[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int v = 1; v < NumV; v++) {
            if (esValido(v, grafo, camino, pos)) {
                camino[pos] = v;
                if (cicloEncontrado(grafo, camino, pos + 1) == true) {
                    return true;
                }
                camino[pos] = -1;
            }
        }
        return false;
    }

    /*
    * Esta funcion soluciona el problema de ciclo Hamiltoniano usando vuelta
    * atras,utiliza principalmente cicloEncontrado () para resolver el
    * problema. Devuelve falso si no hay un ciclo hamiltoniano
    * posible, de lo contrario devuelve verdadero e imprime la ruta.
    * Mencionar que puede haber más de una solución,
    * Esta función imprime una de las soluciones factibles. 
     */
    int CicloHam(int graph[][]) {
        camino = new int[NumV];
        for (int i = 0; i < NumV; i++) {
            camino[i] = -1;
        }
        /* Pongamos el vertice 0 como el primer vertice en la ruta.
         * Si hay un ciclo Hamiltoniano, entonces el camino puede ser iniciado
         * desde cualquier punto del ciclo ya que el grafico es no dirigido
         */
        camino[0] = 0;
        if (cicloEncontrado(graph, camino, 1) == false) {
            System.out.println("\nNo existe solucion");
            return 0;
        }
        imprimirSolucion(camino);
        return 1;
    }

    void imprimirSolucion(int path[]) {
        System.out.println("Si existe solucion: "
                + "El siguiente es un ciclo hamiltoniano");
        for (int i = 0; i < NumV; i++) {
            System.out.print(" " + path[i] + " ");
        }
        System.out.println(" " + path[0] + " ");
    }

    public static void main(String args[]) {
        HamiltonianCircuit hamilton
                = new HamiltonianCircuit();
        /* Creamos el siguiente grafo
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0},};
        hamilton.CicloHam(graph1);

        /* Creamos el siguiente grafo
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},};
        hamilton.CicloHam(graph2);
    }
}

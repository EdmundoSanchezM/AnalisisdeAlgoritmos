import java.util.LinkedList;

/**
 *
 * @author Edmundo J Sanchez M Esta clase representa un grafo sin direcciones
 * usando una lista de adyacencia
 */
public class Grafo {

    private int V; // Numero de vertices
    private LinkedList<Integer> adj[]; //Lista de adyacencia 

    Grafo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //Funcion para añadir un vertice en el grafo
    void anadirVertice(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);//Grafo sin direccion
    }

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

}

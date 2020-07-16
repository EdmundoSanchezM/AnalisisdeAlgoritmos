/**
 *
 * @author Edmundo J Sanchez M
 * programa para colorear un grafo
 */
import java.util.*;
import java.util.LinkedList;

public class ColorearGrafo {

    // Asignamos colores (a partir de 0) a todos los vertices e imprimimos 
    // las asignaciones de colores 
    static void ColorearGrafo(Grafo g) {
        int V = g.getV();
        LinkedList<Integer> adj[] = g.getAdj();
        int resultado[] = new int[V];
        // Inicializamos todos los vertices como sin asignar
        Arrays.fill(resultado, -1);
        
        // Asignamos el primer color al primer vertice
        resultado[0] = 0;
        
        // Un arreglo temporal para guardar los colores disponibles. El valor
        // falso de colorDisponible[cr] significaria que el color cr esta asignado
        // a uno de sus vertices adyacentes
        boolean colorDisponible[] = new boolean[V];

        // Inicializamos todos los colores como disponibles 
        Arrays.fill(colorDisponible, true);
        // Asignamos los colores a los V-1 vertices faltantes 
        for (int u = 1; u < V; u++) {
            // Procesamos todos los vertices de adiacencia y marcamos sus colores
            // como no disponible
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (resultado[i] != -1) {
                    colorDisponible[resultado[i]] = false;
                }
            }
            // Buscamos el primer color disponible  
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (colorDisponible[cr]) {
                    break;
                }
            }
            resultado[u] = cr; // Asignamos el color encontrado   

            // Reiniciamos los valores de vuelta a verdadero para la siguiente 
            // iteracion 
            Arrays.fill(colorDisponible, true);
        }

        // Imprimims el resultado
        for (int u = 0; u < V; u++) {
            System.out.println("Vertice " + u + " ---> Color "
                    + resultado[u]);
        }
    }

    public static void main(String args[]) {
        Grafo g1 = new Grafo(5);
        g1.anadirVertice(0, 1);
        g1.anadirVertice(0, 2);
        g1.anadirVertice(1, 2);
        g1.anadirVertice(1, 3);
        g1.anadirVertice(2, 3);
        g1.anadirVertice(3, 4);
        System.out.println("Coloreando grafo 1");
        ColorearGrafo(g1);
        System.out.println();
        System.out.println("Coloreando grafo 2");
        Grafo g2 = new Grafo(5);
        g2.anadirVertice(0, 1);
        g2.anadirVertice(0, 2);
        g2.anadirVertice(1, 2);
        g2.anadirVertice(1, 4);
        g2.anadirVertice(2, 4);
        g2.anadirVertice(4, 3);
        ColorearGrafo(g2);
    }
}

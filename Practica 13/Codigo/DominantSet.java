import java.util.Vector;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class DominantSet {

    static Vector<Integer>[] g;
    static boolean[] box = new boolean[100000];

    static Vector<Integer> Dominant(int vertices, int aristas) {
        Vector<Integer> S = new Vector<Integer>();
        for (int i = 0; i < vertices; i++) {
            if (!box[i]) {
                S.add(i);
                box[i] = true;
                for (int j = 0; j < (int) g[i].size(); j++) {
                    if (!box[g[i].get(j)]) {
                        box[g[i].get(j)] = true;
                        break;
                    }
                }
            }
        }
        return S;
    }
    public static void main(String[] args) {
        int vertices, aristas, x, y;
        vertices = 5; // Numero de vertices
        aristas = 6; // Numero de aristas
        g = new Vector[vertices];
        for (int i = 0; i < vertices; i++) {
            g[i] = new Vector<Integer>();
        }
        g[0].add(1);
        g[1].add(0); // x = 1, y = 2 ; 
        g[1].add(2);
        g[2].add(1); // x = 2, y = 3 ; 
        g[2].add(3);
        g[3].add(2); // x = 3, y = 4 ; 
        g[0].add(3);
        g[3].add(0); // x = 1, y = 4 ; 
        g[3].add(4);
        g[4].add(3); // x = 4, y = 5 ; 
        g[2].add(4);
        g[4].add(2); // x = 3, y = 5 ; 
        Vector<Integer> S = Dominant(vertices, aristas);
        System.out.print("El conjunto dominante es : { ");
        for (int i = 0; i < (int) S.size(); i++) {
            System.out.print(S.get(i) + 1 + " ");
        }
        System.out.print("}");
        System.out.println("");
    }

}

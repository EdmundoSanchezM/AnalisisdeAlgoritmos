import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 */
public class HuffmanLogica {

    private final HuffmanNodo arrel;
    private final Map<Character, HuffmanNodo> fulles = new HashMap<>();

    public String Codificar(HuffmanNodo nodo) {

        if (nodo.pare == null) {
            return "";
        } else {
            if (nodo.pare.fe == nodo) {
                return Codificar(nodo.pare) + '0';
            } else {
                return Codificar(nodo.pare) + '1';
            }
        }
    }

    public String Codificar(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            r += Codificar(fulles.get(s.charAt(i)));
        }
        return r;
    }

    public String Decodificar(String s) {
        System.out.println("LEN(s) " + s.length() + " " + s);
        String r = "";
        HuffmanNodo p = arrel;
        for (int i = 0; i < s.length(); i++) {
            int j = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (j == 0) {
                p = p.fe;
                if (p.fd == null && p.fe == null) {
                    r += p.c;
                    p = arrel;
                }
            }
            if (j == 1) {
                p = p.fd;
                if (p.fd == null && p.fe == null) {
                    r += p.c;
                    p = arrel;
                }
            }
        }
        return r;
    }

    public HuffmanLogica(Map<Character, Double> F) {
        PriorityQueue<HuffmanNodo> CP = new PriorityQueue<HuffmanNodo>(F.size(), new NodoComparador());
        Set<Character> llaves = F.keySet();
        for (Character i : llaves) {
            HuffmanNodo P = new HuffmanNodo(null, null, i, F.get(i));
            CP.offer(P);
            fulles.put(i, P);
        }
        while (CP.size() != 1) {
            HuffmanNodo p = CP.peek();
            CP.remove();
            HuffmanNodo q = CP.peek();
            CP.remove();
            HuffmanNodo FinalNodo = new HuffmanNodo(p, q, ' ', p.f + q.f);
            CP.add(FinalNodo);
        }
        arrel = CP.peek();
    }

    class NodoComparador implements Comparator<HuffmanNodo> {
        public int compare(HuffmanNodo n1, HuffmanNodo n2) {
            if (n1.f < n2.f) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    class HuffmanNodo {
        Double f;
        char c;
        HuffmanNodo fe, fd, pare;
        HuffmanNodo(HuffmanNodo fe, HuffmanNodo fd, char c, double f) {
            this.fe = fe;
            this.fd = fd;
            this.c = c;
            this.f = f;
            if (fe != null) {
                fe.pare = this;
            }
            if (fd != null) {
                fd.pare = this;
            }
        }

    }

}

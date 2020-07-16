/**
 *
 * @author Edmundo J Sanchez M
 */
public class Nodos {

    
    private int NodoInicial;
    private int NodoFinal;
    
    public int getNodoInicial() {
        return NodoInicial;
    }

    public Nodos(int NodoInicial, int NodoFinal) {
        this.NodoInicial = NodoInicial;
        this.NodoFinal = NodoFinal;
    }

    public void setNodoInicial(int NodoInicial) {
        this.NodoInicial = NodoInicial;
    }

    public int getNodoFinal() {
        return NodoFinal;
    }

    public void setNodoFinal(int NodoFinal) {
        this.NodoFinal = NodoFinal;
    }

}

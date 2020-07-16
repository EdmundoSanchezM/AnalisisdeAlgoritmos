/**
 * @author sdelaot
 */
public class ObjetoDeMochila {

    private int peso;
    private int beneficio;

    public ObjetoDeMochila(int peso, int beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    @Override
    public String toString() {
        return "ObjetoDeMochila{" + "peso=" + peso + ", beneficio=" + beneficio + '}';
    }
}

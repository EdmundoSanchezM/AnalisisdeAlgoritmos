/**
 * @author sdelaot
 */
public class ObjetoDeMochila {

    private float peso;
    private float beneficio;
    private float solucion;
    private float retabilidad;

    public ObjetoDeMochila(float peso, float beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
        solucion = (float) 0.0;
        this.retabilidad = beneficio / peso;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }

    public float getSolucion() {
        return solucion;
    }

    public void setSolucion(float solucion) {
        this.solucion = solucion;
    }

    public float getRetabilidad() {
        return retabilidad;
    }

    public void setRetabilidad(float retabilidad) {
        this.retabilidad = retabilidad;
    }


    @Override
    public String toString() {
        return "ObjetoDeMochila{" + "peso=" + peso + ", beneficio=" + beneficio + ", rentabilidad=" + retabilidad + ", solucion=" + solucion + '}';
    }
}

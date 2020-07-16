import java.util.ArrayList;

/**
*/
public class DatosMochila {

    int MaximoBeneficio;
    ArrayList<Integer> Solucion;

    public DatosMochila() {

    }

    public DatosMochila(int valor, ArrayList<Integer> valora) {
        this.MaximoBeneficio = valor;
        this.Solucion = valora;
    }

    public int getMaximoBeneficio() {
        return MaximoBeneficio;
    }

    public void setMaximoBeneficio(int MaximoBeneficio) {
        this.MaximoBeneficio = MaximoBeneficio;
    }

    public ArrayList<Integer> getSolucion() {
        return Solucion;
    }

    public void setSolucion(ArrayList<Integer> Solucion) {
        this.Solucion = Solucion;
    }

}

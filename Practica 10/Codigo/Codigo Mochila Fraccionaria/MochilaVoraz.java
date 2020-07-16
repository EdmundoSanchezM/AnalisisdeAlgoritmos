import java.util.LinkedList;

/**
 * @author sdelaot
 */
public class MochilaVoraz {

    LinkedList<ObjetoDeMochila> objetos;

    public MochilaVoraz() {
        this.objetos = new LinkedList<>();
    }

    public void insertarObjetosEnMochilaFraccionaria(int n, int M,
            ObjetoDeMochila[] objetosM) {
        int i;
        for (i = 0; i < n; i++) {
            objetosM[i].setSolucion((float) 0.0);
        }
        float pesoActual = 0;
        for (i = 0; pesoActual < M && i < n; i++) {
            if (pesoActual + objetosM[i].getPeso() <= M) {
                objetosM[i].setSolucion(1);
            } else {
                objetosM[i].setSolucion(objetosM[i].getSolucion() + ((M - pesoActual) / objetosM[i].getPeso()));
            }
            if (objetosM[i].getSolucion() > 0.0) {
                objetos.add(objetosM[i]);
            }
            pesoActual += objetosM[i].getSolucion() * objetosM[i].getPeso();
        }
    }

    private int Dividir(ObjetoDeMochila arreglo[], int incio, int fin, int forma) {
        if (forma == 0) {
            float pivote = arreglo[fin].getBeneficio();
            int i = (incio - 1);
            for (int j = incio; j < fin; j++) {
                if (arreglo[j].getBeneficio() >= pivote) {
                    i++;
                    ObjetoDeMochila intercambioTemp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = intercambioTemp;
                }
            }
            ObjetoDeMochila intercambioTemp = arreglo[i + 1];
            arreglo[i + 1] = arreglo[fin];
            arreglo[fin] = intercambioTemp;
            return i + 1;
        } else if (forma == 1) {
            float pivote = arreglo[fin].getPeso();
            int i = (incio - 1);
            for (int j = incio; j < fin; j++) {
                if (arreglo[j].getPeso() <= pivote) {
                    i++;
                    ObjetoDeMochila intercambioTemp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = intercambioTemp;
                }
            }
            ObjetoDeMochila intercambioTemp = arreglo[i + 1];
            arreglo[i + 1] = arreglo[fin];
            arreglo[fin] = intercambioTemp;
            return i + 1;
        } else {
            float pivote = arreglo[fin].getRetabilidad();
            int i = (incio - 1);
            for (int j = incio; j < fin; j++) {
                if (arreglo[j].getRetabilidad() >= pivote) {
                    i++;
                    ObjetoDeMochila intercambioTemp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = intercambioTemp;
                }
            }
            ObjetoDeMochila intercambioTemp = arreglo[i + 1];
            arreglo[i + 1] = arreglo[fin];
            arreglo[fin] = intercambioTemp;
            return i + 1;
        }

    }

    public void QuickSort(ObjetoDeMochila arreglo[], int inicio, int fin, int forma) {
        if (inicio < fin) {
            int IndexDividir = Dividir(arreglo, inicio, fin, forma);
            QuickSort(arreglo, inicio, IndexDividir - 1, forma);
            QuickSort(arreglo, IndexDividir + 1, fin, forma);
        }
    }

    public LinkedList<ObjetoDeMochila> getObjetos() {
        return objetos;
    }
}

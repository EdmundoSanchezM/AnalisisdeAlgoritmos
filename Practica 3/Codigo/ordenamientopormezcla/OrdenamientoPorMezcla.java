import java.util.ArrayList;

/**
 *
 * @author sdelaot
 * @author Edmundo J Sanchez M
 */
//Abril2020 - Edmundo J - Modificado para el uso de informacion reunida en lugar de int
public class OrdenamientoPorMezcla {

    private ArrayList lista;
    public ArrayList ordenarPorMezcla(ArrayList unaLista, int op) {
        int i, j, k;
        if (unaLista.size() > 1) {
            int nElementosIzq = unaLista.size() / 2;
            int nElementosDer = unaLista.size() - nElementosIzq;
            ArrayList <Ciudadano> listaIzquierda = new ArrayList <Ciudadano>();
            ArrayList <Ciudadano> listaDerecha = new ArrayList<Ciudadano>();
            llenarLista(unaLista, listaIzquierda, 0, nElementosIzq);
            llenarLista(unaLista, listaDerecha, nElementosIzq, nElementosIzq + nElementosDer);
            listaIzquierda = ordenarPorMezcla(listaIzquierda,op);
            listaDerecha = ordenarPorMezcla(listaDerecha,op);
            intercambiar(unaLista, listaIzquierda, listaDerecha,op);
        }
        return unaLista;
    }

    private void llenarLista(ArrayList arreglo, ArrayList arreglo2, int inicio, int fin) {
        int contador = 0;
        for (int i = inicio; i < fin; i++) {
            arreglo2.add(contador,arreglo.get(i));
            contador++;
        }
    }

    private void intercambiar(ArrayList unaLista, ArrayList listaIzquierda, ArrayList listaDerecha, int op) {
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList  <Ciudadano> clistaIzquierda = new ArrayList<Ciudadano>();
        ArrayList  <Ciudadano> clistaDerecha = new ArrayList<Ciudadano>();
        clistaIzquierda = listaIzquierda;
        clistaDerecha = listaDerecha;
        while (clistaIzquierda.size() != j && clistaDerecha.size() != k) {
            if ((clistaIzquierda.get(j).getNombre().compareToIgnoreCase(clistaDerecha.get(k).getNombre())<0&&op==1)||
                (clistaIzquierda.get(j).getPaterno().compareToIgnoreCase(clistaDerecha.get(k).getPaterno())<0&&op==2)||
                (clistaIzquierda.get(j).getMaterno().compareToIgnoreCase(clistaDerecha.get(k).getMaterno())<0&&op==3)||
                (clistaIzquierda.get(j).getEdad()<clistaDerecha.get(k).getEdad()&&op==4)||
                (clistaIzquierda.get(j).getDireccion().getColonia().compareToIgnoreCase(clistaDerecha.get(k).getDireccion().getColonia())<0&&op==5)||
                (clistaIzquierda.get(j).getDireccion().getCp().compareToIgnoreCase(clistaDerecha.get(k).getDireccion().getCp())<0&&op==6)||
                (clistaIzquierda.get(j).getDireccion().getEntidadfederativa().getNombre().compareToIgnoreCase(clistaDerecha.get(k).getDireccion().getEntidadfederativa().getNombre())<0&&op==7)||
                (clistaIzquierda.get(j).getDireccion().getEntidadfederativa().getMunicipioalcaldia().getNombre().compareToIgnoreCase(clistaDerecha.get(k).getDireccion().getEntidadfederativa().getMunicipioalcaldia().getNombre())<0&&op==8)){
                unaLista.set(i,clistaIzquierda.get(j));
                i++;
                j++;
            } else {
                unaLista.set(i,clistaDerecha.get(k));
                i++;
                k++;
            }
        }
        while (clistaIzquierda.size() != j) {
            unaLista.set(i,listaIzquierda.get(j));
            i++;
            j++;
        }
        while (clistaDerecha.size() != k) {
            unaLista.set(i,clistaDerecha.get(k));
            i++;
            k++;
        }
    }
}

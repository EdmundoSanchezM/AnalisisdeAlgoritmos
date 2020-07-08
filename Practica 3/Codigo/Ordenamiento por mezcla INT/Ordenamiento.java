/**
*
* @author sdelaot
*/

public class Ordenamiento {
public static void main(String[] args) {
OrdenamientoPorMezcla ordenamiento = new OrdenamientoPorMezcla( 100 );
ordenamiento.llenarArreglo();
ordenamiento.mostrarLista( "Lista sin ordenar" );
int [] lista = ordenamiento.ordenarPorMezcla( ordenamiento.getLista());
ordenamiento.setLista(lista);
ordenamiento.mostrarLista( "Lista ordenada" );
}
}
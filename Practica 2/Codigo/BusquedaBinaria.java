/**
 * Implementacion del algoritmo de busqueda binaria
 *
 * @author Saul De La O Torres
 */
public class BusquedaBinaria {

    /**
     * Busca el x si esta presente y devuelve el indice del elemento si esta en
     * el arreglo, funcion recursiva.
     *
     * @param arr arreglo sobre el cual se busca
     * @param l
     * @param r
     * @param x el entero que se busca
     * @return devuelve el indice del elemento buscado
     */
    public int buscarBinariamente(int[] arr, int l, int r, int x) {
// condicion de parada
        if (r >= l) {
            int mitad = l + (r - l) / 2;
// Si el elemento esta presente a la mitad del arreglo
            if (arr[mitad] == x) {
                return mitad;
            }
// Si el elemento es mas pequenio que la mitad, entonces
// estara presente en el subarreglo izquierdo
            if (arr[mitad] > x) {
                return buscarBinariamente(arr, l, mitad - 1, x);
            }
// En caso contrario el elemento estara presente
// en el subarreglo derecho
            return buscarBinariamente(arr, mitad + 1, r, x);
        }
// El elemento no esta presente en el arreglo
        return -1;
    }

    /**
     * Busca iterativamente
     *
     * @param arr el arreglo
     * @param x el elemento a buscar
     * @return devuelve el indice del elemento buscado, -1 si no esta
     */
    int buscarBinariamenteIterativo(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
// calcula la mitad
            int mitad = l + (r - l) / 2;
// Check if x is present at mid
            if (arr[mitad] == x) {
                return mitad;
            }
// si x es mas grande ignora la mitad derecha
            if (arr[mitad] < x) {
                l = mitad + 1;
            } else { // si x mas paquenio, ignora la mitad derecha
                r = mitad - 1;
            }
        }
// Si el elemento no esta en el arreglo
        return -1;
    }
}

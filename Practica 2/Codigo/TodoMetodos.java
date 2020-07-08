import java.util.Scanner;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class TodoMetodos {

    private Scanner teclado = new Scanner(System.in);
    private Datos datos = new Datos();
    private BusquedaBinaria Busqueda = new BusquedaBinaria();

    public int MetodoRecursivo(int[]Arr,int l, int r, int NumeroBuscar) {
        return Busqueda.buscarBinariamente(Arr, l, r,NumeroBuscar);
    }

    public int MetodoIterativo(int[]Arr, int NumeroBuscar) {
        return Busqueda.buscarBinariamenteIterativo(Arr, NumeroBuscar);
    }

    public void LlamadaMetodos() {
        int Lugar = 0;
        String LugarMensaje = null;
        double TiempoInicio = 0;
        double TiempoFin = 0;
        int arr[]=datos.getArreglo();
        int Tamano=datos.getTamano();
        int NumeroB= datos.getNumeroBuscar();
        TiempoInicio = System.nanoTime();
        Lugar = MetodoRecursivo(arr,0,Tamano-1,NumeroB);
        TiempoFin = System.nanoTime();
        LugarMensaje = (Lugar == -1) ? ("No existe en el arreglo.") : ("El numero buscado fue: " + datos.getNumeroBuscar() + " y se encuentra en:" + Lugar + "");
        System.out.println("Metodo Recursivo: " + LugarMensaje);
        System.out.println("Tiempo de ejecucion con busqueda recursiva en milisegundos: " + (TiempoFin - TiempoInicio) / 1000000);
        TiempoInicio = System.nanoTime();
        Lugar = MetodoIterativo(arr,NumeroB);
        TiempoFin = System.nanoTime();
        LugarMensaje = (Lugar == -1) ? ("No existe en el arreglo.") : ("El numero buscado fue: " + datos.getNumeroBuscar() + " y se encuentra en:" + Lugar + "");
        System.out.println("Metodo Iterativo: " + LugarMensaje);
        System.out.println("Tiempo de ejecucion con busqueda iterativa en milisegundos: " + (TiempoFin - TiempoInicio) / 1000000);
    }

    public void BuscaNumeroUsuario() {
        System.out.println("Ingrese el numero a buscar en el arreglo: ");
        datos.setNumeroBuscar(teclado.nextInt());
        LlamadaMetodos();
    }

    public void ImprimirArreglo() {
        int Arreglo[] = datos.getArreglo();
        int n = datos.getTamano();
        System.out.println("Arreglo ordenado: ");
        for (int i = 0; i < n; i++) {
            System.out.print(Arreglo[i] + " ");
        }
        System.out.println("");
    }

    public void QuickSort() {
        int Arreglo[] = datos.getArreglo();
        int n = Arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Arreglo[j] > Arreglo[j + 1]) {
                    // swap temp and arr[i]
                    int temp = Arreglo[j];
                    Arreglo[j] = Arreglo[j + 1];
                    Arreglo[j + 1] = temp;
                }
            }
        }
        datos.setArreglo(Arreglo);
        ImprimirArreglo();
    }

    public void GenerarNumeros() {
        int Tamano = datos.getTamano();
        int Arreglo[] = new int[Tamano];
        for (int i = 0; i < Tamano; i++) {
            int valorRandom = (int) Math.floor(Math.random() * (Tamano + Tamano + 1) - Tamano);
            Arreglo[i] = valorRandom;
        }
        datos.setArreglo(Arreglo);
        QuickSort();
        BuscaNumeroUsuario();
    }

    public void IngresaNumeroUsuario() {
        System.out.println("Ingrese el numero de elementos del arreglo: ");
        datos.setTamano(teclado.nextInt());
        GenerarNumeros();
    }
}

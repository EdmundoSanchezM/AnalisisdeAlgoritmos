import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class Ordenamiento {
    public static void main(String[] args) {
        ManejoDatos manejodatos = new ManejoDatos();
        ArrayList<Ciudadano> Ciudadanos = manejodatos.CreacionCiudadanos();
        System.out.println("Ciudadanos no ordenados");
        manejodatos.ImprimirCiudadanos(Ciudadanos);
        int Opc = manejodatos.Menu();
        OrdenamientoPorMezcla ordenamientopormezcla = new OrdenamientoPorMezcla();
        ArrayList<Ciudadano> CiudadanosOrdenados = ordenamientopormezcla.ordenarPorMezcla(Ciudadanos,Opc);
        System.out.println("Ciudadanos ya ordenados");
        manejodatos.ImprimirCiudadanos(CiudadanosOrdenados);
    }
}

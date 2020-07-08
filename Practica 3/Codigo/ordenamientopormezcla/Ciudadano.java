/**
 *
 * @author Edmundo J Sanchez M
 */
public class Ciudadano {
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private Direccion direccion;

    public Ciudadano(String nombre, String paterno, String materno, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }


    public int getEdad() {
        return edad;
    }
    
}

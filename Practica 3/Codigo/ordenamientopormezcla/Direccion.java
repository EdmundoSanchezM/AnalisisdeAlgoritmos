/**
 *
 * @author Edmundo J Sanchez M
 */
public class Direccion {
    private String calle;
    private int numero;
    private String colonia;
    private String cp;
    private EntidadFederativa entidadfederativa;

    public Direccion(String calle, int numero, String colonia, String cp, EntidadFederativa entidadfederativa) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.entidadfederativa = entidadfederativa;
    }

    public EntidadFederativa getEntidadfederativa() {
        return entidadfederativa;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCp() {
        return cp;
    }
    
}

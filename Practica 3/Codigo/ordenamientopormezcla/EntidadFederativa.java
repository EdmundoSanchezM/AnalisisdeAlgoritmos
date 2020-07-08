/**
 *
 * @author Edmundo J Sanchez M
 */
public class EntidadFederativa {
    private String Nombre;
    private MunicipioAlcaldia municipioalcaldia;

    public EntidadFederativa(String Nombre, MunicipioAlcaldia municipioalcaldia) {
        this.Nombre = Nombre;
        this.municipioalcaldia = municipioalcaldia;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public MunicipioAlcaldia getMunicipioalcaldia() {
        return municipioalcaldia;
    }
    
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class ManejoDatos {
    
    public void ImprimirCiudadanos(ArrayList nuevoc) {
        ArrayList<Ciudadano> Ciudadanos = new ArrayList<Ciudadano>();
        Ciudadanos = nuevoc;
        for (int i = 0; i < Ciudadanos.size(); i++) {
            System.out.println("------------------------------------------");
            System.out.println("Nombre: " + Ciudadanos.get(i).getNombre() + " Apellido Paterno: " + Ciudadanos.get(i).getPaterno() + " Apellido Materno: " + Ciudadanos.get(i).getMaterno()
                    + " Edad: " + Ciudadanos.get(i).getEdad() + "\nCalle: " + Ciudadanos.get(i).getDireccion().getCalle() + " Numero: " + Ciudadanos.get(i).getDireccion().getNumero()
                    + " Colonia: " + Ciudadanos.get(i).getDireccion().getColonia() + " Codigo Postal: " + Ciudadanos.get(i).getDireccion().getCp()
                    + "\nEntidad Federativa: " + Ciudadanos.get(i).getDireccion().getEntidadfederativa().getNombre()
                    + " Municipio/Alcaldia: " + Ciudadanos.get(i).getDireccion().getEntidadfederativa().getMunicipioalcaldia().getNombre());
            System.out.println("------------------------------------------");
        }

    }
    
    public ArrayList CreacionCiudadanos(){
        ManejoDatos manejodatos= new ManejoDatos();
        String nombres[] = {"Edmundo", "Pedro", "Pablo", "Guillermo", "Carlos", "Cedric", "Jhoana", "Maki", "Ebina", "Yosafat", "Sui", "Marysol", "Abraham",
            "Noe", "Foreman", "Francisco", "Saul","Saul de la O", "Victor", "Maria de la Luz", "Juan", "Felix", "Miguel", "Manuel", "Alexis", "Ismael",
            "Jorge", "Ruben", "Eduardo", "Martin", "Enrique", "Edgar", "Ana", "Maria", "Evelyn", "Alejandra", "Patricia", "Carmen", "Atziri", "Deyanira", "Monse"};
        String apellidos[] = {"Sanchez", "Mendez", "Covarrubias", "Olvera", "Arenas", "Anleu", "Tinoco", "Barron", "Ingles", "Villalobos", "Alarcon", "Ramos", "Diaz", "Fuentes", "Solo", "Garcia", "Nava",
            "Jimenez", "Andrade", "Rodriguez", "Casas", "Villa", "Nishikino", "Dantes", "Monson", "Xochihua", "Ramirez", "Torres", "Hernandez", "Marin", "Mendoza", "Rojas", "Bodet", "Ojeda", "Sangreal", "Navarro", "Franco", "Casados", "Manriquez", "Maldonado"};
        String EntidadFederativa[]={"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "CD. Mexico", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan",
            "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi", 
            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas"};
        String MunicipioAlcaldia[] = {"Alvaro obregon", "Azcapotzalco", "Benito Juarez", "Coyoacan", "Cuajimalpa de Morelos", "Cuauhtemoc", "Gustavo A Madero",
            "Iztacalco", "Iztapalapa", "La Magdalena Contreras", "Miguel Hidalgo", "Milpa Alta", "Tlalpan", "Tlahuac", "Venustiano Carranza", "Xochimilco","Huajuapan de Leon","La Paz","Celaya","Huajolotitlan","Puerto Escondido","Villa Hermosa",
        "Tijuana","Acapulco","Tepit","Ecatepec","Chalco","Nezahuacoyotl","Mexicali","Ensenada","Torreon","Carmen","Manzanillo","Ocampo","Leon","Copala","Toluca","Tonala"};
        String Calles[] = {"Andador Juan Pablo Anaya", "Caracuaro", "Av.Textcoco", "Av.Tepozanes", "Barranca del Muerto", "Congreso de la Union",
            "La Roqueta", "Maremoto", "Eugenia", "Mar Azof", "Mar de Java", "Mar Mediterraneo", "Plan Sexenal", "Pisco", "Manta", "Natal", "Ignacio Ayala", "Congreso de Chipalcingo Sur", "Mario Bautista","Miguel Hidalgo","Monte Alban",
            "Reforma","Periferico"," Emiliano Zapata","Benito Juárez","Francisco I Madero"};
        String Colonia[] = {"Unidad Ermita Zaragoza", "Lindavista", "Santa Maria Aztahuacan", "Agricola Oriental", "Portales", "Morelos", "Merced", "Centro", "Leyes de Reforma",
            "Pantitlan", "Tepalcates", "Santa Marta Acatitla", "Narvarte", "Pensil", "20 de Noviembre", "Zacatenco", "Olivar del Conde", "El Arenal", "Lomas de Zaragoza", "Providencia", "Constitucion", "Tecalolco","El Chipote",
            "Calvario","Cumbres","Tepozanes","Colmena","Obispado","Refineria"};
        ArrayList<Ciudadano> Ciudadanos = new ArrayList<Ciudadano>();
        for (int i = 0; i < 40; i++) {
            int CPint = 1000 + new Random().nextInt(9000);
            String CP = "0" + Integer.toString(CPint);
            MunicipioAlcaldia muni = new MunicipioAlcaldia(MunicipioAlcaldia[(int) Math.floor(Math.random() * MunicipioAlcaldia.length)]);
            EntidadFederativa ent = new EntidadFederativa(EntidadFederativa[(int) Math.floor(Math.random() * EntidadFederativa.length)], muni);
            Direccion dirrec = new Direccion(Calles[(int) Math.floor(Math.random() * Calles.length)], (int) Math.floor(Math.random() * (1000 - 1) + 1), Colonia[(int) Math.floor(Math.random() * Colonia.length)], CP, ent);
            Ciudadano nuevoc = new Ciudadano(nombres[(int) Math.floor(Math.random() * nombres.length)], apellidos[(int) Math.floor(Math.random() * apellidos.length)], apellidos[(int) Math.floor(Math.random() * apellidos.length)], (int) Math.floor(Math.random() * (100 - 18) + 18), dirrec);
            Ciudadanos.add(nuevoc);
        }
        return Ciudadanos;
    }
    public int Menu(){
        Scanner Leer = new Scanner(System.in);
        System.out.println("Como quiere ordenar los datos?");    
        System.out.println("1.- Nombre\n2.- Apellido Paterno\n3.- Apellido Meterno\n4.- Edad\n5.- Colonia"
                + "\n6.- CP\n7.- Entidad Federativa\n8.- Municipio y/o Alcaldia");
        System.out.println("Ingrese el digito: ");
        int opcion = Leer.nextInt();
        return opcion;
    }
}

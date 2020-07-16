import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 */
public class Huffman {

    static Map<Character, Double> Frecuencia(String cadena) {
        char[] Arraycadena;
        char caracter;
        Arraycadena = cadena.toCharArray();
        Map<Character, Double> F = new HashMap<Character, Double>();
        for (int i = 0; i < Arraycadena.length; i++) {
            caracter = Arraycadena[i];
            F.put(caracter, 0.0);
            for (int j = i; j < Arraycadena.length; j++) {
                if (Arraycadena[j] == caracter) {
                    Double contador = F.get(caracter) + 1;
                    F.replace(caracter, contador);
                    Arraycadena[j] = ' ';
                }
            }
        }
        F.remove(' ');
        Set<Character> llaves = F.keySet();
        for (Character i : llaves) {
            Double Frecuencia = F.get(i) / Arraycadena.length;
            F.replace(i, Frecuencia);
            System.out.println("Letra " + i + " Frecuencia: " + F.get(i));
        }
        return F;
    }

    public static void main(String[] args) {
        ManejoArchivo objArchivo = new ManejoArchivo();
        String NombreArchivo = "Secuencia Genomica";
        String cadena = objArchivo.LecturaArchivo(NombreArchivo);
        Map<Character, Double> F = Frecuencia(cadena);
        HuffmanLogica f = new HuffmanLogica(F);
        System.out.println("original : " + cadena);
        String cadenaCodificada = f.Codificar(cadena);
        System.out.println("codificado : " + cadenaCodificada);
        String cadenaDecodificada = f.Decodificar(cadenaCodificada);
        System.out.println("decodificado :" + cadenaDecodificada);
        objArchivo.EscrituraArchivo(cadenaCodificada, NombreArchivo);
        objArchivo.CompararArchivos(NombreArchivo);
    }
}

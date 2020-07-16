/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vozgraficafft;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Clase para obtner los datos de entrada del archivo de audio que se quiere
 * se obtiene la informacion de la onda
 * @author Edmundo J Sanchez M
 */
public class ObtenerDatosAudio {

    private static final double WAVEFORM_HEIGHT_COEFFICIENT = 1.3; // This fits the waveform to the swing node height
    final double width = 1023;
    private float[] InformacionOnda;
    private int[] AmplitudAudio;
    
    public void ObtenerDatosdelAudio(String nombreArchivo) throws UnsupportedAudioFileException, IOException{
        File temporalDecodedFile = new File(nombreArchivo);
        AmplitudAudio = obtenerWAVAmplitudes(temporalDecodedFile);
        procesarAmplitudes(AmplitudAudio);
    }
    /**
     * Obtenemos las amplitudos de la entrada de audio
     *
     * @param archivo
     * @return
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public int[] obtenerWAVAmplitudes(File archivo) throws UnsupportedAudioFileException, IOException {
        //Obtenemos Audio input stream
        try (AudioInputStream audioentrada = AudioSystem.getAudioInputStream(archivo)) {
            AudioFormat baseFormat = audioentrada.getFormat();

            //Codificacion audio
            AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_UNSIGNED;
            float sampleRate = baseFormat.getSampleRate();
            int numerodeCanales = baseFormat.getChannels();

            AudioFormat decodificandoAudio = new AudioFormat(encoding, sampleRate, 16, numerodeCanales, numerodeCanales * 2, sampleRate, false);
            int disponible = audioentrada.available();

            //Obtenemos la Modulación por impulsos codificados o PCM del Audio 
            try (AudioInputStream pcmdecodificacionaudio = AudioSystem.getAudioInputStream(decodificandoAudio, audioentrada)) {
                final int Tamanio_buffer = 4096; 
                //Creamos un buffer
                byte[] buffer = new byte[Tamanio_buffer];

                //Obtenemos el promedio para un arreglo pequeño
                int TamanioMaximoArreglo = 100000;
                int[] AmplitudesFinales = new int[TamanioMaximoArreglo];
                int muestraxPixel = disponible / TamanioMaximoArreglo;

                //Variables para calcular AmplitudesFinales 
                int contadoractualmuestra = 0;
                int posicionceldaarreglo = 0;
                float actualvalorcelda = 0.0f;

                //Variable para el bucle
                int valorceldaarreglo = 0;
                //Leemos los datos disponibles por trozos
                while (pcmdecodificacionaudio.read(buffer, 0, Tamanio_buffer) > 0) {
                    for (int i = 0; i < buffer.length - 1; i += 2) {
                        //Calculamos el valor
                        valorceldaarreglo = (int) (((((buffer[i + 1] << 8) | buffer[i] & 0xff) << 16) / 32767) * WAVEFORM_HEIGHT_COEFFICIENT);

                        if (contadoractualmuestra != muestraxPixel) {
                            ++contadoractualmuestra;
                            actualvalorcelda += Math.abs(valorceldaarreglo);
                        } else {
                            //Evitamos ArrayIndexOutOfBoundsException
                            if (posicionceldaarreglo != TamanioMaximoArreglo) {
                                AmplitudesFinales[posicionceldaarreglo] = AmplitudesFinales[posicionceldaarreglo + 1] = (int) actualvalorcelda / muestraxPixel;
                            }

                            //Actualizamos las variables
                            contadoractualmuestra = 0;
                            actualvalorcelda = 0;
                            posicionceldaarreglo += 2;
                        }
                    }
                }

                return AmplitudesFinales;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return new int[1];
    }

    /**
     * Procesamos las amplitudes
     *
     * @param DatosPCM
     * @return Arreglo con las amplitudes a ocupar
     */
    public void procesarAmplitudes(int[] DatosPCM) {
        //Tomamos la anchura del panel en donde se muestra
        InformacionOnda = new float[(int) width];
        int muestrasxPixel = DatosPCM.length / (int)width;

        //CALCULAMOS
        float nValue;
        for (int w = 0; w < (int)width; w++) {
            int c = w * muestrasxPixel;
            nValue = 0.0f;
            for (int s = 0; s < muestrasxPixel; s++) {
                nValue += (Math.abs(DatosPCM[c + s]) / 65536.0f);
            }
            //Salcamos datos de la onda
            InformacionOnda[w] = nValue / muestrasxPixel;
        }
        String str = " ";
        for (int i = 0; i < InformacionOnda.length; i++) {
            str = str + ", " + String.valueOf(InformacionOnda[i]);
        }
        try {
            SerializacionInformacionOnda(str);
        } catch (IOException ex) {
        }
    }
    /**
     * Serializamos la informacion de la onda
     * 
     * @param str 
    */
    public void SerializacionInformacionOnda(String str) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DatosOnda.txt"));
        oos.writeObject(str);
        oos.close();
    }
}

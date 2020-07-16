/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vozgraficafft;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase para generar las graficas de los calculos obtenidos mediante el uso de
 * DFT, DIFFFT o DITFFT
 * @author Edmundo J Sanchez M
 */
public class VozGraficafft extends Application {

    Scene scene, scene1;
    final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    final double width = SCREEN_SIZE.getWidth() * 0.667;
    final double heigth = SCREEN_SIZE.getHeight() * 0.6046;

    @Override
    public void start(Stage stage) throws Exception {
        init(stage);
    }
    
    //Se crean las escenas que se ocuparan a lo largo de la interfaz
    private void init(Stage primarystage) {
        ObtenerDatosAudio objeto = new ObtenerDatosAudio();
        try {
            String NombreArchivo="Grabacion.wav";
            objeto.ObtenerDatosdelAudio("audio/"+NombreArchivo);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
        }
        primarystage.setOnCloseRequest(c -> {
            try {
                Cerrar();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        HBox root = new HBox();
        root.getChildren().add(createGrid(primarystage));
        scene = new Scene(root, 400, 400);
        primarystage.setTitle("Transformada Rapida de Fourier de un Audio");
        primarystage.setScene(scene);
        primarystage.show();
    }
    
    //Funcion para cerrar la aplicacion por completo y borrar los datos de la onda
    public void Cerrar() throws IOException {
        Files.deleteIfExists(Paths.get("DatosOnda.txt"));
        System.exit(0);
    }

    /**
     * Creacion diamica de un panel que contiene los botones con sus acciones
     * correspondiente
     *
     * @param primarystage se ocupara para poder pasar el valor a las funciones
     * que activan los botones
     * @return retorna el panel completo para colocarlo en la escena
     */
    public GridPane createGrid(Stage primarystage) {
        Button button1 = new Button("Graficar audio de entrada");
        Button button2 = new Button("Graficar salida usando DIFFFT de forma iterativa");
        Button button5 = new Button("Graficar salida usando DITFFT de forma iterativa");
        Button button3 = new Button("Graficar salida usando DFT");
        Button button4 = new Button("Graficar salida usando DIFFFT de forma recursiva");
        Button button6 = new Button("Graficar salida usando DITFFT de forma resursiva");
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(button1, 0, 0);
        gridPane.add(button3, 0, 1);
        gridPane.add(button2, 0, 2);
        gridPane.add(button4, 0, 3);
        gridPane.add(button5, 0, 4);
        gridPane.add(button6, 0, 5);
        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button4.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button5.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button6.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        gridPane.setStyle("-fx-background-color: lightBLUE;");
        button1.setOnAction(event -> {
            try {
                GraficarAudioEntrada();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button2.setOnAction(event -> {
            try {
                GraficarAudioSalidaDIFFFTIterativo();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button3.setOnAction(event -> {
            try {
                GraficarAudioSalidaDFT();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button4.setOnAction(event -> {
            try {
                GraficarAudioSalidaDIFFFTRecursivo();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button5.setOnAction(event -> {
            try {
                GraficarAudioSalidaDITFFTIterativo();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        button6.setOnAction(event -> {
            try {
                GraficarAudioSalidaDITFFTRecursivo();
            } catch (IOException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VozGraficafft.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return gridPane;
    }

    /**
     * Funcion para el arreglo del archivo creado
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public float[] ObtenerArregloFloat() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DatosOnda.txt"));
        String str = (String) ois.readObject();
        ois.close();
        if (str != null) {
            String str1[] = str.split(",");
            float arr[] = new float[str1.length - 1];
            // at i=0 it is space so start from 1
            for (int i = 1; i < str1.length; i++) {
                arr[i - 1] = Float.parseFloat(str1[i]);
            }
            return arr;
        }
        return null;
    }
    
    /**
     *Funcion para completar el arreglo
     * @param DatosOnda 
     * La utilidad de esta funcion esta explicada en el reporte de la practica
     * pero basicamente nos genera un arreglo correspondiente con la potencia
     * de dos mas cercana y mas grande al tamaño del arreglo DatosOnda
     */
    public float[] CompletarArreglo(float[] DatosOnda) {
        if((DatosOnda.length != 0) && ((DatosOnda.length & (DatosOnda.length - 1)) == 0)){//Potencia de 2
            return DatosOnda;
        }
        int n = 1;
        while (n <= DatosOnda.length) {
            n *= 2;
        }
        int DatosFaltantes = n - DatosOnda.length;
        int MitadDatosFaltantes = (int) DatosFaltantes / 2;
        float ArregloCompleto[] = new float[n];
        //Inicio Bits parte 1
        for (int i = 0; i < MitadDatosFaltantes; i++) {
            ArregloCompleto[i] = 0;
        }
        //Bits Audio
        for (int i = 0; i < DatosOnda.length; i++) {
            ArregloCompleto[i + MitadDatosFaltantes] = DatosOnda[i];
        }
        //Inicio Bits parte 2
        for (int i = 0; i < MitadDatosFaltantes; i++) {
            ArregloCompleto[i + MitadDatosFaltantes + DatosOnda.length] = 0;
        }
        return ArregloCompleto;
    }

    /**
     * Funcion para graficar el audio de entrada
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioEntrada() throws FileNotFoundException, IOException, ClassNotFoundException {
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());
        //Graficacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < DatosOnda.length; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio entrada");
        stage.show();
        //Fin graficacion
    }

    /**
     * Funcion para graficar la DFT del audio
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioSalidaDFT() throws IOException, FileNotFoundException, ClassNotFoundException{
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());
        int Tamanio = DatosOnda.length;
        TransformadaFourierDiscreta transformada = new TransformadaFourierDiscreta(Tamanio);
        Complejo DatosOndaComplejo[] = new Complejo[DatosOnda.length];
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOndaComplejo[i] = new Complejo(DatosOnda[i], 0);
        }
        Complejo[] dft = transformada.calcularTransformadaDirecta(DatosOndaComplejo);
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOnda[i] = (float) dft[i].calcularMagnitud();
        }
        //Graficacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < DatosOnda.length; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio Transformada de Fourier Discreta");
        stage.show();
        //Fin graficacion
    }

    /**
     * Funcion para graficar la DIF itarativo del audio
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioSalidaDIFFFTIterativo() throws FileNotFoundException, IOException, ClassNotFoundException {
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());
        int Tamanio = DatosOnda.length;
        TransformadaDIFFFT transformada = new TransformadaDIFFFT();
        Complejo DatosOndaComplejo[] = new Complejo[Tamanio];
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOndaComplejo[i] = new Complejo(DatosOnda[i], 0);
        }
        Tamanio = DatosOndaComplejo.length;
        Complejo[] dft = transformada.calcularTransformada(Tamanio, DatosOndaComplejo, transformada.calcularRaices(Tamanio));
        for (int i = 0; i < Tamanio; i++) {
            DatosOnda[i] = (float) dft[i].calcularMagnitud();
        }
        //Grafiacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < Tamanio; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio DIFFFT Iterativo");
        stage.show();
        //Fin graficacion
    }

    /**
     * Funcion para graficar la DIF recursivo del audio
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioSalidaDIFFFTRecursivo() throws FileNotFoundException, IOException, ClassNotFoundException {
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());
        int Tamanio = DatosOnda.length;
        TransformadaDIFFFT transformada = new TransformadaDIFFFT();
        Complejo DatosOndaComplejo[] = new Complejo[DatosOnda.length];
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOndaComplejo[i] = new Complejo(DatosOnda[i], 0);
        }
        Complejo[] dft = transformada.recursivoTransformada(Tamanio, DatosOndaComplejo);
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOnda[i] = (float) dft[i].calcularMagnitud();
        }
        //Grafiacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < DatosOnda.length; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio DIFFFT Recursivo");
        stage.show();
        //Fin graficacion
    }

    /**
     * Funcion para graficar la DIT iterativo del audio
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioSalidaDITFFTIterativo() throws FileNotFoundException, IOException, ClassNotFoundException {
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());;
        int Tamanio = DatosOnda.length;
        TransformadaDITFFT transformada = new TransformadaDITFFT();
        Complejo DatosOndaComplejo[] = new Complejo[DatosOnda.length];
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOndaComplejo[i] = new Complejo(DatosOnda[i], 0);
        }
        Complejo[] dft = transformada.calcularTransformada(Tamanio, DatosOndaComplejo, transformada.calcularRaices(Tamanio));
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOnda[i] = (float) dft[i].calcularMagnitud();
        }
        //Grafiacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < DatosOnda.length; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio DITFFT Iterativo");
        stage.show();
        //Fin graficacion
    }

    /**
     * Funcion para graficar la DIT recursivo del audio
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    public void GraficarAudioSalidaDITFFTRecursivo() throws FileNotFoundException, IOException, ClassNotFoundException {
        float[] DatosOnda = CompletarArreglo(ObtenerArregloFloat());
        int Tamanio = DatosOnda.length;
        TransformadaDITFFT transformada = new TransformadaDITFFT();
        Complejo DatosOndaComplejo[] = new Complejo[DatosOnda.length];
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOndaComplejo[i] = new Complejo(DatosOnda[i], 0);
        }
        Complejo[] dft = transformada.recursivoTransformada(Tamanio, DatosOndaComplejo);
        for (int i = 0; i < DatosOnda.length; i++) {
            DatosOnda[i] = (float) dft[i].calcularMagnitud();
        }
        //Grafiacion
        Stage stage = new Stage();
        Pane root = new Pane();
        Canvas canvas = new Canvas(width, heigth);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.web("#252525"));
        gc.fillRect(0, 0, width, heigth);
        gc.setStroke(Color.ORANGE);
        for (int i = 0; i < DatosOnda.length; i++) {
            int value = (int) (DatosOnda[i] * canvas.getHeight());
            int y1 = ((int) canvas.getHeight() - 2 * value) / 2;
            int y2 = y1 + 2 * value;
            gc.strokeLine(i, y1, i, y2);
        }
        root.getChildren().add(canvas);
        Group group = new Group(canvas);
        Scene scene = new Scene(group, width, heigth);
        stage.setScene(scene);
        stage.setTitle("Grafica audio DITFFT Recursivo");
        stage.show();
        //Fin 
    }

    public static void main(String[] args) {
        launch(args);
    }

}

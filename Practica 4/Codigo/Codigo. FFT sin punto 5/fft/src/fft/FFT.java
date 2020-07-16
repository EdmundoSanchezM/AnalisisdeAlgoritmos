/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

import java.awt.event.ActionEvent;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Uso de JavaFX para generar graficas de DITFFT/DIFFT/DFT
 * para esta parte se ocuoan los calculos iterativos de DIT Y DIF FFT
 * @author Edmundo J Sanchez M
 */
public class FFT extends Application {

    Scene scene, scene1;

    @Override
    public void start(Stage stage) throws Exception {
        init(stage);
    }
    //Se crean las escenas que se ocuparan a lo largo de la interfaz
    private void init(Stage primarystage) {
        HBox root = new HBox();
        HBox root1 = new HBox();
        root.getChildren().add(createGrid(primarystage));
        scene = new Scene(root, 900, 400);
        scene1 = new Scene(root1, 900, 400);
        primarystage.setTitle("Transformada Rapida de Fourier");
        primarystage.setScene(scene);
        primarystage.show();

    }
    
    /**
     * Creacion diamica de un panel que contiene los botones con sus acciones
     * correspondiente
     * @param primarystage se ocupara para poder pasar el valor a las funciones
     * que activan los botones
     * @return retorna el panel completo para colocarlo en la escena
     */
    public GridPane createGrid(Stage primarystage) {
        Button button1 = new Button("Graficar funciones de entrada de DFT");
        Button button2 = new Button("Graficar funciones de entrada de DIFFFT");
        Button button5 = new Button("Graficar funciones de entrada de DITFFT");
        Button button3 = new Button("Graficar salida usando DFT");
        Button button4 = new Button("Graficar salida usando DIFFFT");
        Button button6 = new Button("Graficar salida usando DITFFT");
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
            DFTInicioGraficas(primarystage);
        });
        button2.setOnAction(event -> {
            DIFFFTInicioGraficas(primarystage);
        });
        button3.setOnAction(event -> {
            DFTSalidaGraficas(primarystage);
        });
        button4.setOnAction(event -> {
            DIFFFTSalidaGraficas(primarystage);
        });
        button5.setOnAction(event -> {
            DITFFTInicioGraficas(primarystage);
        });
        button6.setOnAction(event -> {
            DITFFTSalidaGraficas(primarystage);
        });
        return gridPane;
    }
    
    /**
     * Creacion de las graficas de entrada de DFT
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DFTInicioGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DFT para grafica inicial
        CalculadoraDFT DFTDatos = new CalculadoraDFT();
        int Tamanio = DFTDatos.N;
        Complejo[] w = DFTDatos.Cuadrado;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de entrada de DFT");
        //Pulso
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i + 1 != Tamanio) {
                if (w[i].getReal() == 1 && w[i + 1].getReal() == 0) {
                    data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
                }
            }
        }
        linechart.getData().add(data);
        //Senoidal
        w = DFTDatos.Senoidal;
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DFTDatos.Delta;
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i == 0) {
                data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
            }
        }
        linechart.getData().add(data3);
        //Rampa
        w = DFTDatos.Rampa;
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }

    /**
     * Creacion de las graficas de salida de DFT para ello se obtiene el arreglo
     * de complejos inicial y luego se hace la transforamda
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DFTSalidaGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DFT para grafica de salida
        CalculadoraDFT DFTDatos = new CalculadoraDFT();
        int Tamanio = DFTDatos.N;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de salida DFT");
        //Pulso
        Complejo[] w = DFTDatos.Cuadrado;
        TransformadaFourierDiscreta transformada = new TransformadaFourierDiscreta(Tamanio);
        w = transformada.calcularTransformadaDirecta(w);
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data);
        //Senoidal
        w = DFTDatos.Senoidal;
        w = transformada.calcularTransformadaDirecta(w);
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DFTDatos.Delta;
        w = transformada.calcularTransformadaDirecta(w);
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data3);
        //Rampa
        w = DFTDatos.Rampa;
        w = transformada.calcularTransformadaDirecta(w);
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }

    /**
     * Creacion de las graficas de entrada de DIF
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DIFFFTInicioGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DIFFFT para grafica inicial
        CalculadoraDIFFFT DIFFFTDatos = new CalculadoraDIFFFT();
        int Tamanio = DIFFFTDatos.N;
        Complejo[] w = DIFFFTDatos.Cuadrado;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de entrada de DIFFFT");
        //Pulso
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i + 1 != Tamanio) {
                if (w[i].getReal() == 1 && w[i + 1].getReal() == 0) {
                    data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
                }
            }
        }
        linechart.getData().add(data);
        //Senoidal
        w = DIFFFTDatos.Senoidal;
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DIFFFTDatos.Delta;
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i == 0) {
                data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
            }
        }
        linechart.getData().add(data3);
        //Rampa
        w = DIFFFTDatos.Rampa;
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }

    
    /**
     * Creacion de las graficas de salida de DIF para ello se obtiene el arreglo
     * de complejos inicial y luego se hace la transforamda
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DIFFFTSalidaGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DIFFFT para grafica de salida
        CalculadoraDIFFFT DIFFFTDatos = new CalculadoraDIFFFT();
        int Tamanio = DIFFFTDatos.N;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de salida de DIFFFT");
        //Pulso
        Complejo[] w = DIFFFTDatos.Cuadrado;
        TransformadaDIFFFT transformada = new TransformadaDIFFFT();
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data);
        //Senoidal
        w = DIFFFTDatos.Senoidal;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DIFFFTDatos.Delta;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data3);
        //Rampa
        w = DIFFFTDatos.Rampa;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }
    
    /**
     * Creacion de las graficas de entrada de DIT
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DITFFTInicioGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DIFFFT para grafica inicial
        CalculadoraDITFFT DIFFFTDatos = new CalculadoraDITFFT();
        int Tamanio = DIFFFTDatos.N;
        Complejo[] w = DIFFFTDatos.Cuadrado;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de entrada de DITFFT");
        //Pulso
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i + 1 != Tamanio) {
                if (w[i].getReal() == 1 && w[i + 1].getReal() == 0) {
                    data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
                }
            }
        }
        linechart.getData().add(data);
        //Senoidal
        w = DIFFFTDatos.Senoidal;
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DIFFFTDatos.Delta;
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
            if (i == 0) {
                data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i + 1].getReal()));
            }
        }
        linechart.getData().add(data3);
        //Rampa
        w = DIFFFTDatos.Rampa;
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].getReal()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }

    /**
     * Creacion de las graficas de salida de DIT para ello se obtiene el arreglo
     * de complejos inicial y luego se hace la transforamda
     * @param primarystage se ocupara para poder actualizar la escena con los
     * nuevos datos
     */
    public void DITFFTSalidaGraficas(Stage primarystage) {
        HBox root1 = new HBox();
        //Creaccion de objeto DIFFFT para grafica de salida
        CalculadoraDITFFT DITFFTDatos = new CalculadoraDITFFT();
        int Tamanio = DITFFTDatos.N;
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Graficas de funciones de salida de DITFFT");
        //Pulso
        TransformadaDITFFT transformada = new TransformadaDITFFT();
        Complejo[] w = DITFFTDatos.Cuadrado;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.setName("Funcion pulso cuadrado");
        for (int i = 0; i < Tamanio; i++) {
            data.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data);
        //Senoidal
        w = DITFFTDatos.Senoidal;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data2 = new XYChart.Series<>();
        data2.setName("Funcion senoidal");
        for (int i = 0; i < Tamanio; i++) {
            data2.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data2);
        //Delta
        w = DITFFTDatos.Delta;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data3 = new XYChart.Series<>();
        data3.setName("Funcion delta de Dirac");
        for (int i = 0; i < Tamanio; i++) {
            data3.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data3);
        //Rampa
        w = DITFFTDatos.Rampa;
        w = transformada.calcularTransformada(Tamanio, w, transformada.calcularRaices(Tamanio));
        XYChart.Series<String, Number> data4 = new XYChart.Series<>();
        data4.setName("Funcion rampa");
        for (int i = 0; i < Tamanio; i++) {
            data4.getData().add(new XYChart.Data<String, Number>(Integer.toString(i), w[i].calcularMagnitud()));
        }
        linechart.getData().add(data4);
        root1.getChildren().addAll(createGrid(primarystage), linechart);
        scene = new Scene(root1, 900, 400);
        primarystage.setScene(scene);
    }    
    
    public static void main(String[] args) {
        launch(args);
    }

}

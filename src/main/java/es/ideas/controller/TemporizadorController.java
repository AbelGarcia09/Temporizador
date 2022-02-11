/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas.controller;

import es.ideas.model.Tiempo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Abel
 */
public class TemporizadorController implements Initializable {

    @FXML
    private Label horas;
    @FXML
    private Label minutos;
    @FXML
    private Label segundos;
    @FXML
    private Button idPlay;
    @FXML
    private Button idPause;
    @FXML
    private Button idReset;
    @FXML
    private Button idPaper;
    @FXML
    private Button idSubeHora;
    @FXML
    private Button idSubeMin;
    @FXML
    private Button idSubeSec;
    @FXML
    private Button idBajaHora;
    @FXML
    private Button idBajaMin;
    @FXML
    private Button idBajaSec;
    private Tiempo ultimo_tiempo;
    private Timeline timeline;
    private int hora, minuto, segundo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent evento) -> {
            comprobarTimer();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        ultimo_tiempo = new Tiempo();

        muestraTiempo();
        compruebaCero();
        System.out.println(Integer.parseInt(segundos.getText()));
    }

    @FXML
    private void play(ActionEvent event) {
        timeline.play();
        ultimo_tiempo.setTiempo(
                segundos.getText(),
                minutos.getText(),
                horas.getText());

        botonesStatus(true);
    }

    @FXML
    private void pause(ActionEvent event) {
        timeline.pause();

        botonesStatus(false);
    }

    @FXML
    private void reset(ActionEvent event) {
        segundos.setText(ultimo_tiempo.getSegundos());
        minutos.setText(ultimo_tiempo.getMinutos());
        horas.setText(ultimo_tiempo.getHoras());
    }

    @FXML
    private void borrar(ActionEvent event) {
        segundos.setText("00");
        minutos.setText("00");
        horas.setText("00");

        compruebaCero();
    }

    @FXML
    private void subeSec(ActionEvent event) {

        manipulaTiempo(segundos, "SUMA");

    }

    @FXML
    private void bajaSec(ActionEvent event) {
        manipulaTiempo(segundos, "RESTA");
    }

    @FXML
    private void subeHora(ActionEvent event) {
        manipulaTiempo(horas, "SUMA");
    }

    @FXML
    private void subeMin(ActionEvent event) {
        manipulaTiempo(minutos, "SUMA");
    }

    @FXML
    private void bajaHora(ActionEvent event) {
        manipulaTiempo(horas, "RESTA");
    }

    @FXML
    private void bajaMin(ActionEvent event) {
        manipulaTiempo(minutos, "RESTA");
    }

    private void comprobarTimer() {
        hora = Integer.parseInt(horas.getText());
        minuto = Integer.parseInt(minutos.getText());
        segundo = Integer.parseInt(segundos.getText());

        if (segundo > 0) {
            segundo--;
        } else {
            segundo = 59;
            if (minuto > 0) {
                minuto--;
            } else {
                minuto = 59;
                if (hora > 0) {
                    hora--;
                }
            }
        }

        muestraTiempo();

        if (hora == 0 && minuto == 0 && segundo == 0) {
            timeline.stop();
        }
    }

    private void compruebaCero() {
        if (horas.getText().equals("00") && minutos.getText().equals("00") && segundos.getText().equals("00")) {
            idPlay.setDisable(true);
            idPause.setDisable(true);
            idReset.setDisable(true);
            idPaper.setDisable(true);
        } else {
            idPlay.setDisable(false);
        }
    }

    private void botonesStatus(boolean estado) {
        idPlay.setDisable(estado);
        idPause.setDisable(!estado);
        idReset.setDisable(estado);
        idPaper.setDisable(estado);
        idSubeHora.setDisable(estado);
        idSubeMin.setDisable(estado);
        idSubeSec.setDisable(estado);
        idBajaHora.setDisable(estado);
        idBajaMin.setDisable(estado);
        idBajaSec.setDisable(estado);
    }

    private void muestraTiempo() {
        if (hora < 10) {
            horas.setText("0" + hora);
        } else {
            horas.setText("" + hora);
        }

        if (minuto < 10) {
            minutos.setText("0" + minuto);
        } else {
            minutos.setText("" + minuto);
        }

        if (segundo < 10) {
            segundos.setText("0" + segundo);
        } else {
            segundos.setText("" + segundo);
        }
    }

    private void manipulaTiempo(Label tipo, String accion) {
        int total = Integer.parseInt(tipo.getText());

        if (accion.equals("SUMA")) {
            if (total < 59) {
                if (total < 9) {
                    tipo.setText("0" + (total + 1));
                } else {
                    tipo.setText("" + (total + 1));
                }
            }
        } 

        if (accion.equals("RESTA")){
           if (total < 59) {
                if (total < 9 && total > 1) {
                    tipo.setText("0" + (total - 1));
                } else {
                    tipo.setText("" + (total - 1));
                }
            } 
        }
        
        compruebaCero();
    }

}

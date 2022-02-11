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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent evento) -> {
            comprobarTimer();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        
        ultimo_tiempo = new Tiempo();
    }

    @FXML
    private void play(ActionEvent event) {
        timeline.play();
        ultimo_tiempo.setTiempo(
                segundos.getText(), 
                minutos.getText(), 
                horas.getText());
    }

    @FXML
    private void pause(ActionEvent event) {
        timeline.pause();
    }

    @FXML
    private void reset(ActionEvent event) {
        segundos.setText(ultimo_tiempo.getSegundos());
        minutos.setText(ultimo_tiempo.getMinutos());
        horas.setText(ultimo_tiempo.getHoras());
    }

    @FXML
    private void borrar(ActionEvent event) {
        segundos.setText("0");
        minutos.setText("0");
        horas.setText("0");
    }

    @FXML
    private void subeSec(ActionEvent event) {
        int total = Integer.parseInt(segundos.getText());
        if (total < 59) {
            segundos.setText("" + (total + 1));
        }
    }

    @FXML
    private void bajaSec(ActionEvent event) {
        int total = Integer.parseInt(segundos.getText());
        if (total > 0) {
            segundos.setText("" + (total - 1));
        }
    }

    @FXML
    private void subeHora(ActionEvent event) {
        int total = Integer.parseInt(horas.getText());
        if (total < 59) {
            horas.setText("" + (total + 1));
        }
    }

    @FXML
    private void subeMin(ActionEvent event) {
        int total = Integer.parseInt(minutos.getText());
        if (total < 59) {
            minutos.setText("" + (total + 1));
        }
    }

    @FXML
    private void bajaHora(ActionEvent event) {
        int total = Integer.parseInt(horas.getText());
        if (total > 0) {
            horas.setText("" + (total - 1));
        }
    }

    @FXML
    private void bajaMin(ActionEvent event) {
        int total = Integer.parseInt(minutos.getText());
        if (total > 0) {
            minutos.setText("" + (total - 1));
        }
    }

    private void comprobarTimer() {
        int segundo = Integer.parseInt(segundos.getText());
        int minuto = Integer.parseInt(minutos.getText());
        int hora = Integer.parseInt(horas.getText());

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

        segundos.setText(segundo + "");
        minutos.setText(minuto + "");
        horas.setText(hora + "");

        if (segundo == 0 && minuto == 0 && hora == 0) {
            timeline.stop();
        }
    }

}

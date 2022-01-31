/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private int contador = 0;
    private String ultimo_tiempo;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            contador++;
            int sec = Integer.parseInt(segundos.getText());
            int min = Integer.parseInt(minutos.getText());
            int hora = Integer.parseInt(minutos.getText());

            if (contador == 60) {
                sec = sec - 1;
                segundos.setText("" + sec);
                System.out.println(sec);
                contador = 0;
            }

            if (sec == 0) {

                if (!minutos.getText().equals("0")) {
                    segundos.setText("59");
                    minutos.setText("" + (min - 1));
                } 

            }

        }

    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void play(ActionEvent event) {
        timer.start();
        ultimo_tiempo = segundos.getText();
    }

    @FXML
    private void pause(ActionEvent event) {
        timer.stop();
    }

    @FXML
    private void reset(ActionEvent event) {
        if (ultimo_tiempo != null) {
            segundos.setText(ultimo_tiempo);
        }
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

}

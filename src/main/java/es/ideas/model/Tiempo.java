/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abel
 */
public class Tiempo {
    String segundos, minutos, horas, recordatorio;
    private ObservableList<Tiempo> listaTiempo = FXCollections.observableArrayList();
    
    public Tiempo() {
        segundos = "00";
        minutos = "00";
        horas = "00";
        recordatorio = "";
    }

    public Tiempo(String segundos, String minutos, String horas, String recordatorio) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
        this.recordatorio = recordatorio;
    }

    public void setTiempo(String segundos, String minutos, String horas, String recordatorio) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
        this.recordatorio = recordatorio;
    }
    
    public String getSegundos() {
        return segundos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }

    @Override
    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
    }
    
    public ObservableList<Tiempo> getTiempos() {
        return listaTiempo;
    }
}

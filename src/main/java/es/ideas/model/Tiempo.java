/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas.model;

/**
 *
 * @author Abel
 */
public class Tiempo {
    String segundos, minutos, horas;
    
    public Tiempo() {
        this.segundos = "0";
        this.minutos = "0";
        this.horas = "0";
    }

    public Tiempo(String segundos, String minutos, String horas) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public void setTiempo(String segundos, String minutos, String horas) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
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
    
    
}

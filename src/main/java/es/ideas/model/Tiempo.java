package es.ideas.model;
/**
 *
 * @author Abel
 */
public class Tiempo {
    /*En la clase tiempo tenemos segundos, minutos, horas, el recordatorio, la 
    posición asignada, y la lista de tiempos*/
    String segundos, minutos, horas, recordatorio;
    String[] primer_tiempo = new String[3];
    int posicion;
    static int posicion_siguiente = 0;
    
    public Tiempo() {
        segundos = "00";
        minutos = "00";
        horas = "00";
        recordatorio = "";
    }

    public Tiempo(String segundos, String minutos, String horas,
            String recordatorio) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
        this.recordatorio = recordatorio;
        //En el array guardamos el primer tiempo.
        primer_tiempo[0] = segundos;
        primer_tiempo[1] = minutos;
        primer_tiempo[2] = horas;
        /*La variable estática posicion_siguiente suma 1 posición por cada 
        instancia creada. La variable posicion es la que realmente le asignamos
        a cada instancia.*/
        posicion = posicion_siguiente;
        posicion_siguiente++;
    }

    public void setTiempo(String segundos, String minutos, String horas,
            String recordatorio) {
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String[] getPrimer_tiempo() {
        return primer_tiempo;
    }

    public void setPrimer_tiempo(String[] ultimo_tiempo) {
        this.primer_tiempo = ultimo_tiempo;
    }

    public static int getPosicion_siguiente() {
        return posicion_siguiente;
    }

    public static void setPosicion_siguiente(int posicion_siguiente) {
        Tiempo.posicion_siguiente = posicion_siguiente;
    }

    //Los items de la lista se guardan en el siguiente formato.
    @Override
    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
    }
   
}

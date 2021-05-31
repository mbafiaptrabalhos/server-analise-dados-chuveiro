package br.com.fiap.autochuveiro.business;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calculo {

    private final Long potencia = 5500L;
    private final Double TARIFA = 0.500710;
    private int ms;
    private Double segundos;
    private Double minutos;
    private Double horas;

    public Calculo(String milisegundos) {
        this.ms = Integer.parseInt(milisegundos);
        this.segundos = Double.parseDouble(milisegundos) / 1000;
        this.minutos = segundos / 60;
        this.horas = minutos / 60;
    }

    // formula: Pot*horas
    // Pot = Potencia chuveiro
    private Double getEnergia() {
        Double pot = (double) (potencia / 1000); // conversão de W para kW

        return pot * horas;
    }

    // formula: tarifa * EnergiaConsumida
    public Double getCusto() {

        if (horas != 0.0) {
            Double custo = TARIFA * getEnergia();
            return custo;
        }
        return null;
    }

    public String msToHourSecond() {
        int segundos = ( ms / 1000 ) % 60;
        int minutos  = ( ms / 60000 ) % 60;
        int horas    = ms / 3600000;

        return String.format( "%02d:%02d:%02d", horas, minutos, segundos );
    }
}

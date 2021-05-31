package br.com.fiap.autochuveiro.business;

import br.com.fiap.autochuveiro.model.Consumo;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalculoChuveiro {

    private String tempo;

    public CalculoChuveiro(String tempo) {
        this.tempo = tempo;
    }

    public Consumo consumoCalculado() {

        Calculo valorConsumo = new Calculo(this.tempo);

        Consumo consumo = new Consumo();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String result = now.format(formatador);
        
        consumo.setData(result);
        consumo.setTempo(valorConsumo.msToHourSecond());

        DecimalFormat df = new DecimalFormat("0.##");
        String valor = df.format(valorConsumo.getCusto());
        consumo.setValor(valor);

        if (valor.compareTo("20.00") <= 0) {
            consumo.setConsumo("Baixo");
        } else {
            if (valor.compareTo("20.00") > 0 && valor.compareTo("50.00") < 0) {
                consumo.setConsumo("Médio");
            } else {
                consumo.setConsumo("Alto");
            }
        }

        System.out.println("tempo: " + valorConsumo.msToHourSecond() + " valor: " + valorConsumo.getCusto());
        return consumo;
    }
}

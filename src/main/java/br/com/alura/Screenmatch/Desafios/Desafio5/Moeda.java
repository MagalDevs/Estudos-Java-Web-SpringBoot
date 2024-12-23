package br.com.alura.Screenmatch.Desafios.Desafio5;

import java.text.DecimalFormat;

public enum Moeda {
    DOLAR(6.09),
    EURO(6.38),
    REAL(1.0);

    private double taxa;

    Moeda(double v) {
        this.taxa = v;
    }

    public double converterPara(double valorEmReais) {
        return valorEmReais/taxa;
    }

    public static void main(String[] args) {
        DecimalFormat deci = new DecimalFormat("0.00");
        System.out.println(deci.format(Moeda.DOLAR.converterPara(100))); // 16.43 (aproximado)
        System.out.println(deci.format(Moeda.EURO.converterPara(100)) ); // 15.66 (aproximado)
    }
}

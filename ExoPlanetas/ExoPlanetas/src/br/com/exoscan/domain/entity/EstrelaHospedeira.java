package br.com.exoscan.domain.entity;

import java.io.Serializable;

public class EstrelaHospedeira implements Serializable {

    private static final long serialVersionUID = 1L;
    private double massa;
    private double raio;
    private double temperatura;

    public EstrelaHospedeira(double massa, double raio, double temperatura) {

        this.massa = massa;
        this.raio = raio;
        this.temperatura = temperatura;
    }

    public double getMassa() {
        return massa;
    }

    public double getRaio() {
        return raio;
    }

    public double getTemperatura() {
        return temperatura;
    }
}
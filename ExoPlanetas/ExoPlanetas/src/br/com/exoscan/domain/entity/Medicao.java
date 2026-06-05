package br.com.exoscan.domain.entity;

import java.time.LocalDate;

public class Medicao {

    private LocalDate data;
    private String telescopio;
    private String metodoDeteccao;

    public Medicao(LocalDate data, String telescopio, String metodoDeteccao) {
        this.data = data;
        this.telescopio = telescopio;
        this.metodoDeteccao = metodoDeteccao;
    }
}
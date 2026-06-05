package br.com.exoscan.domain.entity;

import java.io.Serializable;

public class Exoplaneta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String tipo;
    private String status;
    private int anoDescoberta;
    private double massa;
    private double raio;
    private double periodoOrbital;
    private double semiEixoMaior;
    private double excentricidade;
    private double inclinacao;
    private double fluxoEstelar;
    private EstrelaHospedeira estrela;

    public Exoplaneta(
            Long id,
            String nome,
            String tipo,
            String status,
            int anoDescoberta,
            double massa,
            double raio,
            double periodoOrbital,
            double semiEixoMaior,
            double excentricidade,
            double inclinacao,
            double fluxoEstelar,
            EstrelaHospedeira estrela) {

        if (massa < 0)
            throw new IllegalArgumentException("Massa inválida");

        if (raio < 0)
            throw new IllegalArgumentException("Raio inválido");

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
        this.anoDescoberta = anoDescoberta;
        this.massa = massa;
        this.raio = raio;
        this.periodoOrbital = periodoOrbital;
        this.semiEixoMaior = semiEixoMaior;
        this.excentricidade = excentricidade;
        this.inclinacao = inclinacao;
        this.fluxoEstelar = fluxoEstelar;
        this.estrela = estrela;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getRaio() {
        return raio;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public double getSemiEixoMaior() {
        return semiEixoMaior;
    }

    public EstrelaHospedeira getEstrela() {
        return estrela;
    }

    public double getMassa() {
        return massa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }

    public int getAnoDescoberta() {
        return anoDescoberta;
    }

    public double getExcentricidade() {
        return excentricidade;
    }

    public double getInclinacao() {
        return inclinacao;
    }

    public double getFluxoEstelar() {
        return fluxoEstelar;
    }
}


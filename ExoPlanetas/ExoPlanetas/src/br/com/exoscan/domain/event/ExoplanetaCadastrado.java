package br.com.exoscan.domain.event;

import java.time.LocalDateTime;

public class ExoplanetaCadastrado {

    private final Long id;
    private final LocalDateTime dataHora;
    private final String nome;

    public ExoplanetaCadastrado(Long id, String nome, LocalDateTime dataHora) {
        this.id = id;
        this.nome = nome;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Exoplaneta cadastrado. Nome: " + nome;
    }
}
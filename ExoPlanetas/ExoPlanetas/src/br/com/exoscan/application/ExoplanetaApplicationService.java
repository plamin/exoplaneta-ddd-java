package br.com.exoscan.application;

import br.com.exoscan.domain.entity.Exoplaneta;
import br.com.exoscan.domain.event.ExoplanetaCadastrado;
import br.com.exoscan.domain.event.HabitabilidadeCalculada;
import br.com.exoscan.domain.repository.ExoplanetaInterface;
import br.com.exoscan.domain.service.HabitabilidadeScore;
import br.com.exoscan.domain.valueobject.IndiceHabitabilidade;
import br.com.exoscan.infrastructure.event.EventPublisher;

import java.time.LocalDateTime;

public class ExoplanetaApplicationService {

    private final ExoplanetaInterface repository;
    private final HabitabilidadeScore service;
    private final EventPublisher publisher;

    public ExoplanetaApplicationService(
            ExoplanetaInterface repository,
            HabitabilidadeScore service,
            EventPublisher publisher
    ) {

        this.repository = repository;
        this.service = service;
        this.publisher = publisher;
    }

    public void cadastrar(Exoplaneta planeta) {
        repository.salvar(planeta);
        publisher.publicar(new ExoplanetaCadastrado(planeta.getId(),planeta.getNome(),LocalDateTime.now()));
    }

    public IndiceHabitabilidade analisar(Long id) {
        Exoplaneta planeta = repository.buscarPorId(id).orElseThrow();
        IndiceHabitabilidade indice = service.calcular(planeta);
        publisher.publicar(new HabitabilidadeCalculada(id,indice.getValor()));
        return indice;
    }
}
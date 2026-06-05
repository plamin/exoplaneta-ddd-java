
package br.com.exoscan.infrastructure.repository;

import br.com.exoscan.domain.entity.Exoplaneta;
import br.com.exoscan.domain.repository.ExoplanetaInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExoplanetasCatalogo
        implements ExoplanetaInterface {
    private final List<Exoplaneta> planetas = new ArrayList<>();

    @Override
    public void salvar(Exoplaneta planeta) {
        planetas.add(planeta);
    }

    @Override
    public Optional<Exoplaneta> buscarPorId(Long id) {
        return planetas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Exoplaneta> buscarPorNome(String nome) {
        return planetas.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    @Override
    public List<Exoplaneta> listarTodos() {
        return planetas;
    }
}
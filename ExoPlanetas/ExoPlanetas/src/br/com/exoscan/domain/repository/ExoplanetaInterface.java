package br.com.exoscan.domain.repository;

import br.com.exoscan.domain.entity.Exoplaneta;

import java.util.List;
import java.util.Optional;

public interface ExoplanetaInterface {
    void salvar(Exoplaneta planeta);
    Optional<Exoplaneta> buscarPorId(Long id);
    Optional<Exoplaneta> buscarPorNome(String nome);
    List<Exoplaneta> listarTodos();
}
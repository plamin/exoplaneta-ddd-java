package br.com.exoscan.domain.service;

import br.com.exoscan.domain.entity.Exoplaneta;
import br.com.exoscan.domain.valueobject.IndiceHabitabilidade;

public class HabitabilidadeScore {
    public IndiceHabitabilidade calcular(Exoplaneta planeta) {
        double score = 0;
        if (planeta.getRaio() <= 1.8)
            score += 0.30;

        if (planeta.getPeriodoOrbital() >= 200 &&
                planeta.getPeriodoOrbital() <= 400)
            score += 0.30;

        if (planeta.getSemiEixoMaior() >= 0.9 &&
                planeta.getSemiEixoMaior() <= 1.5)
            score += 0.20;

        if (planeta.getEstrela().getTemperatura() >= 5000 &&
                planeta.getEstrela().getTemperatura() <= 6500)
            score += 0.20;

        return new IndiceHabitabilidade(score);
    }
}
package br.com.exoscan.domain.valueobject;

public class IndiceHabitabilidade {
    private final double valor;
    public IndiceHabitabilidade(double valor) {

        if (valor < 0 || valor > 1)
            throw new IllegalArgumentException();
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public boolean ehHabitavel() {
        return valor >= 0.75;
    }
}
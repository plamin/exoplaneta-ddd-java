package br.com.exoscan.domain.valueobject;

public class TemperaturaEquilibrio {
    private final double valor;
    public TemperaturaEquilibrio(double valor) {

        if (valor <= 0)
            throw new IllegalArgumentException();

        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
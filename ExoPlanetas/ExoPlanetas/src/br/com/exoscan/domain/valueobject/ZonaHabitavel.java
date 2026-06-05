package br.com.exoscan.domain.valueobject;

public class ZonaHabitavel {
    private final double limiteInterno;
    private final double limiteExterno;

    public ZonaHabitavel(double limiteInterno, double limiteExterno) {
        this.limiteInterno = limiteInterno;
        this.limiteExterno = limiteExterno;
    }

    public boolean contem(double distancia) {

        return distancia >= limiteInterno
                && distancia <= limiteExterno;
    }
}
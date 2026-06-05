package br.com.exoscan.infrastructure.event;

public class EventPublisher {
    public void publicar(Object evento) {
        System.out.println(evento);
    }
}
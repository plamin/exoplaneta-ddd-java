package br.com.exoscan.infrastructure.permanenciaplanetas;

import br.com.exoscan.domain.entity.Exoplaneta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PermanenciaPlanetasCadastrados {
    private static final String ARQUIVO = "planetas.dat";
    public void salvar(List<Exoplaneta> planetas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            out.writeObject(planetas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Exoplaneta> carregar() {
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (List<Exoplaneta>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
package br.com.exoscan.infrastructure.csv;

import br.com.exoscan.domain.entity.EstrelaHospedeira;
import br.com.exoscan.domain.entity.Exoplaneta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorCsv {

    public List<Exoplaneta> carregar(String caminhoArquivo) {

        List<Exoplaneta> planetas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;
            br.readLine();

            long id = 1;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",", -1);
                try {
                    if (dados[21].isBlank() || dados[26].isBlank()) {
                        continue;
                    }

                    EstrelaHospedeira estrela =
                            new EstrelaHospedeira(parseDouble(dados[56]), parseDouble(dados[61]), parseDouble(dados[51]));

                    Exoplaneta planeta =
                            new Exoplaneta(
                                    id++,

                                    // nome
                                    dados[1] + " " + dados[2],

                                    // tipo
                                    dados[3],

                                    // status
                                    "Confirmado",

                                    // ano descoberta
                                    0,

                                    // massa
                                    parseDouble(dados[21]),

                                    // raio
                                    parseDouble(dados[26]),

                                    // período orbital
                                    parseDouble(dados[5]),

                                    // semi eixo maior
                                    parseDouble(dados[9]),

                                    // excentricidade
                                    parseDouble(dados[13]),

                                    // inclinação
                                    parseDouble(dados[17]),

                                    // fluxo estelar
                                    0.0,

                                    estrela
                            );
                    planetas.add(planeta);
                } catch (Exception ignored) {
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return planetas;
    }

    private double parseDouble(String valor) {

        if (valor == null || valor.isBlank()) {
            return 0.0;
        }

        return Double.parseDouble(valor);
    }
}
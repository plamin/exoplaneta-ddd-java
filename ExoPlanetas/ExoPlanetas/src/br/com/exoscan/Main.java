package br.com.exoscan;

import br.com.exoscan.application.ExoplanetaApplicationService;
import br.com.exoscan.domain.entity.EstrelaHospedeira;
import br.com.exoscan.domain.entity.Exoplaneta;
import br.com.exoscan.domain.service.HabitabilidadeScore;
import br.com.exoscan.infrastructure.csv.LeitorCsv;
import br.com.exoscan.infrastructure.event.EventPublisher;
import br.com.exoscan.infrastructure.permanenciaplanetas.PermanenciaPlanetasCadastrados;
import br.com.exoscan.infrastructure.repository.ExoplanetasCatalogo;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExoplanetasCatalogo repository = new ExoplanetasCatalogo();

        HabitabilidadeScore service = new HabitabilidadeScore();

        EventPublisher publisher = new EventPublisher();

        ExoplanetaApplicationService app =
                new ExoplanetaApplicationService(
                        repository,
                        service,
                        publisher
                );


        LeitorCsv leitor = new LeitorCsv();

        List<Exoplaneta> planetasNasa =
                leitor.carregar("ExoPlanetas/src/dados/planets.csv");

        for (Exoplaneta planeta : planetasNasa) {
            app.cadastrar(planeta);
        }


        PermanenciaPlanetasCadastrados persistencia = new PermanenciaPlanetasCadastrados();

        List<Exoplaneta> planetasSalvos = persistencia.carregar();

        for (Exoplaneta planeta : planetasSalvos) {
            app.cadastrar(planeta);
        }

        System.out.println("\nEXOSCAN");
        System.out.println("\nPlanetas carregados: " + repository.listarTodos().size());

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("");
            System.out.println("1 - Buscar planeta");
            System.out.println("2 - Cadastrar planeta");
            System.out.println("0 - Sair");

            String opcao = scanner.nextLine();

            switch (opcao) {

                case "1":
                    System.out.println("\nDigite o nome do planeta:");
                    String nomeBusca = scanner.nextLine();

                    var planetaOptional = repository.buscarPorNome(nomeBusca);

                    if (planetaOptional.isPresent()) {

                        Exoplaneta planeta = planetaOptional.get();

                        var resultado = app.analisar(planeta.getId());

                        System.out.println("\nID: " + planeta.getId());
                        System.out.println("Nome: " + planeta.getNome());
                        // MEDIDAS QUE USAM NOMRALMENTE PRA MEDIR OS EXOPLANETAS
                        System.out.println("\nPlaneta");
                        System.out.println("Método de descoberta: " + planeta.getTipo());
                        System.out.println("Massa: " + planeta.getMassa() + " Massas de Júpiter");
                        System.out.println("Raio: " + planeta.getRaio() + " Raios de Júpiter");
                        System.out.println("Período orbital: " + (int) planeta.getPeriodoOrbital() + " dias");
                        System.out.println("Semi-eixo maior: " + planeta.getSemiEixoMaior());
                        System.out.println("Excentricidade: " + planeta.getExcentricidade());
                        System.out.println("Inclinação orbital: " + planeta.getInclinacao() + "°");

                        System.out.println("\nEstrela Hospedeira");
                        System.out.println("Temperatura: " + planeta.getEstrela().getTemperatura() + " Kelvin");
                        System.out.println("Massa: " + planeta.getEstrela().getMassa() + " Massas Solares");
                        System.out.println("Raio: " + planeta.getEstrela().getRaio() + " Raios Solares");

                        System.out.println("\nHabitabilidade");
                        System.out.println("Índice: " + resultado.getValor());
                        System.out.println("Habitável: " + resultado.ehHabitavel());

                    } else {

                        System.out.println("\nPlaneta não encontrado.");
                    }

                    break;

                case "2":
                    System.out.println("\nCadastrar planeta");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Método de descoberta: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Massa (Mj): ");
                    double massa =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Raio (Rj): ");
                    double raio =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Período orbital (dias): ");
                    double periodo =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Semi-eixo maior (AU): ");
                    double semiEixo =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Excentricidade: ");
                    double excentricidade =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Inclinação orbital: ");
                    double inclinacao =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Temperatura da estrela (K): ");
                    double temperatura =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Massa da estrela (M☉): ");
                    double massaEstrela =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Raio da estrela (R☉): ");
                    double raioEstrela =
                            Double.parseDouble(scanner.nextLine());

                    EstrelaHospedeira estrela =
                            new EstrelaHospedeira(
                                    massaEstrela,
                                    raioEstrela,
                                    temperatura
                            );

                    Exoplaneta novoPlaneta =
                            new Exoplaneta(
                                    System.currentTimeMillis(),
                                    nome,
                                    tipo,
                                    "Confirmado",
                                    2026,
                                    massa,
                                    raio,
                                    periodo,
                                    semiEixo,
                                    excentricidade,
                                    inclinacao,
                                    0,
                                    estrela
                            );

                    app.cadastrar(novoPlaneta);
                    planetasSalvos.add(novoPlaneta);
                    persistencia.salvar(planetasSalvos);
                    System.out.println("\nPlaneta cadastrado com sucesso!");
                    break;


                case "0":
                    scanner.close();
                    System.out.println("\nSistema encerrado.");
                    return;
                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }
}
package br.com.alura.Screenmatch.Main;

import br.com.alura.Screenmatch.model.*;
import br.com.alura.Screenmatch.repository.SerieRepository;
import br.com.alura.Screenmatch.service.ConsumoApi;
import br.com.alura.Screenmatch.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;
import java.util.stream.Collectors;

public class Main{
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY  = "&apikey=fc73cd7d";

    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository repository;

    public Main(SerieRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() throws JsonProcessingException {
        var opcao = -1;
        while (opcao != 0){
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries buscadas
                    
                    0 - Sair                                 
                    """;

        System.out.println(menu);
        opcao = scanner.nextInt();
        scanner.nextLine();


        switch (opcao) {
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 3:
                listarSeriesBuscadas();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    }

    private void buscarSerieWeb() throws JsonProcessingException {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        //dadosSeries.add(dados);
        repository.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() throws JsonProcessingException {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = scanner.nextLine();
        var json = consumo.ObterDados(ENDERECO + nomeSerie.strip().replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() throws JsonProcessingException {
        DadosSerie dadosSerie = getDadosSerie();
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var json = consumo.ObterDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }

    private void listarSeriesBuscadas() {
        List<Serie> series = repository.findAll();
       series.stream()
               .sorted(Comparator.comparing(Serie::getGenero))
               .forEach(System.out::println);
    }
}

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

    private List<Serie> series = new ArrayList<>();

    private Optional<Serie> serieBusca;

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
                    4 - Buscar séries por título
                    5 - Buscar séries por ator
                    6 - Top 5 Séries
                    7 - Buscar séries por categoria
                    8 - Filtrar séries
                    9 - Buscar episódios por trecho
                    10 - Top 5 episódios por série
                    11 - Buscar episódios a partir de uma data
                    
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
            case 4:
                buscarSeriePorTitulo();
                break;
            case 5:
                buscarSeriePorAtor();
                break;
            case 6:
                buscarTop5Series();
                break;
            case 7:
                buscarSeriesPorCategoria();
                break;
            case 8:
                filtrarSeries();
                break;
            case 9:
                buscarEpisodioPorTrecho();
                break;
            case 10:
                topEpisodiosPorSerie();
                break;
            case 11:
                buscarEpisodiosDepoisDeUmaData();
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
        listarSeriesBuscadas();
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = scanner.nextLine();

        Optional<Serie> serie = repository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serie.isPresent()) {
            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.ObterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodio(episodios);
            repository.save(serieEncontrada);
        }else {
            System.out.println("Série não encontrada!");
        }
    }

    private void listarSeriesBuscadas() {
        series = repository.findAll();
        series.stream()
               .sorted(Comparator.comparing(Serie::getGenero))
               .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = scanner.nextLine();

        serieBusca = repository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBusca.isPresent()){
            System.out.println("Dados da série buscada: " + serieBusca.get());
        }else{
            System.out.println("Série não encontrada!");
        }
    }

    private void buscarSeriePorAtor() {
        System.out.println("Qual o nome para busca");
        var nomeAtor = scanner.nextLine();
        System.out.println("Avaliações a partir de que valor? ");
        var avaliacao = scanner.nextDouble();
        List<Serie> seriesEncontradas = repository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);

        System.out.println("Séries em que '" + nomeAtor + "' atuou:");
        seriesEncontradas.stream()
                        .sorted(Comparator.comparing(Serie::getAvaliacao).reversed())
                        .forEach(s -> System.out.println(s.getTitulo() + " - avaliação: " + s.getAvaliacao()));
    }

    private void buscarTop5Series() {
        List<Serie> serieTop5 = repository.findTop5ByOrderByAvaliacaoDesc();
        serieTop5.forEach(s -> System.out.println(s.getTitulo() + " - avaliação: " + s.getAvaliacao()));
    }


    private void buscarSeriesPorCategoria() {
        System.out.println("Deseja buscar séries de que categoria/gênero?");
        var nomeGenero = scanner.nextLine();
        Categoria categoria = Categoria.fromPortuguese(nomeGenero);
        List<Serie> seriesPorCategoria = repository.findByGenero(categoria);

        System.out.println("Séries da Categoria: " + nomeGenero);
        seriesPorCategoria.forEach(System.out::println);
    }

    private void filtrarSeries() {
        System.out.println("Digite o máximo de temporadas desejada:");
        var maxTemporada = scanner.nextInt();
        System.out.println("Digite a avaliação mínima da temporada desejada:");
        var avaliacaoMinima = scanner.nextDouble();
        List<Serie> seriesFiltradas = repository.seriesPorTemporadaEAvaliacao(maxTemporada, avaliacaoMinima);
        System.out.println("Séries filtradas:");
        seriesFiltradas.forEach(System.out::println);
    }

    private void buscarEpisodioPorTrecho() {
        System.out.println("Qual o nome do episódio para busca?");
        var trechoEpisodio = scanner.nextLine();
        List<Episodio> episodiosEncontrados = repository.episodiosPorTrecho(trechoEpisodio);

        episodiosEncontrados.forEach(e -> System.out.printf("Série: %s Temporada %s - Episódio %s - %s\n",
                e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
    }

    private void topEpisodiosPorSerie() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repository.topEpisodiosPorSerie(serie);
            System.out.println("Top 5 episódios de " + serie.getTitulo() + ":");
            topEpisodios.forEach(e -> System.out.printf("Temporada %s - Episódio %s - %s  - Avaliação - %s\n",
                     e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        }
    }

    private void buscarEpisodiosDepoisDeUmaData() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de lançamento:");
            var anoLancamento = scanner.nextInt();
            scanner.nextLine();

            List<Episodio> episodiosAno = repository.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(System.out::println);
        }
    }
}

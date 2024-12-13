package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.model.DadosEpisodio;
import br.com.alura.Screenmatch.model.DadosSerie;
import br.com.alura.Screenmatch.model.DadosTemporada;
import br.com.alura.Screenmatch.service.ConsumoApi;
import br.com.alura.Screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.ObterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=fc73cd7d");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.ObterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=fc73cd7d");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json ,DadosEpisodio.class );
		System.out.println(dadosEpisodio);

		int totalTemporadas = dados.totalTemporadas();

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= totalTemporadas; i++) {
			json = consumoApi.ObterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+ i +"&apikey=fc73cd7d");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);
	}
}

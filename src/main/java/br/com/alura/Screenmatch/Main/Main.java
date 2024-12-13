package br.com.alura.Screenmatch.Main;

import br.com.alura.Screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Main{
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY  = "&apikey=fc73cd7d";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca:");
        var nomeserie = scanner.nextLine();
        var path = ENDERECO + nomeserie.strip().replace(" ", "+") + API_KEY;
        var json = consumo.ObterDados(path);
    }
}

package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.List;

public class D02 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream().map(n -> n.toUpperCase()).forEach(System.out::println);
    }
}

package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D02 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");

        Map<Integer, List<String>> mapPalavras = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(mapPalavras);

    }
}

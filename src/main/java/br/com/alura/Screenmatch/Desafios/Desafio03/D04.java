package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.List;

public class D04 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        List<String> listaSemRepeticao = palavras.stream()
                .distinct()
                .toList();
        listaSemRepeticao.forEach(System.out::println);
    }
}

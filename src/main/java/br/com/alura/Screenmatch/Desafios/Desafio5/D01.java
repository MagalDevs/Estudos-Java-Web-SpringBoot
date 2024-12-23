package br.com.alura.Screenmatch.Desafios.Desafio5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class D01 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");

        var listaNumeros = input.stream()
                .map(str -> {
                    try {
                       return Optional.of(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                       return Optional.<Integer>empty();
                    }

                }).filter(Optional::isPresent).map(Optional::get).toList();

        listaNumeros.forEach(System.out::println);
    }
}

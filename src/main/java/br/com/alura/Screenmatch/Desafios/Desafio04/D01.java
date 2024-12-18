package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class D01 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> maiorNumero = numeros.stream()
                .max(Integer::compareTo);

        maiorNumero.ifPresent(System.out::println);
    }
}

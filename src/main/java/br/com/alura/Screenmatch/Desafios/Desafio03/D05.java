package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class D05 {
    public static void main(String[] args) {
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> numerosPrimos = listaDeNumeros.stream()
                .flatMap(Collection::stream)
                .filter(D05::ehPrimo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(numerosPrimos);
    }

    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false; // Números menores que 2 não são primos
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Divisível por outro número que não 1 e ele mesmo
            }
        }
        return true;
    }
}

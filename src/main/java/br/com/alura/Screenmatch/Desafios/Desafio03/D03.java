package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> listaNova = numeros.stream().filter(n -> !(n%2==0))
                        .map(n -> n*2)
                        .collect(Collectors.toList());
        listaNova.forEach(System.out::println);
    }
}

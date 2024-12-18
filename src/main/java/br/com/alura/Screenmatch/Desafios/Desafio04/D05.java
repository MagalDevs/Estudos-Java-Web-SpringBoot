package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D05 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> separando = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 ==0));

        System.out.println(separando.get(true));
        System.out.println(separando.get(false));
    }
}

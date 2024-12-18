package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.List;

public class D04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        int totalSomaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .peek(System.out::println)
                .reduce(0, (total, n) -> total + n);
        System.out.println(totalSomaPares);
    }
}

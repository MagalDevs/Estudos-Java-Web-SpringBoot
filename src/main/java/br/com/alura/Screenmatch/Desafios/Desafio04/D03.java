package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D03 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        // código do agrupamento de dados
        String concatenado = nomes.stream()
                        .collect(Collectors.joining(", "));

        System.out.println(concatenado);
        // Resultado Esperado: "Alice, Bob, Charlie"
    }
}

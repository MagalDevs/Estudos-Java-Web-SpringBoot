package br.com.alura.Screenmatch.Desafios.Desafio04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D07 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Fone de Ouvido", 100.0, "Eletrônicos"),
                new Produto("Caneta", 5.0, "Papelaria")
        );

        Map<String, Long> quantidadePorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                         Collectors.counting()));

        System.out.println(quantidadePorCategoria);
    }
}

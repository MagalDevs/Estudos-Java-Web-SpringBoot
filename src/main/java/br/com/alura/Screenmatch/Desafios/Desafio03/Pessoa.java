package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class D06Pessoa {
    String nome;
    int idade;

    D06Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public static void main(String[] args) {
        List<D06Pessoa> pessoas = Arrays.asList(
                new D06Pessoa("Alice", 22),
                new D06Pessoa("Bob", 17),
                new D06Pessoa("Charlie", 19)
        );

        List<D06Pessoa> listaNova = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .sorted(Comparator.comparing(D06Pessoa::getNome))
                .toList();
        listaNova.forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome() + ", idade: " + pessoa.getIdade()));
    }
}

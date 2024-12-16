package br.com.alura.Screenmatch.Desafios.Desafio03;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class D08Produto {

    private String nome;
    private double preco;
    private String categoria;

    public D08Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<D08Produto> produtos = Arrays.asList(
                new D08Produto("Smartphone", 800.0, "Eletrônicos"),
                new D08Produto("Notebook", 1500.0, "Eletrônicos"),
                new D08Produto("Teclado", 200.0, "Eletrônicos"),
                new D08Produto("Cadeira", 300.0, "Móveis"),
                new D08Produto("Monitor", 900.0, "Eletrônicos"),
                new D08Produto("Mesa", 700.0, "Móveis")
        );

        List<D08Produto> listaNovaProdutos = produtos.stream()
                .filter(p -> p.categoria.equals("Eletrônicos"))
                .sorted(Comparator.comparing(D08Produto::getPreco))
                .limit(3)
                .toList();
        listaNovaProdutos.forEach(System.out::println);
    }
}

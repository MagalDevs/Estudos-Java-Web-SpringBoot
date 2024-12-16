package br.com.alura.Screenmatch.Desafios.Desafio03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class D07Produto {

        private String nome;
        private double preco;
        private String categoria;

        public D07Produto(String nome, double preco, String categoria) {
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
        List<D07Produto> produtos = Arrays.asList(
                new D07Produto("Notebook", 1500.0, "Eletrônicos"),
                new D07Produto("Teclado", 200.0, "Eletrônicos"),
                new D07Produto("Smartphone", 800.0, "Eletrônicos"),
                new D07Produto("Cadeira", 300.0, "Móveis"),
                new D07Produto("Monitor", 900.0, "Eletrônicos"),
                new D07Produto("Mesa", 700.0, "Móveis")
        );

        List<D07Produto> listaNovaProdutos = produtos.stream()
                .filter(p -> p.categoria.equals("Eletrônicos") && p.preco < 1000)
                .sorted(Comparator.comparing(D07Produto::getPreco))
                .toList();
        listaNovaProdutos.forEach(System.out::println);
    }
}

package br.com.alura.Screenmatch.Desafios.Desafio02;

public class D04 {
    public static void main(String[] args) {
        Palindromo verificar = n -> n.contentEquals(new StringBuilder(n).reverse());

        System.out.println(verificar.verificarPalindromo("socorrammesubinoonibusemmarrocos"));
        System.out.println(verificar.verificarPalindromo("coiso"));
    }
}

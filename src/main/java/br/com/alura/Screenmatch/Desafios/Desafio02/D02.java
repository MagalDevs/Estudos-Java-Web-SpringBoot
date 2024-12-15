package br.com.alura.Screenmatch.Desafios.Desafio02;

public class D02 {
    public static void main(String[] args) {
        Primo numeroPrimo = n -> {
            if (n <= 1) return false;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        System.out.println(numeroPrimo.Primo(13));
        System.out.println(numeroPrimo.Primo(4));
    }
}

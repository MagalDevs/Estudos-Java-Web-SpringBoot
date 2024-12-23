package br.com.alura.Screenmatch.Desafios.Desafio5;

public class D04 {
    public static void main(String[] args) {
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos")); // Saída: true
        System.out.println(ehPalindromo("Java")); // Saída: false



    }
    public static boolean ehPalindromo(String palavra) {
        String palavraSemEspaco = palavra.replace(" ", "").toLowerCase();
        return new StringBuilder(palavraSemEspaco).reverse().toString().equalsIgnoreCase(palavraSemEspaco);
    }

}

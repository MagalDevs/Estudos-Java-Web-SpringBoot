package br.com.alura.Screenmatch.Desafios.Desafio5;

public class D03 {
    public static void main(String[] args) {
        System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
        System.out.println(obterPrimeiroEUltimoNome("Maria   ")); // Saída: "Maria"
        System.out.println(obterPrimeiroEUltimoNome("              Daniel Galvão Magalhães da Silva    "));

    }

    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        var nome = nomeCompleto.strip().split("\\s+");
        String primeiroNome = nome[0];
        if (nome.length > 1){
            String ultimoNome = nome[nome.length - 1];
            return primeiroNome + " " + ultimoNome;
        }else{
            return primeiroNome;
        }
    }
}

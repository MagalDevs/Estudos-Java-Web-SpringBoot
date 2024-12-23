package br.com.alura.Screenmatch.Desafios.Desafio5;

import java.util.Arrays;
import java.util.List;

public class D05 {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(normalizeEmails(emails));
// Saída: ["teste@exemplo.com", "exemplo@java.com", "usuario@teste.com"]

    }

    public static List<String> normalizeEmails(List<String> emails) {
        return emails.stream().map(String::toLowerCase).toList();
    }
}

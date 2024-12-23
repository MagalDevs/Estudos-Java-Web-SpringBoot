package br.com.alura.Screenmatch.Desafios.Desafio5;

import java.util.Optional;

public class D02 {
    public static void main(String[] args) {
        System.out.println(processaNumero(Optional.of(5))); // Saída: Optional[25]
        System.out.println(processaNumero(Optional.of(-3))); // Saída: Optional.empty
        System.out.println(processaNumero(Optional.empty())); // Saída: Optional.empty
    }

    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        if (numero.isPresent() && numero.get() > 0){
            return Optional.of(numero.get() * numero.get());
        }else {
            return Optional.empty();
        }
    }
}

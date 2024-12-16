package br.com.alura.Screenmatch.Desafios.Desafio02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D06 {
    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("Daniel", "Thiago", "Pedro", "Julia", "Arthur");
        listaNomes.sort((x,y ) -> x.compareTo(y));
        System.out.println(listaNomes);

    }
}

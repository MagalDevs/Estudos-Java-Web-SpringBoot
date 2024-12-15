package br.com.alura.Screenmatch.Desafios.Desafio02;

public class D07 {
    public static void main(String[] args) {
        ID07 divisao = (a, b) -> {
            if (b== 0) throw new ArithmeticException("Divisão por zero");

            return (double) a/b;
        };

        try {
            System.out.println(divisao.dividir(200, 80));
            System.out.println(divisao.dividir(10, 0));
        }catch (ArithmeticException n){
            System.out.println(n.getMessage());
        }

    }
}

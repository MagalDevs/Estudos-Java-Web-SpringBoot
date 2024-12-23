package br.com.alura.Screenmatch.Desafios.Desafio5;

public enum Mes {
    JANEIRO(2),
    FEVEREIRO(28),
    MARCO(31),
    ABRIL(30),
    MAIO(31),
    JUNHO(30),
    JULHO(31),
    AGOSTO(31),
    SETEMBRO(30),
    OUTUBRO(31),
    NOVEMBRO(30),
    DEZEMBRO(31);

    private int diasDoAno;

    public int getNumeroDeDias(){
        return diasDoAno;
    }

    Mes(int dias) {
        this.diasDoAno = dias;
    }

    public static void main(String[] args) {
        System.out.println(Mes.FEVEREIRO.getNumeroDeDias()); // 28
        System.out.println(Mes.JULHO.getNumeroDeDias()); // 31
    }
}

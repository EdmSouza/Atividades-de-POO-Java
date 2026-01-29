package genericsandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum Naipe {
    COPAS, OUROS, ESPADAS, PAUS
}

enum Valor {
    A, DOIS, TRES, QUATRO, CINCO, SEIS, SETE,
    OITO, NOVE, DEZ, J, Q, K
}

public class Carta2 {
    private Naipe naipe;
    private Valor valor;

    public Carta2(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valor getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }

    public static List<Carta2> criarBaralho() {
    List<Carta2> baralho = new ArrayList<>();

    for (Naipe n : Naipe.values()) {
        for (Valor v : Valor.values()) {
            baralho.add(new Carta2(n, v));
        }
    }
    return baralho;
    }
    public static List<List<Carta>> distribuirCartas(
        List<Carta2> baralho, int m, int n) {

    if (m * n > baralho.size()) {
        throw new IllegalArgumentException("Cartas insuficientes");
    }

    Collections.shuffle(baralho);

    List<List<Carta2>> jogadores = new ArrayList<>();

    int indice = 0;
    for (int i = 0; i < m; i++) {
        List<Carta2> mao = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            mao.add(baralho.get(indice++));
        }
        jogadores.add(mao);
    }
    return jogadores;
    }
    public static void ordenarPorValor(List<Carta2> mao) {
    mao.sort(Comparator.comparing(Carta2::getValor));
    }
    public static void ordenarPorNaipeEValor(List<Carta2> mao) {
    mao.sort(
        Comparator.comparing(Carta2::getNaipe)
                  .thenComparing(Carta2::getValor)
    );
    }
    public static void main(String[] args) {
    List<Carta2> baralho = criarBaralho();

    List<List<Carta2>> jogadores = distribuirCartas(baralho, 4, 5);

    for (int i = 0; i < jogadores.size(); i++) {
        List<Carta2> mao = jogadores.get(i);

        ordenarPorNaipeEValor(mao);

        IO.println("Jogador " + (i + 1));
        for (Carta c : mao) {
            IO.println(c);
        }
        IO.println();
    }
}
}
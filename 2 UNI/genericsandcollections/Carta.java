package genericsandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Carta implements Comparable<Carta> {

    private int valor;
    private int naipe;

    public Carta(int valor, int naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public int getNaipe() {
        return naipe;
    }

    @Override
    public int compareTo(Carta outra) {
        return Integer.compare(this.valor, outra.valor);
    }

    @Override
    public String toString() {
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] naipes = {"Copas","Ouros","Espadas","Paus"};

        return valores[valor - 1] + " de " + naipes[naipe];
    }

    public static List<Carta> criarBaralho() {
    List<Carta> baralho = new ArrayList<>();

    for (int naipe = 0; naipe < 4; naipe++) {
        for (int valor = 1; valor <= 13; valor++) {
            baralho.add(new Carta(valor, naipe));
        }
    }

    return baralho;
    }

    public static List<Set<Carta>> distribuirCartas(List<Carta> baralho, int m, int n) {

    Collections.shuffle(baralho);

    List<Set<Carta>> jogadores = new ArrayList<>();

    int indice = 0;

    for (int i = 0; i < m; i++) {
        Set<Carta> mao = new HashSet<>();
        for (int j = 0; j < n; j++) {
            mao.add(baralho.get(indice++));
        }
        jogadores.add(mao);
    }

    return jogadores;
    }

    public static List<Set<Carta>> distribuirCartasOrdenadasPorValor(
        List<Carta> baralho, int m, int n) {

    Collections.shuffle(baralho);

    List<Set<Carta>> jogadores = new ArrayList<>();
    int indice = 0;

    for (int i = 0; i < m; i++) {
        Set<Carta> mao = new TreeSet<>();
        for (int j = 0; j < n; j++) {
            mao.add(baralho.get(indice++));
        }
        jogadores.add(mao);
    }

    return jogadores;
    }

    public static List<Set<Carta>> distribuirCartasOrdenadasPorNaipe(
        List<Carta> baralho, int m, int n) {

    Collections.shuffle(baralho);

    Comparator<Carta> comp = (c1, c2) -> {
        if (c1.getNaipe() != c2.getNaipe()) {
            return Integer.compare(c1.getNaipe(), c2.getNaipe());
        }
        return Integer.compare(c1.getValor(), c2.getValor());
    };

    List<Set<Carta>> jogadores = new ArrayList<>();
    int indice = 0;

    for (int i = 0; i < m; i++) {
        Set<Carta> mao = new TreeSet<>(comp);
        for (int j = 0; j < n; j++) {
            mao.add(baralho.get(indice++));
        }
        jogadores.add(mao);
    }

    return jogadores;
    }

    public static void main(String[] args) {

    List<Carta> baralho = criarBaralho();


    List<Set<Carta>> jogadores = distribuirCartas(baralho, 4, 5);
    for (Set<Carta> mao : jogadores) {
        IO.println(mao);
    }


    baralho = criarBaralho();
    jogadores = distribuirCartasOrdenadasPorValor(baralho, 4, 5);
    for (Set<Carta> mao : jogadores) {
        IO.println(mao);
    }


    baralho = criarBaralho();
    jogadores = distribuirCartasOrdenadasPorNaipe(baralho, 4, 5);
    for (Set<Carta> mao : jogadores) {
        IO.println(mao);
    }
}
}
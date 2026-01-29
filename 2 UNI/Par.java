import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definimos T e U com a restrição "extends Comparable" para garantir
// que os itens dentro do par saibam se comparar.
class Par<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Par<T, U>> {
    
    private T primeiro;
    private U segundo;

    public Par(T primeiro, U segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public T getPrimeiro() { return primeiro; }
    public U getSegundo() { return segundo; }

    @Override
    public String toString() {
        return "(" + primeiro + ", " + segundo + ")";
    }

    // A mágica acontece aqui
    @Override
    public int compareTo(Par<T, U> outro) {
        // 1. Compara o primeiro elemento
        int comparacaoPrimeiro = this.primeiro.compareTo(outro.primeiro);

        // 2. Se forem diferentes (resultado != 0), a ordem já está decidida
        if (comparacaoPrimeiro != 0) {
            return comparacaoPrimeiro;
        }

        // 3. Se forem iguais (resultado == 0), o critério de desempate é o segundo elemento
        return this.segundo.compareTo(outro.segundo);
    }
}

public class TesteParComparavel {
    public static void main(String[] args) {
        
        // --- Teste 1: Pares de Inteiros ---
        System.out.println("--- Teste 1: Ordenando Inteiros ---");
        List<Par<Integer, Integer>> listaNumeros = new ArrayList<>();
        listaNumeros.add(new Par<>(2, 10));
        listaNumeros.add(new Par<>(1, 5));
        listaNumeros.add(new Par<>(1, 2)); // Empate no primeiro com o anterior
        listaNumeros.add(new Par<>(3, 1));

        System.out.println("Antes: " + listaNumeros);
        Collections.sort(listaNumeros); // Usa o nosso compareTo automaticamente
        System.out.println("Depois: " + listaNumeros);
        // Esperado: (1, 2), (1, 5), (2, 10), (3, 1)

        
        // --- Teste 2: Pares de String e Integer (Tipos mistos) ---
        System.out.println("\n--- Teste 2: Nomes e Idades ---");
        List<Par<String, Integer>> listaPessoas = new ArrayList<>();
        listaPessoas.add(new Par<>("Carlos", 25));
        listaPessoas.add(new Par<>("Ana", 30));
        listaPessoas.add(new Par<>("Carlos", 20)); // Empate de nome, idade decide
        listaPessoas.add(new Par<>("Beatriz", 22));

        System.out.println("Antes: " + listaPessoas);
        Collections.sort(listaPessoas);
        System.out.println("Depois: " + listaPessoas);
        // Esperado: Ordem alfabética, e quem tiver mesmo nome ordena por idade crescente
        
        
        // --- Teste 3: Comparação Manual (Retorno do compareTo) ---
        System.out.println("\n--- Teste 3: Verificação Manual ---");
        Par<Integer, String> p1 = new Par<>(10, "A");
        Par<Integer, String> p2 = new Par<>(10, "B");
        
        int resultado = p1.compareTo(p2);
        
        if (resultado < 0) System.out.println(p1 + " vem antes de " + p2);
        else if (resultado > 0) System.out.println(p1 + " vem depois de " + p2);
        else System.out.println("São iguais");
    }
}
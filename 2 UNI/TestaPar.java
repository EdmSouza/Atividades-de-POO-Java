// Classe genérica Par
public final class Par<A, B> {
    private final A primeiro;
    private final B segundo;

    // Construtor
    public Par(A primeiro, B segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    // Métodos de acesso
    public A getPrimeiro() {
        return primeiro;
    }

    public B getSegundo() {
        return segundo;
    }

    // Representação em String
    @Override
    public String toString() {
        return "(" + primeiro + ", " + segundo + ")";
    }
}

public class TestaPar {
    public static void main(String[] args) {
        // Par de inteiros
        Par<Integer, Integer> coordenada = new Par<>(10, 20);
        System.out.println("Coordenada: " + coordenada);

        // Par de String e Integer
        Par<String, Integer> aluno = new Par<>("Ana", 9);
        System.out.println("Aluno: " + aluno.getPrimeiro() + " - Nota: " + aluno.getSegundo());

        // Par de Double e String
        Par<Double, String> produto = new Par<>(19.99, "Caderno");
        System.out.println("Produto: " + produto);

        // Par de tipos personalizados
        Pessoa p1 = new Pessoa("Carlos", 32);
        Pessoa p2 = new Pessoa("Beatriz", 29);
        Par<Pessoa, Pessoa> casal = new Par<>(p1, p2);
        System.out.println("Casal: " + casal);
    }

    // Classe auxiliar para teste
    static class Pessoa {
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public String toString() {
            return nome + " (" + idade + " anos)";
        }
    }
}
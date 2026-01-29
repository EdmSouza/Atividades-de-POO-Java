public class MaiorElemento {

    // Método genérico que retorna o maior elemento de um array de objetos Comparable
    public static <T extends Comparable<T>> T maior(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("O array não pode ser nulo ou vazio.");
        }

        T maior = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(maior) > 0) {
                maior = array[i];
            }
        }
        return maior;
    }

    // Classe personalizada que implementa Comparable
    static class Pessoa implements Comparable<Pessoa> {
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public int compareTo(Pessoa outra) {
            return Integer.compare(this.idade, outra.idade);
        }

        @Override
        public String toString() {
            return nome + " (" + idade + " anos)";
        }
    }

    // Programa de teste
    public static void main(String[] args) {
        // Teste com Integer
        Integer[] numeros = {10, 25, 3, 42, 18};
        System.out.println("Maior número: " + maior(numeros));

        // Teste com String
        String[] palavras = {"banana", "abacaxi", "laranja", "uva"};
        System.out.println("Maior palavra (ordem alfabética): " + maior(palavras));

        // Teste com classe personalizada Pessoa
        Pessoa[] pessoas = {
            new Pessoa("Ana", 25),
            new Pessoa("Carlos", 32),
            new Pessoa("Beatriz", 29)
        };
        System.out.println("Pessoa mais velha: " + maior(pessoas));
    }
}
public class OrdenacaoGenerica {

    // Método genérico para verificar se o array está ordenado ascendentemente
    public static <T extends Comparable<T>> boolean estaOrdenadoAsc(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false; // encontrou um elemento fora de ordem
            }
        }
        return true;
    }

    // Classe exemplo que implementa Comparable
    static class Pessoa implements Comparable<Pessoa> {
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public int compareTo(Pessoa outra) {
            // Ordena por idade
            return Integer.compare(this.idade, outra.idade);
        }

        @Override
        public String toString() {
            return nome + " (" + idade + ")";
        }
    }

    // Programa principal para testar
    public static void main(String[] args) {
        // Teste com Integer
        Integer[] numeros = {1, 2, 3, 4, 5};
        System.out.println("Números ordenados? " + estaOrdenadoAsc(numeros));

        Integer[] numerosDesordenados = {1, 3, 2, 4, 5};
        System.out.println("Números ordenados? " + estaOrdenadoAsc(numerosDesordenados));

        // Teste com String
        String[] palavras = {"Ana", "Bruno", "Carlos", "Daniel"};
        System.out.println("Palavras ordenadas? " + estaOrdenadoAsc(palavras));

        String[] palavrasDesordenadas = {"Ana", "Carlos", "Bruno", "Daniel"};
        System.out.println("Palavras ordenadas? " + estaOrdenadoAsc(palavrasDesordenadas));

        // Teste com Pessoa
        Pessoa[] pessoas = {
            new Pessoa("João", 20),
            new Pessoa("Maria", 25),
            new Pessoa("Pedro", 30)
        };
        System.out.println("Pessoas ordenadas por idade? " + estaOrdenadoAsc(pessoas));

        Pessoa[] pessoasDesordenadas = {
            new Pessoa("João", 20),
            new Pessoa("Pedro", 18),
            new Pessoa("Maria", 25)
        };
        System.out.println("Pessoas ordenadas por idade? " + estaOrdenadoAsc(pessoasDesordenadas));
    }
}
public class Fila<T> {
    private T[] elementos;
    private int inicio;
    private int fim;
    private int totalElementos;
    private int tamanhoMaximo;

    // Construtor
    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.tamanhoMaximo = capacidade;

        this.elementos = (T[]) new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.totalElementos = 0;
    }

    // Método para inserir (enqueue)
    public void enfileirar(T elemento) {
        if (isCheia()) {
            throw new RuntimeException("Erro: A fila está cheia!");
        }
        elementos[fim] = elemento;
        // Lógica circular: se chegar no final do array, volta para o índice 0
        fim = (fim + 1) % tamanhoMaximo;
        totalElementos++;
    }

    // Método para remover (dequeue)
    public T desenfileirar() {
        if (isVazia()) {
            throw new RuntimeException("Erro: A fila está vazia!");
        }
        T elementoRemovido = elementos[inicio];
        

        elementos[inicio] = null; 
        
        // Lógica circular para o início também
        inicio = (inicio + 1) % tamanhoMaximo;
        totalElementos--;
        
        return elementoRemovido;
    }

    public boolean isVazia() {
        return totalElementos == 0;
    }

    public boolean isCheia() {
        return totalElementos == tamanhoMaximo;
    }

    public int tamanho() {
        return totalElementos;
    }

    @Override
    public String toString() {
        if (isVazia()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        // Precisamos percorrer usando a lógica circular apenas para imprimir
        int atual = inicio;
        for (int i = 0; i < totalElementos; i++) {
            sb.append(elementos[atual]);
            if (i < totalElementos - 1) {
                sb.append(", ");
            }
            atual = (atual + 1) % tamanhoMaximo;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class TesteFilaGenerica {
    public static void main(String[] args) {
        
        // --- Teste 1: Fila de Strings ---
        System.out.println("--- Teste 1: Fila de Strings ---");
        Fila<String> filaBanco = new Fila<>(3);
        
        filaBanco.enfileirar("Cliente A");
        filaBanco.enfileirar("Cliente B");
        filaBanco.enfileirar("Cliente C");
        
        System.out.println("Fila atual: " + filaBanco);
        
        System.out.println("Atendendo: " + filaBanco.desenfileirar());
        System.out.println("Fila após atendimento: " + filaBanco);
        
        filaBanco.enfileirar("Cliente D"); // Testando a circularidade (reuso de espaço)
        System.out.println("Entrou Cliente D: " + filaBanco);

        
        // --- Teste 2: Fila de Inteiros (Double) ---
        System.out.println("\n--- Teste 2: Fila de Números ---");
        Fila<Double> filaNumeros = new Fila<>(5);
        
        filaNumeros.enfileirar(10.5);
        filaNumeros.enfileirar(20.0);
        
        System.out.println("Fila de números: " + filaNumeros);
        System.out.println("Tamanho atual: " + filaNumeros.tamanho());
        
        // Esvaziando a fila
        while(!filaNumeros.isVazia()) {
            System.out.println("Removendo: " + filaNumeros.desenfileirar());
        }
        
    }
}
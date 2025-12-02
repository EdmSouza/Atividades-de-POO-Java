public class Pilha {
    private int[] elementos;
    private int topo;
    private int capacidade;

    // Construtor
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1;  // pilha começa vazia
    }

    // Verifica se está vazia
    public boolean estaVazia() {
        return topo == -1;
    }

    // Verifica se está cheia
    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    // Empilha um valor
    public void empilhar(int valor) {
        if (estaCheia()) {
            System.out.println("Erro: a pilha está cheia, não é possível empilhar.");
        } else {
            topo++;
            elementos[topo] = valor;
        }
    }

    // Desempilha um valor
    public int desempilhar() {
        if (estaVazia()) {
            System.out.println("Erro: a pilha está vazia, não é possível desempilhar.");
            return -1; // ou lançar exceção
        } else {
            int valor = elementos[topo];
            topo--;
            return valor;
        }
    }

    // Retorna o elemento no topo sem remover
    public int topo() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia.");
            return -1;
        } else {
            return elementos[topo];
        }
    }
}
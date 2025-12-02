public class CalculadoraNPR {
    private int topo;
    private double[] pilha;

    public CalculadoraNPR() {
        pilha = new double[100];
        topo = -1;
    }

    public boolean pilhaCheia() {
        return topo == pilha.length - 1;
    }

    public boolean pilhaVazia() {
        return topo == -1;
    }

    public void addNaPilha(double n) {
        if (pilhaCheia()) {
            IO.println("Pilha cheia");
            return;
        }
        topo++;
        pilha[topo] = n;
    }

    public double desempilhar() {
        if (pilhaVazia()) {
            IO.println("Pilha está vazia");
            return 0;
        }
        double valor = pilha[topo];
        topo--;
        return valor;
    }

    public void soma() {
        if (topo < 1) {
            IO.println("Erro: Pilha precisa ter pelo menos 2 elementos para soma");
            return;
        }
        double b = desempilhar();
        double a = desempilhar();
        addNaPilha(a + b);
    }

    public void diferenca() {
        if (topo < 1) {
            IO.println("Erro: Pilha precisa ter pelo menos 2 elementos para subtração");
            return;
        }
        double b = desempilhar();
        double a = desempilhar();
        addNaPilha(a - b);
    }

    public void multiplicacao() {
        if (topo < 1) {
            IO.println("Erro: Pilha precisa ter pelo menos 2 elementos para multiplicação");
            return;
        }
        double b = desempilhar();
        double a = desempilhar();
        addNaPilha(a * b);
    }

    public void divisao() {
        if (topo < 1) {
            IO.println("Erro: Pilha precisa ter pelo menos 2 elementos para divisão");
            return;
        }
        double b = desempilhar();
        if (b == 0) {
            IO.println("Erro: Divisão por zero!");
            addNaPilha(b); // recoloca o valor na pilha
            return;
        }
        double a = desempilhar();
        addNaPilha(a / b);
    }

    public double resultado() {
        if (topo != 0) {
            IO.println("Há " + (topo + 1) + " elementos na pilha. Operação inválida - deve haver exatamente 1 elemento");
            return 0;
        } else {
            return pilha[0];
        }
    }

    public void exibirPilha() {
        IO.print("Pilha: ");
        if (pilhaVazia()) {
            IO.println("vazia");
        } else {
            for (int i = 0; i <= topo; i++) {
                IO.print(pilha[i] + " ");
            }
            IO.println();
        }
    }

    public static void main(String[] args) {
        CalculadoraNPR calc = new CalculadoraNPR();
        
        IO.println("=== CALCULADORA NPR ===");
        
        // Teste 1: 2 + 3
        IO.println("\nTeste 1: 2 + 3");
        calc.addNaPilha(2);
        calc.addNaPilha(3);
        calc.exibirPilha();
        calc.soma();
        calc.exibirPilha();
        IO.println("Resultado: " + calc.resultado());
        
        // Limpar pilha para próximo teste
        while (!calc.pilhaVazia()) {
            calc.desempilhar();
        }
        
        // Teste 2: 5 - 2
        IO.println("\nTeste 2: 5 - 2");
        calc.addNaPilha(5);
        calc.addNaPilha(2);
        calc.exibirPilha();
        calc.diferenca();
        calc.exibirPilha();
        IO.println("Resultado: " + calc.resultado());
        
        // Limpar pilha para próximo teste
        while (!calc.pilhaVazia()) {
            calc.desempilhar();
        }
        
        // Teste 3: 4 * 3
        IO.println("\nTeste 3: 4 * 3");
        calc.addNaPilha(4);
        calc.addNaPilha(3);
        calc.exibirPilha();
        calc.multiplicacao();
        calc.exibirPilha();
        IO.println("Resultado: " + calc.resultado());
        
        // Limpar pilha para próximo teste
        while (!calc.pilhaVazia()) {
            calc.desempilhar();
        }
        
        // Teste 4: 10 / 2
        IO.println("\nTeste 4: 10 / 2");
        calc.addNaPilha(10);
        calc.addNaPilha(2);
        calc.exibirPilha();
        calc.divisao();
        calc.exibirPilha();
        IO.println("Resultado: " + calc.resultado());
        
        // Teste 5: Expressão mais complexa: (5 + 3) * 2
        IO.println("\nTeste 5: (5 + 3) * 2");
        calc.addNaPilha(5);
        calc.addNaPilha(3);
        calc.exibirPilha();
        calc.soma();
        calc.exibirPilha();
        calc.addNaPilha(2);
        calc.exibirPilha();
        calc.multiplicacao();
        calc.exibirPilha();
        IO.println("Resultado: " + calc.resultado());
    }
}
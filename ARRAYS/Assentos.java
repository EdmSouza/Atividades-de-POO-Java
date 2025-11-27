import java.util.Random;

public class Assentos {
    private String[] assentos;
    private Random random; // Objeto para gerar números

    public Assentos() {
        // Correção da inicialização do array
        this.assentos = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        this.random = new Random();
    }

    public void listarassentos() {
        IO.println("\n--- Mapa de Assentos ---");
        // Imprime o array bonitinho
        for (int i = 0; i < assentos.length; i++) {
            IO.print("[" + assentos[i] + "] ");
            // Pula linha a cada 4 assentos para parecer um avião
            if ((i + 1) % 4 == 0) {
                IO.println("");
            }
        }
        IO.println("");
    }

    // Verifica se a seção está cheia para evitar loop infinito
    public boolean verificarLotacao(int inicio, int fim) {
        int contadorOcupados = 0;
        int totalAssentos = (fim - inicio) + 1;
        
        for (int i = inicio; i <= fim; i++) {
            if (assentos[i].contains("X")) {
                contadorOcupados++;
            }
        }
        return contadorOcupados == totalAssentos;
    }

    public void escolhaManual(String classeEscolhida) {
        int inicio, fim;
        
        // Define os limites baseados na classe
        if (classeEscolhida.equals("1")) { // Executiva
            inicio = 1; fim = 4;
            IO.println("Escolha entre 1 e 4");
        } else { // Economica
            inicio = 5; fim = 16;
            IO.println("Escolha entre 5 e 16");
        }

        if (verificarLotacao(inicio - 1, fim - 1)) {
            IO.println("Esta classe está lotada!");
            return;
        }

        listarassentos();
        int assentoEscolhido = Integer.parseInt(IO.readln("Digite o número do assento: "));

        // Validação se o número está dentro da classe correta
        if (assentoEscolhido < inicio || assentoEscolhido > fim) {
            IO.println("Erro: Esse assento não pertence à classe escolhida!");
            return;
        }

        // Lógica de índice: Assento 1 é índice 0
        int indice = assentoEscolhido - 1;

        if (assentos[indice].contains("X")) {
            IO.println("Erro: Assento ocupado! Tente novamente.");
        } else {
            assentos[indice] = assentos[indice] + "X"; // Marca o assento
            IO.println("Reserva concluída com sucesso no assento " + assentoEscolhido);
        }
    }

    public void assentoAleatorio(String classeEscolhida) {
        int inicioIndex, fimIndex;

        if (classeEscolhida.equals("1")) {
            inicioIndex = 0; // Índices do array (0 a 3)
            fimIndex = 3;
        } else {
            inicioIndex = 4; // Índices do array (4 a 15)
            fimIndex = 15;
        }

        // 1. Antes de tentar, vê se tem vaga
        if (verificarLotacao(inicioIndex, fimIndex)) {
            IO.println("Não há vagas aleatórias nesta classe.");
            return;
        }

        // 2. Tenta sortear até achar um livre
        int indiceSorteado;
        do {
            // Gera número entre inicio e fim. 
            // Ex executiva: random.nextInt(4) gera 0,1,2,3.
            // Ex economica: random.nextInt(12) + 4 gera 4 a 15.
            if(classeEscolhida.equals("1")){
                indiceSorteado = random.nextInt(4);
            } else {
                indiceSorteado = random.nextInt(12) + 4;
            }
            
        } while (assentos[indiceSorteado].contains("X")); // Repete se tiver X

        // 3. Marca e avisa
        assentos[indiceSorteado] = assentos[indiceSorteado] + "X";
        IO.println("Sistema escolheu para você o assento: " + (indiceSorteado + 1));
    }

    // Método auxiliar para perguntar a classe
    public String perguntarClasse() {
        String op = IO.readln("Digite 1 para Executiva (1-4) ou 2 para Econômica (5-16): ");
        if (op.equals("1") || op.equals("2")) {
            return op;
        } else {
            IO.println("Opção inválida.");
            return null;
        }
    }

    public static void main(String[] args) {
        Assentos voo = new Assentos();
        
        while (true) {
            IO.println("\n---- SISTEMA DE RESERVAS ----");
            int opcao = Integer.parseInt(IO.readln("1. Escolher Manualmente\n2. Escolha Aleatória\n3. Ver Mapa\n0. Sair\nOpção: "));

            if (opcao == 0) break;

            if (opcao == 1) {
                String classe = voo.perguntarClasse();
                if (classe != null) voo.escolhaManual(classe);
            } 
            else if (opcao == 2) {
                String classe = voo.perguntarClasse();
                if (classe != null) voo.assentoAleatorio(classe);
            } 
            else if (opcao == 3) {
                voo.listarassentos();
            }
        }
    }
}
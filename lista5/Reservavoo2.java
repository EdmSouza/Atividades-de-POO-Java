
public class Reservavoo2 {

    public static void main(String[] args) {
        boolean[] assentos = new boolean[40]; // false = livre, true = ocupado

        while (true) {
            mostrarMapa(assentos);

            // Verifica se o avião está lotado
            if (todosOcupados(assentos)) {
                IO.println("Avião lotado. Fim do programa.");
                break;
            }

            IO.println("\nClasse desejada (1 = primeira classe, 2 = econômica):");
            int classe = Integer.parseInt(IO.readln(""));

            if (classe != 1 && classe != 2) {
                IO.println("Classe inválida. Encerrando.");
                break;
            }

            IO.println("Deseja escolher o assento? (1 = sim, 2 = não)");
            int opc = Integer.parseInt(IO.readln(""));

            int assentoEscolhido = -1;

            if (opc == 1) { 
                // usuário escolhe
                assentoEscolhido = Integer.parseInt(IO.readln("Qual assento deseja? (1 a 40)"));

                // validação: dentro do intervalo
                if (assentoEscolhido < 1 || assentoEscolhido > 40) {
                    IO.println("Assento inexistente. Encerrando.");
                    break;
                }

                // valida classe
                if (classe == 1 && assentoEscolhido > 12) {
                    IO.println("Esse assento não pertence à primeira classe. Encerrando.");
                    break;
                }
                if (classe == 2 && assentoEscolhido <= 12) {
                    IO.println("Esse assento não pertence à classe econômica. Encerrando.");
                    break;
                }

                // se está ocupado → encerra
                if (assentos[assentoEscolhido - 1]) {
                    IO.println("Assento já ocupado. Encerrando.");
                    break;
                }

            } else if (opc == 2) {
                // sistema escolhe o primeiro livre da classe
                assentoEscolhido = escolherAutomatico(assentos, classe);
                if (assentoEscolhido == -1) {
                    IO.println("Não há assentos disponíveis nessa classe. Encerrando.");
                    break;
                }

            } else {
                IO.println("Opção inválida. Encerrando.");
                break;
            }

            // marca como ocupado
            assentos[assentoEscolhido - 1] = true;
            IO.println("Assento " + assentoEscolhido + " reservado com sucesso!\n");
        }
    }

    // ---------------- FUNÇÕES AUXILIARES ----------------

    public static void mostrarMapa(boolean[] a) {
        IO.print("Mapa de assentos: ");
        for(int linha = 0; linha<4; linha++){
            for(int coluna = 0; coluna<10; coluna++){
                int indice = linha + (coluna*4);
                int numeroAssento = indice +1;
                
                if (numeroAssento < 10) {
                    IO.print(" " + numeroAssento); // Espaço extra para números < 10
                } else {
                    IO.print(numeroAssento);
                }

                if (a[indice]) {
                    IO.print("X ");
                } else {
                    IO.print("  "); // Espaços vazios para alinhar
                }
                
                IO.print(" "); // Espaço entre as colunas
            }
            IO.println(""); // Pula para a próxima linha visual
        }
        IO.println("");
    }

    public static boolean todosOcupados(boolean[] a) {
        for (boolean x : a) if (!x) return false;
        return true;
    }

    public static int escolherAutomatico(boolean[] a, int classe) {
        int inicio = (classe == 1 ? 0 : 12);
        int fim = (classe == 1 ? 12 : 40);

        for (int i = inicio; i < fim; i++) {
            if (!a[i]) return i + 1;
        }
        return -1;
    }
}

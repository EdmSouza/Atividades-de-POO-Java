public class Reservavoo {

    public static void main(String[] args) {
        boolean[] assentos = new boolean[16]; // false = livre, true = ocupado

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
                assentoEscolhido = Integer.parseInt(IO.readln("Qual assento deseja? (1 a 16)"));

                // validação: dentro do intervalo
                if (assentoEscolhido < 1 || assentoEscolhido > 16) {
                    IO.println("Assento inexistente. Encerrando.");
                    break;
                }

                // valida classe
                if (classe == 1 && assentoEscolhido > 4) {
                    IO.println("Esse assento não pertence à primeira classe. Encerrando.");
                    break;
                }
                if (classe == 2 && assentoEscolhido <= 4) {
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
        for (int i = 0; i < a.length; i++) {
            if (a[i]) IO.print((i+1) + "X ");
            else IO.print((i+1) + " ");
        }
        IO.println("");
    }

    public static boolean todosOcupados(boolean[] a) {
        for (boolean x : a) if (!x) return false;
        return true;
    }

    public static int escolherAutomatico(boolean[] a, int classe) {
        int inicio = (classe == 1 ? 0 : 4);
        int fim = (classe == 1 ? 4 : 16);

        for (int i = inicio; i < fim; i++) {
            if (!a[i]) return i + 1;
        }
        return -1;
    }
}

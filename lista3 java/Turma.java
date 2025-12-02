class Aluno {
    private String nome;
    private int matricula;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    } 

    public String listaraluno() {
        return "Aluno: " + nome + " | Matrícula: " + matricula;
    }
}

public class Turma {
    private Aluno[] lista;
    private int qtd;
    private String nomeTurma;
    private String disciplina;
    private String periodo;

    public Turma(String nomeTurma, String disciplina, String periodo) {
        this.lista = new Aluno[100];
        this.qtd = 0;
        this.nomeTurma = nomeTurma;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }

    public void addaluno(Aluno a) {
        if (qtd < lista.length) {
            lista[qtd] = a;
            qtd++;
            IO.println("Aluno adicionado com sucesso!");
        } else {
            IO.println("Turma cheia! Não é possível adicionar mais alunos.");
        }
    }

    public void consulTurma() {
        IO.println("\n-- Dados da turma --");
        IO.println("Nome da turma: " + nomeTurma);
        IO.println("Disciplina: " + disciplina);
        IO.println("Período: " + periodo);
        IO.println("Quantidade de alunos: " + qtd);

        if (qtd == 0) {
            IO.println("Nenhum aluno matriculado.");
        } else {
            IO.println("\n-- Lista de Alunos --");
            for (int i = 0; i < qtd; i++) {
                IO.println(lista[i].listaraluno());
            }
        }
        IO.println("--------------------\n");
    }

    public static void main(String[] args) {
        Turma turma = null;

        while (true) {
            int opcao = Integer.parseInt(IO.readln(
                "\n=== SISTEMA DE TURMAS ===\n" +
                "1 - Criar turma\n" +
                "2 - Adicionar aluno\n" +
                "3 - Consultar turma\n" +
                "4 - Sair\n" +
                "Escolha uma opção: "
            ));

            if (opcao == 1) {
                // Criar turma
                if (turma != null) {
                    IO.println("Já existe uma turma criada!");
                } else {
                    String nomeT = IO.readln("Digite o nome da Turma: ");
                    String disc = IO.readln("Digite a disciplina: ");
                    String per = IO.readln("Digite o período: ");
                    turma = new Turma(nomeT, disc, per);
                    IO.println("Turma criada com sucesso!");
                }
            } 
            else if (opcao == 2) {
                // Adicionar aluno
                if (turma == null) {
                    IO.println("Erro: Crie uma turma primeiro!");
                } else {
                    String nome = IO.readln("Digite o nome do aluno: ");
                    int matricula = Integer.parseInt(IO.readln("Digite a matrícula: "));
                    turma.addaluno(new Aluno(nome, matricula));
                }
            } 
            else if (opcao == 3) {
                // Consultar turma
                if (turma == null) {
                    IO.println("Erro: Nenhuma turma criada ainda!");
                } else {
                    turma.consulTurma();
                }
            }
            else if (opcao == 4) {
                IO.println("Saindo do sistema...");
                break;
            }
            else {
                IO.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
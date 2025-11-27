class Aluno{
    private String nome;
    private long matricula;

    public Aluno(String nome,long matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public String listaraluno(){
        return "Aluno: "+nome+"\n"+"Matrícula: "+matricula;
    }

}

public class Turma {
    private Aluno[] lista;
    private int qtd;
    private String disciplina;
    private double periodo;

    public Turma(String disciplina,double periodo){
        lista = new Aluno[100];
        qtd = 0;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }
    public void listarTurma(){
        if(qtd == 0){
            IO.println("Turma vazia, adicione alunos");
        }else{
            IO.println("\nDisciplina: "+disciplina+"\nPeríodo: "+periodo);
            for(int i =0;i<qtd;i++){
                IO.println(lista[i].listaraluno());
            }
        }
    }
    public void addaluno(Aluno a){
        if(lista.length>qtd){
            lista[qtd]= a;
            qtd++;
            IO.println("Aluno adicionado");
        }else{
            IO.println("Turma está cheia, não é possível adicionar alunos");
        }
    }

    public static void main(String[] args){
        String disc = IO.readln("Digite a disciplina: ");
        double per = Double.parseDouble(IO.readln("Digite o período: "));
        Turma resultado = new Turma(disc,per);
        while(true){
            IO.println("\n------ESCOLHA UMA OPÇÃO PARA AVANÇAR-------");
            int opcao = Integer.parseInt(IO.readln("\nDigite 0 para sair, 1 para listar turma ou 2 para adicionar aluno: \n"));
            if(opcao == 0){
                IO.println("Saindo do programa...");
                break;
            }else if(opcao == 1){
                resultado.listarTurma();
            }else if(opcao == 2){
                String nom = IO.readln("Digite um nome: ");
                long matr = Long.parseLong(IO.readln("Digite a matrícula: "));
                Aluno a = new Aluno(nom,matr);
                resultado.addaluno(a);
            }else{
                IO.println("Número inválido, digite 0, 1 ou 2");
        }
        }
    }
}

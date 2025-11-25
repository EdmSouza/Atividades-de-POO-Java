public class Q1 {
    private int qntAlunos;
    private int qntLivros;

    public Q1(int qntAlunos, int qntLivros) {
        this.qntAlunos = qntAlunos;
        this.qntLivros = qntLivros;
    }// Método que calcula livros por aluno (arredondado de 0.5 cima e baixo)
    public double calcularLivrosPorAluno() {
        double resultado = (double) qntAlunos / qntLivros;
        return Math.round(resultado);
    }
    public String determinarConceito() {
        double livPorAluno = calcularLivrosPorAluno();
        if (livPorAluno <= 8) {
            return "CONCEITO A";
        } else if (livPorAluno >= 9 && livPorAluno <= 12) {
            return "CONCEITO B";
        } else if (livPorAluno >= 13 && livPorAluno <= 18) {
            return "CONCEITO C";
        } else {
            return "CONCEITO D";
        }
    } public void exibirResultado() {
        IO.println("O conceito do curso é: " + determinarConceito());
    }
    public static void main(String[] args) {
        int alunos = Integer.parseInt(IO.readln("Qual a quantidade de alunos do curso? __"));
        int livros = Integer.parseInt(IO.readln("Qual a quantidade de livros do curso? __"));
        Q1 curso = new Q1(alunos, livros);
        curso.exibirResultado();
    }
}

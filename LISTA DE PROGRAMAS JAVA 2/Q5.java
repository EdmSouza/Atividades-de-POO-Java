public class Q5{
    private int diaAtual;
    private int mesAtual;
    private int anoAtual;

    // Construtor
    public Q5(int dia, int mes, int ano) {
        this.diaAtual = dia;
        this.mesAtual = mes;
        this.anoAtual = ano;
    }

    // Verifica se o ano é bissexto
    public boolean ehBissexto(int ano) {
        return (ano % 4==0 && ano %100 != 0) || (ano% 400 == 0);
    }

    // Retorna o número de dias de um mês específico
    public int diasDoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return ehBissexto(ano) ? 29 : 28;
            default:
                return 0;
        }
    } public int diasDesdeInicioDoAno(int dia, int mes, int ano) {
        int total = 0;
        for (int m = 1; m < mes; m++) {
            total += diasDoMes(m, ano);
        }
        total += dia;
        return total;
    }
    public int totalDiasDoAno(int ano) {
        return ehBissexto(ano) ? 366 : 365;
    }

    // Método principal de cálculo
    public int diasParaSaoJoao() {
        int diaSaoJoao = 24;
        int mesSaoJoao = 6;

        // Se ainda não chegou o São João deste ano
        if (mesAtual < mesSaoJoao || (mesAtual == mesSaoJoao && diaAtual <= diaSaoJoao)) {
            int diasHoje = diasDesdeInicioDoAno(diaAtual, mesAtual, anoAtual);
            int diasSaoJoao = diasDesdeInicioDoAno(diaSaoJoao, mesSaoJoao, anoAtual);
            return diasSaoJoao - diasHoje;
        }else{
            int diasRestantesAnoAtual = totalDiasDoAno(anoAtual) - diasDesdeInicioDoAno(diaAtual, mesAtual, anoAtual);
            int diasAteSaoJoaoProxAno = diasDesdeInicioDoAno(diaSaoJoao, mesSaoJoao, anoAtual+1);
            return diasRestantesAnoAtual + diasAteSaoJoaoProxAno;
        }
    } public void exibirResultado() {
        int faltam = diasParaSaoJoao();
        System.out.println("Faltam " + faltam + " dias para o próximo São João!");
    }
    public static void main(String[] args) {
        int dia = Integer.parseInt(IO.readln("Digite o dia atual: "));
        int mes = Integer.parseInt(IO.readln("Digite o mês atual: "));
        int ano = Integer.parseInt(IO.readln("Digite o ano atual: "));
        Q5 calc = new Q5(dia, mes, ano);
        calc.exibirResultado();
    }
}

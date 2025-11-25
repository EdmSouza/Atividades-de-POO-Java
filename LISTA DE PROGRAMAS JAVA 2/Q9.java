public class Q9 {
    private int mes;

    public Q9(int mes){
    this.mes = mes;
    } public boolean mesinvalido(){
        if(mes > 12 || mes <1){
            return true;
        } else{
            return false;
        }
    } public String converter(){
        if(mesinvalido() == true){
            return "Digite um mes válido, de 1 a 12."; //quando usa return n precisar usar o comando de imprimir na tela
        }
        String mesf = switch(mes){
            case 1 -> "Janeiro";
            case 2 -> "Fevereiro";
            case 3 -> "Março";
            case 4 -> "Abril";
            case 5 -> "Maio";
            case 6 -> "Junho";
            case 7 -> "Julho";
            case 8 -> "Agosto";
            case 9 -> "Setembro";
            case 10 -> "Outubro";
            case 11 -> "Novembro";
            case 12 -> "Dezembro";
            default -> "Erro, tente novamente";
        }; return mesf;
    } public static void main(String[] args){
        int mes = Integer.parseInt(IO.readln("Digite o número do mes correspondente: ___"));//Garante que mesmo digitando qualquer coisa haverá a conversao para inteiro
        Q9 conversao = new Q9(mes);
        String resultado = conversao.converter();
        if(conversao.mesinvalido() == false){
            IO.println("O mes correspondente é: ___"+resultado);
        }else {
            IO.println(resultado);
        }
    }
}


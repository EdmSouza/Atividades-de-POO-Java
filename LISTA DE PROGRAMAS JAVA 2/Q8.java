public class Q8 {
    private int mes;
    private int ano;

public Q8(int mes, int ano){
    this.mes = mes;
    this.ano = ano;
    } public int calculardias(){
        int dias = switch(mes){
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> ehbissexto(ano) ? 29 : 28;
            default -> 0;
        }; return dias;
    } public boolean ehbissexto(int ano){
        if((ano%4 == 0 && ano % 100 != 0) || ano%400 == 0){
            return true;
        }else{
            return false;
        }
    } public void resultado(){
        int total = calculardias();
        IO.println("O número de dias desse mes é: ___"+total);
    } public static void main(String[] args){
        int mes = Integer.parseInt(IO.readln("Digite o numero do mes: ___"));
        int ano = Integer.parseInt(IO.readln("Digite o ano correspondente: ___"));
        Q8 alocar = new Q8(mes,ano);
        alocar.resultado();
    }

}

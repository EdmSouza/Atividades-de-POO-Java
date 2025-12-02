public class Bissexto {
    public static void main(String[] args) {
        int mes = Integer.parseInt(IO.readln("Digite um mes:"));
        int ano = Integer.parseInt(IO.readln("Digite um ano:"));

        int[] diadomes = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dias = diadomes[mes-1];

        if (mes>12 || mes <1){
            IO.println("Mes inválido, digite um mes entre 1 a 12");
            return;
        }if(mes ==2 && ((ano%4 == 0 && ano%100 != 0 ) || (ano%400 == 0))){
            dias++;
        }IO.println("O mes "+mes+" do ano "+ano+" tem "+dias+" dias");
    }
}
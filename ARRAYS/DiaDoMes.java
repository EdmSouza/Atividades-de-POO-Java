
public class DiaDoMes {
    private int mes;
    private int ano;
    private int[] diaspormes = {31,28,31,30,31,30,31,31,30,31,30,31};

    public DiaDoMes(int mes,int ano){
        this.mes = mes;
        this.ano = ano;
    }
    public boolean ehbissexto(){
        if((this.ano%4 == 0 && this.ano%100 != 0)||(this.ano%400 == 0)){
            return true;
        }else{
            return false;
        }
    }
    public int getQntdDias(){
        if(this.mes == 2 && ehbissexto() == true){
            return 29;
        }
        else{
            return diaspormes[this.mes-1];
        }
    }
    
    public static void main(String[] args){
        while(true){
            int n = Integer.parseInt(IO.readln("\n-------------Digite '0' caso queira sair do programa, ou qualquer número para avançar-----------\n\n"));
            if(n==0){
                break;
            }
            int mesf = Integer.parseInt(IO.readln("\nDigite um mês(entre 1 e 12): "));
            if(mesf>=1 && mesf<=12){
                int anof = Integer.parseInt(IO.readln("Digite um ano: "));
                DiaDoMes resultado = new DiaDoMes(mesf,anof);
                IO.println("\nO mes: "+mesf+ ", do ano de: "+anof+ ", tem: "+resultado.getQntdDias()+" dias");
            }else{
                IO.println("\nO mes digitado é inválido, digite um número entre 1 e 12 para meses");
        }
    }
}
}

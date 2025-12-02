public class Qtdposit {
    private int cont;


    public Qtdposit(){
        cont = 0;
    }

    public void calcularpos(){
        for(int i = 0;;i++){
            int num = Integer.parseInt(IO.readln("Digite um número inteiro ou 0 para encerrar o programa: "));
            if(num>0){
                cont++;
            }else if(num==0){
                IO.println("\nA quantidade de números inteiros positivos é: "+cont);
                break;
            }
        }
    }


    public static void main(String[] args){
        int opcao = Integer.parseInt(IO.readln("Digite qualquer número inteiro para avançar ou 0 para sair: "));
        if(opcao == 0){
            IO.println("Saindo...");
        }else{
            Qtdposit resultado = new Qtdposit();
            resultado.calcularpos();
        }
    }
}

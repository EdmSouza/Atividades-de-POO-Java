
public class SeqInteiros {
    private int num;



    public SeqInteiros(){

    }


    public void seqdenumeros(){
        int soma = 0;
        while(true){
            num = Integer.parseInt(IO.readln(" "));
            soma += num;
            if(num == 0){
                break;
            }
        }resultadof(soma);
    }

    public void resultadof(int soma){
        int resultado = soma;
        IO.println("A soma dos números digitados é: "+resultado);
    }


    public static void main(String[] args){
        SeqInteiros calculo = new SeqInteiros();
        calculo.seqdenumeros();
    }

}

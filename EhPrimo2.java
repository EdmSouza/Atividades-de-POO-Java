public class EhPrimo2 {
    private int num;
    private boolean ehprimo;


    public EhPrimo2(int num){
        this.num = num;
        this.ehprimo = true;
    }

    public void verificaprimo(){
        int cont = 3;
        if(this.num<2 || this.num%2 == 0){
            ehprimo = false;
        }
        else if(num>2 && num%2 != 0){
            while(cont<=Math.sqrt(num)){
                if(num%cont==0){
                    ehprimo = false;
                    break;
                }cont+=2;
            }
        }resultado();
    }

    public void resultado(){
        if(num == 2 || ehprimo == true){
            IO.println("O número "+this.num+" é primo");
        }
    }

    public static void main(String[] args){
        int numero = Integer.parseInt(IO.readln("Digite um número: "));
        EhPrimo2 calculo = new EhPrimo2(numero);
        calculo.verificaprimo();
    }
}

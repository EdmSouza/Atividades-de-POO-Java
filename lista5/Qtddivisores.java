public class Qtddivisores {
    private int cont;


    public Qtddivisores(){
        cont = 0;
    }

    public void calculardiv(){
        int num = Integer.parseInt(IO.readln("Digite um número inteiro ou 0 para encerrar o programa: "));
        cont = 0;                   /*aqui eu garanto que caso eu instancie esse mesmo objeto com outro número em algum momento, */
        for(int i = 1;i<=num;i++){  /*ele nao some com o const utilizado anteriormente */
            if(num%i == 0){
                cont++;
            }
        }IO.println("\nA quantidade de números inteiros divisores de "+num+" é: "+cont);
    }

    public static void main(String[] args){
            Qtddivisores resultado = new Qtddivisores();
            resultado.calculardiv();
    }
}
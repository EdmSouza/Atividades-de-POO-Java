public class EhPrimo {
    private int num;
    private boolean primo;


    public EhPrimo(){
    }


    public void verificarprimo(){
        this.primo = true;
        num = Integer.parseInt(IO.readln("Digite um número: "));
        int i = 2;
        while(i<num){
            if(num%i == 0){
                primo = false;
                break; // aqui encerra o looping quando encontra um divisor inteiro, só que o break so quebra o laço, o método ainda roda e leva ate o outro método
            }else{
                i++; // intera com i +1 para continuar dividindo
            }
        }imprimirresultado(); // termina o laço e chama o método
    }


    public void imprimirresultado(){
        if(primo == true && num>=2){ // já considera os negativos e o menor numero primo que tem, o 2
            IO.println("O número "+num+" é primo");
        }
    }


    public static void main(String[] args){
        EhPrimo resultado = new EhPrimo();
        resultado.verificarprimo();
    }
}

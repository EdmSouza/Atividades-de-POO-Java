public class SomadeInteiros {
    private int num;
    private int soma = 0;


    public SomadeInteiros(){
    }


    public void loop(){
        IO.println("Digite um número, caso queira encerrar o programa digite 0\n");
        while(true){
            num = Integer.parseInt(IO.readln(""));
            if(num==0){
                IO.println("Encerrando...\n");
                IO.println("A soma dos números digitados é: "+soma);
                break;
            }else{
                somatorio(num);
            }
        }
    }

    private void somatorio(int num){
        this.soma = num + this.soma;
    }


    public static void main(String[] args){
        SomadeInteiros resultado = new SomadeInteiros();
        resultado.loop();
    }
}

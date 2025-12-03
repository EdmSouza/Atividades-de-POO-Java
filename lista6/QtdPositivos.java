public class QtdPositivos {
    private int num;
    private int qtd;



    public  QtdPositivos(){

    }


    public void loop(){
        this.qtd =0;
        IO.println("Digite um número para avançar ou 0 para encerrar:\n");
        while(true){
            num = Integer.parseInt(IO.readln(""));
            if(num == 0){
                IO.println("Encerrando...\n");
                IO.println("A quantidade de números positivos é: "+qtd);
                break;
            }else if(num>0){
                this.qtd++;
            }
        }
    }


    public static void main(String[] args){
        QtdPositivos resultado = new QtdPositivos();
        resultado.loop();
    }


}

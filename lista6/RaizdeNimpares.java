public class RaizdeNimpares {
    private int num;
    private int ctd;


    public RaizdeNimpares(int num){
        this.num = num;
    }


    public void calculoRaiz(){
        int temp = num;
        this.ctd=0;
        int i=1;
        while(true){
            temp = temp-i;
            if(temp>=0){
                ctd++;
                i+=2;
            }else{
                break;
            }
        }imprimir();
    }
    

    public void imprimir(){
        IO.println("A raíz inteira de "+num+" é: "+ctd);
    }


    public static void main(String[] args){
        int n = Integer.parseInt(IO.readln("Digite um número inteiro: "));
        RaizdeNimpares resposta = new RaizdeNimpares(n);
        resposta.calculoRaiz();
    }
}

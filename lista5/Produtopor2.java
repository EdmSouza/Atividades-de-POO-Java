import java.util.ArrayList;

public class Produtopor2{

    public Produtopor2(){
    }

    public void imprimirdobrado(){
        ArrayList<Integer> numeros = new ArrayList<>();
        while(true){
            int n = Integer.parseInt(IO.readln("Digite um número inteiro ou 0 para encerrar: "));
            if(n == 0){
                break;
            }else{
                numeros.add(n*2);
            }
        }IO.println("A lista com elementos numéricos dobrados é: ");
        for(int i=0;i<=numeros.size()-1;i++){
            IO.println("{"+numeros.get(i)+"}");
        }
    }

    public static void main(String[] args){
            Produtopor2 resultadof = new Produtopor2();
            resultadof.imprimirdobrado();
    }
}
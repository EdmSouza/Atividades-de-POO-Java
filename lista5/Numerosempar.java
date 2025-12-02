import java.util.ArrayList;

public class Numerosempar{

    public Numerosempar(){
    }

    public void imprimirindicespares(){
        ArrayList<Integer> numeros = new ArrayList<>();
        while(true){
            int n = Integer.parseInt(IO.readln("Digite um número inteiro ou 0 para encerrar: "));
            if(n == 0){
                break;
            }else{
                numeros.add(n);
            }
        }IO.println("A lista em posições pares é: ");
        for(int i=0;i<=numeros.size()-1;i=i+2){
            IO.println(numeros.get(i));
        }
    }

    public static void main(String[] args){
            Numerosempar resultadof = new Numerosempar();
            resultadof.imprimirindicespares();
    }
}
import java.util.ArrayList;

public class Ninteiros {

    public Ninteiros(){
    }

    public void imprimirinverso(){
        ArrayList<Integer> numeros = new ArrayList<>();
        while(true){
            int n = Integer.parseInt(IO.readln("Digite um número inteiro ou 0 para encerrar: "));
            if(n == 0){
                break;
            }else{
                numeros.add(n);
            }
        }IO.println("A lista invertida é: ");
        for(int i = numeros.size()-1;i>=0;i--){
            IO.println(numeros.get(i));
        }
    }

    public static void main(String[] args){
            Ninteiros resultadof = new Ninteiros();
            resultadof.imprimirinverso();
    }
}

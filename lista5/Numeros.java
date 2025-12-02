
import java.util.ArrayList;

public class Numeros {
    private int num;


    public Numeros(int num){
        this.num = num;
    }

    public void nNumeros(){
        ArrayList<Integer> atenegativo = new ArrayList<>();
        for(int i = num; i>=num*(-1);i--){
            atenegativo.add(i);
        }IO.println(atenegativo);
    }


    public static void main(String[] args){
        while(true){
            int n= Integer.parseInt(IO.readln("Digite um número n inteiro positivo: "));
            Numeros resultado = new Numeros(n);
            if(n>0){
                IO.println("A lista dos m números inteiros de n até -n é: ");
                resultado.nNumeros();
                break;
            }else{
                IO.println("Digite um número n inteiro positivo.");
        }
        }
    }
}

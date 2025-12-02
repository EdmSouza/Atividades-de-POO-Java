import java.util.ArrayList;

public class Multiplo {
    private int num1;
    private int num2;

    
    public Multiplo(int num1, int num2){
        this.num1 =num1;
        this.num2 = num2;

    }

    public void operacao(){
        ArrayList<Integer> mult = new ArrayList<>();
        if(num1>=num2){
            for(int i = num2;i<=num1;i++){
                if(i%5 == 0){
                    mult.add(i);
                }
            }
        }else{
            for(int i = num1;i<=num2;i++){
                if(i%5 == 0){
                    mult.add(i);
                }
        }
    }IO.println(mult);
}

    public static void main(String[] args){
        int n1= Integer.parseInt(IO.readln("Digite um número: "));
        int n2= Integer.parseInt(IO.readln("Digite outro número: "));
        Multiplo resultado = new Multiplo(n1,n2);
        IO.println("Os números mutiplos de 5, entre "+n1+" e "+n2+", são: ");
        resultado.operacao();
    }
}

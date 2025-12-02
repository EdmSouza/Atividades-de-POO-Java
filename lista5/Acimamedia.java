import java.util.ArrayList;

public class Acimamedia {
    private int cont;


    public Acimamedia(){
        cont = 0;
    }


    public void media(){
        ArrayList<Double> nums = new ArrayList<>();
        for(int i=0;;i++){
            double n = Double.parseDouble(IO.readln("Digite um número: "));
            nums.add(n);
            double ter = Double.parseDouble(IO.readln("Digite 0 caso queira encerrar o programa: "));
            if(ter == 0){
                break;
            }else{
                nums.add(ter);
            }
        }
        double soma =0;
        for(double numero : nums){
                soma += numero;
        }double mediaf = soma/nums.size();
        for(double numero : nums){
            if(numero>mediaf){
                cont++;
            }
        }IO.println("Quantidade acima da média: "+cont);
    }


    public static void main(String[] args){
        Acimamedia resultado = new Acimamedia();
        resultado.media();
    }
}


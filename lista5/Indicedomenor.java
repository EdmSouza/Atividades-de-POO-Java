import java.util.ArrayList;

public class Indicedomenor {
    private ArrayList<Double> num;


    public Indicedomenor(){
        num = new ArrayList<>();
        
    }

    public void menor(){
        for(int i=0;;i++){
            double n = Double.parseDouble(IO.readln("Digite um número: "));
            num.add(n);
            String encerrar = IO.readln("Digite ENCERRAR, caso queria terminar o laço ou clique Enter para continuar: \n");
            if(encerrar.equals("ENCERRAR")){
                break;
            }
        }if(num.isEmpty()){
            IO.println("Lista vazia");
        }else{
            double menor = num.get(0);
            for(int i =0;i<num.size();i++){
            if(menor>num.get(i)){
                menor = num.get(i);
            }
        }IO.println("O menor número está na posiçao: "+num.indexOf(menor));
        }
    }


    public static void main(String[] args){
        Indicedomenor resultado = new Indicedomenor();
        resultado.menor();
    }

}

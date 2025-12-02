import java.util.ArrayList;

public class Fila {
    private ArrayList<String> fila;


    public Fila(){
        fila = new ArrayList<>();
    }

    public void addfila(){
        for(int i = 0;;i++){
            String n = IO.readln("Adicione alguém a fila, caso queira encerrar a fila digite: ENCERRAR\nCaso queira chamar alguém da FILA, digite: CHAMAR\n");
            if(n.equals("ENCERRAR")){
                IO.println("Sobrou na fila: "+fila);
                break;
            }else if(n.equals("CHAMAR")){
                chamarfila();
            }
            else{
                fila.add(n);
                IO.println("Fila: "+fila);
            }
        }
    }
    
    public void chamarfila(){
        if(fila.isEmpty()){
            IO.println("Fila vazia");
        }else{
            IO.println("Chamando: "+fila.get(0));
            fila.remove(0);
            IO.println("Resto da fila: "+fila);
        }
    }


    public static void main(String[] args){
        int opcao = Integer.parseInt(IO.readln("Digite qualquer número para ir a fila ou 0 para encerrar o programa: "));
        if(opcao == 0){
            IO.println("Encerrando o programa...");
        }else{
            Fila resultado = new Fila();
            int opcao2 = Integer.parseInt(IO.readln("Comece a fila, para adicionar alguém digite 0: "));
            if(opcao2 == 0){
                resultado.addfila();
            }else{
                IO.println("Número inválido");
            }
        }
    }
}

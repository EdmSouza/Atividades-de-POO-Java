public class Pilha {
    private int elemtopo;
    private int[] pilha;
    private int qtd;


    public Pilha(int elemtopo, int qtd){
        qtd = 0;
        elemtopo = -1;
        pilha = new int[100];
    }

    public void desempilhar(){
        if(qtd == 0){
            IO.println("Pilha está vazia, não é possível desempilhar.");
        }else{
            elemtopo--;
            qtd--;
        }
    }

    public void empilhar(int elemt){
        if(pilha.length()<(qtd -1)){
            elemtopo++;
            pilha[elemtopo] = elemt;
            qtd++;
        }else{
            IO.println("A pilha está cheia, não é possível empilhar");
        }
    }

    public void showpilha(){
        IO.println(pilha[elemtopo]);
    }


    public static void main(String[] args){
        Pilha main = new Pilha()
    }

}

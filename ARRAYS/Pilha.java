public class Pilha {
    private int elemtopo;
    private int[] pilha;
    private int qtd;


    public Pilha(){
        qtd = 0;
        elemtopo = -1;
        pilha = new int[100];
    }

    public int desempilhar(){
        if(qtd == 0){
            IO.println("A pilha está vazia, não é possível desempilhar.\n");
            return -1;
        }else{
            int valordesempilhado = pilha[elemtopo];
            elemtopo--;
            qtd--;
            IO.println("O elemento foi desempilhado com sucesso!\n");
            return valordesempilhado;
        }
    }

    public void empilhar(int elemt){
        if(pilha.length>qtd){
            elemtopo++;
            pilha[elemtopo] = elemt;
            qtd++;
            IO.println("O número: "+elemt+" foi empilhado com sucesso!\n");
        }else{
            IO.println("A pilha está cheia, não é possível empilhar.\n");
        }
    }

    public void showpilha(){
        if(qtd == 0){
            IO.println("A pilha está vazia, adicione algum número inteiro primeiro.");
        }else{
            IO.println("\nO(s) elemento(s) da pilha é(são): \n");
            for(int i = qtd-1; i>=0;i--){
                IO.println("["+pilha[i]+"]"+"");
        }
    }
    }


    public static void main(String[] args){
        Pilha main = new Pilha();
        while(true){
            IO.println("\n---PROGRAMA DE PILHA---\n");
            int opcao = Integer.parseInt(IO.readln("Digite 1 para emplihar, 2 para desempilhar ou 3 para mostrar a pilha.\nCaso queira encerrar o programa, digite 0.\n\n"));
            if(opcao == 1){
                int elemt = Integer.parseInt(IO.readln("\n*****Digite um número inteiro para empilhar*****\n"));
                main.empilhar(elemt);
                }else if(opcao == 2){
                    int num = main.desempilhar();
                    if(num != -1){
                        IO.println("Você removeu o número: "+num);
                    }else{
                        IO.println("");
                    }
                }else if(opcao == 3){
                    main.showpilha();
                }else if(opcao == 0){
                    IO.println("\nEncerrando o programa...");
                    break;
                }else{
                    IO.println("Digite um número válido");
                }
            }
        }
    }

import java.util.Arrays;

class Contato{
    private String nome; //aqui eu tenho atributos privados, para ser acessado por outra classe eu preciso de um método que faça
    private String numero; //a intermediaçao, os getters e setters


    public Contato(String nome, String numero){
        this.nome = nome; // eu crio um contato exigindo que ele tenha um numero e um nome
        this.numero = numero;
    }


    public void listarctt(){ //aqui é como printar um contato
        IO.println(nome+": "+numero);
    }

    public String getnome(){
        return nome;
    }

    public String getnumero(){
        return numero;
    }

    public void setnumero(String numero){
        this.numero = numero;
    }

}


public class ListadeContatos { //crio uma outra classe que controle o estado da lista de contatos
    private Contato[] listadecontatos; // aqui eu defino um array composto por elementos de Contato
    private int contador; //por aqui eu sei quantos contatos tem a lista

    public ListadeContatos(){
        listadecontatos = new Contato[10];
        this.contador = 0;
    }


    public void addcttnaLista(String n, String num){
        for(int i =0; i<contador;i++){
            if(listadecontatos[i].getnome().equals(n)){
                IO.println("Contato já existente!");
                return;
            }
        }//para adicionar contato o metodo precisa receber esse contato e armazenar na lista, mas nao posso adicionar um contato igual a outro ja existente
        if(contador>= listadecontatos.length){ //sabendo que o contador está no limite do tamanho do array eu sei q ele esta cheio
            listacheia();
        }
        Contato newcontato = new Contato(n, num);
        listadecontatos[contador] = newcontato;
        contador++;
        }

    public void listacheia(){
        int tamanho = contador +1; //com esse método, sempre que o array estiver cheio ele automaticamente abre mais um espaço para adicionar outro contato
        listadecontatos = Arrays.copyOf(listadecontatos, tamanho); // crio uma copia do array anterior e aumento 1 no tamanho
    }

    public void consultarlista(String nome){
        boolean ctt = false;
        int i = 0;
        while(i<=contador){ //pra eu consultar algum contato na lista eu preciso percorrer o array de contatos
            if(listadecontatos[i].getnome().equals(nome)){ // como o array é de Strings, sabendo que uma String é um tipo de dado que
                listadecontatos[i].listarctt(); //ao eu atribuir algo estou comparando para onde o objeto aponta, eu preciso entao de um
                ctt = true; //método especifico(equals) para comparar
                break;
            }
            else if(ctt == false){
                i++;
            }
        }IO.println("Contato não encontrado");
    }

    public void alterarctt(String name){
        int x = 0;
        boolean numalte = false;
        while(x<=listadecontatos.length-1){ //mesma logica so que eu chamo o metodo set para alterar o nume que corresponde ao nome dado
            if(listadecontatos[x].getnome().equals(name)){
                String numr = IO.readln("Digite um número: ");
                listadecontatos[x].setnumero(numr);
                IO.println("Numero alterado");
                numalte = true;
                return;
            }else if(numalte == false){ //preciso percorrer a lista toda
                x++;
            }
        }IO.println("Contato nao encontrado");
    }

    public void removertctt(String nom){
        int i =0;
        while(i<contador){
            if(listadecontatos[i].getnome().equals(nom)){
                for (int j = i; j < contador - 1; j++) {
                    listadecontatos[j] = listadecontatos[j+1];
            }
            listadecontatos[contador - 1] = null; // Limpa o último
            contador--; // Diminui o total
            IO.println("Removido com sucesso");
            return;
        } i++;
    }
}
}

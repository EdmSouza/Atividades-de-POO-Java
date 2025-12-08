class Contato{
    private long numero;
    private String nome;


    public Contato(long numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    public long getNumber(){
        return this.numero;
    }

    public String getName(){
        return this.nome;
    }

    public void setNumber(long numero){
        this.numero = numero;
    }

    public void visualizarctt(long numero, String nome){
        IO.println("Nome: "+nome+"| Número: "+numero);
    }
}



public class Contatos {
    private Contato[] contatos;
    private int tamanho;


    public Contatos(){
        contatos = new Contato[100];
        this.tamanho = 0;
    }


    public void addcontato(String nome, long numero){
        if(tamanho == contatos.length-1){
            Contato[] novalistactt = new Contato[tamanho*2];
            for(int i = 0; i<tamanho ;i++){
                novalistactt[i] = contatos[i];
            }novalistactt = contatos;
            tamanho*=2;
        }else{
            for(int i = 0; i<tamanho; i++){
                if(contatos[i].getName().equals(nome)){
                    contatoexistente();
                    break;
                }else{
                    Contato ctt = new Contato(numero, nome);
                    this.tamanho++;
                    break;
                }
            }
        }
    }

    public void contatoexistente(){
        IO.println("Contato já existente");
    }

    public void removerctt(String nome, long numero){
        for(int i = 0; i<tamanho; i++){
            if(contatos[i].getName().equals(nome) && tamanho != 0){
                Contato[] newlista = new Contato[tamanho-1];
                for(int j = 0; j<i; j++){
                    newlista[j] = contatos[i];
                }
                for(int k = i+1; k < tamanho; k++){
                    newlista[k-1] = contatos[k];
                }tamanho-=1;
                newlista = contatos;
                break;
                }
                else{
                    cttnaoexistente();
                    break;
            }
        }
    }

    public void cttnaoexistente(){
        IO.println("Contato não existente");
    }

    public void listarcontatos(){
        for(int i =0; i<tamanho; i++){
            IO.println(contatos[i]);
        }
    }

    public void atualizarctt(String nome, long numero){
        Contato[] novalista = new Contato[tamanho];
        for(int i = 0; i < tamanho; i++){
            if(contatos[i].getName().equals(nome)){
                novalista[i] = contatos[i];
                novalista[i].setNumber(numero);
            }novalista = contatos;
            break;
        }
    }

    public void consultarcontato(String nome){
        for(int i = 0; i<tamanho; i++){
            if(contatos[i].getName().equals(nome)){
                IO.println(contatos[i]);
            }
        }
    }
}



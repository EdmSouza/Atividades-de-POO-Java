class Topico{
    private String dia;
    private String mes;
    private String ano;
    private String titulo;
    private String assunto;

    public Topico(String dia,String mes,String ano, String titulo,String assunto){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.titulo = titulo;
        this.assunto = assunto;
    }
    public String listartopico(){
        return dia+"/"+mes+"/"+ano+"\n"+titulo+"\n"+assunto;
        }
}public class Topicos{
    private Topico[] lista;
    private int qtd;

    public Topicos(){
        lista = new Topico[100];
        qtd = 0;
    }

    public void listartop(){
        if(qtd == 0){
            IO.println("A lista está vazia, adicione algum tópico");
        }else{
            for(int i=0;i<qtd;i++){
                IO.println(lista[i].listartopico());
            }
        }
    }
    public void addtopicos(Topico t){
        if(lista.length>qtd){
            lista[qtd] = t;
            qtd++;
        }else{
            IO.println("Lista cheia, nao é possível adicionar tópicos");
        }
    }
    public static void main(String[] args){
        Topicos resultado = new Topicos();
        IO.println("----Escolha um programa--------");
        int opcao= Integer.parseInt(IO.readln("Digite 1 caso queira adicionar um novo tópico, ou 0 para listar os tópicos"));
        if(opcao == 1){
            String diaf =IO.readln("Digite um dia: ");
            String mesf =IO.readln("Digite um mes: ");
            String anof =IO.readln("Digite um ano: ");
            String tit =IO.readln("Digite um título: ");
            String ass =IO.readln("Digite um assunto: ");
            Topico t = new Topico(diaf,mesf,anof,tit,ass);
            resultado.addtopicos(t);
        }else if(opcao ==0){
            resultado.listartop();
        }else{
            IO.println("Digite um número válido, 0 ou 1");
        }
    }
}

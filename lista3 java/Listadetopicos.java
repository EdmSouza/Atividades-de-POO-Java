class Topico {
    private int dia;
    private int mes;
    private int ano;
    private String assunto;
    private String titulo;

    public Topico(int dia,int mes,int ano,String assunto,String titulo) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.assunto = assunto;
        this.titulo = titulo;
    }
    public String listartopicos(){
        return "Tópico: " + titulo+ "Data: "+dia+"/"+mes+"/"+ano+" Assunto: "+assunto;
    }
} public class Listadetopicos{
    private Topico[] lista;
    private int qtd;

    public Listadetopicos(){
        lista = new Topico[100];
        qtd = 0;
    }
    public void addtopico(Topico t){
        if(qtd < lista.length){
            lista[qtd] = t;
            qtd++;
        }else{
            IO.println("Lista cheia");
        }
    }
    public void listartudo(){
        if(qtd == 0){
            IO.println("Lista vazia");
        } else{
            for(int i=0;i<qtd;i++){
                IO.println(lista[i].listartopicos());
            }
        }
    }
    public static void main(String[] args){
        Listadetopicos sistema = new Listadetopicos();
        while(true){
            int r1 = Integer.parseInt(IO.readln("DIGITE 1 OU 2 PARA CONTINUAR, OU QUALQUER NÚMERO PARA SAIR.\n1-Adicionar um tópico\n2-Listar os tópicos\n"));
            if(r1 == 1){
                int dia = Integer.parseInt(IO.readln("Digite um dia:__"));
                int mes = Integer.parseInt(IO.readln("Digite um mes:__"));
                int ano = Integer.parseInt(IO.readln("Digite um ano:__"));
                String assunto = IO.readln("Qual o assunto?___");
                String titulo = IO.readln("Qual o título?__");
                Topico t = new Topico(dia, mes, ano, assunto, titulo);
                sistema.addtopico(t);
            }else if(r1 == 2){
                sistema.listartudo();
            }else{
                break;
        }
        }
    }
}
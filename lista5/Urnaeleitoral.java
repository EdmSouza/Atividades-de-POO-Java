import java.util.ArrayList;

class RegistroCandidatos{
    public String nome;
    public ArrayList<String> candidatos = new ArrayList<>();


    public RegistroCandidatos(){
        this.nome = nome;
    }

    public void registrar(){
        for(int i=1;;i++){
            nome = IO.readln("Digite seu nome: ");
            candidatos.add(nome);
            String encerrar= IO.readln("Digite 'ENCERRAR' para encerrar");
            if(encerrar.equals("ENCERRAR")){
                break;
            }
        }
    }
}

public class Urnaeleitoral {
    private int nulo;
    private int branco;
    private ArrayList<String> listacand;
    private ArrayList<Integer> listadevotos;


    public Urnaeleitoral(ArrayList<String> candidatos){
        this.nulo = 0;
        this.branco = 0;
        listacand = candidatos;
        listadevotos = new ArrayList<>();
        for(int i = 0;i<listacand.size();i++){
            listadevotos.add(0);
        }
    }

    public void votar(){
        IO.println("---Urna Eletrônica---");
        int num = 0;
        for(int i =0;;i++){
            num = Integer.parseInt(IO.readln("Digite o número do candidato, -1 para encerrar votaçao ou 0 para branco: \nLista de candidatos: "+listacand));
            if(num ==-1){
                break;
            }
            else if(num == 0){
                IO.println("Voto em BRANCO computado.");
                branco++;
            }else if (num > 0 && num <= listacand.size()) {
                // Se digitou 1, pega o índice 0. Se digitou 2, pega índice 1.
                confirmarvot(num);
            }else{
                IO.println("Número inválido! Voto NULO computado.");
                nulo++;
        }
        }
    }

    public void confirmarvot(int num){
        int indice = num - 1;
        String nomeDoCandidato = listacand.get(indice);
        IO.println("Deseja confirmar o voto ao candidato"+nomeDoCandidato+"? \n");
        int opcao = Integer.parseInt(IO.readln("Digite 1 para confirmar voto ou 0 para cancelar: "));
        if(opcao == 1){
            int votosatuais = listadevotos.get(indice);
            listadevotos.set(indice, votosatuais+1);
            confirmar();
        }else if(opcao == 0){
            cancelar();
        }
    }

    public void confirmar(){
        IO.println("Votação concluida! PLIN PLIN\n");
    }

    public void cancelar(){
        IO.println("Votação cancelada\n");
    }

    public void apurarresult(){
        IO.println("A quantidade de votos foi: \n\n");
        for(int i=0; i < listacand.size(); i++) {
            // Imprime Nome (lista 1) + Votos (lista 2)
            IO.println(listacand.get(i) + ": " + listadevotos.get(i) + " votos");
        }
        IO.println("Brancos: " +branco);
        IO.println("Nulos: " +nulo);
    }


    public static void main(String[] args){
        RegistroCandidatos reg = new RegistroCandidatos();
        reg.registrar();

        Urnaeleitoral urna = new Urnaeleitoral(reg.candidatos);
        urna.votar();
        urna.apurarresult();
    }
}

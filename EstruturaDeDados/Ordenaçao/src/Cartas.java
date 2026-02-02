/*
Elabore um método estático que construa o conjunto completo de cartas do baralho. Antes, defina a classe Carta.
Dados um conjunto completo de cartas, um inteiro 1≤ m ≤ 4 e um inteiro 1 ≤ n ≤13, se quer distribuir n cartas para m jogadores. Para isto, defina um método que aceite como argumentos um conjunto completo de cartas cs e os valores de m e n. O método deve embaralhar as cartas de cc e então construir m conjuntos com n cartas cada um, todas pegas do conjunto completo cs. 
Altere o método anterior para que os conjuntos distribuídos permitam iterar em na ordem natural das cartas. A ordem natural é dada pelo número ou letra da carta, assim: primeiro A, depois 2,  3, .., 10, e por último J, Q e K, nessa ordem.
Altere o método anterior considerando que a ordem prioritária será pelo tipo de carta e depois pelo número ou letra. Considere a ordem do tipo de carta é Copas, Ouros, Espadas e, por último, Paus.
Escreva um método main que teste os métodos anteriores.
 */

import java.util.*; //aqui eu sei que a questao se trata de coleçoes, e um baralho e jogadores irao trabalhar com colecoes de cartas

class Cartas implements Comparable<Cartas>{ //defino uma classe estrutural chamado cartas, ela sabe o que é e sabe se definir e diferenciar de outras
    //private int cor; //cada carta tem uma cor, valor e pertence a algum naipe
    private int val;
    private int naipe;


    public Cartas(int val, int naipe){
        this.val = val; //esses valores sao passados ao construtor, pois a questao pede para criarmos uma carta a partir de valores dados pelo usuario
        this.naipe = naipe;
    }

    public int getVal(){ //esses valores serao usados fora da classe cartas
        return val;
    }
    
    public int getNaipe(){
        return naipe;
    }

    @Override //aqui entra a implementaçao da interface comparable, ela ira comparar dois valores, separei eles por valor e naipe para facilitar
    public int compareTo(Cartas outra){
        return Integer.compare(this.val,outra.val); //e aqui ele vai atribuir, comparando em uma lista de String, os valores de int q recebeu
    }

    @Override
    public String toString(){ 
            String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            String[] naipes = {"Copas","Ouros","Espadas","Paus"};
            //String[] cores = {"Vermelho","Preto"};
            return valores[val-1] + " de " + naipes[naipe];// + " na cor " + cores[cor];
    }
}
class Baralho{

    public static List<Cartas> addbaralho(){
        List<Cartas> baralho = new ArrayList<>();
        for(int naipe = 0; naipe<4; naipe++){
            for(int valor = 1; valor<=13; valor++){
                    baralho.add(new Cartas(valor, naipe));
            }
        }return baralho;
    }

    public static List<List<Cartas>> distribuir(List<Cartas> baralho, int m, int n){ //aqui eu fiz o seguinte, o mestre vai distribuir m cartas para n jogadores
        Collections.shuffle(baralho);
        int it = 0; //sabemos que o baralho contem todas as cartas, entao utilizamos o metodo shuffle para embaralhar. Vamos entao agr varrer a lista de cartas embaralhadas, para isso definimos quantos jogadores ira receber as m cartas
        List<List<Cartas>> jogadores = new ArrayList<>(); //para isso, passamos que cada jogador sera uma mao de cartas de certo tipo e valor
        for(int i = 0; i<n; i++){
            List<Cartas> mao = new ArrayList<>(); //criamos entao uma mao que recebera m cartas e entregará essas n cartas um dos m jogadores
            for(int j = 0; j<m; j++){
                mao.add(baralho.get(it));
                it++; //iteramos
            }jogadores.add(mao); //entregamos as cartas a lista de jogadores, como estamos trabalho com list, eles sao indexáveis
        }return jogadores;
    }

    public static List<Set<Cartas>> distribuirOrdemNat(List<Cartas> baralho, int m, int n){ //aqui eu fiz o seguinte, o mestre vai distribuir m cartas para n jogadores
        Collections.shuffle(baralho);
        int it = 0; //sabemos que o baralho contem todas as cartas, entao utilizamos o metodo shuffle para embaralhar. Vamos entao agr varrer a lista de cartas embaralhadas, para isso definimos quantos jogadores ira receber as m cartas
        List<Set<Cartas>> jogadores = new ArrayList<>(); //para isso, passamos que cada jogador sera uma mao de cartas de certo tipo e valor
        for(int i = 0; i<n; i++){
            Set<Cartas> mao = new TreeSet<>(); //criamos entao uma mao que recebera m cartas e entregará essas n cartas um dos m jogadores
            for(int j = 0; j<m; j++){ // percebe que, diferente da de cima, criamos um set, que, através do método TreeSet, ordenará de acordo a ordem com que foi definida, nesse caso, a ordem que foi definida na implementaçao de comparable em Cartas
                mao.add(baralho.get(it));
                it++; //iteramos
            }jogadores.add(mao); //entregamos as cartas a lista de jogadores, como estamos trabalho com list, eles sao indexáveis
        }return jogadores;
    }

}


/*
Elabore um método estático que leia uma sequência de nomes. Os nomes devem ser carregados numa List a qual deve ser retornada como resultado do método.
Elabore um método estático que, dada uma lista de nomes, realize as seguintes impressões:
Imprima os elementos duplicados. A listagem impressa não deve ter duplicados.
Imprima os não duplicados.
Elabore um método estático que, dadas duas listas de nomes calcule os elementos que estão em uma das duas listas mas não estão na outra.
Elabore um método estático que, dada uma lista de nomes, imprima os duplicados. Junto com cada duplicado deverá também imprimir o número de vezes em que aparece duplicado na lista original.
Escreva um método main que teste os métodos anteriores.
*/

import java.util.*;

public class Ordenaçao{ //Defino uma classe qualquer

    public static List<String> listar(String nome){ //implemento um método estático(isto é, uma instancia de classe e nao de obj)
        List<String> lista = new ArrayList<>(); //passo como argumento do método uma String, e por ser um array dinamico a lista expandirá sozinha
        lista.add(nome); //como List é uma interface, e arraylist a implementacao da lista, ela possui metodos abstratos, um deles é o add.
        return lista; //passamos como retorno do método uma lista de Strings
    } //como definimos atraves de uma List, o mesmo permite elementos repetidos, diferente do set

    public static void organizarReptNRept(List<String> lista){ //percebe que eu poderia ter passado um parametro qualquer entre as chaves
        Set<String> listaNd = new HashSet<>(lista); //setei uma lista set que percorra a lista original e add nela oq n tiver duplicados
        IO.println("Não Duplicados: "+listaNd);
        Set<String> listad = new HashSet<>(); //criei 2 listas, uma irá forçar add os elementos da lista original nessa lista de set
        Set<String> analisados = new HashSet<>(); //caso eu nao consiga add, entao esse elemento é duplicado, por lógica, ent add ele em uma lista set de duplicados
        for(int i = 0; i<lista.size(); i++){
            String nome = lista.get(i);
            if(!analisados.add(nome)){
                listad.add(nome);
            }
        }IO.println("Duplicados: "+listad);
    }

    public static void contemElms(List<String> lista1, List<String> lista2){ //precisamos comparar elementos de 2 listas(repetidos ou n)
        Map<String, Integer> cont2 = new HashMap<>(); //defino que essa lista é mapeada por quantidade de vezes que um elemento aparece
        for(int i = 0; i<lista2.size(); i++){ //pego o elemento da lista2 e add nessa nova lista e incremento por sua qntd(caso ja tenha esse elemento)
            String nome = lista2.get(i);
            if(cont2.containsKey(nome)){
                cont2.put(nome, cont2.get(nome)+1);
            }else{
                cont2.put(nome,1);
            }
        }
        List<String> listacomp = new ArrayList<>(); //aqui começa a análise, eu crio uma lista que conta a quantidade e o tipo de elemento que tem na lista1 e nao tem na lista2
        for(int j = 0; j<lista1.size(); j++){
            String nome = lista1.get(j); //pego esse elemento da lista1
            if(cont2.containsKey(nome) && cont2.get(nome) > 0){ //vou agora conferir se ele ja existe na lista2 mais ou igual a 1 vez
                cont2.put(nome, cont2.get(nome)-1); //se existe esse elemento da lista1 em lista2 eu subtraio seu indice de quantidade
            }else{ //caso esse valor seja = 0, isso indica que esse elemento exista so na lista1 ou mais na lista1 que na lista2
                listacomp.add(nome); //entao eu adiciono aqui nessa lista de comparaçao
            }
        }
        IO.println("A quantidade de elementos que tem em uma lista e nao na outra é: "+listacomp.size()); //faz parte do estudo de conjuntos
    }

    public static void duplicEqnt(List<String> lista1){ //o problema exige imprimir somente os duplicados e sua ordem de ocorrencia
        Map<String, Integer> nomes = new HashMap<>(); //isso se resolve com map, associamos a chave nome ao valor de ocorrencia (int)
        for(int i = 0; i<lista1.size(); i++){ //para isso definimos uma string nome que recebe a chave da lista do parametro do metodo
            String nome = lista1.get(i);
            if(nomes.containsKey(nome)){ //tratamos o caso de ja ter sido inserido o valor da chave nessa nova lista
                nomes.put(nome, nomes.get(nome)+1); //se sim, aumentamos a quantidade, pois achamos o duplicado
            }else{
                nomes.put(nome,1); //se nao, entao add pela primeira vez no map
            }
        }Iterator<String> it = nomes.keySet().iterator(); //sabendo que map nao é associado por indice, criamos um iterator
        while(it.hasNext()){ //o iterator ira navegar pela estrutura, se trata de uma interface, dentro dela temos o metodo hasnext
            String nome = it.next(); //ele ira analisar a ultima chave(elemento), e se houver outro elemento, o next ira apontar pra ele
            int qtd = nomes.get(nome); //copiamos o valor atribuido a chave pelo metodo get
            if(qtd>1){ //se essa chave possuir valor>1 ent é pq é repetido, entao printamos o seus valores respectivos
                IO.println("Repetido(a): "+nome +" -> "+ qtd);
            }
        }
    }


    public static void main(String[] args){
        List<String> lista1 = Arrays.asList(
            "Marcos","Ana","Pedro","Ana","Maria","Pedro");
        List<String> lista2 = Arrays.asList(
                "Marcos","Ana","Ana","Pedro");
        organizarReptNRept(lista1);
        contemElms(lista1,lista2);
        duplicEqnt(lista2);
    }
}
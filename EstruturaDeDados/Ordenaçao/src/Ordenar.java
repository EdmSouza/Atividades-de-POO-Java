
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

public class Ordenar{ //Defino uma classe qualquer

    public static List<String> listar(String nome){ //implemento um método estático(isto é, uma instancia de classe e nao de obj)
        List<String> lista = new ArrayList<>(); //passo como argumento do método uma String, e por ser um array dinamico a lista expandirá sozinha
        lista.add(nome); //como List é uma interface, e arraylist a implementacao da lista, ela possui metodos abstratos, um deles é o add.
        return lista; //passamos como retorno do método uma lista de Strings
    } //como definimos atraves de uma List, o mesmo permite elementos repetidos, diferente do set

    public static void organizarReptNRept(List<String> lista){ //percebe que eu poderia ter passado um parametro qualquer entre as chaves
        
    }
}
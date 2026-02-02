import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generics{
    private List<Generics> lista;

    public List<Generics> getLista(){
        return this.lista;
    }

    public static <T extends Comparable<T>> void ordenAsc(List<T> lista){
        Collections.sort(lista);
    }

    //o que fizemos aqui? Definimos um método qualquer, esse método é capaz de receber uma lista, percebe que essa lista ela é generica.
//após isso definimos um método que altera os dados internos dessa lista, isto é, modificando-a até torná-la ordenada ascendentemente
//temos que o metodo sort faz justamente isso

class Verificacao{
    
    public static <T extends Comparable<T>> boolean verificarOdenacao(T[] array){
        //esse método irá receber um array de tipo T, só que definimos q T é comparavel com objetos do seu tipo
        for(int i = 0; i<array.length-1; i++){
            if(array[i].compareTo(array[i+1])>0){
                return false;
            }
        }return true;
    }
}

class Maiorelem{

    public static <T extends Comparable<T>> void verifMaior(T[] array){
        T maior = array[0];
        for(int j = 0; j<array.length-1; j++){
            if(maior.compareTo(array[j+1])<0){
                maior = array[j+1];
            }
        }System.out.println("O maior objeto é: "+maior);
    }
}

class ConctArrays{

    public static <T extends Comparable<T>> void juntarArrays(T[] array1, T[] array2){
        T[] array3 = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, array3, 0, array2.length);
    }
}

    public static void main(String[] args){
        List<String> nomes = new ArrayList<>(Arrays.asList("Edu","Souza","Guima"));
        Generics.ordenAsc(nomes);
        System.out.println("Nomes: "+nomes);
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,7,9,0,3));
        Generics.ordenAsc(nums);
        System.out.println("Numeros: "+nums);

        String[] nomes1 = {"Edu","Souza","Guima"};
        Integer[] numeros = {1,2,3,6,7,0,3,4,10};
        String[] nomes2 = new String[2];
        nomes2[0] = "Bella";
        nomes2[1] = "Carvalho";

        System.out.println(Verificacao.verificarOdenacao(nomes1));
        System.out.println(Verificacao.verificarOdenacao(nomes2));
        System.out.println(Verificacao.verificarOdenacao(numeros));

        Maiorelem.verifMaior(nomes2);
        Maiorelem.verifMaior(numeros);
        Maiorelem.verifMaior(nomes1);
    }
}

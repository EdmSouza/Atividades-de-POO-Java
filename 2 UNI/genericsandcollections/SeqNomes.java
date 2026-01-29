package genericsandcollections;
import java.util.*;

public class SeqNomes{

    public static List<String> listanomes(){
        List<String> nomes = new ArrayList<>();
        while(true){
            String nome = IO.readln();
            if(nome.equalsIgnoreCase("FIM")){
                break;
            }else{
                nomes.add(nome);
            }
        }return nomes;
    }

    public static void imprimirDuplicados(List<String> nomes) {
        Set<String> vistos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        for (String nome : nomes) {
            if (!vistos.add(nome)) {
                duplicados.add(nome);
            }
        }

        IO.println("Duplicados:");
        for (String nome : duplicados) {
            IO.println(nome);
        }
    }

    public static void imprimirNaoDuplicados(List<String> nomes) {
        Map<String, Integer> contagem = new HashMap<>();

        for (String nome : nomes) {
            contagem.put(nome, contagem.getOrDefault(nome, 0) + 1);
        }

        IO.println("Não duplicados:");
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            if (entry.getValue() == 1) {
                IO.println(entry.getKey());
            }
        }
    }

    public static Set<String> diferencaEntreListas(List<String> a, List<String> b) {
        Set<String> setA = new HashSet<>(a);
        Set<String> setB = new HashSet<>(b);

        Set<String> resultado = new HashSet<>(setA);
        resultado.addAll(setB);

        Set<String> intersecao = new HashSet<>(setA);
        intersecao.retainAll(setB);

        resultado.removeAll(intersecao);

        return resultado;
    }

    public static void imprimirDuplicadosComContagem(List<String> nomes) {
        Map<String, Integer> contagem = new HashMap<>();

        for (String nome : nomes) {
            contagem.put(nome, contagem.getOrDefault(nome, 0) + 1);
        }

        IO.println("Duplicados com contagem:");
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            if (entry.getValue() > 1) {
                IO.println(entry.getKey() + " → " + entry.getValue() + " vezes");
            }
        }
    }

    public static void main(String[] args) {

        List<String> teste1 = listanomes();
        imprimirDuplicados(teste1);

        List<String> lista1 = Arrays.asList(
                "Ana", "João", "Maria", "Ana", "Carlos", "João", "Pedro"
        );

        List<String> lista2 = Arrays.asList(
                "Pedro", "Lucas", "Ana", "Marcos"
        );

        imprimirDuplicados(lista1);
        IO.println();

        imprimirNaoDuplicados(lista1);
        IO.println();

        Set<String> diff = diferencaEntreListas(lista1, lista2);
        IO.println("Diferença entre listas:");
        for (String nome : diff) {
            IO.println(nome);
        }
        IO.println();

        imprimirDuplicadosComContagem(lista1);
    }
}


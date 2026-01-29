import java.util.Arrays;

public class ConcatenacaoGenerica {

    public static <T> T[] concatenar(T[] primeiro, T[] segundo) {

        T[] resultado = Arrays.copyOf(primeiro, primeiro.length + segundo.length);


        System.arraycopy(segundo, 0, resultado, primeiro.length, segundo.length);

        return resultado;
    }

    public static void main(String[] args) {

        Integer[] nums1 = {1, 2, 3};
        Integer[] nums2 = {4, 5, 6};
        
        Integer[] numsResultado = concatenar(nums1, nums2);
        
        System.out.println("Teste com Inteiros:");
        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Array 2: " + Arrays.toString(nums2));
        System.out.println("Concatenado: " + Arrays.toString(numsResultado));
        System.out.println("-----------------------------");


        String[] texto1 = {"Olá", "Mundo"};
        String[] texto2 = {"Java", "Generics", "Funciona!"};

        String[] textoResultado = concatenar(texto1, texto2);

        System.out.println("Teste com Strings:");
        System.out.println("Array 1: " + Arrays.toString(texto1));
        System.out.println("Array 2: " + Arrays.toString(texto2));
        System.out.println("Concatenado: " + Arrays.toString(textoResultado));
        System.out.println("-----------------------------");
        

        Character[] chars1 = {'A', 'B'};
        Character[] chars2 = {'C', 'D', 'E'};
        
        Character[] charsResultado = concatenar(chars1, chars2);
        
        System.out.println("Teste com Caracteres:");
        System.out.println("Concatenado: " + Arrays.toString(charsResultado));
    }
}






public class Comparar {
    
    public static <T extends Comparable<T>>boolean crescente(T[] objetos){
        for(int i = 0; i<objetos.length-1; i++){
            if(objetos[i].compareTo(objetos[i+1])>0){
                return false;
            }
        }
    }
}

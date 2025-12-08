public class ImprimirN {
    private int num;
    private int[] nums;
    private int cont;


    public ImprimirN(int num){
        if(num>0){
            nums = new int[num*2+1];
        }else{
            nums = new int[((num*2)*(-1))+1];
        }
        this.num = num;
        this.cont = 0;
    }

    public void calcular(){
        int j = 0;
        if(num>0){
            for(int i = -num; i<=num; i++){
                nums[j] = i;
                j++;
                cont++;
        }
        }else{
            for(int i = num; i <= -num; i++){
                nums[j] = i;
                j++;
                cont++;
            }
        }
        exibir();
    }
    public void exibir(){
        for(int i = 0; i < cont; i++){
            IO.print(" | "+nums[i]);
        }
    }

    public static void main(String[] args){
        int numr = Integer.parseInt(IO.readln(""));
        ImprimirN resultado = new ImprimirN(numr);
        resultado.calcular();
    }
}

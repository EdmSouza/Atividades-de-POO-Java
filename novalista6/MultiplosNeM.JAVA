public class MultiplosNeM{
    private int num1;
    private int num2;
    private int[] multiplos;
    private int maior;
    private int menor;
    private int cont;


    public MultiplosNeM(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
        this.cont = 0;
    }

    public void calcularmultiplos(){
        multiplos = new int[maior-menor + 1];
        int j = 0;
        for(int i = menor; i<=maior; i++){
            if(i%5==0){
                multiplos[j] = i;
                j++;
                cont++;
            }
        }exibir();
    }

    public void maiordosnum(){
        this.maior = num1;
        this.menor = num2;
        if(num2>maior){
            maior = num2;
            menor = num1;
        }calcularmultiplos();
    }

    public void exibir(){
        IO.println("Os múltiplo são: ");
        for(int i = 0; i<cont; i++){
            IO.println(multiplos[i]);
            }
        }

    public static void main(String[] args){
        int numr1 = Integer.parseInt(IO.readln(""));
        int numr2 = Integer.parseInt(IO.readln(""));
        MultiplosNeM resultado = new MultiplosNeM(numr1,numr2);
        resultado.maiordosnum();
    }
}
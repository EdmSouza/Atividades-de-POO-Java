public class RaizporNimpares {
    private int num;
    private int impares;
    private int cont;


    public RaizporNimpares(int num){
        this.num = num;
        this.impares = 1;
        this.cont = 0;
    }

    public void calcularraiz(){
        int numtemp = num;
        while(true){
            numtemp -= impares;
            impares+=2;
            if(numtemp>=0){
                cont++;
            }else{
                break;
            }
        }resultado();
    }

    public void resultado(){
        IO.println("A raíz inteira de "+this.num+" é: "+this.cont);
    }

    public static void main(String[] args){
        int numero = Integer.parseInt(IO.readln(""));
        RaizporNimpares calculo = new RaizporNimpares(numero);
        calculo.calcularraiz();
    }
}

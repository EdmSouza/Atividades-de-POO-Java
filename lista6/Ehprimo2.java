public class Ehprimo2 {
    private int num;
    private boolean primo;


    public Ehprimo2(){
    }


    private void verificarprimo(){
        this.primo = true;
        num = Integer.parseInt(IO.readln("Digite um número: "));
        if(num%2 == 0 && num !=2){
            primo = false;
        }
        int i=3;
        while(i<=Math.sqrt(num) && primo != false){
            if(num%i == 0){
                primo = false;
                break;
            }else{
                i+=2;
            }
        }imprimir();
    }

    public void imprimir(){
        if(primo == true && num>=2){
            IO.println("O número "+num+" é primo");
        }else{
            IO.println("O número "+num+" não é primo");
        }
    }


    public static void main(String[] args){
        Ehprimo2 resultado = new Ehprimo2();
        resultado.verificarprimo();
    }

}

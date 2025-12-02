public class Ehprimo {
    private int num;


    public Ehprimo(int num){
        this.num = num;
    }


    public void ehprimo(){
        boolean primo = true;
        if(num<0){
            primo = false;
            IO.println("O número "+num+" não é primo");
        }
        for(int i =2; i<num;i++){
            if(num%i == 0){
                IO.println("O número "+num+" não é primo");
                primo = false;
                break;
            }
        }if(primo != false){
            IO.println("O número "+num+" é primo");
        }
    }

    public static void main(String[] args){
        int n = Integer.parseInt(IO.readln("Digite um número inteiro não negativo: "));
        Ehprimo resultado = new Ehprimo(n);
        resultado.ehprimo();
    }
}

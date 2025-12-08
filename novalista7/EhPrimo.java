public class EhPrimo {
    private int num;
    private boolean ehprimo;


    public EhPrimo(int num){
        this.num = num;
        this.ehprimo = true;
    }

    public void testePrimo(){
        int contar = 2;
        if(num == 2){
            ehprimo = true;
        }else if(num<2){
            ehprimo = false;
        }
        else{
            while(contar<num){
                if(num%contar==0){
                    ehprimo = false;
                }
                contar++;
            }
        }verificarprimo();
        }

        public void verificarprimo(){
            if(ehprimo){
                IO.println("o número "+this.num+" é primo");
            }
        }

        public static void main(String[] args){
            int numero = Integer.parseInt(IO.readln(""));
            EhPrimo resultado = new EhPrimo(numero);
            resultado.testePrimo();
        }
    }

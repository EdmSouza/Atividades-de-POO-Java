public class Q6 {
    public static void main(String[] args) {
        int valorgarrafa = 10;
        var qntgarr = IO.readln("O preço da garrafa de vinho é de R$10,00. Digite a quantidade de garrafas de vinho que deseja _");
        int qntfinal = Integer.parseInt(qntgarr);
        if (qntfinal >= 3){
            int divisoesde3= qntfinal / 3; //se eu divido a qntd de garr por 3, por exemplo 6, eu tenho 2 grupos de 3 un, isto é -20 reais
            int divisoresde3 = qntfinal % 3; //nesse exemplo de 6, nao sobra resto, logo divisoresde3*valor... = 0, ent fica: 2*divisoes de 3(nesse exemplo:2)* valor...=40
            IO.println("Na compra de 3 garrafas de vinho, voce paga pelo valor de somente 2 garrafas"); //se eu pegar 4 garrafas, será 2*(2grupos de 3)* valor... + (1 garrafa de resto)*valor = 30 reais
            IO.println("Comprando "+qntfinal+ " garrafas de vinho voce irá pagar: R$"+((divisoesde3*2*valorgarrafa)+divisoresde3*valorgarrafa));
        } else{
            preço(qntfinal, valorgarrafa);
        }
    } public static void preço(int qntfinal, int valorgarrafa){
        int preçofinal = qntfinal * valorgarrafa;
        IO.println("Comprando "+qntfinal+ " garrafas de vinho voce irá pagar: R$"+preçofinal);
    }
}

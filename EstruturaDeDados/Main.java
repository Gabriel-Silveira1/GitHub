package EstruturaDeDados;

public class Main {
    public static void main(String [] args) {
        int [] numeros = {5,4,3,2,1};
        
        inverter(numeros);
    }

    private static void inverter(final int[] numeros) {
        Pilha pilha = new Pilha(numeros[0]);
        for (int i = 1; i < numeros.length; i++) {
            pilha.push(numeros[i]);
        }
        var node  = pilha.pop();
        while(node != null) {
            System.out.println(node.getValue());
            node = pilha.pop();
        }
    }
}

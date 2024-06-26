package EstruturaDeDados;

import java.util.Random;

public class FilaDeAtendimento {
    public static void main (String [] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101);

        Fila fila = new Fila(cliente);
        System.out.println("Chegou o cliente: " + cliente);

        for(int i = 2; i <= n; i++) {
            cliente = random.nextInt(101);
            System.out.println("Chegou o cliente: " + cliente);
            fila.enfileirar(cliente);
        }

        //Atendimento dos clientes
        var node = fila.desenfileirar();
        while (node != null) {
            System.out.println("Atendido o cliente: " + node.getValue());
            node = fila.desenfileirar();
        }
    }
}

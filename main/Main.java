package main;

import java.util.Scanner;
import implementation.SupermarketArray;
import implementation.supermarket;

public class Main {
    private final static int SIZE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //ler o que o usuário va digitar
        supermarket supermarket1 = new SupermarketArray(SIZE);
        int opcao; //armazenando aqui
        do {
            System.out.println("\nLista de Compras");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o item a ser inserido: ");
                    String item = scanner.next(); //apenas palavras simples
                    supermarket1.add(item);
                    break;
                case 2:
                    supermarket1.print();
                    break;
                case 3:
                    System.out.println("Digite uma posição do item a ser removido: ");
                    int index = scanner.nextInt();
                    supermarket1.delete(index);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;        
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 4);

          scanner.close();  
    } 
}

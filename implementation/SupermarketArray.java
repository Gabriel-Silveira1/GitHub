package implementation;

public class SupermarketArray implements supermarket{
    private final String [] items;
    private int lastIndex;
    
    public SupermarketArray(final int size) {
        items = new String[size]; //iniciando vetor itens
        lastIndex = -1; //indicando o ultimo elemento inserido, como não tem nenhum -1
    }
    
    @Override
    public void add(final String item) {
        if(lastIndex == items.length-1) {
            System.err.println("Lista de Supermercados cheia"); //se o ultimo elemento inserido for igual ao tamanho maximo -1, lista cheia
        } else {
            lastIndex ++; //se ainda tiver espaço no array vai adicionar uma posição a frente do ultimo
            items[lastIndex] = item; //adicionando em items através desse comando
        }
    }

    @Override
    public void print() {
        System.out.println("---------------------");
        if(lastIndex < 0) {
            System.out.println("Lista de Supermercado vazia"); 
        } //navegar até o ultimo indice adicionado sem ser negativo, se não será uma lista vazia e dará erro
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(i + " - " + items[i]); //método para navegar na lista da posição zero até o ultimo elemento que foi inserido
        }
        System.out.println("----------------------");
    }

    @Override
    public void delete(final int index) {
        if(index >= 0 && index <= lastIndex) { 
            shift(index);//que puxa os elementos da direita para a esquerda e lembrando quenão vai receber o item, vai receber o indice do meu array
            lastIndex--;
        } else {
            System.err.println("Índice inválido: " + index);
        }
    }
    
    private void shift(final int index) {
        for(int i = index; i < lastIndex; i++) {
            items[i] = items [i+1]; // para puxar os elementos do array da direita para a esquerda
        }
    }
}

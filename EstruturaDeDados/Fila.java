package EstruturaDeDados;

public class Fila {
    private Node first;
    private Node last;
    private int length;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {return this.value;}
    }

    public Fila(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void getFirst() {
        if(first != null) {
            System.out.println("First: " + first.value);
        } else {
            System.out.println("Fila vazia");
        }
    }

    public void getLast() {
        if(last != null) {
            System.out.println("Last: " + last.value);
        } else {
            System.out.println("Fila vazia");
        }
    }

    public void getLength() {
        if(last != null) {
            System.out.println("Length: " + length);
        }
    }

    public void print() {
        System.out.println("----------");
        Node temp = first;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enfileirar(int value) {
            Node newNode = new Node(value);
            
            if(length == 0) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            length++;
    }

    public Node desenfileirar() {
        if(length == 0) return null;
        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public static void main (String [] args) {
        Fila myFila = new Fila(1);

        /*myFila.getFirst();
        myFila.getLast();
        myFila.getLength();
        
        myFila.print();*/

        myFila.enfileirar(2);
        myFila.enfileirar(3);

        /*myFila.getFirst();
        myFila.getLast();
        myFila.getLength();

        myFila.print();*/

        System.out.println(myFila.desenfileirar().value);
        System.out.println(myFila.desenfileirar().value);
        System.out.println(myFila.desenfileirar().value);
    }
}

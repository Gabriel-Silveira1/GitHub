package EstruturaDeDados;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    public static Node root;
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value) {
        if(root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> fila = new LinkedList<>();
            fila.add(root);
            while(fila.size() > 0) {
                Node currentNode = fila.remove();
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    fila.add(currentNode.left);
                }
                if(currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    fila.add(currentNode.right);
                }
            }
        }
    }

    public void preOrdem() {
        preOrdem(root);
    }

    private void preOrdem(final Node node) {
        // Raiz - Esquerda - Direita
        if(node == null) return;
        System.out.println(node.value);
        preOrdem(node.left);
        preOrdem(node.right);
    }

    public void emOrdem() {
        emOrdem(root);
    }

    private void emOrdem(final Node node) {
        // Esquerda - Raiz - Direita
        if(node == null) return;
        emOrdem(node.left);
        System.out.println(node.value);
        emOrdem(node.right);
    }

    public void posOrdem() {
        posOrdem(root);
    }

    private void posOrdem(final Node node) {
        // Esquerda - Raiz - Direita
        if(node == null) return;
        posOrdem(node.left);
        posOrdem(node.right);
        System.out.println(node.value);
    }
    
    public void BFS() {
        if(root == null) return;
        Queue<Node> fila = new LinkedList<>();
        fila.add(root);
        while(!fila.isEmpty()) {
            Node node = fila.remove();
            if(node.left != null) fila.add(node.left);
            if(node.right != null) fila.add(node.right);
            
            System.out.println(node.value);
        }
    }

    public static void main (String [] args) {
        Arvore arvore = new Arvore();
        arvore.insert(37);
        arvore.insert(11);
        arvore.insert(66);
        arvore.insert(8);
        arvore.insert(17);
        arvore.insert(42);
        arvore.insert(72);

        System.out.println("-----------");
        arvore.BFS();
        System.out.println("-----------");
        

        /*System.out.println(arvore.root.value);
        System.out.println(arvore.root.left.value);
        System.out.println(arvore.root.right.value);

        System.out.println(arvore.root.isLeaf());
        System.out.println(arvore.root.right.isLeaf());*/
    }
}

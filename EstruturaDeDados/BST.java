package EstruturaDeDados;

public class BST {
    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        if(root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final Node root, final int value) {
        if(root == null) return;
        if(value > root.value) {
            if(root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        } else {
            if(root.left == null) root.left = new Node(value);
            else insert (root.left, value);
        }
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

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(final Node root, final int value) {
        if(root == null) return false;
        if(root.value == value) return true;
        if(value > root.value) return contains(root.right, value);
        else return contains(root.left, value);
    }

    public int minValue(Node currentNode) {
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(final Node root, final int value) {
        if (root == null) return null;
        if(value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if(value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if ((root.left == null) && (root.right == null)) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BST arvore = new BST();
        arvore.insert(37);
        arvore.insert(11);
        arvore.insert(66);
        arvore.insert(8);
        arvore.insert(17);
        arvore.insert(42);
        arvore.insert(72);

        arvore.deleteNode(66);
        arvore.emOrdem();

        /*System.out.println(arvore.contains(11));
        System.err.println(arvore.contains(99));*/
    }
}

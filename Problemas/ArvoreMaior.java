package Problemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import EstruturaDeDados.Arvore;

public class ArvoreMaior {
    public static List<Integer> largestValues(Arvore tree) {
        var list = new ArrayList<Integer>();//professor disse no começo da codificação que ele tem uma implementação de árvore binária e por isso acho que meu código não está dando certo, tentei descobrir fazendo uns testes com quick fix mas não consegui descobrir
        solveTree(tree.root, 0, list);
        return list;
    }

    private static void solveTree(final Arvore.Node node, final int level, final ArrayList<Integer> list) {
        if (node == null) return;
        if(level == list.size()) {
            list.add(node.value);
        } else {
            list.set(level, Math.max(list.get(level), node.value));
        }
        solveTree(node.left, level+1, list);
        solveTree(node.right, level+1, list);
    }

    public static void main(String[] args) {
        Arvore tree = new Arvore();
        tree.insert(100);
        tree.insert(10);

        tree.insert(5);
        
        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(largestValues(tree));

    }
}




import java.util.Scanner;
import java.util.Stack;

// create Node class to design the structure of the AVL Tree Node
class Node
{
    int key;
    int h;  //for height
    Node leftChild;
    Node rightChild;

    //default constructor to create null node
    public Node()
    {
        leftChild = null;
        rightChild = null;
        key = 0;
        h = 0;
    }
    // parameterized constructor
    public Node(int key)
    {
        leftChild = null;
        rightChild = null;
        this.key = key;
        h = 0;
    }
}

// create class ConstructAVLTree for constructing AVL Tree
class ConstructBTree {
    public Node rootNode;

    //Constructor to set null value to the rootNode
    public ConstructBTree() {
        rootNode = null;
    }

    //create removeAll() method to make AVL Tree empty
    public void removeAll() {
        rootNode = null;
    }

    // create checkEmpty() method to check whether the AVL Tree is empty or not
    public boolean checkEmpty() {
        if (rootNode == null)
            return true;
        else
            return false;
    }

    // create insertElement() to insert element to to the AVL Tree
    public void insertElement(int element) {
        rootNode = insertElement(element, rootNode);
    }

    //create getHeight() method to get the height of the AVL Tree
    private int getHeight(Node node) {
        return node == null ? -1 : node.h;
    }

    //create maxNode() method to get the maximum height from left and right node
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    private int bFactor(Node node) {
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }


    //create insertElement() method to insert data in the AVL Tree recursively
    private Node insertElement(int element, Node node) {
        //check whether the node is null or not
        if (node == null)
            node = new Node(element);
            //insert a node in case when the given element is lesser than the element of the root node
        else if (element < node.key) {
            node.leftChild = insertElement(element, node.leftChild);
            if (bFactor(node) == 2)
                if (element < node.leftChild.key)
                    node = rotateLeft(node);
                else
                    node = rotateBigLeft(node);
        } else if (element > node.key) {
            node.rightChild = insertElement(element, node.rightChild);
            if (bFactor(node) == -2)
                if (element > node.rightChild.key)
                    node = rotateRight(node);
                else
                    node = rotateBigRight(node);
        } else
            ;  // if the element is already present in the tree, we will do nothing
        node.h = getMaxHeight(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        return node;

    }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child
    private Node rotateLeft(Node a) {
        Node b = a.leftChild;
        a.leftChild = b.rightChild;
        b.rightChild = a;
        a.h = getMaxHeight(getHeight(a.leftChild), getHeight(a.rightChild)) + 1;
        b.h = getMaxHeight(getHeight(b.leftChild), a.h) + 1;
        return b;
    }

    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child
    private Node rotateRight(Node a) {
        Node b = a.rightChild;
        a.rightChild = b.leftChild;
        b.leftChild = a;
        a.h = getMaxHeight(getHeight(a.leftChild), getHeight(a.rightChild)) + 1;
        b.h = getMaxHeight(getHeight(b.rightChild), a.h) + 1;
        return b;
    }

    //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child
    private Node rotateBigLeft(Node a) {
        a.leftChild = rotateRight(a.leftChild);
        return rotateLeft(a);
    }

    //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child
    private Node rotateBigRight(Node a) {
        a.rightChild = rotateLeft(a.rightChild);
        return rotateRight(a);
    }

    //create getTotalNumberOfNodes() method to get total number of nodes in the AVL Tree

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.key); // выводим его значение в консоли
                    localStack.push(temp.leftChild); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}

// create AVLTree class to construct AVL Tree
class BTreeExample
{
    //main() method starts
    public static void main(String[] args) {
        ConstructBTree avl = new ConstructBTree();
        avl.insertElement(1);
        avl.insertElement(2);
        avl.insertElement(3);
        avl.insertElement(4);
        avl.insertElement(5);
        System.out.println(avl.rootNode.key);
        avl.printTree();
        //creating Scanner class object to get input from user
    }
}

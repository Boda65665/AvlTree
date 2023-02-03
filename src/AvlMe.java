//    class Main{
//        public static void main(String[] args) {
//            ConstructAVL avl = new ConstructAVL();
//            avl.insertElement(1);
//            avl.insertElement(2);
//            avl.insertElement(3);
//            avl.insertElement(4);
//            avl.insertElement(5);
//            System.out.println(avl.rootNode.right.key);
//        }
//    }
//    class Node
//    {
//        int key;
//        int h;  //for height
//        Node left;
//        Node right;
//
//        //default constructor to create null node
//        public Node()
//        {
//            left = null;
//            right = null;
//            key = 0;
//            h = 0;
//        }
//        // parameterized constructor
//        public Node(int key)
//        {
//            left = null;
//            right = null;
//            this.key = key;
//            h = 0;
//        }
//    }
//    class ConstructAVL {
//        public Node rootNode;
//
//        //Constructor to set null value to the rootNode
//        public ConstructAVL() {
//            rootNode = null;
//        }
//
//        //create removeAll() method to make AVL Tree empty
//        public void removeAll() {
//            rootNode = null;
//        }
//
//        // create checkEmpty() method to check whether the AVL Tree is empty or not
//        public boolean checkEmpty() {
//            if (rootNode == null)
//                return true;
//            else
//                return false;
//        }
//        public void insertElement(int key)
//        {
//            rootNode = insertElement(key, rootNode);
//        }
//
//        //create getHeight() method to get the height of the AVL Tree
//        private int getHeight(Node node)
//        {
//            return node == null ? -1 : node.h;
//        }
//
//        //create maxNode() method to get the maximum height from left and right node
//        private int getMaxHeight(int left,int right)
//        {
//            return Math.max(left, right);
//        }
//        private Node insertElement(int key, Node node)
//        {
//            //check whether the node is null or not
//            if (node == null)
//                node = new Node(key);
//                //insert a node in case when the given element is lesser than the element of the root node
//            else if (key < node.key)
//            {
//                node.left = insertElement( key, node.left );
//                if( getHeight( node.left ) - getHeight( node.right ) == 2 )
//                    if( key < node.left.key )
//                        node = rotateWithLeftChild( node );
//                    else
//                        node = doubleWithLeftChild( node );
//            }
//            else if( key > node.key )
//            {
//                node.right = insertElement( key, node.right );
//                if( getHeight( node.right ) - getHeight( node.left ) == 2 )
//                    if( key > node.right.key)
//                        node = rotateWithRightChild( node );
//                    else
//                        node = doubleWithRightChild( node );
//            }
//            else
//                ;  // if the element is already present in the tree, we will do nothing
//            node.h=getMaxHeight(getHeight(node.left),getHeight(node.right));
//            return node;
//
//        }
//        private Node rotateWithLeftChild(Node node2)
//        {
//            Node node1 = node2.left;
//            node2.left = node1.right;
//            node1.right = node2;
//            node2.h = getMaxHeight( getHeight( node2.left ), getHeight( node2.right ) ) + 1;
//            node1.h = getMaxHeight( getHeight( node1.left ), getHeight(node2)) + 1;
//            return node1;
//        }
//
//        // creating rotateWithRightChild() method to perform rotation of binary tree node with right child
//        private Node rotateWithRightChild(Node node1)
//        {
//            Node node2 = node1.right;
//            node1.right = node2.left;
//            node2.left = node1;
//            node1.h = getMaxHeight( getHeight( node1.left ), getHeight( node1.right ) ) + 1;
//            node2.h = getMaxHeight( getHeight( node2.right ), getHeight(node1) ) + 1;
//            return node2;
//        }
//
//        //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child
//        private Node doubleWithLeftChild(Node node3)
//        {
//            node3.left = rotateWithRightChild( node3.left );
//            return rotateWithLeftChild( node3 );
//        }
//
//        //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child
//        private Node doubleWithRightChild(Node node1)
//        {
//            node1.right = rotateWithLeftChild( node1.right );
//            return rotateWithRightChild( node1 );
//        }
//
//
//    }
//
//

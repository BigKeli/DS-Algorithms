package AVLTree;

import java.util.Scanner;

public class AVL1 {

    public static void main(String[] args) {
        // Create an instance of the AVL tree
        AVLTree Prod = new AVLTree();
        // Create a scanner for user input
        Scanner Scanner = new Scanner(System.in);
        System.out.println(" Number of products: ");
        // Read the total number of products
        int TotalProd = Scanner.nextInt();
        // Insert products into the AVL tree
        for (int i = 1; i < TotalProd + 1; i++) {
            System.out.println("Enter productId and both prices:  ");
            Prod.insert(Scanner.nextInt(), Scanner.nextInt(), Scanner.nextInt());
        }
        // Perform an in-order traversal to display products and calculate total price
        Prod.inorder();
        // Output the total final price
        System.out.print("Total final Price: " + Prod.getTotalPrice());
    }

    static class AVLNode {
        AVLNode left, right; // Pointers to left and right children
        int productId; // Identifier for the product
        int suitablePrice; // The price chosen for the product

        int height; // Height of the node for balancing purposes

        // Default constructor
        public AVLNode() {
            left = null;
            right = null;
            height = 0;
        }

        // Constructor with productId
        public AVLNode(int n) {
            left = null;
            right = null;
            productId = n;
            height = 0;
        }

        // Method to select the suitable price for the product
        protected void pricePicker(int n1, int n2) {
            if (n1 > n2)
                suitablePrice = n2;
            else
                suitablePrice = n1;
        }
    }

    static class AVLTree {
        public int TotalPrice; // Total price calculated from all nodes
        private AVLNode root; // Root node of the AVL tree

        // Constructor initializing the root to null
        public AVLTree() {
            root = null;
        }

        // Check if the tree is empty
        public boolean isEmpty() {
            return root == null;
        }

        // Set the tree to empty
        public void makeEmpty() {
            root = null;
        }

        // Get the height of a node
        private int height(AVLNode t) {
            return t == null ? -1 : t.height;
        }

        // Return the maximum of two integers
        private int max(int lhs, int rhs) {
            return lhs > rhs ? lhs : rhs;
        }

        // Public method to insert a product into the AVL tree
        public void insert(int data, int price1, int price2) {
            root = insert(data, root, price1, price2);
        }

        // Recursive insertion method for the AVL tree
        private AVLNode insert(int x, AVLNode t, int price1, int price2) {
            if (t == null) {
                // Create a new node if the current node is null
                t = new AVLNode(x);
                t.pricePicker(price1, price2);
            } else if (x < t.productId) {
                // Insert into the left subtree if x is less than the current node's productId
                t.left = insert(x, t.left, price1, price2);

                // Rebalance the tree if needed
                if (height(t.left) - height(t.right) == 2)
                    if (x < t.left.productId)
                        t = rotateWithLeftChild(t);
                    else
                        t = doubleWithLeftChild(t);
            } else if (x > t.productId) {
                // Insert into the right subtree if x is greater than the current node's productId
                t.right = insert(x, t.right, price1, price2);

                // Rebalance the tree if needed
                if (height(t.right) - height(t.left) == 2)
                    if (x > t.right.productId)
                        t = rotateWithRightChild(t);
                    else
                        t = doubleWithRightChild(t);
            }

            // Update the height of the current node
            t.height = max(height(t.left), height(t.right)) + 1;
            return t;
        }

        // Perform a single right rotation with the left child
        private AVLNode rotateWithLeftChild(AVLNode k2) {
            AVLNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = max(height(k2.left), height(k2.right)) + 1;
            k1.height = max(height(k1.left), k2.height) + 1;
            return k1;
        }

        // Perform a single left rotation with the right child
        private AVLNode rotateWithRightChild(AVLNode k1) {
            AVLNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = max(height(k1.left), height(k1.right)) + 1;
            k2.height = max(height(k2.right), k1.height) + 1;
            return k2;
        }

        // Perform a double rotation: left-right
        private AVLNode doubleWithLeftChild(AVLNode k3) {
            k3.left = rotateWithRightChild(k3.left);
            return rotateWithLeftChild(k3);
        }

        // Perform a double rotation: right-left
        private AVLNode doubleWithRightChild(AVLNode k1) {
            k1.right = rotateWithLeftChild(k1.right);
            return rotateWithRightChild(k1);
        }

        // Count the number of nodes in the AVL tree
        public int countNodes() {
            return countNodes(root);
        }

        private int countNodes(AVLNode r) {
            if (r == null)
                return 0;
            else {
                int l = 1;
                l += countNodes(r.left);
                l += countNodes(r.right);
                return l;
            }
        }

        // Search for a productId in the AVL tree
        public boolean search(int val) {
            return search(root, val);
        }

        private boolean search(AVLNode r, int val) {
            boolean found = false;
            while ((r != null) && !found) {
                int rval = r.productId;
                if (val < rval)
                    r = r.left;
                else if (val > rval)
                    r = r.right;
                else {
                    found = true;
                    break;
                }

                found = search(r, val);
            }
            return found;
        }

        // Perform an in-order traversal of the AVL tree
        public void inorder() {
            inorder(root);
        }

        private void inorder(AVLNode r) {
            if (r != null) {
                inorder(r.left);
                TotalPrice += r.suitablePrice * r.productId;
                inorder(r.right);
            }
        }

        // Get the total price of all products
        private int getTotalPrice() {
            return TotalPrice;
        }
    }
}
package AVLTree;

import java.util.Scanner;

public class AVL2 {
    static class AVLNode {

        AVLNode left, right;

        int SubjectNr = 0;
        String Subject;
        int height;


        public AVLNode() {
            left = null;
            right = null;
            height = 0;
        }


        public AVLNode(String n) {
            left = null;
            right = null;
            Subject = n;
            height = 0;
        }
    }

    static class AVLTree {

        private AVLNode root;

        /* Constructor */
        public AVLTree() {
            root = null;
        }


        /* Function to get height of node */
        private int height(AVLNode t) {
            return t == null ? -1 : t.height;
        }

        /* Function to max of left/right node */

        private int max(int lhs, int rhs) {
            return lhs > rhs ? lhs : rhs;
        }
        /* Function to insert Subject */

        public void insert(String data) {
            root = insert(data, root);
        }
        /* Function to insert Subject recursively */

        private AVLNode insert(String x, AVLNode t) {

            if (t == null) {

                t = new AVLNode(x);
                t.SubjectNr++;
            } else if (x.compareTo(t.Subject) == 0) {
                t.SubjectNr++;
            } else if (x.compareTo(t.Subject) < 0) {
                t.left = insert(x, t.left);

                if (height(t.left) - height(t.right) == 2)
                    if (x.compareTo(t.Subject) > 0)
                        t = rotateWithLeftChild(t);
                    else
                        t = doubleWithLeftChild(t);
            } else if (x.compareTo(t.Subject) > 0) {
                t.right = insert(x, t.right);

                if (height(t.right) - height(t.left) == 2)

                    if (x.compareTo(t.Subject) > 0)
                        t = rotateWithRightChild(t); // right -right tree
                    else
                        t = doubleWithRightChild(t); // right - left tree
            } else {
            }


            t.height = max(height(t.left), height(t.right)) + 1;
            return t;

        }

        private AVLNode rotateWithLeftChild(AVLNode k2) {

            AVLNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = max(height(k2.left), height(k2.right)) + 1;
            k1.height = max(height(k1.left), k2.height) + 1;
            return k1;

        }


        private AVLNode rotateWithRightChild(AVLNode k1) {

            AVLNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = max(height(k1.left), height(k1.right)) + 1;
            k2.height = max(height(k2.right), k1.height) + 1;

            return k2;

        }


        private AVLNode doubleWithLeftChild(AVLNode k3) {

            k3.left = rotateWithRightChild(k3.left);
            return rotateWithLeftChild(k3);
        }


        private AVLNode doubleWithRightChild(AVLNode k1) {

            k1.right = rotateWithLeftChild(k1.right);
            return rotateWithRightChild(k1);

        }

        /* Functions to count number of nodes */

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

        /* Functions to search for an element */

        public boolean search(String val) {
            return search(root, val);
        }

        private boolean search(AVLNode r, String val) {

            boolean found = false;
            while ((r != null) && !found) {
                String rval = r.Subject;
                if (val.compareTo(r.Subject) > 0)
                    r = r.left;
                else if (val.compareTo(r.Subject) < 0)
                    r = r.right;
                else {
                    found = true;
                    break;
                }

                found = search(r, val);
            }
            return found;

        }

        /* Function for inorder traversal */

        public void inorder() {
            inorder(root);
        }

        private void inorder(AVLNode r) {
            if (r != null) {
                inorder(r.left);
                System.out.println(r.Subject + " was picked:  " + r.SubjectNr);
                inorder(r.right);
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Enter number of students: ");
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        AVLTree TreeSave = new AVLTree();
        for (int i = 1; i < nr + 1; i++) {
            System.out.println("Enter student " + i + " grades( 3 subjects only ):  ");
            System.out.println("Grade for first subject: ");
            TreeSave.insert(scanner.next());
            System.out.println("Grade for secong subject: ");
            TreeSave.insert(scanner.next());
            System.out.println("Grade for third subject: ");
            TreeSave.insert(scanner.next());

        }
        System.out.println("Subjects are presented in order: ");
        TreeSave.inorder();


    }
}
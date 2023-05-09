public class MyTreeSet<T> {
    // Добавление элемента, получение элемента по ключу, удаление элемента по ключу
    private int size = 0;
    private Node root = null;

    private class Node {
        public T element;
        public Node left = null;
        public Node right = null;
        public Node (T entryElement) {
            this.element = entryElement;
        }
    }

    public T put(T entryElement) {
        if (root == null) {
            root = new Node(entryElement);
            size++;
        }
        return putHelper(root,entryElement);
    }
    private T putHelper(Node node, T entryElement) {
        Comparable<? super T> T = (Comparable<? super T>)entryElement;
        int cmp = T.compareTo(node.element);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(entryElement);
                size++;

            }
            return putHelper(node.left,entryElement);
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(entryElement);
                size++;

            }
            return putHelper(node.right,entryElement);
        }
        T oldElement = node.element;
        node.element = entryElement;
        return oldElement;

    }
    public T get(Object element) {
        Node node = findNode(element);
        if (node == null) return null;
        return node.element;
    }
    private Node findNode(Object target) {
        Comparable<? super T> T = (Comparable<? super T>) target;
        Node node = root;
        while (node != null) {
            int cmp = T.compareTo(node.element);
            if (cmp < 0) {
                node = node.left;
            }
            if (cmp > 0) {
                node = node.right;
            }
            if (cmp == 0) return node;
        }
        return null;
    }
    private Node findParent(Object target) {
        Comparable<? super T> T = (Comparable<? super T>) target;
        Node node = root;
        Node parent = root;
        while (node != null) {
            int cmp = T.compareTo(node.element);
            if (cmp < 0) {
                parent = node;
                node = node.left;
            }
            if (cmp > 0) {
                parent = node;
                node = node.right;
            }
            if (cmp == 0) return parent;
        }
        return null;
    }
    public T remove(Object element) {
        T oldElement = get(element);
        if (element == root) root = delRecursive(element);
        else delRecursive(element);
        System.out.println("Root = " + root.element);
        return oldElement;
    }
    private Node delRecursive(Object element) {
        Node node = findNode(element);
        Node parent = findParent(element);
        if (node.left == null && node.right == null) {
            if (node == parent.left) parent.left = null;
            if (node == parent.right) parent.right = null;
            size--;
            return parent;
        }
        if (node.right == null) {
            if (node == parent.left) parent.left = node.left;
            if (node == parent.right) parent.right = node.left;
            size--;
            return parent;
        }
        if (node.left == null) {
            if (node == parent.left) parent.left = node.right;
            if (node == parent.right) parent.right = node.right;
            size--;
            return parent;
        }
        Node tempNode = findSmallest(node.right);
        delRecursive(tempNode.element);
        node.element = tempNode.element;
        return parent;
    }
    private Node findSmallest(Node node) {
        if (node.left == null) return node;
        else {
            return findSmallest(node.left);
        }
    }
    public boolean contains(Object element) {
        Comparable<? super T> T = (Comparable<? super T>) element;
        Node node = root;
        while (node != null) {
            int cmp = T.compareTo(node.element);
            if (cmp < 0) {
                node = node.left;
            }
            if (cmp > 0) {
                node = node.right;
            }
            if (cmp == 0) return true;
        }
        return false;
    }
    public void printTree() {
        LER(root);
        System.out.println("__________");
    }
    private void LER(Node node) {
        if (node.left != null) LER(node.left);
        System.out.println(node.element);
        if (node.right != null) LER(node.right);
    }
}



public class Main {
    public static void main(String[] args) {
        MyTreeSet<Integer> test = new MyTreeSet<>();
        test.put(100);
        test.put(80);
        test.put(130);
        test.put(40);
        test.put(90);
        test.put(110);
        test.put(170);
        test.put(20);
        test.put(60);
        test.put(120);
        test.put(140);
        test.put(200);
        test.put(10);
        test.put(30);
        test.put(50);
        test.put(70);
        test.put(5);
        test.put(55);
        if (test.contains(55)) System.out.println("true");
        test.remove(100);
        test.printTree();
    }
}
package org.example;

public class Example {

    public static void main(String[] args) {
        stringExample();
        integerExample();
    }

    private static void integerExample() {
        SortedLinkedList<String> linkedListString = new SortedLinkedList<>();
        linkedListString.add("Adela");
        linkedListString.add("Adam");
        linkedListString.add("Xaver");
        linkedListString.add("Ivan");

        final Iterator<String> iteratorString = linkedListString.iterator();

        while (iteratorString.hasNext()) {
            final String next = iteratorString.next();
            System.out.println(next);
        }

        System.out.println("Adam contains " + linkedListString.contains("Adam") + " times.");
        System.out.println("Pavel contains " + linkedListString.contains("Pavel") + " times.");
    }

    private static void stringExample() {
        SortedLinkedList<Integer> linkedListInteger = new SortedLinkedList<>();
        final int value1 = 1;
        linkedListInteger.add(value1);
        linkedListInteger.add(1000);
        linkedListInteger.add(0);
        linkedListInteger.add(25);

        final Iterator<Integer> iterator = linkedListInteger.iterator();

        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println("1000 contains " + linkedListInteger.contains(1000) + " times.");
        System.out.println("2 contains " + linkedListInteger.contains(2) + " times.");
    }

}

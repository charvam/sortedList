package org.example;

import java.util.Iterator;

public class Example {

    public static void main(String[] args) {
        stringExample();
        integerExample();
    }

    private static void stringExample() {
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

        System.out.println("Is word 'Adam' in list:" + linkedListString.contains("Adam"));
        System.out.println("Is word 'Pavel' in list:" + linkedListString.contains("Pavel"));
    }

    private static void integerExample() {
        SortedLinkedList<Integer> linkedListInteger = new SortedLinkedList<>();
        linkedListInteger.add(1);
        linkedListInteger.add(1000);
        linkedListInteger.add(0);
        linkedListInteger.add(25);

        final Iterator<Integer> iterator = linkedListInteger.iterator();

        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println("Is number '1' in list:" + linkedListInteger.contains(1));
        System.out.println("Is number '2' in list:" + linkedListInteger.contains(2));

    }

}

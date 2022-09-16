package org.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class SortedLinkedListTest {

    @Test
    void add_differentValues() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add(10);
        sortedLinkedList.add(1);
        sortedLinkedList.add(11);
        sortedLinkedList.add(2);

        final Iterator<Integer> iterator = sortedLinkedList.iterator();

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(10, iterator.next());
        assertEquals(11, iterator.next());
    }

    @Test
    void add_null() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();

        assertThrows(IllegalArgumentException.class, () -> sortedLinkedList.add(null));
    }

    @Test
    void contains() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add(10);

        assertTrue(sortedLinkedList.contains(10));
        assertFalse(sortedLinkedList.contains(1));
    }
}
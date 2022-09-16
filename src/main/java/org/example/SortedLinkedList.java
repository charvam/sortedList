package org.example;


import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private Element<T> first;

    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Input value can not be null");
        }

        if (first == null) {
            first = new Element<>(value);
        } else {
            Element<T> current = first;
            Element<T> previous = first;

            while (current.getNext() != null && value.compareTo(current.getValue()) > 0) {
                previous = current;
                current = current.getNext();
            }

            addNewElement(value, current, previous);
        }
        size++;
    }

    public boolean contains(T value) {

        for (T next : this) {
            if (next.compareTo(value) == 0) {
                return true;
            }
        }
        return false;
    }

    public void remove(T value) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public int size() {
        return size;
    }

    private void addNewElement(T value, Element<T> current, Element<T> previous) {
        final Element<T> added = new Element<>(value);

        if (isFirst(current)) {
            if (value.compareTo(current.getValue()) > 0) {
                addBehind(current, added);
            } else {
                addBefore(current, added);
                first = added;
            }
        } else if (isLast(current)) {
            if (value.compareTo(current.getValue()) > 0) {
                addBehind(current, added);
            } else {
                addBetween(previous, added, current);
            }
        } else {
            addBetween(previous, added, current);
        }
    }

    private void addBefore(Element<T> current, Element<T> added) {
        added.setNext(current);
    }

    private void addBehind(Element<T> current, Element<T> added) {
        current.setNext(added);
    }

    private void addBetween(Element<T> previous, Element<T> added, Element<T> current) {
        previous.setNext(added);
        added.setNext(current);
    }

    private boolean isFirst(Element<T> element) {
        return element == first;
    }
    
    private boolean isLast(Element<T> element) {
        return element.getNext() == null;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Element<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    return null;
                } else {
                    T value = current.getValue();
                    current = current.getNext();
                    return value;
                }
            }
        };
    }

    private static class Element<T> {
        private Element<T> next;
        private T value;

        public Element(T value) {
            this.value = value;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}

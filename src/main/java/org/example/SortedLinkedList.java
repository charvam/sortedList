package org.example;


public class SortedLinkedList<T extends Comparable<T>> implements LinkedList<T> {
    private Element<T> first;

    @Override
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
    }

    @Override
    public int contains(T value) {
        int count = 0;
        final Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            final T next = iterator.next();
            if (next.compareTo(value) == 0)  {
                count++;
            }
        }
        return count;
    }

    @Override
    public void remove(T value) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public Iterator<T> iterator() {
        return new Iterator<>(first);
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
}

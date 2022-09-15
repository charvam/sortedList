package org.example;

public class Iterator<T> {
    private Element<T> current;

    public Iterator(Element<T> current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
         if (current == null) {
             return null;
         } else {
             T value = current.getValue();
             current = current.getNext();
             return value;
         }
    }
}

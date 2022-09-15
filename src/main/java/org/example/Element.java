package org.example;

public class Element<T> {
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

package myStack;

import java.util.Iterator;

class StackIterator<Item> implements Iterator<Item> {

    Node<Item> current;

    public StackIterator(CustomStack<Item> st) {
        current = st.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }

    public Item next() {
        Item data = current.getData();
        current = current.getNext();
        return data;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

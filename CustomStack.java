package myStack;


import java.util.Objects;


public class CustomStack<Item> implements Iterable<Item> {
    private Node head;
    private int size;

    public CustomStack() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    public Item pop() {
        Item item = (Item) head.item;
        head = head.next;
        size--;
        return item;
    }

    public boolean contains(Item item){
        boolean checker=false;
        if(head==null)
            System.out.println("Stack is Empty");
        Node<Item> temp= head;
        while(temp!=null){
            if(Objects.equals(temp.item,item)){
                checker=true;
                break;
            }
            temp=temp.next;
        }
        return checker;
    }
    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }


    public int size() {
        return size;
    }
    public Item peek(){
        return (Item)head.item;
    }

    private myStack.Node<Item> getNodeAt(int index) {
        myStack.Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void reverse() {
        int li = 0;
        int ri = size - 1;

        while (li < ri) {
            myStack.Node<Item> left = getNodeAt(li);
            myStack.Node<Item> right = getNodeAt(ri);

            Item temp = left.item;
            left.item = right.item;
            right.item = temp;

            li++;
            ri--;
        }
    }


    public void traverse() {
        myStack.Node<Item> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Item center() {
        myStack.Node<Item> slow = head;
        myStack.Node<Item> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.item;
    }

    Node<Item> getHead() {
        return head;
    }

    public StackIterator<Item> iterator() {
        return new StackIterator<Item>(this);
    }
}
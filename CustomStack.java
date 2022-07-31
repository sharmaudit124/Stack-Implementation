package myStack;


import java.util.Objects;


public class CustomStack<Item> implements Iterable<Item> {
    private Node head;
    private int size;
/*
* Constructor
*/
    public CustomStack() {
        head = null;
        size = 0;
    }
/*
* To check is stack empty
*/
    public boolean isEmpty() {
        return (size == 0);
    }

/*
* To pop / delete item
*/
    public Item pop() {
        Item item = (Item) head.item;
        head = head.next;
        size--;
        return item;
    }
/*
*  To check whether item is present in stack
*/
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
    
/*
* To push / add item
*/
    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

/*
* To get size
*/
      public int size() {
        return size;
    }
    
 /*
* To get element presnet on top /peeked element
*/
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
    
 /*
* To reverse stack
*/
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

/*
* To traverse stack
*/
    public void traverse() {
        myStack.Node<Item> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }
/*
* To get centered item in stack
*/
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

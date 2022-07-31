package myStack;

public class MainStack{

    public static void main(String[] args) {
        CustomStack<Integer> st = new CustomStack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(90);
        st.push(45);
        st.push(43);

        System.out.println(st.contains(90));
        st.pop();
        st.traverse();
        System.out.println("Peeked value is :"+st.peek());
        st.reverse();
        st.traverse();
        System.out.println(st.size());
        System.out.println("Centered Value is " + st.center());

        StackIterator itr = st.iterator();

        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();


//        for (Integer s : st)
//            System.out.print(s +" ");
//        System.out.println();




    }
}

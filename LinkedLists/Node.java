package LinkedLists;

public class Node<E>{
    public Node<E> next;
    public E data;
    Node(E newValue){
        data =newValue;

    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
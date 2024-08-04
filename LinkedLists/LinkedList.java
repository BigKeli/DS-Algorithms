package LinkedLists;

public class LinkedList<E> {
    Node<E> Head;
    Node<E> Tail;
    LinkedList(E GenericValue){
        Head= new Node<>(GenericValue);
        Tail=Head;
    }
    public void insert(E value){
        Tail.next= new Node<>(value);
        Tail =Tail.next;
    }


    public E middle(){
        Node<E> FastNode =Head;
        Node<E> SlowNode =Head;

        while(FastNode.next!=null){
            FastNode = FastNode.next;
            if (FastNode.next==null){
            }else { FastNode = FastNode.next;
                }
            SlowNode = SlowNode.next;
        }
        E Mid= SlowNode.data;
        return Mid;
    }


}
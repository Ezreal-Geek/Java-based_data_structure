package LinearList.SinglyList;


import tree.Node;

public class SinglyList<T> extends Object {

    public Node<T> head;

    //constructor
    public SinglyList() {
        this.head = new Node<T>();
    }

    public SinglyList(T[] values) {
        this();
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++) {
            rear.next = new Node<T>(values[i], null);
            rear = rear.next;
        }
    }

    public String toString() {
        String str = this.getClass().getName() + "(";
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null) {
                str += ",";
            }
        }
        return str + ")";
    }

    public Node<T> insert(int i, T x) {
        if (x == null) {
            throw new NullPointerException();
        }
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        front.next = new Node<T>(x, front.next);
        return front.next;
    }

    public Node<T> insert(T x) {
        return insert(Integer.MAX_VALUE, x);
    }

    public Node<T> search(T key) {
        Node<T> t = this.head.next;
        while (t != null) {
            if (t.data == key) {
                return t;
            } else {
                t = t.next;
            }
        }
        return t;
    }

    public T remove(int i) {
        Node<T> frond = this.head;
        for (int j = 0; frond.next != null && j < i; j++) {
            frond = frond.next;
        }
        if (i >= 0 && frond.next != null) {
            T old = frond.next.data;
            frond.next = frond.next.next;
            return old;
        }
        return null;
    }

    public void replaceAll(T key, T x) {
        Node<T> t = this.head.next;
        while (t != null) {
            if (t.data == key) {
                t.data = x;
                t = t.next;
            } else {
                t = t.next;
            }
        }
    }


}

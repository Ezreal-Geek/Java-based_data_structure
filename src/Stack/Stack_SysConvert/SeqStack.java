package Stack.Stack_SysConvert;

public final class SeqStack<T> implements Stack<T> {
    private SeqList<T> list;

    public SeqStack(int length) {
        this.list = new SeqList<T>(length);
    }

    public SeqStack() {
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x) {
        this.list.insert(x);
    }

    @Override
    public T peek() {
        System.out.print(this.list.get(list.n - 1));
        return this.list.get(list.n - 1);
    }

    @Override
    public T pop() {
        return list.remove(list.n - 1);
    }

}

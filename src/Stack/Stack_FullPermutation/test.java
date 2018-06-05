package Stack.Stack_FullPermutation;

/**
 * @author E.z.
 * @Description: 实现n个字符的全排列
 * @created 2018-05-03 14:10
 * @Version 1.0
 **/

public class test {
    public static void main(String[] args) {

        Character[] values = {'A', 'B', 'C', 'D'};
        SeqList<Character> sl = new SeqList<Character>(values);
        permutate(sl);

    }

    public static void permutate(SeqList sl) {
        SeqStack<State> stack = new SeqStack<>();    // 创建一个任务栈
        int length = sl.n;
        State temp = new State(0, 0, 0);
        for (int i = 0; i < length; i++)
            stack.push(new State(0, i, 0));

        int flag = 1;   // 输出格式美观控制符
        // 栈空则结束
        while (!stack.isEmpty()) {
            // 弹出一个当前任务
            temp = stack.pop();

            // 如果已排到最后队尾，则打印当前数组。temp.i 即当前位
            if (temp.i == length - 1) {
                if (flag % 6 == 0) {
                    System.out.println(sl.toString());
                    flag++;
                } else {
                    System.out.print(sl.toString() + "\t");
                    flag++;
                }
            }

            // 否则分解子任务
            else {
                swap(sl, temp.i, temp.j);   // 交换队列元素
                if (temp.n == 0) {
                    temp.n += 1;
                    stack.push(temp);
                    int k = temp.i + 1;     // 当前位进一位
                    for (int x = k; x < length; ++x)
                        stack.push(new State(k, x, 0));
                }
            }

        }
    }

    public static void swap(SeqList seqList, int i, int j) {
        Object tmp = seqList.element[j];
        Object x = seqList.element[i];
        Object y = seqList.element[j];
        seqList.element[j] = x;
        seqList.element[i] = tmp;
    }
}

class State {
    // i：当前位，j：欲交换位，n：第几次出栈。
    public int i;
    public int j;
    public int n;

    public State(int i, int j, int n) {
        this.i = i;
        this.j = j;
        this.n = n;
    }
}

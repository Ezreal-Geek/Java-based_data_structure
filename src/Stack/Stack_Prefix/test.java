package Stack.Stack_Prefix;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author E.z.
 * @Description: 输入一个中缀表达式，输出它的前缀表达式，并计算结果。不支持小数。
 * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
 * @create V1.0
 **/

public class test {
    public static void main(String[] args) {
        System.out.println("请输入你的中缀表达式：");
        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();
        //String infix = "(4-2)*23-42";
        StringBuffer prefix = toPrefix(infix);
        System.out.println("中缀表达式：" + infix);
        System.out.print("转换成前缀表达式为：");
        System.out.println(prefix);
        int value = calPrefix(prefix);
        System.out.println("\n计算值为：" + value);
    }

    public static StringBuffer toPrefix(String infix) {
        Stack<String> ss = new SeqStack<String>(infix.length());  // operator
        StringBuffer sb = new StringBuffer(infix.length() * 2);
        for (int i = infix.length(); i > 0; --i) {
            char ch = infix.charAt(i - 1);
            switch (ch) {
                case '+':
                case '-':
                    while (!ss.isEmpty() && (ss.peek().equals("*") || ss.peek().equals("/"))) {
                        sb.append(ss.pop());
                    }
                    ss.push(ch + "");
                    break;
                case '*':
                case '/':
                    ss.push(ch + "");
                    break;
                case ')':
                    ss.push(ch + "");
                    break;
                case '(':
                    String out = ss.pop();
                    while (out != null && !out.equals(")")) {
                        sb.append(out);
                        out = ss.pop();
                    }
                    break;
                case ' ':
                    break;
                default:
                    sb.append((ch + ""));
                    if (i > 1) {
                        ch = infix.charAt(i - 2);
                    }
                    if (!(ch >= '0' && ch <= '9')) {
                        sb.append(" ");
                    }
            }

        }
        while (!ss.isEmpty()) {
            sb.append(ss.pop());
        }
        sb.reverse();
        return sb;
    }

    public static int calPrefix(StringBuffer sb) {
        SeqStack<Integer> ss = new SeqStack<Integer>();
        int value = 0;
        for (int i = sb.length(); i > 0; --i) {
            char ch = sb.charAt(i - 1);
            if (ch >= '0' && ch <= '9') {
                int flag = 0;
                int args = 1;
                int sum = 0;
                while (ch != ' ' && ch >= '0' && ch <= '9') {
                    flag++;
                    if (flag == 1) {
                        sum = ch - '0';
                    }
                    value = ch - '0';
                    if (flag > 1) {
                        args *= 10;
                        sum = args * value + sum;
                    }
                    --i;
                    ch = sb.charAt(i - 1);
                }
                i++;
                ss.push(sum);
                // System.out.println(sum + " pushed");
            } else {
                int value2 = 0;
                if (ch != ' ') {
                    int x = ss.pop();
                    int y = ss.pop();
                    // System.out.print(x + " and " + y + " popped, ");
                    switch (ch) {
                        case '*':
                            value2 = x * y;
                            break;
                        case '/':
                            value2 = x / y;
                            break;
                        case '+':
                            value2 = x + y;
                            break;
                        case '-':
                            value2 = x - y;
                            break;
                    }
                    System.out.print(x + (ch + "") + y + "=" + value2 + ", ");
                    ss.push(value2);
                    // System.out.println(value2 + " pushed");

                }
            }
        }
        // System.out.println(ss.isEmpty());
        return ss.pop();
    }
}

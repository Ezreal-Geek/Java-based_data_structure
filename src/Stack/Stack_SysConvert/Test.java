package Stack.Stack_SysConvert;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author E.z.
 * @Description: 1.实现1到35之间任意进制转换    2.支持负数    3.不支持小数
 * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
 * @create V1.0
 **/

public class Test {
    public static void main(String[] args) {
        String[] NList = new String[35];
        // 向NList里逐一添加0-9
        for (int i = 0; i < 9; i++) {
            NList[i] = i + "";
        }
        // 向NList里逐一添加A-Z
        int chara = 65;
        for (int i = 9; i < 35; i++) {
            NList[i] = (char) chara + "";
            chara++;
        }

        int con = 1;    // 循环控制
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个十进制整数：");
            int num = scanner.nextInt();
            int tmp = num;  // 另外保存这个数
            System.out.println("要转换成__进制（输入一个1-35的整数）：");
            int N = scanner.nextInt();
            boolean min_flag = false;   // 负数标识符

            try {

                SeqStack<String> ss = new SeqStack<String>();
                do {
                    int rem = num % N;
                    if (rem < 0) {
                        rem = -rem;
                        min_flag = true;
                    }
                    ss.push(NList[rem]);
                    // System.out.println(NList[rem - 1] + "已入栈");
                    num = (int) (num / N);
                }
                while (num != 0);

                System.out.print(tmp + "的" + N + "进制表示为：");
                if (min_flag) {
                    System.out.print("-");
                } else {
                    System.out.print("");
                }
                while (!ss.isEmpty()) {
                    ss.peek();
                    ss.pop();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error！你输入的数太大了！转换失败！" + "\n");
            } finally {
                System.out.println("\n");
                System.out.println("输入1 继续");
                con = scanner.nextInt();
            }

        }
        while (con == 1);
    }
}

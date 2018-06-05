package LinearList.SinglyList;

public class Josephus extends SinglyList {

    public static void main(String[] args) {
        String[] prisoners = {"A", "B", "C", "D", "E"};
        SinglyList<String> circle = new SinglyList<String>(prisoners);
        int number = prisoners.length;
        int start = 0;
        int distance = 2;

        System.out.println(circle.toString());
        while (number > 1) {
            start = (start + distance - 1) % number;
            System.out.println(circle.remove(start).toString() + "被杀，剩余的人是");
            System.out.println(circle.toString());
            number -= 1;
            if (number == 1) {
                System.out.println("被赦免者是:" + circle.head.next.data);
            }
        }

    }
}

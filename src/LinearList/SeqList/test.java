package LinearList.SeqList;

public class test {
    public static void main(String[] args) {
        String[] values = {"A", "B", "C", "A", "E", "B", "C"};
        SeqList seq = new SeqList(values);
        seq.showAll();
        System.out.println("-----removeAll(\"A\")-----");
        seq.removeAll("A");
        seq.showAll();
        System.out.println("-----removeAll(\"a\")-----");
        seq.removeAll("a");     // 异常测试
        System.out.println("-----replaceFirst(\"B\", \"E\")-----");
        seq.replaceFirst("B", "E");
        seq.showAll();
        System.out.println("-----replaceFirst(\"b\", \"E\")-----");
        seq.replaceFirst("b", "E");
        seq.showAll();
        System.out.println("-----searchLast(\"E\")-----");
        System.out.println(seq.searchLast("E"));
        System.out.println("-----removeLast(\"E\")-----");
        seq.removeLast("E");
        seq.showAll();
        System.out.println("-----removeLast(\"e\")-----");
        seq.removeLast("e");
        seq.showAll();
        System.out.println("-----replaceLast(\"C\", \"Z\")-----");
        seq.replaceLast("C", "Z");
        seq.showAll();
        System.out.println("-----replaceLast(\"c\", \"Z\")-----");
        seq.replaceLast("c", "Z");
        seq.showAll();
        System.out.println("-----replaceLast(\"E\", \"Z\")-----");
        seq.replaceLast("E", "Z");
        seq.showAll();
        System.out.println("-----replaceAll(\"Z\", \"K\")-----");
        seq.replaceAll("Z", "K");
        seq.showAll();

        Integer[] num = {6, 3, 10, 2, 5, 21, 11};
        SeqList seq2 = new SeqList(num);

    }
}

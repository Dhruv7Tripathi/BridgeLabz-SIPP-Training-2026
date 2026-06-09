import java.util.*;

public class test {
    static int a = 10;

    public static void main(String[] args) {
        System.out.println(a);
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        for (String str : list) {
            System.out.println(str);
        }
    }
}

import java.util.*;

public class useGenerics {

    public static void main(String[] args) {
        // Using Generics to ensure type safety

        // Without Generics (unsafe) - would require casting
        // List list = new ArrayList();
        // list.add("Hello");
        // String str = (String) list.get(0); // ClassCastException risk

        // With Generics (type-safe) - no casting needed
        List<String> stringList = new ArrayList<String>();
        stringList.add("Hello");
        stringList.add("World");
        String str = stringList.get(0); // Type-safe, no casting required

        // Generic method example
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        Integer num = intList.get(0); // Type-safe

        // Using generic map
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Age", 25);
        map.put("Score", 95);
        Integer age = map.get("Age"); // Type-safe

        System.out.println("String List: " + stringList);
        System.out.println("Integer List: " + intList);
        System.out.println("Map: " + map);
    }
}

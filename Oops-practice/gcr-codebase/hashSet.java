import java.util.Comparator;
import java.util.TreeSet;

class Student {
  int id;
  String name;
  int age;

  Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
  }
}

public class hashSet {
  public static void main(String[] args) {
    TreeSet<Student> studentSet = new TreeSet<>(Comparator
        .comparing((Student s) -> s.name)
        .thenComparing(Comparator.comparingInt((Student s) -> s.age).reversed()));

    Student student1 = new Student(1, "Alice", 25);
    Student student2 = new Student(2, "Bob", 21);
    Student student3 = new Student(3, "Charlie", 22);

    studentSet.add(student1);
    studentSet.add(student2);
    studentSet.add(student3);

    System.out.println(studentSet);
  }
}

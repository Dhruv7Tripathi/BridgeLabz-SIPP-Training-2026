
class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

class Student extends Person {
  private final int studentId;
  private double gpa;

  public Student(String name, int age, int studentId, double gpa) {
    super(name, age);
    this.studentId = studentId;
    this.gpa = gpa;
  }

  @Override
  public String toString() {
    return "Student{" +
        "parent=" + super.toString() +
        ", studentId=" + studentId +
        ", gpa=" + gpa +
        '}';
  }
}

class GradStudent extends Student {
  private String thesis;

  public GradStudent(String name, int age, int studentId, double gpa, String thesis) {
    super(name, age, studentId, gpa);
    this.thesis = thesis;
  }

  @Override
  public String toString() {
    return "GradStudent{" +
        "parent=" + super.toString() +
        ", thesis='" + thesis + '\'' +
        '}';
  }
}

public class UniversitySystem {
  public static void main(String[] args) {
    Person person = new Person("John", 30);
    Student student = new Student("Alice", 20, 101, 3.8);
    GradStudent gradStudent = new GradStudent("Bob", 25, 102, 3.9, "AI in Education");

    System.out.println(person);
    System.out.println(student);
    System.out.println(gradStudent);

    System.out.println("\nIS-A relationship:");
    System.out.println("GradStudent IS-A Student: " + (gradStudent instanceof Student));
    System.out.println("Student IS-A Person: " + (student instanceof Person));
    System.out.println("GradStudent IS-A Person: " + (gradStudent instanceof Person));
  }
}

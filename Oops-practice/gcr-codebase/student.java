import java.util.ArrayList;

public class student {
  static class employee {
    String name;

    employee(String name) {
      this.name = name;
    }

    @Override
    public String toString() {

      return name;
    }
  }

  public static void main(String[] args) {
    ArrayList<employee> employees = new ArrayList<>();
    employees.add(new employee("Alice"));
    employees.add(new employee("Bob"));
    // employees.add();
    System.out.println(employees);
  }
}

import java.util.*;

public class codingGuild {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // String s1 = sc.nextLine();
    String name = sc.nextLine();
    String rank = sc.nextLine();
    int age = sc.nextInt();
    double salary = sc.nextDouble();
    double membershipFee = salary * 0.05;

    int annualBonus = (int) (salary * 0.12);
    System.out.println("Name: " + name);
    System.out.println("Rank: " + rank);
    System.out.println("Age: " + age);
    System.out.println("Salary: " + salary);
    System.out.println("Membership Fee: " + membershipFee);
    System.out.println("Annual Bonus: " + annualBonus);
    System.out.println("Welcome to the Coding Guild!");
  }
}

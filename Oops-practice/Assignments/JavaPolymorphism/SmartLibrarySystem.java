
abstract class LibraryMember {
  protected String memberName;
  protected String memberId;

  public LibraryMember(String memberName, String memberId) {
    this.memberName = memberName;
    this.memberId = memberId;
  }

  abstract double calculateFine(int overdueDays);

  public void printDetails() {
    System.out.println("Name: " + memberName + ", ID: " + memberId);
  }
}

class StudentMember extends LibraryMember {
  public StudentMember(String memberName, String memberId) {
    super(memberName, memberId);
  }

  @Override
  double calculateFine(int overdueDays) {
    return overdueDays * 5.0;
  }
}

class FacultyMember extends LibraryMember {
  public FacultyMember(String memberName, String memberId) {
    super(memberName, memberId);
  }

  @Override
  double calculateFine(int overdueDays) {
    return overdueDays * 2.0;
  }
}

class GuestMember extends LibraryMember {
  public GuestMember(String memberName, String memberId) {
    super(memberName, memberId);
  }

  @Override
  double calculateFine(int overdueDays) {
    return overdueDays * 10.0;
  }
}

public class SmartLibrarySystem {
  private LibraryMember[] members;
  private int memberCount;

  public SmartLibrarySystem(int capacity) {
    members = new LibraryMember[capacity];
    memberCount = 0;
  }

  public void addMember(LibraryMember member) {
    if (memberCount < members.length) {
      members[memberCount++] = member;
    }
  }

  public void printAllMembers() {
    System.out.println("=== Library Members ===");
    for (int i = 0; i < memberCount; i++) {
      members[i].printDetails();
    }
  }

  public void findAndDisplayMember(String memberId) {
    for (int i = 0; i < memberCount; i++) {
      if (members[i].memberId.equals(memberId)) {
        System.out.println("Member Found:");
        members[i].printDetails();
        return;
      }
    }
    System.out.println("Member with ID " + memberId + " not found.");
  }

  public void displayMemberFine(String memberId, int overdueDays) {
    for (int i = 0; i < memberCount; i++) {
      if (members[i].memberId.equals(memberId)) {
        double fine = members[i].calculateFine(overdueDays);
        System.out.println(members[i].memberName + " - Fine: $" + fine);
        return;
      }
    }
  }

  public static void main(String[] args) {
    SmartLibrarySystem library = new SmartLibrarySystem(5);

    library.addMember(new StudentMember("Alice", "S001"));
    library.addMember(new FacultyMember("Prof. Bob", "F001"));
    library.addMember(new GuestMember("Charlie", "G001"));

    library.printAllMembers();

    System.out.println("\n=== Finding Member ===");
    library.findAndDisplayMember("S001");

    System.out.println("\n=== Fine Calculation ===");
    library.displayMemberFine("S001", 5);
    library.displayMemberFine("F001", 5);
    library.displayMemberFine("G001", 5);
  }
}

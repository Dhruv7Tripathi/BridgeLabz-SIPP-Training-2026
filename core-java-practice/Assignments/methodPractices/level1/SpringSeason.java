
public class SpringSeason {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Not a Spring Season");
      return;
    }
    int month, day;
    try {
      month = Integer.parseInt(args[0]);
      day = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
      System.out.println("Not a Spring Season");
      return;
    }

    if (isSpring(month, day)) {
      System.out.println("Its a Spring Season");
    } else {
      System.out.println("Not a Spring Season");
    }
  }

  public static boolean isSpring(int month, int day) {
    // Spring is March 20 (3/20) to June 20 (6/20) inclusive
    if (month < 3 || month > 6)
      return false;
    if (month == 3)
      return day >= 20 && day <= 31;
    if (month == 6)
      return day <= 20 && day >= 1;
    return day >= 1 && day <= 31; // April and May
  }

}

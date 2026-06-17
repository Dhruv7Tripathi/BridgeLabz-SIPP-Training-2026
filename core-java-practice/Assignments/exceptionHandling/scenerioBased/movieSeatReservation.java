
public class movieSeatReservation {
  private static int[] seats = { 101, 102, 103, 104, 105 };

  public static int getSeat(int index) {
    try {
      return seats[index];
    } catch (Exception e) {
      // handle invalid access and return -1
      return -1;
    }
  }

  public static void main(String[] args) {
    int requested = 8;
    int result = getSeat(requested);
    System.out.println(result);
  }
}

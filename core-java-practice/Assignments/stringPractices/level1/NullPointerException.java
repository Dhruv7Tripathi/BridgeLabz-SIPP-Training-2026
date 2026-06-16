public class NullPointerException {

  public static void generateException() {
    String text = null;
    text.length();
  }

  public static void handleException() {
    String text = null;

    try {
      text.length();
    } catch (java.lang.NullPointerException e) {
      System.out.println("NullPointerException handled");
    }
  }

  public static void main(String[] args) {
    generateException();
    handleException();
  }
}

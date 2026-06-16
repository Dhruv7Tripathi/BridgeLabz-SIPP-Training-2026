public class usernameValidator {

  public static boolean isValidUsername(String username) {
    if (username == null || username.isEmpty()) {
      return false;
    }
    return isValidUsername(username, 0);
  }

  private static boolean isValidUsername(String username, int index) {
    if (index == username.length()) {
      return true;
    }

    char ch = username.charAt(index);
    if (ch < 'a' || ch > 'z') {
      return false;
    }

    return isValidUsername(username, index + 1);
  }
}

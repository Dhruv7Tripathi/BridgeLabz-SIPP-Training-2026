import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class customerFeedBackAnalyzer {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;
    Pattern p = Pattern.compile("\\bgood\\b", Pattern.CASE_INSENSITIVE);
    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      if (line == null)
        break;
      if (p.matcher(line).find())
        count++;
    }
    System.out.println("Good Feedback Count = " + count);
  }
}

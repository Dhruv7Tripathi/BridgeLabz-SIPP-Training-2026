import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class checkedException {

  public static void main(String[] args) {
    try {
      String content = Files.readString(Path.of("data.txt"));
      System.out.print(content);
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }
}

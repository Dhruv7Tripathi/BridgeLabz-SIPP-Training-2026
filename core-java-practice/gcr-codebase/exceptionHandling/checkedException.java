package exceptionHandling;

import java.io.FileReader;
import java.io.IOException;

public class checkedException {
  static void calculateTotal() throws FileNotFoundException {
    File fr = new File("file.txt");
    FileReader fileReader = new FileReader(fr);
  }

  // public static void main(String[] args) {
  // try {
  // readFile("file.txt");
  // } catch (IOException e) {
  // System.out.println("Caught IOException: " + e.getMessage());
  // e.printStackTrace();
  // }
  // }

  // public static void readFile(String filename) throws IOException {
  // FileReader fr = new FileReader(filename);
  // fr.close();
  // }
}

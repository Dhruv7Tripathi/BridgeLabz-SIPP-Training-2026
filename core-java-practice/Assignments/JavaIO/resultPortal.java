import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class resultPortal {

  public static void main(String[] args) {
    String inputFile = args.length > 0 ? args[0] : "results.txt";
    String outputFile = args.length > 1 ? args[1] : "report-card.txt";

    try {
      List<String> students = readInput(inputFile);
      appendReport(students, outputFile);
      System.out.println("Report appended to " + outputFile);
    } catch (FileNotFoundException e) {
      System.out.println("Input file not found: " + inputFile);
    } catch (IOException e) {
      System.out.println("I/O error: " + e.getMessage());
    }
  }

  private static List<String> readInput(String inputFile) throws FileNotFoundException {
    List<String> students = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(inputFile))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
          students.add(line);
        }
      }
    }
    return students;
  }

  private static void appendReport(List<String> students, String outputFile) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
      writer.newLine();
      writer.write("===== Student Result Report =====");
      writer.newLine();

      for (String student : students) {
        String[] parts = student.split(",");
        if (parts.length < 2) {
          continue;
        }

        String name = parts[0].trim();
        double total = 0;
        int count = 0;

        for (int i = 1; i < parts.length; i++) {
          try {
            total += Double.parseDouble(parts[i].trim());
            count++;
          } catch (NumberFormatException ignored) {
            // Ignore invalid marks.
          }
        }

        if (count == 0) {
          continue;
        }

        double average = total / count;
        writer.write(String.format("%s | Average: %.2f", name, average));
        writer.newLine();
      }
    }
  }
}

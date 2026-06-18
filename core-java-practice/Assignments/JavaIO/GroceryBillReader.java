import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {
        String fileName = "bill.txt";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            System.out.println("Total lines: " + count);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

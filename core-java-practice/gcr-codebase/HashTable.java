import java.util.Hashtable;

public class HashTable {
  private Hashtable<String, String> table = new Hashtable<>();

  public void storeString(String key, String value) {
    table.put(key, value);
  }

  public String retrieveString(String key) {
    return table.get(key);
  }
}

public class box<T> {
  private T value;

  public box(T value) {
    this.value = value;
  }

  public T get() {
    return value;
  }

  public T fetch() {
    return value;
  }

  public void set(T value) {
    this.value = value;
  }

  public static void main(String[] args) {
    box<Integer> i = new box<>(10);
    System.out.println(i.fetch());
    i.set(20);
    System.out.println(i.fetch());
    box<String> b = new box<>("Hello");
    System.out.println(b.fetch());
    b.set("World");
    System.out.println(b.fetch());
  }
}

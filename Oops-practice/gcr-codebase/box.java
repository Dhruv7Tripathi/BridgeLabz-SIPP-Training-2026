
class fruits {
  private String name;

  public fruits(String name) {
    this.name = name;
  }

  public String taste() {
    return name + " tastes sweet";
  }

  @Override
  public String toString() {
    return name;
  }
}

class box<T extends fruits> {
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
    box<fruits> b = new box<>(new fruits("Apple"));
    System.out.println(b.fetch());
    System.out.println(b.fetch().taste());

    b.set(new fruits("Mango"));
    System.out.println(b.fetch());
    System.out.println(b.fetch().taste());
  }
}

public class favuorComposition {

  interface Repository<T> {
    void save(T item);

    T getLastSaved();
  }

  static class MemoryRepository<T> implements Repository<T> {
    private T lastSaved;

    @Override
    public void save(T item) {
      this.lastSaved = item;
    }

    @Override
    public T getLastSaved() {
      return lastSaved;
    }
  }

  static class Service<T> {
    private final Repository<T> repository; // Composition over inheritance

    Service(Repository<T> repository) {
      this.repository = repository;
    }

    void process(T item) {
      repository.save(item);
    }

    T latest() {
      return repository.getLastSaved();
    }
  }
}

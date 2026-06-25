interface StreamingService {
  void streamMovie(String movieName);

  default void showSubscriptionDetails() {
    System.out.println("Streaming service subscription is active.");
  }
}

interface GamingService {
  void playGame(String gameName);

  default void showSubscriptionDetails() {
    System.out.println("Gaming service subscription is active.");
  }
}

public class MultiServiceSmartTv implements StreamingService, GamingService {
  private final String[] movieNames = { "Inception", "The Matrix", "Interstellar" };
  private final String[] gameNames = { "FIFA", "Minecraft", "Chess" };

  @Override
  public void streamMovie(String movieName) {
    System.out.println("Streaming movie: " + movieName);
  }

  @Override
  public void playGame(String gameName) {
    System.out.println("Playing game: " + gameName);
  }

  @Override
  public void showSubscriptionDetails() {
    StreamingService.super.showSubscriptionDetails();
    GamingService.super.showSubscriptionDetails();
  }

  public void displayAvailableContent() {
    System.out.println("Available movies:");
    for (String movie : movieNames) {
      System.out.println(movie);
    }

    System.out.println("Available games:");
    for (String game : gameNames) {
      System.out.println(game);
    }
  }

  public static void main(String[] args) {
    MultiServiceSmartTv smartTv = new MultiServiceSmartTv();
    smartTv.showSubscriptionDetails();
    smartTv.displayAvailableContent();
  }
}

interface TextModeration {
  void moderateText(String post);

  default void displayModerationPolicy() {
    System.out.println("Text moderation policy: no offensive content.");
  }

  static boolean containsRestrictedWords(String post) {
    String lower = post.toLowerCase();
    return lower.contains("hate") || lower.contains("abuse") || lower.contains("badword");
  }
}

interface SpamDetection {
  void detectSpam(String post);

  default void displayModerationPolicy() {
    System.out.println("Spam detection policy: no repetitive or promotional spam.");
  }

  static boolean isSpam(String post) {
    String lower = post.toLowerCase();
    return lower.contains("buy now") || lower.contains("click here") || lower.contains("free money");
  }
}

class ContentModerator implements TextModeration, SpamDetection {
  @Override
  public void moderateText(String post) {
    // implemented via reviewPosts
  }

  @Override
  public void detectSpam(String post) {
    // implemented via reviewPosts
  }

  public void reviewPosts(String[] posts) {
    for (String post : posts) {
      if (SpamDetection.isSpam(post)) {
        System.out.println("Spam post: " + post);
      } else if (TextModeration.containsRestrictedWords(post)) {
        System.out.println("Offensive post: " + post);
      } else {
        System.out.println("Valid post: " + post);
      }
    }
  }

  @Override
  public void displayModerationPolicy() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayModerationPolicy'");
  }
}

public class AIContentModerationPlatform {
  public static void main(String[] args) {
    String[] posts = {
        "This is a normal community update.",
        "Buy now and get free money!",
        "I hate this abusive behavior.",
        "Click here for amazing offers!"
    };

    ContentModerator moderator = new ContentModerator();
    moderator.reviewPosts(posts);
  }
}

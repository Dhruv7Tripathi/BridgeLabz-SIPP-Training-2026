class Notification {
  String recipientName;
  String message;

  Notification(String recipientName, String message) {
    this.recipientName = recipientName;
    this.message = message;
  }

  void sendNotification() {
    System.out.println("Sending notification to " + recipientName + ": " + message);
  }
}

class EmailNotification extends Notification {
  EmailNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println("Email sent to " + recipientName + ": " + message);
  }
}

class SMSNotification extends Notification {
  SMSNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println("SMS sent to " + recipientName + ": " + message);
  }
}

class PushNotification extends Notification {
  PushNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println("Push notification sent to " + recipientName + ": " + message);
  }
}

public class SmartNotificationSystem {
  public static void main(String[] args) {
    Notification[] notifications = {
        new EmailNotification("Alice", "Your order has been shipped."),
        new SMSNotification("Bob", "Your OTP is 123456."),
        new PushNotification("Charlie", "You have a new app alert.")
    };

    for (Notification notification : notifications) {
      notification.sendNotification();
    }
  }
}

interface Trackable {
  void logActivity();

  default void resetData() {
    System.out.println("Data reset.");
  }
}

interface Reportable {
  void generateReport();
}

interface Notifiable {
  void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
  @Override
  public void logActivity() {
    System.out.println("Activity logged.");
  }

  @Override
  public void generateReport() {
    System.out.println("Report generated.");
  }

  @Override
  public void sendAlert() {
    System.out.println("Alert sent.");
  }
}

public class fitnessTracker {
  public static void main(String[] args) {
    FitnessDevice device = new FitnessDevice();
    device.logActivity();
    device.generateReport();
    device.sendAlert();
    device.resetData();
  }
}

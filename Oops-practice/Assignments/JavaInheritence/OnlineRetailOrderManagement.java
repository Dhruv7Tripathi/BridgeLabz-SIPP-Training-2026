import java.time.LocalDate;

class Order {
  protected String orderId;
  protected LocalDate orderDate;

  public Order(String orderId, LocalDate orderDate) {
    this.orderId = orderId;
    this.orderDate = orderDate;
  }

  public String getOrderStatus() {
    return "Order Placed";
  }
}

class ShippedOrder extends Order {
  protected String trackingNumber;

  public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
    super(orderId, orderDate);
    this.trackingNumber = trackingNumber;
  }

  @Override
  public String getOrderStatus() {
    return "Shipped";
  }
}

class DeliveredOrder extends ShippedOrder {
  protected LocalDate deliveryDate;

  public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
    super(orderId, orderDate, trackingNumber);
    this.deliveryDate = deliveryDate;
  }

  @Override
  public String getOrderStatus() {
    return "Delivered";
  }
}

public class OnlineRetailOrderManagement {
  public static void main(String[] args) {
    Order order = new Order("ORD001", LocalDate.now());
    ShippedOrder shippedOrder = new ShippedOrder("ORD002", LocalDate.now(), "TRK12345");
    DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", LocalDate.now(), "TRK67890", LocalDate.now());

    System.out.println(order.getOrderStatus());
    System.out.println(shippedOrder.getOrderStatus());
    System.out.println(deliveredOrder.getOrderStatus());
  }
}

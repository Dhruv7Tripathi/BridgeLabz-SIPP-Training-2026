interface CouponValidator {
  boolean validateCoupon(String code);

  static boolean isLengthValid(String code) {
    return code != null && code.length() >= 5;
  }
}

class ShoppingCart implements CouponValidator {
  @Override
  public boolean validateCoupon(String code) {
    return CouponValidator.isLengthValid(code) && code.startsWith("SAVE");
  }
}

public class OnlineCoupanValidator {
  public static void main(String[] args) {
    String[] coupons = { "SAVE10", "OFF", "SAVE20", "DEAL" };
    ShoppingCart cart = new ShoppingCart();

    for (String coupon : coupons) {
      System.out.println(coupon + " is " + (cart.validateCoupon(coupon) ? "valid" : "invalid"));
    }
  }
}

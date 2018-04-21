package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public List<BigDecimal> getDiscounts() {
        return discounts;
    }

    public List<OrderLineItem> getOrderLineItemList() {
        return orderLineItemList;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal calculate() {
      /*  PriceCaculator priceCaculator=new PriceCaculator();
        priceCaculator.total(orderLineItemList);
        priceCaculator.discount(discounts);
        BigDecimal tax=priceCaculator.tax(this.tax);
        BigDecimal grandTotal=priceCaculator.grandTotal(tax);
        return grandTotal;*/
      return new PriceCaculator(this).calculate();
    }
}

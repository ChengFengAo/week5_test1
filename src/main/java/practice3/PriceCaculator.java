package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {
    private Order order;
    private BigDecimal subTotal = new BigDecimal(0);
    private BigDecimal taxs,grandTotle;

    public PriceCaculator(Order order){
      this.order=order;
    }

    public BigDecimal calculate() {
        total(order.getOrderLineItemList());
        discount(order.getDiscounts());
        BigDecimal tax=tax(order.getTax());
        BigDecimal grandTotal=grandTotal(tax);
        return grandTotle;
    }


    public BigDecimal total(List<OrderLineItem> orderLineItemList) {
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
        return subTotal;
    }

    public BigDecimal discount(List<BigDecimal> discounts) {
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
        return subTotal;
    }

    public BigDecimal tax(BigDecimal tax) {
         taxs= subTotal.multiply(tax);
         return taxs;
    }

    public BigDecimal grandTotal(BigDecimal taxs) {
        grandTotle= subTotal.add(taxs);
        return grandTotle;
    }
}

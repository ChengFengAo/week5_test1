package practice2;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    private BigDecimal tax;

    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal discountTotal = calculateDiscount(products, items);
        BigDecimal taxTotal = calculateTaxTotal(discountTotal);
        BigDecimal grandTotal = calculateGrandTotal(taxTotal, discountTotal);
        return grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public BigDecimal calculateGrandTotal(BigDecimal taxTotal, BigDecimal discountTotal) {
        return discountTotal.add(taxTotal);
    }
    public BigDecimal calculateTaxTotal(BigDecimal discountTotal) {
        return discountTotal.multiply(tax);
    }
    public BigDecimal calculateDiscount(List<Product> products, List<OrderItem> items) {
        BigDecimal discount =calculateSubtotal(products, items);
        for (Product product : products) {
            OrderItem curItem = findOrderItemByProduct(items, product);
            BigDecimal reducedPrice = product.getPrice()
                    .multiply(product.getDiscountRate())
                    .multiply(new BigDecimal(curItem.getCount()));
            discount = discount.subtract(reducedPrice);
        }
        return discount;
    }
    public BigDecimal calculateSubtotal(List<Product> products, List<OrderItem> items) {   //计算总价格
         BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            OrderItem item = findOrderItemByProduct(items, product);
            BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(item.getCount()));
            subTotal = subTotal.add(itemTotal);
        }
        return subTotal;
    }
    public OrderItem findOrderItemByProduct(List<OrderItem> items, Product product) { //查询订单数量
        OrderItem curItem = null;
        for (OrderItem item : items) {
            if (item.getCode() == product.getCode()) {
                curItem = item;
                break;
            }
        }
        return curItem;
    }


}

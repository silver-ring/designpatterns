package designpatterns.example.behivor.template;

import java.math.BigDecimal;
import java.util.Map;

public abstract class BillCalculator {

    public BigDecimal calculateBill(Map<Long, BigDecimal> items) {
        BigDecimal totalPrice = calculateTotalPrice(items);
        BigDecimal tax = calculateTax(items);
        BigDecimal totalDiscount = calculateTotalDiscount(items);
        BigDecimal offer = calculateOffer(items);
        return totalPrice.add(tax).subtract(totalDiscount).subtract(offer);
    }

    protected BigDecimal calculateTotalPrice(Map<Long, BigDecimal> items) {
        return items.values().stream().reduce(BigDecimal::add).get();
    }

    protected BigDecimal calculateTax(Map<Long, BigDecimal> items) {
        return BigDecimal.ZERO;
    }

    protected BigDecimal calculateTotalDiscount(Map<Long, BigDecimal> items) {
        return BigDecimal.ZERO;
    }

    protected BigDecimal calculateOffer(Map<Long, BigDecimal> items) {
        return BigDecimal.ZERO;
    }

}

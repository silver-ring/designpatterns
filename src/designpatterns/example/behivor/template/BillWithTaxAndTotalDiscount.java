package designpatterns.example.behivor.template;

import java.math.BigDecimal;
import java.util.Map;

public class BillWithTaxAndTotalDiscount extends BillCalculator {

    @Override
    protected BigDecimal calculateTax(Map<Long, BigDecimal> items) {
        BigDecimal totalPrice = calculateTotalPrice(items);
        return totalPrice.multiply(BigDecimal.valueOf(0.12));
    }

    @Override
    protected BigDecimal calculateTotalDiscount(Map<Long, BigDecimal> items) {
        BigDecimal totalPrice = calculateTotalPrice(items);
        return totalPrice.multiply(BigDecimal.valueOf(0.02));
    }

}

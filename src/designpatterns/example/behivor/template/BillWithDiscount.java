package designpatterns.example.behivor.template;

import java.math.BigDecimal;
import java.util.Map;

public class BillWithDiscount extends BillCalculator {

    @Override
    protected BigDecimal calculateTotalDiscount(Map<Long, BigDecimal> items) {

        BigDecimal discountAmount = BigDecimal.ZERO;

        if (items.containsKey(20)) {
            discountAmount.add(BigDecimal.valueOf(12));
        }

        return discountAmount;
    }
}

package designpatterns.example.behivor.template;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailNotificationTest {

    @Test
    final public void calculateBill() {
        Map<Long, BigDecimal> items = new HashMap<>();
        items.put(10L, BigDecimal.valueOf(15));
        items.put(20L, BigDecimal.valueOf(30));
        items.put(30L, BigDecimal.valueOf(17));
        items.put(40L, BigDecimal.valueOf(28));
        items.put(50L, BigDecimal.valueOf(100));

        BillCalculator billWithDiscount = new BillWithDiscount();
        BigDecimal billWithDiscountResult = billWithDiscount.calculateBill(items);

        assertEquals(BigDecimal.valueOf(190), billWithDiscountResult);

        BillCalculator billWithTaxAndTotalDiscount = new BillWithTaxAndTotalDiscount();
        BigDecimal billWithTaxAndTotalDiscountResult = billWithTaxAndTotalDiscount.calculateBill(items);

        assertEquals(BigDecimal.valueOf(209).setScale(2), billWithTaxAndTotalDiscountResult);

    }

}
package 设计模式.策略.strategy;

import java.math.BigDecimal;

/**
 * created on 2018/12/11.
 *
 * @author J
 **/
public class DiscountPer200sub20 implements DiscountStrategy {

    private BigDecimal discount = BigDecimal.valueOf(20);

    @Override
    public BigDecimal discount(BigDecimal amount) {
        int count = amount.intValue() / 200;
        return amount.subtract(discount.multiply(BigDecimal.valueOf(count)));
    }
}

package 设计模式.策略.strategy;

import java.math.BigDecimal;

/**
 * created on 2018/12/11.
 *
 * @author J
 **/
public interface DiscountStrategy {
    /**
     * 计算折扣之后的价格
     */
    default BigDecimal discount(BigDecimal amount) {
        return amount;
    }
}

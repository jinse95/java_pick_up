package 设计模式.策略.strategy;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import 设计模式.策略.Coupon;

import java.math.BigDecimal;

/**
 * created on 2018/12/11.
 *
 * @author J
 **/
@Getter
@Setter
@Accessors(chain = true)
public class ShopDiscountStrategy implements DiscountStrategy {

    private Coupon coupon;

    @Override
    public BigDecimal discount(BigDecimal amount) {
        BigDecimal low = BigDecimal.valueOf(coupon.getLowerLimit());
        BigDecimal high = BigDecimal.valueOf(coupon.getHighLimit());
        //若是不满足条件，返回原价
        if (!(amount.compareTo(low) >= 0 && amount.compareTo(high) < 0)) {
            return amount;
        }

    }
}

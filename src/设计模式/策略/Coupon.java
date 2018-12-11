package 设计模式.策略;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * created on 2018/12/11.
 *
 * @author J
 **/
@Getter
@Setter
@Accessors(chain = true)
public class Coupon {

    private Long id;

    /**
     * 金额或者折扣（1-99）
     */
    private Integer discount;

    /**
     * 类型   1满减  2满折 3满x件减y件价格 4满x件打折
     */
    private Byte couponType;


    /**
     * 下限 对应的金额或者件数
     */
    private Integer lowerLimit;

    /**
     * 上限 对应的金额或者件数
     */
    private Integer highLimit = Integer.MAX_VALUE;
}

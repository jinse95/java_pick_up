package 设计模式.策略;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

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
     * 类型
     * 1 满 lowerLimit 元减 discount 元
     * 2 满 lowerLimit 元打 discount 折
     * 3 满 lowerLimit 件减 discount 件价格
     * 4 满 lowerLimit 件打 discount 折
     */
    private Byte couponType;


    /**
     * 下限 对应的金额或者件数
     */
    private Integer lowerLimit;

    /**
     * 使用开始时间
     */
    private Date beginTime;

    /**
     * 使用截止时间
     */
    private Date endTime;

    /**
     * 上限 对应的金额或者件数
     */
    private Integer highLimit = Integer.MAX_VALUE;

    /**
     * 优惠券优先级
     */
    private Byte couponOrder = 0;
}

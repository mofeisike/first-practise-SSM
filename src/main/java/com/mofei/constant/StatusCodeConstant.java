package com.mofei.constant;

/**
 * @author mofeiske
 * @Description: 状态常量定义
 * @Date: Create in 2019/2/4 17:01
 */
public class StatusCodeConstant {

    /*
    * 存在
    */
    public static final int EXISTS = 2000;


    /*
     * 不存在
     */
    public static final int NO_EXISTS = 3000;
    public static final String NO_EXISTS_MSG = "账号不存在";


    /*
     *冻结
     */
    public static final int FREERON= 4000;
    public static final String FREERON_MSG= "账号被冻结";

    /*
     *激活
     */
    public static final int ACTIVE= 5000;

    /*
     *余额不够
     */
    public static final int BALANCE_NOT_ENOUGH= 6000;
    public static final String BALANCE_NOT_ENOUGH_MSG= "余额不足";

    /*
     *成功
     */
    public static final int SUCCESS= 7000;

    public static final String SUCCESS_MSG = "成功";
}

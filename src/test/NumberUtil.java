package test;

import java.math.BigDecimal;

/**
 * @ClassName NumberUtil
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/8 12:12 下午
 * @Version 1.0
 **/
public class NumberUtil {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("110036");
        System.out.println(bigDecimal2chineseNum(bd));
    }

    private NumberUtil() { }

    /**
     * 中文数字
     */
    private static final String[] CN_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * 中文数字单位
     */
    private static final String[] CN_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";

    /**
     * 特殊字符：点
     */
    private static final String CN_POINT = "点";


    /**
     * int 转 中文数字
     * 支持到int最大值
     *
     * @param intNum 要转换的整型数
     * @return 中文数字
     */
    public static String int2chineseNum(int intNum) {
        StringBuffer sb = new StringBuffer();
        boolean isNegative = false;
        if (intNum < 0) {
            isNegative = true;
            intNum *= -1;
        }
        int count = 0;
        while(intNum > 0) {
            sb.insert(0, CN_NUM[intNum % 10] + CN_UNIT[count]);
            intNum = intNum / 10;
            count++;
        }

        if (isNegative)
            sb.insert(0, CN_NEGATIVE);

        // 一十一万零千零百三十六

        // 一十一万零三十六

        // 正则表达式匹配
        return sb.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
        //return sb.toString();
    }

    /**
     * bigDecimal 转 中文数字
     * 整数部分只支持到int的最大值
     *
     * @param bigDecimalNum 要转换的BigDecimal数
     * @return 中文数字
     */
    public static String bigDecimal2chineseNum(BigDecimal bigDecimalNum) {
        if (bigDecimalNum == null)
            return CN_NUM[0];

        StringBuffer sb = new StringBuffer();

        //将小数点后面的零给去除
        String numStr = bigDecimalNum.abs().stripTrailingZeros().toPlainString();

        String[] split = numStr.split("\\.");
        String integerStr = int2chineseNum(Integer.parseInt(split[0]));

        sb.append(integerStr);

        //如果传入的数有小数，则进行切割，将整数与小数部分分离
        if (split.length == 2) {
            //有小数部分
            sb.append(CN_POINT);
            String decimalStr = split[1];
            char[] chars = decimalStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = Integer.parseInt(String.valueOf(chars[i]));
                sb.append(CN_NUM[index]);
            }
        }

        //判断传入数字为正数还是负数
        int signum = bigDecimalNum.signum();
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }

        return sb.toString();
    }
}

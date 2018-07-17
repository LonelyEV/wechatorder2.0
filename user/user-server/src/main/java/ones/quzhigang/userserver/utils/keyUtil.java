/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: keyUtil
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.utils;

import java.util.Random;

public class keyUtil {

    /**
     * 功能描述: <br>
     * 〈生成唯一主键〉
     *
     * @param
     * @return: java.lang.String
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:19
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}

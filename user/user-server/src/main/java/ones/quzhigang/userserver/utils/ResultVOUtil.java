/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ResultVOUtil
 * Author:   屈志刚
 * Date:     2018/4/25 0025 13:58
 * Description: 结果集转VO工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.utils;

import ones.quzhigang.userserver.enums.ResultEnum;
import ones.quzhigang.userserver.vo.ResultVo;

public class ResultVOUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo error(ResultEnum resultEnum) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(resultEnum.getCode());
        resultVo.setMsg(resultEnum.getMessage());
        return resultVo;
    }
}

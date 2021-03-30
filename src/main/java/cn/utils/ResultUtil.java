package cn.utils;


import cn.dto.ResultDto;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/15 9:14
 * @Description:
 **/
public class ResultUtil {
    public static ResultDto returnSuccess(Object data, int count){
        ResultDto dto = new ResultDto<>();
        dto.setCode(0);
        dto.setData(data);
        dto.setCount(count);
        return dto;
    }

    public static ResultDto returnSuccess(String message){
        ResultDto dto = new ResultDto<>();
        dto.setCode(0);
        dto.setMsg(message);
        return dto;
    }
    public static ResultDto returnSuccess(SysCode sysCode){
        ResultDto dto = new ResultDto<>();
        dto.setCode(sysCode.getCode());
        dto.setMsg(sysCode.getDescription());
        return dto;
    }
    public static ResultDto returnSuccess(){
        ResultDto dto = new ResultDto<>();
        dto.setCode(0);
        return dto;
    }

    /**
     * 返回失败的方法
     * @param code
     * @param msg
     * @return
     */
    public static ResultDto returnFail(int code,String msg){
        ResultDto dto = new ResultDto();
        dto.setCode(code);
        dto.setMsg(msg);
        return dto;
    }
}

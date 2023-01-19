package com.atguigu.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chen Peiyu
 * @version 1.0
 * @description 自定义的异常类
 * @date 1/19/2023 8:26 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgktException extends RuntimeException{
    private Integer code;
    private String msg;

    /**
     * 抛出自定义异常的方法
     * @param code
     * @param errMessage
     */
    public static void cast( Integer code,String errMessage){
        throw new GgktException(code,errMessage);
    }
}

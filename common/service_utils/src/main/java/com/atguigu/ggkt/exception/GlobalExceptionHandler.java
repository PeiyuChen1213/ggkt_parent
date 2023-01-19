package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Chen Peiyu
 * @version 1.0
 * @description 全局异常处理
 * @date 1/19/2023 8:20 PM
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ExceptionHandler(Exception e) {
        e.printStackTrace();
        String message = e.getMessage();
        return Result.fail().message(message);
    }

    /**
     * 处理特定的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    /**
     * 自定义异常类的处理器
     * @param e
     * @return
     */
    @ExceptionHandler(GgktException.class)
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.fail().message(e.getMsg()).code(e.getCode());
    }


}

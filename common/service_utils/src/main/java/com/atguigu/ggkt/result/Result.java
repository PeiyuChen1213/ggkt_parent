package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Chen Peiyu
 * @version 1.0
 * @description 全局统一返回结果类
 * @date 1/19/2023 3:26 PM
 */
@Data
@ApiModel("全局统一返回结果")
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result() {
    }
    private static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<T>();
        if (body != null) {
            result.setData(body);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        return build(data,200,"成功");
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(T data){
        return build(data, 201,"失败");
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}

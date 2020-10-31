package com.qf.hua.ssm.utils;


import lombok.Builder;
import lombok.Data;

/*
* 构建者模式
*/
/*@Builder*/
@Data
public class ResponseEntity<T> {
    private int status;
    private String message;
    private T data;

    public ResponseEntity() {
    }

    public static <T> ResponseEntity<T> success(T data){
        //第一种方式
        ResponseEntity<T> entity = new ResponseEntity();
        entity.setData(data);
        entity.setMessage(ErrorStatus.SUCCESS.getMessage());
        entity.setStatus(ErrorStatus.SUCCESS.getStatus());
        return entity;

        //第二种方式
        /*return (ResponseEntity<T>)ResponseEntity
                .builder().data(data)
                .message(ErrorStatus.SUCCESS.getMessage())
                .status(ErrorStatus.SUCCESS.getStatus()).build();*/
    }

    public static <T> ResponseEntity<T> error(){
        ResponseEntity<T> entity = new ResponseEntity();
        entity.setMessage(ErrorStatus.SERVICE_ERROR.getMessage());
        entity.setStatus(ErrorStatus.SERVICE_ERROR.getStatus());
        return entity;

        /*return (ResponseEntity<T>)ResponseEntity
                .builder()
                .message(ErrorStatus.SERVICE_ERROR.getMessage())
                .status(ErrorStatus.SERVICE_ERROR.getStatus()).build();*/
    }
}

package com.example.logindemo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 24797
 * @version 1.0
 * @description a standard response class when network fetching
 * @date 2025/12/13 16:18
 */
public class Response<T> implements Serializable {
    /**
     * response status represents system status code
     */
    private Integer status;
    /**
     * response massage represents system info
     */
    private String message;
    /**
     * response's timestamp
     */
    private Date timestamp;
    /**
     * any type's data, the info want transfer
     */
    private T data;

    /**
     * @param status    system status code
     * @param message   system info
     * @param timestamp timestamp when response
     * @return success result collection without data
     * @author 24797
     * @date 2025/12/13 16:44
     */
    public static <T> Response<T> success(Integer status, String message, Date timestamp) {
        Response<T> r = new Response<T>();
        r.status = status;
        r.message = message;
        r.timestamp = timestamp;
        return r;
    }

    /**
     * @param status    system status code
     * @param message   system info
     * @param timestamp timestamp when response
     * @param data      any type's data
     * @return success result collection with data
     * @author 24797
     * @date 2025/12/13 16:48
     */
    public static <T> Response<T> success(Integer status, String message, Date timestamp, T data) {
        Response<T> r = new Response<T>();
        r.status = status;
        r.message = message;
        r.timestamp = timestamp;
        r.data = data;
        return r;
    }

    /**
     * @param status    system status code
     * @param message   system info
     * @param timestamp timestamp when response
     * @return error result collection with data
     * @author 24797
     * @date 2025/12/13 16:50
     */
    public static <T> Response<T> error(Integer status, String message, Date timestamp) {
        Response<T> r = new Response<T>();
        r.status = status;
        r.message = message;
        r.timestamp = timestamp;
        return r;
    }

    /**
     * @param status    system status code
     * @param message   system info
     * @param timestamp timestamp when response
     * @param data      any type's data
     * @return error result collection with data
     * @author 24797
     * @date 2025/12/13 16:54
     */
    public static <T> Response<T> error(Integer status, String message, Date timestamp, T data) {
        Response<T> r = new Response<T>();
        r.status = status;
        r.message = message;
        r.timestamp = timestamp;
        r.data = data;
        return r;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}

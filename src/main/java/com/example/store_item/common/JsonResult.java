package com.example.store_item.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult implements Serializable {
    private Integer state;
    private String message;
    private Object data;
    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, Object data) {
        this.state = state;
        this.data = data;
    }
}

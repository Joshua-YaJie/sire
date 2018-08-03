package com.example.demo.dto;

/**
 * Created by jiyajie on 16/8/24.
 */
public class JsonResultDto {

    private boolean success;

    private int code;

    private Object data;

    private String refer;

    public JsonResultDto(boolean _success, int _code, Object _data) {
        this.success = _success;
        this.code = _code;
        this.data = _data;
    }

    public JsonResultDto(boolean _success, String refer) {
        this.success = _success;
        this.refer = refer;
    }
    public JsonResultDto(boolean _success) {
        this(_success, 0, null);
    }

    public JsonResultDto(boolean _success, int _code) {
        this(_success, _code, null);
    }


    public JsonResultDto() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }
}

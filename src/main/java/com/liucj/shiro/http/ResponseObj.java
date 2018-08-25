package com.liucj.shiro.http;

import java.io.Serializable;
import java.util.Calendar;

public class ResponseObj implements Serializable {

    private static final long serialVersionUID = 8037485279569398135L;
    
    private int status;
    
    private String message;
    
    private Object data;
    
    private long timestamp = Calendar.getInstance().getTimeInMillis();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

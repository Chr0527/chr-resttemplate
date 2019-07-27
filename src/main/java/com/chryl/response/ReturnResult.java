package com.chryl.response;

import java.io.Serializable;

/**
 * Created By Chr on 2019/7/27.
 */
public class ReturnResult implements Serializable {
    private static final long serialVersionUID = 3549988627715247304L;
    private String status;
    private UserInfo data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}

package com.jdlx.shopmanager.entity.response;

import com.jdlx.shopmanager.entity.BaseResponse;

/**
 * Created by fupengpeng on 2017/11/30 0030.
 */

public class LoginResponse extends BaseResponse{
    /**
     * 响应数据
     */
    private String data;

    public LoginResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

package com.jdlx.shopmanager.model.personcenter.interf;


import com.jdlx.shopmanager.common.ObjectCallBack;

public interface ILoginModel {

    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @param callBack 回调
     */
    void login(String account, String password, ObjectCallBack<String> callBack);

}

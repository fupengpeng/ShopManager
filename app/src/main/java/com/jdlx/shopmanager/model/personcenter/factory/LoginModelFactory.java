package com.jdlx.shopmanager.model.personcenter.factory;

import com.jdlx.shopmanager.model.personcenter.impl.LoginModelImpl;
import com.jdlx.shopmanager.model.personcenter.interf.ILoginModel;

/**
 * Created by fupengpeng on 2017/11/30 0030.
 */

public class LoginModelFactory {

    /**
     * 创建用户信息业务
     *
     * @return 用户信息业务
     */
    public static ILoginModel newInstance() {
        return new LoginModelImpl();
    }

}

package com.jdlx.shopmanager.presenter.personcenter.factory;

import com.jdlx.shopmanager.activity.personcenter.view.ILoginView;
import com.jdlx.shopmanager.presenter.personcenter.impl.LoginPresenterImpl;
import com.jdlx.shopmanager.presenter.personcenter.interf.ILoginPresenter;

/**
 * Created by fupengpeng on 2017/11/30 0030.
 */

public class LoginPresenterFactory {
    /**
     * 创建登录界面主导器
     *
     * @param loginView 登录界面
     * @return 登录界面主导器实例
     */
    public static ILoginPresenter newInstance(ILoginView loginView) {
        return new LoginPresenterImpl(loginView);
    }
}

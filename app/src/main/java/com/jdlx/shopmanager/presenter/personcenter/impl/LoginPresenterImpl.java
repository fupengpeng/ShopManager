package com.jdlx.shopmanager.presenter.personcenter.impl;

import com.jdlx.shopmanager.activity.IBaseView;
import com.jdlx.shopmanager.activity.personcenter.impl.MainActivity;
import com.jdlx.shopmanager.activity.personcenter.view.ILoginView;
import com.jdlx.shopmanager.common.Consts;
import com.jdlx.shopmanager.common.ObjectCallBack;
import com.jdlx.shopmanager.model.personcenter.factory.LoginModelFactory;
import com.jdlx.shopmanager.model.personcenter.interf.ILoginModel;
import com.jdlx.shopmanager.presenter.BasePresenter;
import com.jdlx.shopmanager.presenter.personcenter.interf.ILoginPresenter;
import com.jdlx.shopmanager.util.InfoUtils;

/**
 * @class_name: LoginPresenterImpl
 * @Description: 登录主导器
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: com.jdlx.shopmanager.presenter.personcenter.impl
 * @author fupengpeng
 * @date 2017/11/30 0030 9:12
 */
public class LoginPresenterImpl extends BasePresenter implements ILoginPresenter {

    /**
     * 登录界面
     */
    private ILoginView loginView;
    /**
     * 用户信息业务
     */
    private ILoginModel loginModel;
    public LoginPresenterImpl(ILoginView loginView) {
        super(loginView);
        this.loginView = loginView;
        this.loginModel = LoginModelFactory.newInstance();
    }


    /**
     * 登录
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void login(String account, String password) {
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.LOGIN);
        // 登录
        loginModel.login(account, password, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String userId) { // 登录成功
                // 关闭等待对话框
                closeWaitDialog();
                // 设置登录成功
                loginView.setLoginSuccess();
                // 到主界面
                startActivity(MainActivity.class);
                // 关闭登录界面
                activity.finish();
            }

            @Override
            public void onFail(Exception e) { // 登录失败
                // 关闭等待对话框
                closeWaitDialog();
                // 显示错误信息
                InfoUtils.showInfo(activity, e.getMessage());
            }
        });
    }
}

package com.jdlx.shopmanager.activity.personcenter.impl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.jdlx.shopmanager.R;
import com.jdlx.shopmanager.activity.BaseActivity;
import com.jdlx.shopmanager.activity.personcenter.view.ILoginView;
import com.jdlx.shopmanager.presenter.personcenter.factory.LoginPresenterFactory;
import com.jdlx.shopmanager.presenter.personcenter.interf.ILoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/11/30 0030.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.btn_login)
    Button btnLogin;

    /**
     * 登录主导器
     */
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //隐藏actionbur，透明状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //创建主导器
        loginPresenter = LoginPresenterFactory.newInstance(this);


    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {

        String account = null,password = null;
        loginPresenter.login(account, password);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    /**
     * 登录成功页面变化
     */
    @Override
    public void setLoginSuccess() {

    }

    /**
     * 密码登录页面变化
     */
    @Override
    public void setPasswordLogin() {

    }
}

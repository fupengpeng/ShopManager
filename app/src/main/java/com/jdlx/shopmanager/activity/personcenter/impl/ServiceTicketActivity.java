package com.jdlx.shopmanager.activity.personcenter.impl;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.jdlx.shopmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/11/29 0029.
 */

public class ServiceTicketActivity extends AppCompatActivity {

    @BindView(R.id.iv_anim_test)
    ImageView ivAnimTest;



    @BindView(R.id.btn_move)
    Button btnMove;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_service_ticket);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_move)
    public void onViewClicked() {

    }


}

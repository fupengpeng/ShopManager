package com.jdlx.shopmanager.activity.personcenter.impl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.jdlx.shopmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fupengpeng on 2017/11/29 0029.
 */

public class ServiceTicketParticularsActivity extends AppCompatActivity {

    @BindView(R.id.ll_yijiankaidan)
    LinearLayout llYijiankaidan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_ticket_particulars);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    |
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    ;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.BLACK);
        }

    }

    @OnClick(R.id.ll_yijiankaidan)
    public void onViewClicked() {
        Intent intent = new Intent(this,AddServiceItemActivity.class);
        startActivity(intent);
    }
}

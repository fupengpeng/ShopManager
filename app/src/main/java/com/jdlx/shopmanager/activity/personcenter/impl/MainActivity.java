package com.jdlx.shopmanager.activity.personcenter.impl;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.jdlx.shopmanager.R;
import com.jdlx.shopmanager.activity.IBaseView;
import com.jdlx.shopmanager.util.AnimationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IBaseView {

    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    private int _xDelta;
    private int _yDelta;

    @BindView(R.id.v4_text)
    TextView v4Text;
    @BindView(R.id.sv_main)
    ScrollView svMain;
    @BindView(R.id.v4_drawerlayout)
    DrawerLayout v4Drawerlayout;
    @BindView(R.id.ll_scv_three)
    LinearLayout llScvThree;
    @BindView(R.id.ll_scv_one)
    LinearLayout llScvOne;
    @BindView(R.id.ll_scv_two)
    LinearLayout llScvTwo;
    @BindView(R.id.rl_scv)
    RelativeLayout rlScv;
    private DrawerLayout drawerLayout;

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initView();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.v4_drawerlayout);
        textView = (TextView) findViewById(R.id.v4_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        svMain.setOnTouchListener(new View.OnTouchListener() {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                final int X = (int) event.getRawX();
//                final int Y = (int) event.getRawY();

                // TODO Auto-generated method stub
                switch (event.getAction()) {
                    //手指抬起
                    case MotionEvent.ACTION_UP:

                        break;

                    //手指落下
                    case MotionEvent.ACTION_DOWN:

//                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) svMain
//                                .getLayoutParams();
//                        _xDelta = X - lParams.leftMargin;
//                        _yDelta = Y - lParams.topMargin;
                        x1 = event.getX();
                        y1 = event.getY();
                        break;

                    //手指滑动
                    case MotionEvent.ACTION_MOVE:

                        //判断当前移动方向
                        x2 = event.getX();
                        y2 = event.getY();
                        if (y1 - y2 > 10) {
                            // 向上
                            Toast.makeText(MainActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
                            //获取rlScv的坐标（y？？）
                            int[] location = new int[2];
                            rlScv.getLocationOnScreen(location);
                            int x = location[0];
                            int y = location[1];
                            //方法一，修改控件margin值
//                            LinearLayout.LayoutParams oneparamsrams = (LinearLayout.LayoutParams) llScvOne.getLayoutParams();
//                            oneparams.setMargins(0,120,0,0);
//                            llScvOne.setLayoutParams(oneparams);

//                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) llScvTwo.getLayoutParams();
//                            params.setMargins(45,  0, 45, 0);// 通过自定义坐标来放置你的控件  新位置属性,left，top，right，bottom
//                            llScvTwo.setLayoutParams(params);

//                            LinearLayout.LayoutParams threeparams = (LinearLayout.LayoutParams) llScvThree.getLayoutParams();
//                            threeparams.setMargins(0,0,0,0);
//                            llScvThree.setLayoutParams(threeparams);


//                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) svMain
//                                    .getLayoutParams();
//                            layoutParams.leftMargin = X - _xDelta;
//                            layoutParams.topMargin = Y - _yDelta;
//                            layoutParams.rightMargin = 45;
//                            layoutParams.bottomMargin = 45;
//                            svMain.setLayoutParams(layoutParams);
                            //动画效果设置
                            Animation scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleyanim);
                            llScvThree.startAnimation(scaleAnimation);
                            Animation oneAnimationS = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_one_s);
                            llScvOne.startAnimation(oneAnimationS);
                            Animation twoAnimationS = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_two_s);
                            llScvTwo.startAnimation(twoAnimationS);

                        } else if (y2 - y1 > 10) {
                            Toast.makeText(MainActivity.this, "向下滑", Toast.LENGTH_SHORT).show();
//                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) llScvTwo.getLayoutParams();
//                            params.setMargins(45,  600, 45, 0);// 通过自定义坐标来放置你的控件  新位置属性,left，top，right，bottom
//                            llScvTwo.setLayoutParams(params);
                            Animation oneAnimationX = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_one_x);
                            llScvOne.startAnimation(oneAnimationX);
                            Animation twoAnimationX = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_two_x);
                            llScvTwo.startAnimation(twoAnimationX);

                            Animation scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scalexanim);
                            llScvThree.startAnimation(scaleAnimation);
                        } else if (x1 - x2 > 10) {
                            Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
                        } else if (x2 - x1 > 10) {
                            Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
                return false;
            }
        });

    }





}

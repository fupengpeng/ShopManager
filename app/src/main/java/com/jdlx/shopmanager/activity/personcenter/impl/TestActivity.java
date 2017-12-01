package com.jdlx.shopmanager.activity.personcenter.impl;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jdlx.shopmanager.R;
import com.jdlx.shopmanager.activity.IBaseView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fupengpeng on 2017/12/1 0001.
 */

public class TestActivity extends AppCompatActivity implements IBaseView {

    int left ;
    int right;
    int top ;
    int bottom;
    int dx;
    int dy;

    // main
    @BindView(R.id.dl_atvt_main_content)
    DrawerLayout dlAtvtMainContent;

    // 主页面
    @BindView(R.id.rl_atvt_main_content)
    RelativeLayout rlAtvtMainContent;

    // scroll栏
    @BindView(R.id.ll_atvt_main_superstratum)
    LinearLayout llAtvtMainSuperstratum;

    // 标题栏
    @BindView(R.id.ll_atvt_main_title)
    LinearLayout llAtvtMainTitle;

    // 图片栏
    @BindView(R.id.ll_atvt_main_iv)
    LinearLayout llAtvtMainIv;

    // 空白栏
    @BindView(R.id.ll_atvt_main_black)
    LinearLayout llAtvtMainBlack;

    // 图片栏内布局
    @BindView(R.id.rl_atvt_main_untreated_order)
    RelativeLayout rlAtvtMainUntreatedOrder;

    private int startX;
    private int startY;

    private boolean isCenter = true;

    Timer timer = new Timer();


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


        llAtvtMainSuperstratum.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 获取手指按下的坐标
                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        // 获取TextView上一次上 下 左 右各边与父控件的距离
                        left = llAtvtMainSuperstratum.getLeft();
                        right = llAtvtMainSuperstratum.getRight();
                        top = llAtvtMainSuperstratum.getTop();
                        bottom = llAtvtMainSuperstratum.getBottom();

                        // 获取手指移动到了哪个点的坐标
                        int movingX = (int) event.getRawX();
                        int movingY = (int) event.getRawY();
                        // 相对于上一个点，手指在X和Y方向分别移动的距离
                        dx = movingX - startX;
                        dy = movingY - startY;

                        if (isCenter){  // 在中间时
                            //scrollView失去焦点

                            if (dy <= (-10)) {  // 向上滑动
                                // 设置本次TextView的上 下 左 右各边与父控件的距离
                                Animation twoAnimationS = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_superstratum_s);
                                llAtvtMainSuperstratum.startAnimation(twoAnimationS);
                                TimerTask task = new TimerTask() {
                                    @Override
                                    public void run() {

                                        runOnUiThread(new Runnable() {      // UI thread
                                            @Override
                                            public void run() {
                                                llAtvtMainSuperstratum.layout(left , 135, right , bottom );
                                            }
                                        });


                                    }
                                };
                                timer.schedule(task, 1000);       // timeTask


                                Animation oneAnimationS = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_black_anim_s);
                                llAtvtMainBlack.startAnimation(oneAnimationS);

                                Animation scaleAnimation = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_iv_anim_s);
                                llAtvtMainIv.startAnimation(scaleAnimation);



                                isCenter = false;
                            }
                            if (dy >= 10 ){  // 向下滑动
                                // 动画效果

                            }
                        }else {
                            //scrollView获取焦点

                            if (dy <= (-10)) {  // 向上滑动
                                // 动画效果

                            }
                            if (dy >= 10 ){  // 向下滑动
                                // 设置到中间去

                                TimerTask task = new TimerTask() {
                                    @Override
                                    public void run() {

                                        runOnUiThread(new Runnable() {      // UI thread
                                            @Override
                                            public void run() {
                                                llAtvtMainSuperstratum.layout(left, 990, right, bottom);
                                            }
                                        });


                                    }
                                };
                                timer.schedule(task, 1000);       // timeTask


                                Animation twoAnimationX = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_superstratum_x);
                                llAtvtMainSuperstratum.startAnimation(twoAnimationX);

                                Animation oneAnimationX = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_black_anim_x);
                                llAtvtMainBlack.startAnimation(oneAnimationX);

                                Animation scaleAnimation = AnimationUtils.loadAnimation(TestActivity.this, R.anim.ll_atvt_main_iv_anim_x);
                                llAtvtMainIv.startAnimation(scaleAnimation);

                                isCenter = true;
                            }


                        }


                        // 本次移动的结尾作为下一次移动的开始
                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                rlAtvtMainContent.invalidate();
                return true;//如果返回true,从手指接触屏幕到手指离开屏幕，将不会触发点击事件。
            }
        });


    }



}

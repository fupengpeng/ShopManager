package com.jdlx.shopmanager.util;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by fupengpeng on 2017/11/30 0030.
 */

public class AnimationUtil {

    private static final String TAG = AnimationUtil.class.getSimpleName();

    /**
     * 从控件所在位置移动到控件的底部
     *
     * @return
     */
    public static TranslateAnimation moveToViewBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public static TranslateAnimation moveToViewLocation() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(10000);
        return mHiddenAction;
    }


//    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) llScvTwo.getLayoutParams();
////                            params.setMargins(0,120,0,0);
////                            llScvTwo.setLayoutParams(params);
//                            params.setMargins(45,  0, 45, 0);// 通过自定义坐标来放置你的控件  新位置属性,left，top，right，bottom
//                            llScvTwo.setLayoutParams(params);
//                            llScvTwo.setAnimation(AnimationUtil.moveToViewLocation());



    //                        /**
//                         * 1、getScorollY()——滚动条滑动的距离
//                         * 2、getMeasuredHeight()——内容的整体高度，包括隐藏部分
//                         * 3、getHeight()——显示高度。内容未布满屏幕，2=3；内容大于屏幕，3=屏幕高度，2>3。
//                         */
//                        //顶部状态
//                        if (svMain.getScrollY() <= 0) {
//                            Log.e(">>>>>>>>>>>>>>", "顶部");
//                            Toast.makeText(MainActivity.this, "顶部", Toast.LENGTH_SHORT).show();
//
//                            //ll_scv_two  ll_scv_one  向上滑动  ll_scv_three 高度变小，内部控件逐渐变小隐藏
//                            int[] location = new int[2];
//                            llScvThree.getLocationOnScreen(location);
//                            int x = location[0];
//                            int y = location[1];
//                            System.out.println("x:" + x + "y:" + y);
//                            Log.e("--------", "onTouch: " + "x:" + x + "  y:" + y);
//                            Toast.makeText(MainActivity.this, "顶部" + "x:" + x + "  y:" + y, Toast.LENGTH_SHORT).show();
//
//
//                        } else {
//
//
//                        }
//
//                        //顶部状态
//                        //TextView的总高度<=一屏幕的高度+滚动条的滚动距离(getChildAt(0):第0个子控件)
//                        if (svMain.getChildAt(0).getMeasuredHeight() <= svMain.getScrollY() + svMain.getHeight()) {
//                            Log.e(">>>>>>>>>>>>>>", "底部");
//                            Toast.makeText(MainActivity.this, "底部", Toast.LENGTH_SHORT).show();
//
//                            //在文本中追加内容
//                            textView.append("111111");
//                        }

}

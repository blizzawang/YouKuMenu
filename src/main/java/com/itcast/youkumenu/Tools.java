package com.itcast.youkumenu;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * 显示和隐藏指定的控件
 */
class Tools {

    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int startOffset) {
//        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);//设置动画播放持续时间
//        ra.setFillAfter(true);//动画停留在播放完成的状态
//        ra.setStartOffset(startOffset);//设置动画延迟时间
//        view.startAnimation(ra);
//
//        for(int i = 0;i < view.getChildCount();i++){
//            View childView = view.getChildAt(i);
//            //设置不可以点击
//            childView.setEnabled(false);
//        }

        //改为属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, 180);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());
    }

    public static void showView(ViewGroup view, int startOffset) {
//        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);//设置动画播放持续时间
//        ra.setFillAfter(true);//动画停留在播放完成的状态
//        ra.setStartOffset(startOffset);
//        view.startAnimation(ra);
//
//        for (int i = 0; i < view.getChildCount(); i++) {
//            View childView = view.getChildAt(i);
//            //设置不可以点击
//            childView.setEnabled(true);
//        }

        //改为属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 180, 360);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());
    }
}

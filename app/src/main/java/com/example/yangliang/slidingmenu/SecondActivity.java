package com.example.yangliang.slidingmenu;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

/**
 * 创建日期：2017/8/31 on 下午9:02
 * 描述: 通过把Activity继承SlidingActivity,设置侧滑菜单
 * a、继承SlidingActivity
 * b、然后在onCreate中setBehindContentView(R.layout.leftmenu); 设置侧滑菜单的布局
 * c、通过getSlidingMenu()得到SlidingMenu对象，然后设置样式
 * 作者: liangyang
 */
public class SecondActivity extends SlidingActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //设置侧滑菜单的布局
        setBehindContentView(R.layout.first_left_item);
        //通过getSlidingMenu()得到SlidingMenu对象，然后设置样式
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置触摸屏幕的模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);


    }
}

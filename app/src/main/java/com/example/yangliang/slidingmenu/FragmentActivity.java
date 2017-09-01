package com.example.yangliang.slidingmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2017/8/31 on 下午10:09
 * 描述:MainActivity继承的是SlidingFragmentActivity ，
 * 在Activity中FragmentPagerAdapter和viewPager作为主布局，然后分别初始化SlidingMenu的两边的菜单
 * 作者: liangyang
 */
public class FragmentActivity extends SlidingFragmentActivity {

    private ViewPager viewPager;
    //初始化list存储fragment作为viewpager容器
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        // 初始化SlideMenu
        initSlidingMenu();
        // 初始化主视图ViewPager
        initViewPager();
    }

    /**
     * 初始化主视图
     */
    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();

        fragmentList.add(fragmentOne);
        fragmentList.add(fragmentTwo);
        fragmentList.add(fragmentThree);

        //初始化ViewPager的适配器
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, fragmentList);
        //绑定适配器
        viewPager.setAdapter(adapter);

    }

    /**
     * 初始化SlideMenu
     */
    private void initSlidingMenu() {

        LeftFragment leftFragment = new LeftFragment();
        //先给侧滑菜单通过 setBehindContentView(R.layout.left_menu_frame) 设置一个布局
        setBehindContentView(R.layout.left_menu_frame);
        //此布局中只有一个FrameLayout，然后使用FragmentManager将LeftFragment替换掉此Fragment，
        // 这样这个Fragment就作为我们侧滑菜单的布局了
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.left_menu_frame, leftFragment);
        fragmentTransaction.commit();
        //设置SlidingMenu
        SlidingMenu slidingMenu = getSlidingMenu();
        //设置左右模式
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //设置触摸屏幕的模式
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏触摸
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//无效果（不能通过拖拽的方式打开侧滑菜单）
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//屏幕边缘触摸滑出侧滑菜单（推荐）
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.setSecondaryShadowDrawable(R.drawable.shadow);

        //设置右边的二级侧滑菜单
        slidingMenu.setSecondaryMenu(R.layout.right_menu_frame);
        RightFragment rightFragment = new RightFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.right_menu_frame, rightFragment).commit();

    }

    /**
     * button的点击事件
     */
    public void showLeftMenu(View view) {
        //打开左侧侧滑菜单
        getSlidingMenu().showMenu();
    }

    public void showRightMenu(View view) {
        //打开右侧（二级）侧滑菜单
        getSlidingMenu().showSecondaryMenu();
    }

}

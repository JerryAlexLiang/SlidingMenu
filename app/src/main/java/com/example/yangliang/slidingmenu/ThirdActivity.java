package com.example.yangliang.slidingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 创建日期：2017/8/31 on 下午9:12
 * 描述: 将SlidingMenu当作普通控件
 * 作者: liangyang
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private SlidingMenu slidingMenu;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button = (Button) findViewById(R.id.btn_open);
        slidingMenu = (SlidingMenu) findViewById(R.id.slidingmenulayout);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.third_slidingmenu_offset);
        //设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);
        //为侧滑菜单设置布局
        slidingMenu.setMenu(R.layout.third_left_item);

        button.setOnClickListener(this);
        slidingMenu.setOnClickListener(this);

//        slidingMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (slidingMenu.isMenuShowing()) {
//                    slidingMenu.toggle();
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open:
                slidingMenu.toggle();
                Toast.makeText(this, "你点击了button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.slidingmenulayout:
                if (slidingMenu.isMenuShowing()) {
                    slidingMenu.toggle();
                }
                break;
        }
    }
}

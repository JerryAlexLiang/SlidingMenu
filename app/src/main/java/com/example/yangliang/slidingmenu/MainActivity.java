package com.example.yangliang.slidingmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.item_one);
        buttonTwo = (Button) findViewById(R.id.item_two);
        buttonThree = (Button) findViewById(R.id.item_three);
        buttonFour = (Button) findViewById(R.id.item_four);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.item_one:
                intent.setClass(MainActivity.this, FirstActivity.class);
                break;

            case R.id.item_two:
                intent.setClass(MainActivity.this, SecondActivity.class);
                break;

            case R.id.item_three:
                intent.setClass(MainActivity.this, ThirdActivity.class);
                break;

            case R.id.item_four:
                intent.setClass(MainActivity.this, FragmentActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}

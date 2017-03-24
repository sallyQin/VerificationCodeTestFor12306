package com.example.a1.verificationcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_cover;//首界面button
    SimpleDraweeView fetch_ticket_pic;//抓票图

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetch_ticket_pic = (SimpleDraweeView) findViewById(R.id.fetch_ticket);
        button_cover = (Button) findViewById(R.id.cover_button);
        button_cover.setOnClickListener(this);
/**
 * 设置“抓票”图的动画效果
 * **/
        TranslateAnimation translateAnimation = new TranslateAnimation(0,0,-35,35);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatMode(Animation.REVERSE);//设置重复模式（来去动作平滑）
        translateAnimation.setRepeatCount(Animation.INFINITE);//设置动画无限循环
        fetch_ticket_pic.setAnimation(translateAnimation);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,ChooseTicketActivity.class);
        startActivity(intent);

    }
}

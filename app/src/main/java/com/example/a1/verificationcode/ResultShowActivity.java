package com.example.a1.verificationcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;


public class ResultShowActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_reStart;
    SimpleDraweeView shining_rotate;
    TextView totalCountsTimes_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_show);
        shining_rotate = (SimpleDraweeView) findViewById(R.id.shining_rotate);
        button_reStart = (Button) findViewById(R.id.button_reStart);
        totalCountsTimes_text = (TextView) findViewById(R.id.totalCountsTimes_text);
        int totalCounts = getIntent().getIntExtra("答对次数",0);
        if(totalCounts == 0){  //设置不同的车票数的文字
            totalCountsTimes_text.setText("没睡醒么？竟然一张票都没抢到！");
        }else if(totalCounts == 1|| totalCounts == 2 ){
            totalCountsTimes_text.setText("啥眼神啊？居然才抢到"+ totalCounts + "张车票！");
        }else {
            totalCountsTimes_text.setText("恭喜！眼明手快，您共抢到了"+ totalCounts + "张票！");
        }

        /**360°旋转**/
        RotateAnimation rotateAnimation = new RotateAnimation(0f,359f,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);//360°旋转
        rotateAnimation.setInterpolator(new LinearInterpolator());//画面不停顿
        rotateAnimation.setDuration(8000);//设置动画持续时间（8秒）
        rotateAnimation.setRepeatCount(-1);//设置无限次重复
        shining_rotate.startAnimation(rotateAnimation); //开启360°旋转

        button_reStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) { //重返首页 按钮的事件监听器
        Intent intent  = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() { //设置按回退键 后重返首页
        super.onBackPressed();
        Intent intent  = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}

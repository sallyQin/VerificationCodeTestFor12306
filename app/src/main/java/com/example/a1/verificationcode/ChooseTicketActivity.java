package com.example.a1.verificationcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ChooseTicketActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    TextView random_text1;//text_明星名1
    TextView random_text2;//text_明星名2
    LinearLayout reload_linear;//刷新
    Button countingTime_btn;
    LinearLayout show_linear;
    TextView hint_touchTxt;
    MyAdapter myGridAdapter;
    ImageView showTrainCover_pic;
    Boolean hasChange = false;
    int count= 0;
    ImageView times_pic;
    TextView times_txt;
    int countNum = 0;//记录答对次数
    TextView clockCountdown_txt;//倒计时秒数
    int clockCountdown = 60;//记录倒计时秒数
    LinearLayout show_starName_linear ;
    TextView hintResult_txt;
    ImageView show_cover_pic;
    TextView toast_show;
    int toastParentHeight; //toast的父view的高度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myGridAdapter = new MyAdapter(R.layout.my_adapter);
        recyclerView.setAdapter(myGridAdapter);
        myGridAdapter.mChooseTicketActivity = ChooseTicketActivity.this; //
        getLoaderManager().restartLoader(1, null, myGridAdapter);//*LoaderManager就是加载器的管理器，一个LoaderManager可管理一个或多个Loader，
        // 一个Activity只能有一个LoadManager. LoaderManager管理Loader的初始化，重启和销毁操作。

        times_pic = (ImageView) findViewById(R.id.times_pic);
        random_text1 = (TextView) findViewById(R.id.random_text1);
        random_text2 = (TextView) findViewById(R.id.random_text2);
        reload_linear = (LinearLayout) findViewById(R.id.reload_linear);
        hint_touchTxt = (TextView) findViewById(R.id.hint_touchTxt);
        show_linear = (LinearLayout) findViewById(R.id.show_content);
        countingTime_btn = (Button) findViewById(R.id.countingTime_btn);
        showTrainCover_pic = (ImageView) findViewById(R.id.showTrainCover_pic);
        times_txt = (TextView) findViewById(R.id.times_txt);
        clockCountdown_txt = (TextView) findViewById(R.id.clockCountdown_txt);
        hintResult_txt = (TextView) findViewById(R.id.hintResult_txt);
        show_starName_linear = (LinearLayout) findViewById(R.id.show_starName_linear);
        show_cover_pic = (ImageView) findViewById(R.id.show_cover);
        toast_show = (TextView) findViewById(R.id.toast_show);

        countingTime_btn.setOnClickListener(new View.OnClickListener() { //设置计时按钮的点击事件监听器
            @Override
            public void onClick(View view) {
                show_linear.setVisibility(View.VISIBLE);
                showTrainCover_pic.setVisibility(View.GONE);
                if(countingTime_btn.getText().toString().equals("提 交 订 单")){
                    if(myGridAdapter.totalCorrectNum == myGridAdapter.UserChosen_CorrectNum){//用户答对的情况
                        countNum++;
                        show_starName_linear.setVisibility(View.INVISIBLE);
                        hintResult_txt.setVisibility(View.VISIBLE);
                        show_cover_pic.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.INVISIBLE);
                        show_cover_pic.setImageResource(R.drawable.correct_show_cover);
                        hintResult_txt.setText("验证成功，跳转中...");
                        setToastAnimation();//设置“成功+1”文本的动画
                        Thread thread2 = new Thread(runnable2);//1.5秒后，黄色灯变绿色灯+答对数字的显示，后0.5秒后返回黄灯状态。
                        thread2.start();
                        Thread thread3 = new Thread(runnable3);
                        thread3.start();
                        Log.d("你做对啦！！！",""+myGridAdapter.UserChosen_CorrectNum);
                    }else{//用户答错的情况
                        hintResult_txt.setVisibility(View.VISIBLE);
                        show_cover_pic.setVisibility(View.VISIBLE);
                        show_cover_pic.setImageResource(R.drawable.false_show_cover);
                        recyclerView.setVisibility(View.INVISIBLE);
                        hintResult_txt.setText("验证错误，请重新验证");
                        show_starName_linear.setVisibility(View.INVISIBLE);
                        Thread thread2 = new Thread(runnable4);
                        thread2.start();
                        times_pic.setImageResource(R.drawable.yellow_led);
                        Log.d("你做错了！！！",""+myGridAdapter.UserChosen_CorrectNum);
                    }
                }
                else if(countingTime_btn.getText().toString().equals("计 时 开 抢")){
                    Thread thread = new Thread(runnable);
                    thread.start();
                }
                countingTime_btn.setText("提 交 订 单");

            }

        });


        try {
            getShiningHintText(); //设置闪烁字
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        reload_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myGridAdapter.updateGridRecyPics();
                reloadStarText();
                myGridAdapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * 初始化&更新明星名字显示文本框
     **/
    void reloadStarText() {
        random_text1.setText(MyAdapter.Star1_name);
        random_text2.setText(MyAdapter.Star2_name);
        Random random = new Random();
        random_text1.setBackgroundResource(this.getResources().getIdentifier("code_bg" + (random.nextInt(7) + 1), "drawable", getPackageName()));//设置明星名1_text背景
        random_text2.setBackgroundResource(this.getResources().getIdentifier("code_bg" + (random.nextInt(7) + 1), "drawable", getPackageName()));//设置明星名2_text背景
    }

    /**
     * 闪烁字
     **/
    void getShiningHintText() throws InterruptedException {

        final Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (hasChange) {
                            hasChange = false;
                            hint_touchTxt.setVisibility(View.INVISIBLE);

                        } else {
                            hasChange = true;
                            hint_touchTxt.setVisibility(View.VISIBLE);
                            count++;
                            if(count == 3){ //闪烁“3次”后，停止在字显示出的状态。
                                timer.cancel();}
                        }
                    }
                });

            }};
        timer.schedule(timerTask, 300L, 500L);

    }


    /**
     * 60秒倒计时
     * **/
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for(int i = 0;i< 60;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clockCountdown = clockCountdown-1;
                clockCountdown_txt.post(new Runnable() {
                    @Override
                    public void run() {
                        clockCountdown_txt.setText(""+clockCountdown);
                        if(clockCountdown ==0){
                            Intent intent = new Intent(ChooseTicketActivity.this,ResultShowActivity.class);
                            intent.putExtra("答对次数",countNum);
                            startActivity(intent);
                        }
                    }
                });

            }
        }
    };


    /**
     * 1.5秒后，黄色灯变绿色灯+答对数字的显示，后0.5秒后返回黄灯状态。
     * **/
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1500); //停止1.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times_pic.post(new Runnable() {
                @Override
                public void run() {
                    times_pic.setImageResource(R.drawable.green_led); //用户答对，灯从黄色变绿色
                    times_txt.setText(""+countNum);//答对数显示
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times_pic.post(new Runnable() {
                @Override
                public void run() {
                    times_pic.setImageResource(R.drawable.yellow_led);//0.5秒后灯从绿色变回黄色
                }
            });
        }

    };


    /**
     * 验证成功的文本提示（2秒后刷新）
     * **/
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            show_starName_linear.post(new Runnable() {
                @Override
                public void run() {
                    show_cover_pic.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    show_starName_linear.setVisibility(View.VISIBLE);
                    hintResult_txt.setVisibility(View.INVISIBLE);
                    myGridAdapter.updateGridRecyPics();
                    reloadStarText();
                    myGridAdapter.notifyDataSetChanged();
                }
            });
        }
    };

    /**
     * 验证失败的文本提示（2秒后刷新）
     * **/
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            show_starName_linear.post(new Runnable() {
                @Override
                public void run() {
                    show_cover_pic.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    show_starName_linear.setVisibility(View.VISIBLE);
                    hintResult_txt.setVisibility(View.INVISIBLE);
                    myGridAdapter.updateGridRecyPics();
                    reloadStarText();
                    myGridAdapter.notifyDataSetChanged();
                }
            });
        }
    };


    /**
     * 设置“成功+1”文本的动画
     * **/
    void setToastAnimation(){
        toast_show.setVisibility(View.VISIBLE);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,0,0,-toastParentHeight);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setDuration(1000);
        translateAnimation.setStartOffset(500);//执行前的等待0.5秒时间
        translateAnimation.setFillAfter(false);//动画执行完后是否停留在执行完的状态
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.1f, 0.0f, 1.1f, 0.0f,0f,-toastParentHeight);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setStartOffset(500);
        scaleAnimation.setFillAfter(true);
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(translateAnimation);
        as.addAnimation(scaleAnimation);
        toast_show.setAnimation(as);
        toast_show.setVisibility(View.INVISIBLE);
    }

    /**
     * 获取toast的父view的高度
     * **/
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            toastParentHeight = ((FrameLayout)toast_show.getParent()).getHeight();
        }

    }
}





package com.example.a1.verificationcode;

import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class MyAdapter extends UniversalAdapter {

    List<Info> list_update;
    static String Star1_name;
    static String Star2_name;
    int totalCorrectNum;
    int UserChosen_CorrectNum;

    public MyAdapter(@LayoutRes int itemRes) {
        super(itemRes);
        updateGridRecyPics();
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, final int position) {
        final SimpleDraweeView grid_image = (SimpleDraweeView) holder.itemView.findViewById(R.id.grid_pic);
        final SimpleDraweeView touch_logo = (SimpleDraweeView) holder.itemView.findViewById(R.id.touch_logo);
        final Info infoRes = list_update.get(position);
        if (infoRes.tick) {
            touch_logo.setBackgroundResource(R.drawable.touch_icon);
        } else {
            touch_logo.setBackgroundResource(0);
        }

        grid_image.setImageURI(Uri.parse("res:///" + holder.itemView.getContext().getResources().getIdentifier(infoRes.resPic, "drawable", holder.itemView.getContext().getPackageName())));//设置正确的图

        grid_image.setOnClickListener(new View.OnClickListener() { //设置itemView的事件监听器
            @Override
            public void onClick(View view) {
                if (infoRes.tick) {
                    if(infoRes.trueOrFalse &&UserChosen_CorrectNum > 0){
                        UserChosen_CorrectNum--;
                    }
                    infoRes.tick = false;
                } else {
                    if(infoRes.trueOrFalse){
                        UserChosen_CorrectNum++;
                    }
                    infoRes.tick = true;
                }

                notifyItemChanged(position);




//
//                View logo = holder.get(R.id.touch_logo);               // 建议用法
//                logo = holder.itemView.findViewById(R.id.touch_logo); // find 但是慢
//                logo = touch_logo;  // 抓取 final 临时变量，这样也可以
//
//                logo.setBackgroundResource(R.drawable.touch_icon);

            }
        });
        }





    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public void onItemChanged(int position) {  //如需对itemView做具体的进一步操作，则需要重写的部分；否则， onItemChanged(int position)不用写。


    }

    List<Info> updateGridRecyPics(){ //资源组图

        List<Info> list = new ArrayList<>();//新的list，装8图的数据
        Random random = new Random();
        /**获取“1/2正确”明星的资源图（1或者2个）**/
        int random_Star1Num = random.nextInt(Info.name.length);//正确图的 随机1/2明星"数号"
        Star1_name = Info.name[random_Star1Num];//随机获取正确的1/2明星“名字”
        Map <String ,String[] > map = Info.getTrue_map();
        String[] strs_corStar1_pic = map.get(Star1_name);//随机获取正确的明星1/2“组图”
        int n = random.nextInt(2);//在正确明星中图中，随机取（1-2幅图）z张数
        int random_corPic_1 = random.nextInt(3);//正确组图中随机 选取1张
        int y = 0;
        if(n == 0){
            list.add(new Info(Star1_name,true,strs_corStar1_pic[random_corPic_1]));
        } else {
            list.add(new Info(Star1_name,true,strs_corStar1_pic[random_corPic_1]));
            String[] balanceStr_corPicRes  = new String[2];
            for(int x =0 ;x < strs_corStar1_pic.length;x++){    //若，随机是选取2张组图的话，进行for（）循环
                if(!strs_corStar1_pic[random_corPic_1].equals(strs_corStar1_pic[x])){
                    balanceStr_corPicRes[y] = strs_corStar1_pic[x];
                    y++;
                }
            }
            list.add(new Info(Star1_name,true,balanceStr_corPicRes[ random.nextInt(2)]));//把随机选取的第二张正确的图，加入list里。
        }

        /**获取“1/2 非正确”明星2者之一的资源图（2或3个）**/
        int blanceNum_cor1 = 4 - list.size();
        String[] strs_falseStar1_pic = Info.getFalse_map().get(Star1_name);//随机获取"非正确"的1/2明星的组图
        int  random_falseStar1_num = random.nextInt(3);//在 非正确 明星的图中，随机取（2-3幅图）中之一数号
        if(blanceNum_cor1 == 2){
            list.add(new Info(Star1_name,false,strs_falseStar1_pic[random_falseStar1_num]));
            for(int x= 0;x< 3;x++){//若，随机是选取2张组图的话
                if(!strs_falseStar1_pic[random_falseStar1_num].equals(strs_falseStar1_pic[x])){
                    list.add(new Info(Star1_name,false,strs_falseStar1_pic[x]));
                    break;
                }
            }
        }else if(blanceNum_cor1 == 3){
            for(int x = 0;x < 3;x++){//若，随机是选取3张组图的话
                list.add(new Info(Star1_name,false,strs_falseStar1_pic[x]));
            }
        }
          /**获取“2/2正确”明星的资源图（1或者2个）**/
        String[] star2NamesStrs = new String[25];
        int q = 0;
        for(int i = 0; i< Info.name.length; i++){ //除去1/2明星名后，重新创建一组明星名。
            if(!Star1_name.equals( Info.name[i])){
                star2NamesStrs[q] =  Info.name[i];
                q++;
            }
        }
        int random_Star2Num = random.nextInt(star2NamesStrs.length);//正确图2/2的 随机明星"数号"
        Star2_name = star2NamesStrs[random_Star2Num];//随机获取正确的2/2明星“名字”
        String[] strs_corStar2_pic = map.get(Star2_name);//随机获取正确的明星1/2“组图”
        int t = random.nextInt(2);//在正确明星中图中，随机取（1-2幅图）数字号
        int random_corPic_2 = random.nextInt(3);//正确组图中随机 选取1张
        int z = 0;
        if(t == 0){
            list.add(new Info(Star2_name,true,strs_corStar2_pic[random_corPic_2]));
        } else {
            list.add(new Info(Star2_name,true,strs_corStar2_pic[random_corPic_2]));
            String[] balStr_corPicRes  = new String[2];
            for(int x =0 ;x < strs_corStar2_pic.length;x++){    //若，随机是选取2张组图的话，进行for（）循环
                if(!strs_corStar2_pic[random_corPic_2].equals(strs_corStar2_pic[x])){
                    balStr_corPicRes[z] = strs_corStar2_pic[x];
                    z++;
                }
            }

            list.add(new Info(Star2_name,true,balStr_corPicRes[ random.nextInt(2)]));//把随机选取的第二张正确的图，加入list里。
        }

        /**获取“2/2 非正确”明星2者之一的资源图（2或3个）**/
        int balanceNum_cor2 = 8 - list.size();
        String[] strs_falseStar2_pic = Info.getFalse_map().get(Star2_name);//随机获取"非正确"的2/2明星的组图
        int  random_falseStar2_num = random.nextInt(balanceNum_cor2);//在 非正确 明星的图中，随机取（2-3幅图）中之一数号
        if(balanceNum_cor2 == 2){
            list.add(new Info(Star2_name,false,strs_falseStar2_pic[random_falseStar2_num]));
            for(int x= 0;x< 3;x++){//若，随机是选取2张组图的话
                if(!strs_falseStar2_pic[random_falseStar2_num].equals(strs_falseStar2_pic[x])){
                    list.add(new Info(Star2_name,false,strs_falseStar2_pic[x]));
                    break;
                }
            }
        }else{
            for(int x = 0;x < 3;x++){//若，随机是选取3张组图的话
                list.add(new Info(Star2_name,false,strs_falseStar2_pic[x]));
            }
        }
        Collections.shuffle(list);//打乱这8组图的顺序
        list_update = list;
        totalCorrectNum = 0;
        UserChosen_CorrectNum = 0;
        for(int i = 0 ;i<list_update.size();i++){ //计算有几个正确的可选项
            if(list_update.get(i).trueOrFalse){
                totalCorrectNum++;
            }
        }
        return  list;
    }

}


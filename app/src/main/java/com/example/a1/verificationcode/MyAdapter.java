package com.example.a1.verificationcode;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class MyAdapter extends UniversalAdapter implements LoaderManager.LoaderCallbacks {


    List<InfoPlus> list_update;
    static String Star1_name;
    static String Star2_name;
    int totalCorrectNum;
    int UserChosen_CorrectNum;
    ChooseTicketActivity mChooseTicketActivity;
    private Cursor mCursor;
    public MyAdapter(@LayoutRes int itemRes) {
        super(itemRes);
    }

    @Override
    public void onBindViewHolder(final UniversalHolder holder, final int position) {
        final SimpleDraweeView grid_image = (SimpleDraweeView) holder.itemView.findViewById(R.id.grid_pic);
        final SimpleDraweeView touch_logo = (SimpleDraweeView) holder.itemView.findViewById(R.id.touch_logo);
        final InfoPlus infoRes = list_update.get(position);
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
            }
        });
        }



    @Override
    public int getItemCount() {
       return null == list_update ? 0 : list_update.size();
    }

    @Override
    public void onItemChanged(int position) {  //如需对itemView做具体的进一步操作，则需要重写的部分；否则， onItemChanged(int position)不用写。


    }

    List<InfoPlus> updateGridRecyPics(){ //资源组图

        List<InfoPlus> list = new ArrayList<>();//新的list，装8图的数据
        Random random = new Random();
        /**获取“1/2正确”明星的资源图（1或者2个）**/
       int random_Star1Num = random.nextInt(Info.name.length);//正确图的 随机1/2明星"数号"
        mCursor.moveToPosition(random_Star1Num * 6); //TTTT
        Star1_name = mCursor.getString(mCursor.getColumnIndex("sName"));//随机获取正确的1/2明星“名字”
        int n = random.nextInt(2);//在正确明星中图中，随机取（1-2幅图）张数
        int random_corPic_1 = random.nextInt(3);//正确组图中随机 选取1张的数字
        int y = 0;
        String corPicRes1;
        if(n == 0){  // 随机获取“1”张 1/2明星图片
        if(random_Star1Num>= 1){
            mCursor.moveToPosition(random_Star1Num*6 + random_corPic_1);
            mCursor.getString(mCursor.getColumnIndex("resPic"));
            list.add(new InfoPlus(Star1_name,true,mCursor.getString(mCursor.getColumnIndex("resPic"))));//add list1
        } else{
            mCursor.moveToPosition(random_corPic_1);
            list.add(new InfoPlus(Star1_name,true,mCursor.getString(mCursor.getColumnIndex("resPic"))));//add list1
        }} else { // 随机获取“2”张 1/2明星图片
            String [] balanceStr_corPicRes = new String[2];
            if(random_Star1Num>= 1){
                mCursor.moveToPosition(random_Star1Num*6 + random_corPic_1);
                corPicRes1 = mCursor.getString(mCursor.getColumnIndex("resPic"));//8张中的第1张
                list.add(new InfoPlus(Star1_name,true,corPicRes1));   // add pic1/8
                for(int x = 0 ;x < 3;x++){    //在3张正确图中，再随机选取第2张 1/2明星组图，用for（）循环
                    mCursor.moveToPosition(random_Star1Num*6 + x);
                    mCursor.getString(mCursor.getColumnIndex("resPic"));
                    if(!corPicRes1.equals( mCursor.getString(mCursor.getColumnIndex("resPic")))){
                        balanceStr_corPicRes[y] =  mCursor.getString(mCursor.getColumnIndex("resPic"));
                        y++;
                    }
                }
                list.add(new InfoPlus(Star1_name,true,balanceStr_corPicRes[ random.nextInt(2)]));  // add pic2/8
            } else{
                mCursor.moveToPosition(random_corPic_1);
                corPicRes1 = mCursor.getString(mCursor.getColumnIndex("resPic"));
                list.add(new InfoPlus(Star1_name,true,corPicRes1));//add list1
                for(int x = 0 ;x < 3;x++){    //在3张正确图中，再随机选取第2张 1/2明星组图，用for（）循环
                    mCursor.moveToPosition(random_corPic_1 + x);
                    if(!corPicRes1.equals( mCursor.getString(mCursor.getColumnIndex("resPic")))){
                        balanceStr_corPicRes[y] =  mCursor.getString(mCursor.getColumnIndex("resPic"));
                        y++;
                    }
                }
                list.add(new InfoPlus(Star1_name,true,balanceStr_corPicRes[ random.nextInt(2)]));  // add pic2/8
            }
        }

        /**获取“1/2 非正确”明星2者之一的资源图（2或3个）**/
        int blanceNum_cor1 = 4 - list.size();
        int  random_falseStar1_num = random.nextInt(3);//在 非正确 明星的图中，随机取（2-3幅图）中之一数号
        if(blanceNum_cor1 == 2){
            mCursor.moveToPosition(random_Star1Num*6 + 3+ random_falseStar1_num);
            String strs_falseStar1_res = mCursor.getString(mCursor.getColumnIndex("resPic"));
            list.add(new InfoPlus(Star1_name,false, mCursor.getString(mCursor.getColumnIndex("resPic"))));
            for(int x= 0;x< 3;x++){//若，随机是选取2张组图的话
                mCursor.moveToPosition(random_Star1Num*6 + 3 + x);
                if(!strs_falseStar1_res.equals(mCursor.getString(mCursor.getColumnIndex("resPic")))){
                    list.add(new InfoPlus(Star1_name,false,mCursor.getString(mCursor.getColumnIndex("resPic"))));
                    break;
                }
            }
        }else if(blanceNum_cor1 == 3){
            for(int x = 0;x < 3;x++){//若，随机是选取3张组图的话
                mCursor.moveToPosition(random_Star1Num*6 + 3+ x);
                list.add(new InfoPlus(Star1_name,false, mCursor.getString(mCursor.getColumnIndex("resPic"))));
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
        int t = random.nextInt(2);//在正确明星图中，随机取（1-2幅图）数字号
        int random_corPic_2 = random.nextInt(3);//正确组图中随机 选取1张
        List<InfoPlus> secondStarResList = new ArrayList<>();
        Boolean statusTf;
        mCursor.moveToPosition(-1);
        while (mCursor.moveToNext()) {
            if (mCursor.getString(mCursor.getColumnIndex("sName")).equals(Star2_name)) {
                if (mCursor.getString(mCursor.getColumnIndex("trueOrFalse")).equals("true")) {
                    statusTf = true;
                } else {
                    statusTf = false;
                }
                secondStarResList.add(new InfoPlus(Star2_name, statusTf, mCursor.getString(mCursor.getColumnIndex("resPic"))));

            }
        }
        
        int z = 0;
        if(t == 0){ //选取1张
            list.add(secondStarResList.get(random_corPic_2 ));
        } else { //选取2张
            list.add(secondStarResList.get(random_corPic_2));
            String[] balStr_corPicRes  = new String[2];
            for(int x =0 ;x < 3;x++){    //若，随机是选取2张组图的话，进行for（）循环
                if(!secondStarResList.get(random_corPic_2).resPic.equals(secondStarResList.get(x).resPic)){
                    balStr_corPicRes[z] = secondStarResList.get(x).resPic;
                    z++;
                }
            }

            list.add(new InfoPlus(Star2_name,true,balStr_corPicRes[ random.nextInt(2)]));//把随机选取的第二张正确的图，加入list里。
        }

        /**获取“2/2 非正确”明星2者之一的资源图（2或3个）**/
        int balanceNum_cor2 = 8 - list.size();
        int  random_falseStar2_num = random.nextInt(balanceNum_cor2);//在 非正确 明星的图中，随机取（2-3幅图）中之一数号
        if(balanceNum_cor2 == 2){
            list.add(new InfoPlus(Star2_name,false,secondStarResList.get(random_falseStar2_num + 3).resPic));
            for(int x= 0;x< 3;x++){//若，随机是选取2张组图的话
                if(!secondStarResList.get(random_falseStar2_num + 3).resPic.equals(secondStarResList.get(3 +x).resPic)){
                    list.add(new InfoPlus(Star2_name,false,secondStarResList.get(3 +x).resPic));
                    break;
                }
            }
        }else{
            for(int x = 0;x < 3;x++){//若，随机是选取3张组图的话
                list.add(new InfoPlus(Star2_name,false,secondStarResList.get(3 +x).resPic));
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

    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(mChooseTicketActivity,InfoProvider.URI_PROVIDER,null, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        if (mCursor != data) {
            if (mCursor != null) {
                mCursor.close();
            }
            mCursor = (Cursor) data;
        }
        updateGridRecyPics();
        mChooseTicketActivity.reloadStarText();//设置明星名字的text
        notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}


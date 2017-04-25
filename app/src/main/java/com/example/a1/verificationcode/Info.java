package com.example.a1.verificationcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 2017/3/8.
 */

public class Info extends SQLiteOpenHelper {

    String sName;
    boolean trueOrFalse;
    String resPic;
    boolean tick;


     Info(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Info", null, 1);
    }

//
//    Info(String sName, Boolean trueOrFalse, String resPic){
//
//        this.sName = sName;
//        this.trueOrFalse = trueOrFalse;
//        this.resPic =resPic;
//    }


    static String[] yangmu = new String[]{"a_yangmi_1","a_yangmi_2","a_yangmi_3"};//杨幂_a
    static String[] wrong_a = new String[]{"a_wrong_1","a_wrong_2","a_wrong_3"};//wrong_a
    static String[] chenhao = new String[]{"b_chenhao_1","b_chenhao_2","b_chenhao_3"};//陈好_b
    static String[] wrong_b = new String[]{"b_wrong_1","b_wrong_2","b_wrong_3"};//wrong_b
    static String[] zhangziyi = new String[]{"c_zhangziyi_1","c_zhangziyi_2","c_zhangziyi_3"};//章子怡_c
    static String[] wrong_c = new String[]{"c_wrong_1","c_wrong_2","c_wrong_3"};//wrong_c
    static String[] mayili = new String[]{"d_mayili_1","d_mayili_2","d_mayili_3"};//马伊琍_d
    static String[] wrong_d = new String[]{"d_wrong_1","d_wrong_2","d_wrong_3"};//wrong_d
    static String[] linwenlong = new String[]{"e_linwenlong_1","e_linwenlong_2","e_linwenlong_3"};//林文龙_e
    static String[] wrong_e = new String[]{"e_wrong_1","e_wrong_2","e_wrong_3"};//wrong_e
    static String[] fanbingbing = new String[]{"f_fanbingbing_1","f_fanbingbing_2","f_fanbingbing_3"};//范冰冰_f
    static String[] wrong_f = new String[]{"f_wrong_1","f_wrong_2","f_wrong_3"};//wrong_f
    static String[] xiayu = new String[]{"g_xiayu_1","g_xiayu_2","g_xiayu_3"};//夏雨_g
    static String[] wrong_g = new String[]{"g_wrong_1","g_wrong_2","g_wrong_3"};//wrong_g
    static String[] aobama = new String[]{"h_aobama_1","h_aobama_2","h_aobama_3"};//奥巴马_h
    static String[] wrong_h = new String[]{"h_wrong_1","h_wrong_2","h_wrong_3"};//wrong_h
    static String[] gongli = new String[]{"i_gongli_1","i_gongli_2","i_gongli_3"};//巩俐_i
    static String[] wrong_i = new String[]{"i_wrong_1","i_wrong_2","i_wrong_3"};//wrong_i
    static String[] zhouxun = new String[]{"j_zhouxun_1","j_zhouxun_2","j_zhouxun_3"};//周迅_j
    static String[] wrong_j = new String[]{"j_wrong_1","j_wrong_2","j_wrong_3"};//wrong_j
    static String[] linyilian = new String[]{"k_linyilian_1","k_linyilian_2","k_linyilian_3"};//林忆莲_k
    static String[] wrong_k = new String[]{"k_wrong_1","k_wrong_2","k_wrong_3"};//wrong_k
    static String[] zhangguorong = new String[]{"l_zhangguorong_1","l_zhangguorong_2","l_zhangguorong_3"};//张国荣_l
    static String[] wrong_l = new String[]{"l_wrong_1","l_wrong_2","l_wrong_3"};//wrong_l
    static String[] wangfeng = new String[]{"m_wangfeng_1","m_wangfeng_2","m_wangfeng_3"};//汪峰_m
    static String[] wrong_m = new String[]{"m_wrong_1","m_wrong_2","m_wrong_3"};//wrong_m
    static String[] xuzheng = new String[]{"n_xuzheng_1","n_xuzheng_2","n_xuzheng_3"};//徐峥_n
    static String[] wrong_n = new String[]{"n_wrong_1","n_wrong_2","n_wrong_3"};//wrong_n
    static String[] fangzuming = new String[]{"o_fangzuming_1","o_fangzuming_2","o_fangzuming_3"};//房祖名_o
    static String[] wrong_o = new String[]{"o_wrong_1","o_wrong_2","o_wrong_3"};//wrong_o
    static String[] wangludan = new String[]{"p_wangludan_1","p_wangludan_2","p_wangludan_3"};//王璐丹_p
    static String[] wrong_p = new String[]{"p_wrong_1","p_wrong_2","p_wrong_3"};//wrong_p
    static String[] sunnan = new String[]{"q_sunnan_1","q_sunnan_2","q_sunnan_3"};//孙楠_q
    static String[] wrong_q = new String[]{"q_wrong_1","q_wrong_2","q_wrong_3"};//wrong_q
    static String[] yaochen = new String[]{"r_yaochen_1","r_yaochen_2","r_yaochen_3"};//姚晨_r
    static String[] wrong_r = new String[]{"r_wrong_1","r_wrong_2","r_wrong_3"};//wrong_r
    static String[] wanglihong = new String[]{"s_wanglihong_1","s_wanglihong_2","s_wanglihong_3"};//王力宏_s
    static String[] wrong_s = new String[]{"s_wrong_1","s_wrong_2","s_wrong_3"};//wrong_s
    static String[] zhuyin = new String[]{"t_zhuyin_1","t_zhuyin_2","t_zhuyin_3"};//朱茵_t
    static String[] wrong_t = new String[]{"t_wrong_1","t_wrong_2","t_wrong_3"};//wrong_t
    static String[] liutao = new String[]{"u_liutao_1","u_liutao_2","u_liutao_3"};//刘涛_u
    static String[] wrong_u = new String[]{"u_wrong_1","u_wrong_2","u_wrong_3"};//wrong_u
    static String[] liukaiwei = new String[]{"v_liukaiwei_1","v_liukaiwei_2","v_liukaiwei_3"};//刘恺威_v
    static String[] wrong_v = new String[]{"v_wrong_1","v_wrong_2","v_wrong_3"};//wrong_v
    static String[] tongliya = new String[]{"w_tongliya_1","w_tongliya_2","w_tongliya_3"};//佟丽娅_w
    static String[] wrong_w = new String[]{"w_wrong_1","w_wrong_2","w_wrong_3"};//wrong_w
    static String[] tangyan = new String[]{"x_tangyan_1","x_tangyan_2","x_tangyan_3"};//唐嫣_x
    static String[] wrong_x = new String[]{"x_wrong_1","x_wrong_2","x_wrong_3"};//wrong_x
    static String[] huge = new String[]{"y_huge_1","y_huge_2","y_huge_3"};//胡歌_y
    static String[] wrong_y = new String[]{"y_wrong_1","y_wrong_2","y_wrong_3"};//wrong_y
    static String[] liuyifei = new String[]{"z_liuyifei_1","z_liuyifei_2","z_liuyifei_3"};//刘亦菲_z
    static String[] wrong_z = new String[]{"z_wrong_1","z_wrong_2","z_wrong_3"};//wrong_z


    static String[] name = new String[]{"杨幂","陈好","章子怡","马伊琍","林文龙","范冰冰","夏雨","奥巴马","巩俐","周迅","林忆莲","张国荣",
            "汪峰","徐峥","房祖名","王璐丹","孙楠","姚晨","王力宏","朱茵","刘涛","刘恺威","佟丽娅","唐嫣","胡歌","刘亦菲"};


static Map<String,String[]> true_map = new HashMap<>();


    static public Map<String, String[]> getTrue_map() {
        true_map.put("杨幂",yangmu);
        true_map.put("陈好",chenhao);
        true_map.put("章子怡",zhangziyi);
        true_map.put("马伊琍",mayili);
        true_map.put("林文龙",linwenlong);
        true_map.put("范冰冰",fanbingbing);
        true_map.put("夏雨",xiayu);
        true_map.put("奥巴马",aobama);
        true_map.put("巩俐",gongli);
        true_map.put("周迅",zhouxun);
        true_map.put("林忆莲",linyilian);
        true_map.put("张国荣",zhangguorong);
        true_map.put("汪峰",wangfeng);
        true_map.put("徐峥",xuzheng );
        true_map.put("房祖名",fangzuming);
        true_map.put("王璐丹",wangludan);
        true_map.put("孙楠",sunnan);
        true_map.put("姚晨",yaochen);
        true_map.put("王力宏",wanglihong);
        true_map.put("朱茵",zhuyin);
        true_map.put("刘涛",liutao);
        true_map.put("刘恺威",liukaiwei);
        true_map.put("佟丽娅",tongliya);
        true_map.put("唐嫣",tangyan);
        true_map.put("胡歌",huge);
        true_map.put("刘亦菲",liuyifei);

        return true_map;
    }


    static Map<String,String[]> false_map = new HashMap<>();

    static public Map<String, String[]> getFalse_map() {
        false_map.put("杨幂",wrong_a);
        false_map.put("陈好",wrong_b);
        false_map.put("章子怡",wrong_c);
        false_map.put("马伊琍",wrong_d);
        false_map.put("林文龙",wrong_e);
        false_map.put("范冰冰",wrong_f);
        false_map.put("夏雨",wrong_g);
        false_map.put("奥巴马",wrong_h);
        false_map.put("巩俐",wrong_i);
        false_map.put("周迅",wrong_j);
        false_map.put("林忆莲",wrong_k);
        false_map.put("张国荣",wrong_l);
        false_map.put("汪峰",wrong_m);
        false_map.put("徐峥",wrong_n);
        false_map.put("房祖名",wrong_o);
        false_map.put("王璐丹",wrong_p);
        false_map.put("孙楠",wrong_q);
        false_map.put("姚晨",wrong_r);
        false_map.put("王力宏",wrong_s);
        false_map.put("朱茵",wrong_t);
        false_map.put("刘涛",wrong_u);
        false_map.put("刘恺威",wrong_v);
        false_map.put("佟丽娅",wrong_w);
        false_map.put("唐嫣",wrong_x);
        false_map.put("胡歌",wrong_y);
        false_map.put("刘亦菲",wrong_z);

        return false_map;
    }


    @Override
    public void onCreate(SQLiteDatabase sq) {
        String sqlStr = "create table verificationCode( sName Text,trueOrFalse Text,resPic Text)";
        sq.execSQL(sqlStr);

        ContentValues contentValues = new ContentValues();
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yangmu[0]);
        sq.insert("verificationCode",null,contentValues);//杨幂_a_1
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yangmu[1]);
        sq.insert("verificationCode",null,contentValues);//杨幂_a_2
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yangmu[2]);
        sq.insert("verificationCode",null,contentValues);//杨幂_a_3
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_a[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_a_1
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_a[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_a_2
        contentValues.put("sName",name[0]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_a[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_a_3

        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",chenhao[0]);
        sq.insert("verificationCode",null,contentValues);//陈好_b_1
        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",chenhao[1]);
        sq.insert("verificationCode",null,contentValues);//陈好_b_2
        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",chenhao[2]);
        sq.insert("verificationCode",null,contentValues);//陈好_b_3
        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_b[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_b_1
        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_b[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_b_2
        contentValues.put("sName",name[1]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_b[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_b_1

        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangziyi[0]);
        sq.insert("verificationCode",null,contentValues);//章子怡_c_1
        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangziyi[1]);
        sq.insert("verificationCode",null,contentValues);//章子怡_c_2
        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangziyi[2]);
        sq.insert("verificationCode",null,contentValues);//章子怡_c_3
        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_c[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_c_1
        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_c[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_c_2
        contentValues.put("sName",name[2]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_c[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_c_3

        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",mayili[0]);
        sq.insert("verificationCode",null,contentValues);//马伊琍_d_1
        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",mayili[1]);
        sq.insert("verificationCode",null,contentValues);//马伊琍_d_2
        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",mayili[2]);
        sq.insert("verificationCode",null,contentValues);//马伊琍_d_3
        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_d[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_d_1
        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_d[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_d_2
        contentValues.put("sName",name[3]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_d[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_d_3

        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linwenlong[0]);
        sq.insert("verificationCode",null,contentValues);//林文龙_e_1
        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linwenlong[1]);
        sq.insert("verificationCode",null,contentValues);//林文龙_e_2
        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linwenlong[2]);
        sq.insert("verificationCode",null,contentValues);//林文龙_e_3
        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_e[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_e_1
        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_e[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_e_2
        contentValues.put("sName",name[4]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_e[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_e_3

        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fanbingbing[0]);
        sq.insert("verificationCode",null,contentValues);//范冰冰_f_1
        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fanbingbing[1]);
        sq.insert("verificationCode",null,contentValues);//范冰冰_f_2
        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fanbingbing[2]);
        sq.insert("verificationCode",null,contentValues);//范冰冰_f_3
        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_f[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_f_1
        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_f[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_f_2
        contentValues.put("sName",name[5]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_f[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_f_3

        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xiayu[0]);
        sq.insert("verificationCode",null,contentValues);//夏雨_g_1
        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xiayu[1]);
        sq.insert("verificationCode",null,contentValues);//夏雨_g_2
        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xiayu[2]);
        sq.insert("verificationCode",null,contentValues);//夏雨_g_3
        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_g[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_g_1
        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_g[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_g_2
        contentValues.put("sName",name[6]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_g[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_g_3

        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",aobama[0]);
        sq.insert("verificationCode",null,contentValues);//奥巴马_h_1
        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",aobama[1]);
        sq.insert("verificationCode",null,contentValues);//奥巴马_h_2
        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",aobama[2]);
        sq.insert("verificationCode",null,contentValues);//奥巴马_h_3
        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_h[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_h_1
        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_h[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_h_1
        contentValues.put("sName",name[7]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_h[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_h_1

        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",gongli[0]);
        sq.insert("verificationCode",null,contentValues);//巩俐_i_1
        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",gongli[1]);
        sq.insert("verificationCode",null,contentValues);//巩俐_i_2
        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",gongli[2]);
        sq.insert("verificationCode",null,contentValues);//巩俐_i_3
        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_i[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_i_1
        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_i[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_i_2
        contentValues.put("sName",name[8]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_i[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_i_3

        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhouxun[0]);
        sq.insert("verificationCode",null,contentValues);//周迅_j_1
        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhouxun[1]);
        sq.insert("verificationCode",null,contentValues);//周迅_j_2
        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhouxun[2]);
        sq.insert("verificationCode",null,contentValues);//周迅_j_3
        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_j[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_j_1
        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_j[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_j_2
        contentValues.put("sName",name[9]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_j[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_j_3

        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linyilian[0]);
        sq.insert("verificationCode",null,contentValues);//林忆莲_k_1
        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linyilian[1]);
        sq.insert("verificationCode",null,contentValues);//林忆莲_k_2
        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",linyilian[2]);
        sq.insert("verificationCode",null,contentValues);//林忆莲_k_3
        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_k[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_k_1
        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_k[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_k_2
        contentValues.put("sName",name[10]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_k[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_k_3

        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangguorong[0]);
        sq.insert("verificationCode",null,contentValues);//张国荣_l_1
        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangguorong[1]);
        sq.insert("verificationCode",null,contentValues);//张国荣_l_2
        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhangguorong[2]);
        sq.insert("verificationCode",null,contentValues);//张国荣_l_3
        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_l[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_l_1
        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_l[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_l_2
        contentValues.put("sName",name[11]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_l[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_l_3

        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangfeng[0]);
        sq.insert("verificationCode",null,contentValues);//汪峰_m_1
        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangfeng[1]);
        sq.insert("verificationCode",null,contentValues);//汪峰_m_2
        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangfeng[2]);
        sq.insert("verificationCode",null,contentValues);//汪峰_m_3
        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_m[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_m_1
        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_m[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_m_2
        contentValues.put("sName",name[12]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_m[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_m_3

        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xuzheng[0]);
        sq.insert("verificationCode",null,contentValues);//徐峥_n_1
        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xuzheng[1]);
        sq.insert("verificationCode",null,contentValues);//徐峥_n_2
        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",xuzheng[2]);
        sq.insert("verificationCode",null,contentValues);//徐峥_n_3
        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_n[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_n_1
        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_n[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_n_2
        contentValues.put("sName",name[13]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_n[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_n_3

        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fangzuming[0]);
        sq.insert("verificationCode",null,contentValues);//房祖名_o_1
        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fangzuming[1]);
        sq.insert("verificationCode",null,contentValues);//房祖名_o_2
        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",fangzuming[2]);
        sq.insert("verificationCode",null,contentValues);//房祖名_o_3
        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_o[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_o_1
        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_o[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_o_2
        contentValues.put("sName",name[14]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_o[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_o_3

        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangludan[0]);
        sq.insert("verificationCode",null,contentValues);//王璐丹_p_1
        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangludan[1]);
        sq.insert("verificationCode",null,contentValues);//王璐丹_p_2
        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wangludan[2]);
        sq.insert("verificationCode",null,contentValues);//王璐丹_p_3
        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_p[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_p_1
        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_p[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_p_2
        contentValues.put("sName",name[15]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_p[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_p_3

        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",sunnan[0]);
        sq.insert("verificationCode",null,contentValues);//孙楠_q_1
        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",sunnan[1]);
        sq.insert("verificationCode",null,contentValues);//孙楠_q_2
        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",sunnan[2]);
        sq.insert("verificationCode",null,contentValues);//孙楠_q_3
        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_q[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_q_1
        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_q[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_q_2
        contentValues.put("sName",name[16]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_q[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_q_3

        contentValues.put("sName",name[17]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yaochen[0]);
        sq.insert("verificationCode",null,contentValues);//姚晨_r_1
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yaochen[1]);
        sq.insert("verificationCode",null,contentValues);//姚晨_r_2
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",yaochen[2]);
        sq.insert("verificationCode",null,contentValues);//姚晨_r_3
        contentValues.put("sName",name[17]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_r[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_r_1
        contentValues.put("sName",name[17]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_r[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_r_2
        contentValues.put("sName",name[17]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_r[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_r_3

        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wanglihong[0]);
        sq.insert("verificationCode",null,contentValues);//王力宏_s_1
        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wanglihong[1]);
        sq.insert("verificationCode",null,contentValues);//王力宏_s_2
        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",wanglihong[2]);
        sq.insert("verificationCode",null,contentValues);//王力宏_s_3
        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_s[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_s_1
        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_s[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_s_2
        contentValues.put("sName",name[18]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_s[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_s_3

        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhuyin[0]);
        sq.insert("verificationCode",null,contentValues);//朱茵_t_1
        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhuyin[1]);
        sq.insert("verificationCode",null,contentValues);//朱茵_t_2
        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",zhuyin[2]);
        sq.insert("verificationCode",null,contentValues);//朱茵_t_3
        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_t[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_t_1
        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_t[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_t_2
        contentValues.put("sName",name[19]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_t[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_t_3

        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liutao[0]);
        sq.insert("verificationCode",null,contentValues);//刘涛_u_1
        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liutao[1]);
        sq.insert("verificationCode",null,contentValues);//刘涛_u_2
        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liutao[2]);
        sq.insert("verificationCode",null,contentValues);//刘涛_u_3
        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_u[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_u_1
        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_u[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_u_2
        contentValues.put("sName",name[20]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_u[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_u_3

        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liukaiwei[0]);
        sq.insert("verificationCode",null,contentValues);//刘恺威_v_1
        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liukaiwei[1]);
        sq.insert("verificationCode",null,contentValues);//刘恺威_v_2
        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liukaiwei[2]);
        sq.insert("verificationCode",null,contentValues);//刘恺威_v_3
        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_v[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_v_1
        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_v[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_v_2
        contentValues.put("sName",name[21]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_v[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_v_3

        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tongliya[0]);
        sq.insert("verificationCode",null,contentValues);//佟丽娅_w_1
        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tongliya[1]);
        sq.insert("verificationCode",null,contentValues);//佟丽娅_w_2
        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tongliya[2]);
        sq.insert("verificationCode",null,contentValues);//佟丽娅_w_3
        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_w[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_w_1
        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_w[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_w_2
        contentValues.put("sName",name[22]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_w[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_w_3

        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tangyan[0]);
        sq.insert("verificationCode",null,contentValues);//唐嫣_x_1
        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tangyan[1]);
        sq.insert("verificationCode",null,contentValues);//唐嫣_x_2
        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",tangyan[2]);
        sq.insert("verificationCode",null,contentValues);//唐嫣_x_3
        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_x[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_x_1
        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_x[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_x_2
        contentValues.put("sName",name[23]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_x[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_x_3

        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",huge[0]);
        sq.insert("verificationCode",null,contentValues);//胡歌_y_1
        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",huge[1]);
        sq.insert("verificationCode",null,contentValues);//胡歌_y_2
        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",huge[2]);
        sq.insert("verificationCode",null,contentValues);//胡歌_y_3
        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_y[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_y_1
        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_y[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_y_2
        contentValues.put("sName",name[24]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_y[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_y_3

        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liuyifei[0]);
        sq.insert("verificationCode",null,contentValues);//刘亦菲_z_1
        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liuyifei[1]);
        sq.insert("verificationCode",null,contentValues);//刘亦菲_z_2
        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","true");
        contentValues.put("resPic",liuyifei[2]);
        sq.insert("verificationCode",null,contentValues);//刘亦菲_z_3
        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_z[0]);
        sq.insert("verificationCode",null,contentValues);//wrong_z_1
        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_z[1]);
        sq.insert("verificationCode",null,contentValues);//wrong_z_2
        contentValues.put("sName",name[25]);
        contentValues.put("trueOrFalse","false");
        contentValues.put("resPic",wrong_z[2]);
        sq.insert("verificationCode",null,contentValues);//wrong_z_3

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

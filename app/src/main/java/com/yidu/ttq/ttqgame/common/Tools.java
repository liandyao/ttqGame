package com.yidu.ttq.ttqgame.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class Tools {

    static Random rd = new Random();

    public static int getRomdon(int num){
        return rd.nextInt(num);
    }

    /**
     * 得到图片信息
     * @param path
     * @return
     */
    public Bitmap getBitMap(String path){
        //System.out.println(Tools.class.getClass().getClassLoader().);
        Bitmap bitmap =BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/"+path));
        System.out.println(bitmap+"==================="+path);
        return bitmap;
    }
}

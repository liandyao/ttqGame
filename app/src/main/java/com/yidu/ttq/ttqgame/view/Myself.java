package com.yidu.ttq.ttqgame.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 主机
 * Created by liandyao on 2017/12/3 0003.
 */

public class Myself {

    private float x ;
    private float y ;
    private boolean isLive = true ;

    public Myself(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    /**
     * 移动的方法
     */
    public void move(){

    }

    /**
     * 画自己
     * @param c 画笔
     */
    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.BLACK); //黑色
        c.drawOval(x,y,x+160,y+160,p);
    }


    /**
     * 返回矩形
     * @return
     */
    public RectF getRectF(){

        return new RectF(x,y,x+160,y+160);
    }
}

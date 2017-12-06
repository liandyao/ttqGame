package com.yidu.ttq.ttqgame.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/12/2 0002.
 * 球类
 */

public class Ball {
    private float x ;
    private float y ;
    private float fx ;//方向x    0左  1右
    private float fy ; //方向y   0上   1下
    private float speed ;



    public Ball(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void move(){
        if(x<=0){
            fx=1;
        }
        if(x>=GameView.width){
            fx=0;
        }

        if(y<=0){
            fy=1;
        }
        if(y>=GameView.height){
            fy=0;
        }

        if(fx==1){
            x+=speed;
        }else{
            x-=speed;
        }

        if(fy==1){
            y+=speed;
        }else{
            y-=speed;
        }
    }

    public void draw(Canvas c){
        move();
        Paint p = new Paint();
        p.setColor(Color.YELLOW);

        c.drawOval(x ,y ,x+20,y+20,p);
    }

    /**
     * 返回矩形
     * @return
     */
    public RectF getRectF(){

        return new RectF(x,y,x+20,y+20);
    }
}

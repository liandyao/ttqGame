package com.yidu.ttq.ttqgame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.yidu.ttq.ttqgame.common.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder holder ;
    Canvas canvas ;
    int time = 0 ; //时间

    public static int width = 0 ;
    public static int height = 0 ;
    //Bitmap back = BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/back.jpg"));
    Bitmap back = new Tools().getBitMap("back.jpg");

    //球
    List<Ball> listBall = new ArrayList<>();
    //自己
    Myself myself = new Myself(200,200);

    public GameView(Context context) {
        super(context);
        holder=this.getHolder();
        holder.addCallback(this);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        System.out.println("按下去了");
                    }
                    case MotionEvent.ACTION_MOVE:{
                        //System.out.println("正在移动:"+motionEvent.getX()+"    "+motionEvent.getY());
                        myself.setX(motionEvent.getX());
                        myself.setY(motionEvent.getY());
                    }
                }
                return true;
            }
        });


        new TimeThread().start();//时间线程
    }

    /**
     * 初始化界面方法
     */
    public void init(){
        for(int i=0;i<10;i++){
            Ball ball = new Ball(Tools.getRomdon(width),Tools.getRomdon(height),Tools.getRomdon(20));
            //Ball ball = new Ball(100,100,2);
            listBall.add(ball);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        System.out.println("初始化......");
        width = this.getWidth();
        height = this.getHeight();
        System.out.println("宽度和高度......"+width+"     "+height);

        init();
        new MyThread().start();//启动线程
        new CalcThread(this).start();//启动碰撞线程
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        System.out.println("改变......");

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        System.out.println("销毁......");
    }

    /**
     * 画图
     */
    private void draw(){
        canvas = holder.lockCanvas();
        //canvas.drawColor(Color.rgb(50,159,50));
        Paint backpaint = new Paint();

        canvas.drawBitmap(back,0,0,backpaint);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(60);
        //Typeface tf = Typeface.create("黑体",Typeface.BOLD);
        p.setTypeface(Typeface.SERIF); //几种字体样式 Typeface.SERIF  ,  Typeface.SANS_SERIF  ,  Typeface.MONOSPACE
        canvas.drawText("分数"+time,200,100,p);


        if(!myself.isLive()){
            p.setColor(Color.RED); //红色
            canvas.drawText("GAME OVER!得分:"+time,200,900,p);
        }else{
            //画自己
            myself.draw(canvas);

            //画球
            for(int i=0;i<listBall.size();i++){
                Ball ball = listBall.get(i);
                ball.draw(canvas);
            }
        }

        holder.unlockCanvasAndPost(canvas);

    }

    /**
     * 时间线程
     */
    class TimeThread extends Thread{
        @Override
        public void run() {

            while (myself.isLive()){
                time++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 重画线程
     */
    class MyThread extends Thread{
        @Override
        public void run() {
            while(true){
                draw();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.yidu.ttq.ttqgame.view;

/**
 * Created by liandyao on 2017/12/3 0003.
 */

public class CalcThread extends Thread {

    GameView gv ;
    public CalcThread(GameView gv){
        this.gv=gv;
    }

    @Override
    public void run() {
        while(true){
            if(gv.time<=3) continue ;
            for(int i=0;i<gv.listBall.size();i++){
                Ball b= gv.listBall.get(i);
                //System.out.println(b.getRectF()+"  ==   "+gv.myself.getRectF());
                if(b.getRectF().intersect(gv.myself.getRectF())){ //是否碰撞
                    //System.out.println("碰撞了..........");
                    //gv.listBall.remove(b);
                    gv.myself.setLive(false); //死亡
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

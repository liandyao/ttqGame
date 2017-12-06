package com.yidu.ttq.ttqgame;

import android.app.Activity;
import android.os.Bundle;

import com.yidu.ttq.ttqgame.view.GameView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}

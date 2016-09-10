package com.wind.process.progrss;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wind.process.progrss.view.ProgressButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressButton progressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressButton = (ProgressButton)findViewById(R.id.activity_main_pb);
        progressButton.setOnClickListener(this);
        progressButton.setText("下载");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_pb:
                progressButton.setText("正在下载");
                thread.start();
                break;
        }
    }


    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=1;i<10;i++){
                Message msg = Message.obtain();
                msg.what =1;
                msg.arg1 =i;
                handler.sendMessage(msg);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            handler.sendEmptyMessage(0);
        }
    });

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                progressButton.setProgress(10*msg.arg1).invalidate();
            }else{
                progressButton.setText("下载完成").finish().invalidate();
                progressButton.setClickable(false);
            }
        }
    };
}

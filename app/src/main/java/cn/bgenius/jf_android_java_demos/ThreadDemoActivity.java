package cn.bgenius.jf_android_java_demos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by jinfei on 20/02/2017.
 */

public class ThreadDemoActivity extends Activity {

    private Button btnlazygirl;
    private Button btnPrettygirl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaddemo);

        btnlazygirl = (Button) findViewById(R.id.btnLazyGirl);
        btnPrettygirl = (Button) findViewById(R.id.btnPrettyGirl);

        btnlazygirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(1500);
                    Log.d("debuginfo",">>>>>>>>>>>>I'm lazy girl , please don't touch me.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        btnPrettygirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1500);
                            Log.d("debuginfo",">>>>>>>>>>>>I'm pretty girl , we can play game.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}

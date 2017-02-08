package cn.bgenius.jf_android_java_demos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import Views.ViewTest;

/**
 * Created by 金飞 on 08/02/2017.
 */

public class CustomerViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ViewTest(this));
    }
}

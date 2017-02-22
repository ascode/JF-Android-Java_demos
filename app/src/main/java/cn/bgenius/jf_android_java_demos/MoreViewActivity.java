package cn.bgenius.jf_android_java_demos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by jinfei on 19/02/2017.
 */

public class MoreViewActivity extends Activity {

    private ListView lv;
    private ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);

        ad = new ArrayAdapter<String>(MoreViewActivity.this, android.R.layout.simple_list_item_1);
//        ad = new ArrayAdapter<String>(MoreViewActivity.this, R.layout.list_cell_demo);
        ad.add("菜单1");
        ad.add("菜单2");
        ad.add("菜单3");

        lv = (ListView) findViewById(R.id.listview1);
        lv.setAdapter(ad);

    }
}

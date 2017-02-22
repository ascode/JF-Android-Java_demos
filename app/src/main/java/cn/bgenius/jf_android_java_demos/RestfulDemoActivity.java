package cn.bgenius.jf_android_java_demos;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by jinfei on 20/02/2017.
 */

public class RestfulDemoActivity extends Activity {

    private Button btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resufuldemo);

        btnGet = (Button) findViewById(R.id.btnGet);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new AsyncTask<String, Void, Void>() {
                        @Override
                        protected Void doInBackground(String... params) {

                            try {
                                URL url = new URL(params[0]);
                                URLConnection conn = url.openConnection();
                                InputStream is = conn.getInputStream();
                                InputStreamReader isr = new InputStreamReader(is);
                                BufferedReader br = new BufferedReader(isr);
                                String line;
                                StringBuilder sb = new StringBuilder();
                                while ((line = br.readLine()) != null) {
                                    sb.append(line);
                                    Log.i("debuginfo", line);
                                }
                                isr.close();
                                is.close();

                                // 读取一下json格式数据
                                JSONObject json = new JSONObject(sb.toString());
                                Log.d("debuginfo", json.getString("query"));

                                JSONObject basic = json.getJSONObject("basic");
                                JSONArray ja = basic.getJSONArray("explains");
                                for (int i = 0; i < ja.length(); i++) {
                                    Log.d("debuginfo", ja.getString(i));

                                }

                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            return null;
                        }
                }.execute("http://fanyi.youdao.com/openapi.do?keyfrom=test011&key=1422502786&type=data&doctype=json&version=1.1&q=good");

            }
        });
    }
}

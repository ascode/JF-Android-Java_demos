package cn.bgenius.jf_android_java_demos;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jinfei on 20/02/2017.
 */

public class AsyncTaskDemoActivity extends Activity {
    private Button btnSubmit;
    private EditText edtUrl;
    private TextView tvShowHtml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctaskdemo);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        tvShowHtml = (TextView) findViewById(R.id.tvShowHtml);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadUrl("http://www.163.com");
            }
        });
    }

    public void ReadUrl(String url){
        new AsyncTask<String, Float, String>(){
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url = new URL(params[0]);
                    URLConnection conn = url.openConnection();
                    long totalLength = conn.getContentLength();
                    InputStream is = conn.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null){
                        sb.append(line);
                        publishProgress((float)(sb.toString().length() / totalLength));
                    }
                    br.close();
                    isr.close();
                    is.close();
                    return sb.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                Toast.makeText(AsyncTaskDemoActivity.this, "开始读取...", Toast.LENGTH_SHORT).show();
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                tvShowHtml.setText(s);
                Log.d("debuginfo", s);
                super.onPostExecute(s);

            }

            @Override
            protected void onProgressUpdate(Float... values) {
                Log.d("debuginfo", String.valueOf(values[0]));
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        }.execute(url);
    }
}

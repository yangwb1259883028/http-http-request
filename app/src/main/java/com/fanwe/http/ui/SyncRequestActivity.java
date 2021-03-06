package com.fanwe.http.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fanwe.http.R;
import com.fanwe.lib.http.IRequest;
import com.fanwe.lib.http.IResponse;
import com.fanwe.lib.http.impl.httprequest.GetRequest;

/**
 * 同步请求demo
 */
public class SyncRequestActivity extends AppCompatActivity
{
    public static final String TAG = "SyncRequestActivity";

    public static final String URL = "http://ilvbt3.fanwe.net/mapi/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_request);
    }

    public void onClickRequest(View view)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    IRequest request = new GetRequest();
                    request.setBaseUrl(URL); //设置请求地址
                    request.getParams().put("ctl", "app").put("act", "init"); //设置请求参数

                    IResponse response = request.execute(); //发起请求，得到Response对象
                    String result = response.getBody(); //请求结果以字符串返回

                    Log.i(TAG, result);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

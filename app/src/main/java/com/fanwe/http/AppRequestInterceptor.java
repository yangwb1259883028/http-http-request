package com.fanwe.http;

import android.util.Log;

import com.fanwe.lib.http.IRequest;
import com.fanwe.lib.http.IResponse;
import com.fanwe.lib.http.interceptor.IRequestInterceptor;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * http请求拦截
 */
public class AppRequestInterceptor implements IRequestInterceptor
{
    public static final String TAG = "AppRequestInterceptor";

    private final Map<IRequest, Long> mMapTime = new WeakHashMap<>();

    @Override
    public void beforeExecute(IRequest request)
    {
        //请求发起之前回调
        mMapTime.put(request, System.currentTimeMillis());
        Log.i(TAG, "beforeExecute:" + request);
    }

    @Override
    public void afterExecute(IRequest request, IResponse response)
    {
        //请求发起之后回调
        long time = System.currentTimeMillis() - mMapTime.get(request);
        Log.i(TAG, "afterExecute:" + request + " " + time);
    }
}

package com.duoyou.task.sdk.xutils.http.app;

import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.ex.HttpException;
import com.duoyou.task.sdk.xutils.http.HttpMethod;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashSet;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HttpRetryHandler {
    public static HashSet<Class<?>> blackList;
    public int maxRetryCount = 2;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        blackList = hashSet;
        hashSet.add(HttpException.class);
        blackList.add(Callback.CancelledException.class);
        blackList.add(MalformedURLException.class);
        blackList.add(URISyntaxException.class);
        blackList.add(NoRouteToHostException.class);
        blackList.add(PortUnreachableException.class);
        blackList.add(ProtocolException.class);
        blackList.add(NullPointerException.class);
        blackList.add(FileNotFoundException.class);
        blackList.add(JSONException.class);
        blackList.add(UnknownHostException.class);
        blackList.add(IllegalArgumentException.class);
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public boolean canRetry(UriRequest uriRequest, Throwable th, int i) {
        LogUtil.w(th.getMessage(), th);
        if (i > this.maxRetryCount) {
            LogUtil.w(uriRequest.toString());
            LogUtil.w("The Max Retry times has been reached!");
            return false;
        }
        if (!HttpMethod.permitsRetry(uriRequest.getParams().getMethod())) {
            LogUtil.w(uriRequest.toString());
            LogUtil.w("The Request Method can not be retried.");
            return false;
        }
        if (!blackList.contains(th.getClass())) {
            return true;
        }
        LogUtil.w(uriRequest.toString());
        LogUtil.w("The Exception can not be retried.");
        return false;
    }
}

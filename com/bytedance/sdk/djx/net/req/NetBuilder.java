package com.bytedance.sdk.djx.net.req;

import android.os.Handler;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class NetBuilder<T extends NetBuilder> {
    protected Map<String, String> mHeaders;
    protected JSONObject mJsonParams;
    protected Map<String, String> mParams;
    protected Object mTag;
    protected String mUrl;
    public Map<String, String> mResponseHeaders = new HashMap();
    protected int mRetryCurrent = 0;
    protected int mMaxRetryCount = 0;
    protected long mReadTimeOut = -1;
    protected long mWriteTimeOut = -1;
    protected long mConnTimeOut = -1;

    public abstract void go(NetCallback netCallback);

    protected void sendSuccessResultCallback() {
    }

    public T url(String str) {
        this.mUrl = str;
        return this;
    }

    public T tag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public T headers(Map<String, String> map) {
        this.mHeaders = map;
        return this;
    }

    public T addHeader(String str, String str2) {
        if (this.mHeaders == null) {
            this.mHeaders = new LinkedHashMap();
        }
        this.mHeaders.put(str, str2);
        return this;
    }

    public T params(Map<String, String> map) {
        this.mParams = map;
        return this;
    }

    public T params(JSONObject jSONObject) {
        this.mJsonParams = jSONObject;
        return this;
    }

    public T addParam(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new LinkedHashMap();
        }
        this.mParams.put(str, str2);
        return this;
    }

    public T timeoutRead(long j) {
        this.mReadTimeOut = j;
        return this;
    }

    public T timeoutWrite(long j) {
        this.mWriteTimeOut = j;
        return this;
    }

    public T timeoutConn(long j) {
        this.mConnTimeOut = j;
        return this;
    }

    protected void sendFailResultCallback(final NetCallback netCallback, Handler handler, final int i, final String str, final Throwable th) {
        if (netCallback == null || handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.bytedance.sdk.djx.net.req.NetBuilder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m368x904698cc(netCallback, i, str, th);
            }
        });
    }

    /* renamed from: lambda$sendFailResultCallback$0$com-bytedance-sdk-djx-net-req-NetBuilder, reason: not valid java name */
    /* synthetic */ void m368x904698cc(NetCallback netCallback, int i, String str, Throwable th) {
        netCallback.onNetError(this, i, str, th);
        netCallback.onNetEnd(this);
    }
}

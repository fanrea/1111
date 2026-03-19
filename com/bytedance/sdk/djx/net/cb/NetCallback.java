package com.bytedance.sdk.djx.net.cb;

import android.os.SystemClock;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class NetCallback<T> {
    protected long mStartTime = SystemClock.elapsedRealtime();

    public void onNetEnd(NetBuilder netBuilder) {
    }

    public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
    }

    public void onNetProgress(NetBuilder netBuilder, float f) {
    }

    public void onNetSuccess(NetBuilder netBuilder, NetResponse<T> netResponse) {
    }

    public void onNetStart(NetBuilder netBuilder) {
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    public Class<?> getType() {
        return String.class;
    }
}

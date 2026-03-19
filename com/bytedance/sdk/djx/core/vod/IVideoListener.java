package com.bytedance.sdk.djx.core.vod;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IVideoListener {
    void onCompletion();

    void onDurationChange(long j);

    void onError(int i, String str, Throwable th);

    void onInfo(int i, int i2);

    void onPrepared();

    void onRenderFirstFrame();

    void onVideoSizeChanged(int i, int i2);
}

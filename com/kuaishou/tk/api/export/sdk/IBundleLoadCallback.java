package com.kuaishou.tk.api.export.sdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface IBundleLoadCallback {
    void onBundleLoadError(int i, Throwable th);

    void onBundleLoadFinish(TkBundleInfo tkBundleInfo);

    void onBundleLoadSuccess(TkBundleInfo tkBundleInfo);
}

package com.kuaishou.tk.api.export.sdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ICompileCallback {
    void onCompileFinish(boolean z);

    void onFailed(TkBundleInfo tkBundleInfo, Throwable th);

    void onSuccess(TkBundleInfo tkBundleInfo);
}

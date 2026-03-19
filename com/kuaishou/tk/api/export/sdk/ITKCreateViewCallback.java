package com.kuaishou.tk.api.export.sdk;

import com.kuaishou.tk.api.export.ITKViewContainer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ITKCreateViewCallback {
    void onFailed(int i, Throwable th, TkBundleInfo tkBundleInfo);

    void onSuccess(ITKViewContainer iTKViewContainer, TkBundleInfo tkBundleInfo);
}

package com.baidu.mobads.container.nativecpu.interfaces;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public interface CpuNativeStatusCB {
    void onAdDownloadWindowShow();

    void onNotifyPerformance(String str);

    void onPermissionClose();

    void onPermissionShow();

    void onPrivacyClick();

    void onPrivacyLpClose();

    void startRouter(Context context, String str);
}

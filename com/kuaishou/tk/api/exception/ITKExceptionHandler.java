package com.kuaishou.tk.api.exception;

import com.kuaishou.tk.api.export.sdk.TkBundleInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ITKExceptionHandler {
    void handleException(Throwable th, TkBundleInfo tkBundleInfo, String str);

    void handleReportException(Throwable th, ContainerInfo containerInfo);
}

package com.duoyou.task.openapi;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface OnDownloadListener {
    void onFailure(String str, String str2);

    void onProgress(int i, long j, long j2, long j3);

    void onSuccess(File file);

    void onWaiting();
}

package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ha implements v10 {
    @Override // com.qq.e.comm.plugin.v10
    public boolean a(ApkDownloadTask apkDownloadTask) {
        return System.currentTimeMillis() - apkDownloadTask.e() > 259200000;
    }

    @Override // com.qq.e.comm.plugin.v10
    public boolean b(ApkDownloadTask apkDownloadTask) {
        return r1.d().c().p() == zr.WIFI;
    }
}

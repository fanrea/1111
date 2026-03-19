package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.network.Networking;
import com.czhj.volley.toolbox.FileDownloader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q {
    private static FileDownloader a;

    public static FileDownloader a() {
        if (a == null) {
            synchronized (q.class) {
                if (a == null && Networking.getDownloadRequestQueue() != null) {
                    a = new FileDownloader(Networking.getDownloadRequestQueue(), 3);
                }
            }
        }
        return a;
    }
}

package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private static volatile hc d;
    private Handler hc = null;

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    public void d(Context context, com.ss.android.socialbase.downloader.h.b bVar) {
        if (hc() && bVar != null) {
            try {
                File file = new File(bVar.mk(), bVar.gb());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            if (this.hc == null) {
                this.hc = new Handler(Looper.getMainLooper());
            }
            final String strTc = bVar.tc();
            com.ss.android.socialbase.downloader.downloader.h.hc(context).tc(bVar.h());
            this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hc.1
                @Override // java.lang.Runnable
                public void run() {
                    mq.b().d(3, mq.getContext(), null, "下载失败，请重试！", null, 0);
                    u uVarD = com.ss.android.downloadlib.gb.d().d(strTc);
                    if (uVarD != null) {
                        uVarD.h();
                    }
                }
            });
        }
    }

    public boolean hc() {
        return mq.tt().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}

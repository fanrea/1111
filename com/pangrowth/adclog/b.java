package com.pangrowth.adclog;

import com.ad.android.alog.Alog;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public b(Queue queue, String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        for (h hVar : f.c) {
            if (hVar != null) {
                Alog alog = i.e;
                hVar.a(alog != null ? alog.c() : 0L);
            }
        }
        try {
            Thread.sleep(15000L);
        } catch (Exception unused) {
        }
        f.a(this.a, this.b);
    }
}

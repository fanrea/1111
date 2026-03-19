package com.ss.android.downloadlib.hc;

import com.kuaishou.socket.nano.SocketMessages;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.downloader.d.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements d.InterfaceC0785d {
    private long d;

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void b() {
    }

    private static class d {
        private static u d = new u();
    }

    public static u d() {
        return d.d;
    }

    private u() {
        this.d = 0L;
        com.ss.android.socialbase.downloader.d.d.d().d(this);
    }

    @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
    public void hc() {
        this.d = System.currentTimeMillis();
    }

    public void d(final c cVar, final long j) {
        if (cVar == null) {
            return;
        }
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.hc.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.d.d.d().b() || System.currentTimeMillis() - u.this.d <= j) {
                    cVar.d(true);
                } else {
                    cVar.d(false);
                }
            }
        }, j);
    }

    public void d(c cVar) {
        d(cVar, 5000L);
    }

    public void hc(c cVar) {
        if (cVar == null) {
            return;
        }
        JSONObject jSONObjectTt = mq.tt();
        int i = SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC;
        int iOptInt = jSONObjectTt.optInt("check_an_result_delay", SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC);
        if (iOptInt > 0) {
            i = iOptInt;
        }
        d(cVar, i);
    }
}

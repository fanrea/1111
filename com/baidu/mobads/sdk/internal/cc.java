package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class cc extends Handler {
    final /* synthetic */ ca a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    cc(ca caVar, Looper looper) {
        super(looper);
        this.a = caVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString(ca.n);
        by byVar = (by) message.getData().getParcelable(ca.m);
        if (!ca.k.equals(string)) {
            this.a.z.a(ca.a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.a.a(false);
            if (this.a.A) {
                this.a.A = false;
                this.a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        bt btVar = new bt(byVar.e(), this.a.y, byVar);
        try {
            try {
                if (this.a.u != ca.t) {
                    this.a.a(btVar);
                    btVar.a(ca.f());
                    this.a.a(true);
                } else {
                    btVar.a();
                    btVar.a(ca.f());
                    if (ca.p != null) {
                        ca.p.b = byVar.b();
                    }
                    this.a.l();
                    if (this.a.A) {
                        this.a.A = false;
                        ca caVar = this.a;
                        caVar.a(caVar.p(), "load remote file just downloaded");
                    }
                }
            } catch (ca.a e) {
                String str = "download apk file failed: " + e.toString();
                this.a.a(false);
                this.a.z.a(ca.a, str);
            }
        } finally {
            btVar.delete();
        }
    }
}

package com.alliance.ssp.ad.r;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: DownLoadTaskNew.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d extends Handler {
    public final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, Looper looper, j jVar) {
        super(looper);
        this.a = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar;
        int i = message.what;
        if (i != 291) {
            if (i == 292 && (jVar = this.a) != null) {
                jVar.a(f.i.e);
                return;
            }
            return;
        }
        j jVar2 = this.a;
        if (jVar2 != null) {
            jVar2.a(message.arg1, message.arg2, f.i.e);
        }
    }
}

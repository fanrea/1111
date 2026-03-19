package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.pi.DFA;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class kf implements DFA {
    private IGDTApkListener a;
    private jf b = new jf();
    private HandlerThread c;
    private Handler d;

    public kf(IGDTApkListener iGDTApkListener) {
        this.a = iGDTApkListener;
        HandlerThread handlerThread = new HandlerThread("GDTApkDelegate");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new a(this.c.getLooper(), iGDTApkListener);
    }

    /* compiled from: A */
    class a extends Handler {
        final /* synthetic */ IGDTApkListener a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, IGDTApkListener iGDTApkListener) {
            super(looper);
            this.a = iGDTApkListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            kf.this.b.a(this.a);
            kf.this.d.removeCallbacks(null);
        }
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void loadGDTApk() {
        Handler handler = this.d;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void startInstall(Context context, GDTApk gDTApk) {
        jf jfVar = this.b;
        if (jfVar != null) {
            jfVar.a(context, gDTApk, this.a);
        }
    }
}

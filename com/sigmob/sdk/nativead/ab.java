package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ab extends Handler {
    static final int b = 87108;
    long c;
    boolean d;

    public ab() {
        this.c = 100L;
        this.d = true;
    }

    public ab(Looper looper) {
        super(looper);
        this.c = 100L;
        this.d = true;
    }

    public void a() {
        sendEmptyMessageDelayed(b, this.c);
    }

    public void a(boolean stopped) {
        this.d = stopped;
    }

    public boolean b() {
        return this.d;
    }
}

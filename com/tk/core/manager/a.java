package com.tk.core.manager;

import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private final HandlerThread aif;

    /* synthetic */ a(byte b) {
        this();
    }

    public static a rV() {
        return C0826a.aig;
    }

    public final HandlerThread rW() {
        return this.aif;
    }

    private a() {
        this.aif = new HandlerThread("tachikoma");
        this.aif.start();
    }

    /* renamed from: com.tk.core.manager.a$a, reason: collision with other inner class name */
    static class C0826a {
        private static final a aig = new a(0);
    }
}

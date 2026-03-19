package com.bytedance.sdk.component.tt.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private d d;
    private hc hc;

    public enum d {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface hc {
        void d(String str, String str2);
    }

    private b() {
        this.d = d.OFF;
        this.hc = new com.bytedance.sdk.component.tt.c.hc();
    }

    /* renamed from: com.bytedance.sdk.component.tt.c.b$b, reason: collision with other inner class name */
    private static class C0285b {
        private static final b d = new b();
    }

    public static void d(d dVar) {
        synchronized (b.class) {
            C0285b.d.d = dVar;
        }
    }

    public static void d(String str, String str2) {
        if (C0285b.d.d.compareTo(d.ERROR) <= 0) {
            C0285b.d.hc.d(str, str2);
        }
    }

    public static void hc(String str, String str2) {
        if (C0285b.d.d.compareTo(d.DEBUG) <= 0) {
            b unused = C0285b.d;
        }
    }
}

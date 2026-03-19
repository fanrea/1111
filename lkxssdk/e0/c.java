package lkxssdk.e0;

import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {
    public static c a;
    public d b;
    public f c;
    public Handler d;
    public lkxssdk.g0.a e = new lkxssdk.g0.c();

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }
}

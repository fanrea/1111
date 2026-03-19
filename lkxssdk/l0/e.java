package lkxssdk.l0;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e {
    public static e a;
    public Context b;
    public String c;

    public e() {
        Context applicationContext = lkxssdk.a.a.d().getApplicationContext();
        this.b = applicationContext;
        this.c = applicationContext.getPackageName();
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    public int a(String str) {
        return this.b.getResources().getIdentifier(str, "layout", this.c);
    }
}

package com.component.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bj {
    private final Map<String, String> a;
    private final LottieAnimationView b;
    private final af c;
    private boolean d;

    bj() {
        this.a = new HashMap();
        this.d = true;
        this.b = null;
        this.c = null;
    }

    public bj(LottieAnimationView lottieAnimationView) {
        this.a = new HashMap();
        this.d = true;
        this.b = lottieAnimationView;
        this.c = null;
    }

    public bj(af afVar) {
        this.a = new HashMap();
        this.d = true;
        this.c = afVar;
        this.b = null;
    }

    public String a(String str, String str2) {
        return a(str2);
    }

    public String a(String str) {
        return str;
    }

    public void b(String str, String str2) {
        this.a.put(str, str2);
        b();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(String str) {
        this.a.remove(str);
        b();
    }

    public void a() {
        this.a.clear();
        b();
    }

    public final String c(String str, String str2) {
        if (this.d && this.a.containsKey(str2)) {
            return this.a.get(str2);
        }
        String strA = a(str, str2);
        if (this.d) {
            this.a.put(str2, strA);
        }
        return strA;
    }

    private void b() {
        if (this.b != null) {
            this.b.invalidate();
        }
        if (this.c != null) {
            this.c.invalidateSelf();
        }
    }
}

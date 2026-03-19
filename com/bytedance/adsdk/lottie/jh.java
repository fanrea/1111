package com.bytedance.adsdk.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class jh {
    private final gb b;
    private boolean c;
    private final Map<String, String> d;
    private final LottieAnimationView hc;

    public String d(String str) {
        return str;
    }

    jh() {
        this.d = new HashMap();
        this.c = true;
        this.hc = null;
        this.b = null;
    }

    public jh(LottieAnimationView lottieAnimationView) {
        this.d = new HashMap();
        this.c = true;
        this.hc = lottieAnimationView;
        this.b = null;
    }

    public String d(String str, String str2) {
        return d(str2);
    }

    public void hc(String str, String str2) {
        this.d.put(str, str2);
        d();
    }

    public final String b(String str, String str2) {
        if (this.c && this.d.containsKey(str2)) {
            return this.d.get(str2);
        }
        String strD = d(str, str2);
        if (this.c) {
            this.d.put(str2, strD);
        }
        return strD;
    }

    private void d() {
        LottieAnimationView lottieAnimationView = this.hc;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        gb gbVar = this.b;
        if (gbVar != null) {
            gbVar.invalidateSelf();
        }
    }
}

package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xw {
    private static final String a = "xw";
    private static final Map<String, Pair<jm, Boolean>> b = new HashMap();
    private static final boolean c;
    private static final boolean d;

    /* compiled from: A */
    class a implements sh {
        final /* synthetic */ pw a;
        final /* synthetic */ jm b;

        @Override // com.qq.e.comm.plugin.sh
        public void a(int i) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(int i, String str, String str2) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(String str, Bitmap bitmap) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
            return false;
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(ValueCallback<Uri> valueCallback, Intent intent) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(String str) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void d(String str) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c(String str) {
            String unused = xw.a;
            xw.b.put(this.a.S0(), new Pair(this.b, Boolean.TRUE));
        }

        a(pw pwVar, jm jmVar) {
            this.a = pwVar;
            this.b = jmVar;
        }
    }

    static {
        c = r1.d().f().a("dwajwl", 0) == 1;
        d = r1.d().f().a("rpdtpsblr", 0) == 1;
    }

    static void b(String str) {
        Object obj;
        Pair<jm, Boolean> pairRemove = b.remove(str);
        if (pairRemove == null || (obj = pairRemove.first) == null) {
            return;
        }
        ((jm) obj).d();
    }

    static void a(Context context, pw pwVar) {
        if (context == null || pwVar == null || !d1.a(pwVar.g0())) {
            return;
        }
        jm jmVarA = new qh(context, pwVar).a();
        if (jmVarA.b() != null) {
            jmVarA.b().a("videoService", new ww());
        }
        b.put(pwVar.S0(), new Pair<>(jmVarA, Boolean.FALSE));
        jmVarA.a(new a(pwVar, jmVarA));
        if (d) {
            jmVarA.c(c);
            jmVarA.a(6);
        } else {
            jmVarA.a(5);
        }
        jmVarA.loadUrl(pwVar.i0());
    }

    static Pair<jm, Boolean> a(String str) {
        return b.get(str);
    }
}

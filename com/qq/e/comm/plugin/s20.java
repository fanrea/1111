package com.qq.e.comm.plugin;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s20 {
    private static volatile s20 n = null;
    private static String o = "bGlidHF1aWNfam5pLnNv";
    private static String p = "bGlicXVpYy56aXA";
    private volatile boolean a = false;
    private volatile boolean b = false;
    private final AtomicInteger c = new AtomicInteger(0);
    private int d = -1;
    private final AtomicInteger e = new AtomicInteger(0);
    private final AtomicInteger f = new AtomicInteger(0);
    private int g = -1;
    private final HashSet<String> h = new HashSet<>();
    private final HashSet<String> i = new HashSet<>();
    private final g j = new g(64);
    private int k = 0;
    private int l = 999;
    private volatile boolean m = false;

    /* compiled from: A */
    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.AD_REQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.EXPOSURE_CGI_REQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.CLICK_CGI_REQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        pro.getVresult(642, 0, this);
    }

    public void a(boolean z) {
        pro.getVresult(643, 0, this, Boolean.valueOf(z));
    }

    private s20() {
        try {
            byte[] bArrDecode = Base64.decode(o, 10);
            Charset charset = d6.a;
            o = new String(bArrDecode, charset);
            p = new String(Base64.decode(p, 10), charset);
        } catch (Exception unused) {
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        @Override // java.lang.Runnable
        public void run() {
            s20.a().a(this.a);
        }

        a(boolean z) {
            this.a = z;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!s20.this.b(this.a)) {
                s20.this.c(this.a);
            } else {
                s20.this.d();
                xo.a((Runnable) new a());
            }
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s20.this.a = false;
            }
        }
    }

    public int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.j.a(str);
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s20.this.b = true;
        }
    }

    private String f(String str) {
        String strOptString;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (lz.c()) {
                strOptString = jSONObject.optString("64");
            } else {
                strOptString = jSONObject.optString("32");
            }
            return strOptString;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String strF = f(str);
        String strSubstring = strF.substring(strF.lastIndexOf(Config.replace) + 1, strF.lastIndexOf("."));
        File file = new File(gu.n() + File.separator + o);
        if (!file.exists()) {
            return false;
        }
        if (TextUtils.equals(gp.a(file), strSubstring)) {
            return true;
        }
        file.delete();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String strF = f(str);
        File file = new File(gu.n() + File.separator + p);
        if (file.exists()) {
            file.delete();
        }
        fb.a().a(new gb.b().a(gu.n()).a(p).d(false).d(strF).b(false).a(), new d(str));
    }

    /* compiled from: A */
    class d extends ez {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (s60.a(file.getAbsolutePath(), gu.n().getAbsolutePath())) {
                if (s20.this.b(this.a)) {
                    qg.c.submit(new a());
                }
            } else {
                xo.a((Runnable) new b());
            }
            file.delete();
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.s20$d$a$a, reason: collision with other inner class name */
            class RunnableC0722a implements Runnable {
                RunnableC0722a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    s20.this.a = false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                s20.this.d();
                xo.a((Runnable) new RunnableC0722a());
            }
        }

        /* compiled from: A */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s20.this.a = false;
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            xo.a((Runnable) new c());
            t20.b(9130013, 4);
        }

        /* compiled from: A */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s20.this.a = false;
            }
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.l = jSONObject.optInt("v", 0);
            String strOptString = jSONObject.optString("32");
            String strOptString2 = jSONObject.optString("64");
            this.k = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(strOptString) || strOptString.lastIndexOf(Config.replace) == -1 || strOptString.lastIndexOf(".") == -1 || TextUtils.isEmpty(strOptString2) || strOptString2.lastIndexOf(Config.replace) == -1) {
                return false;
            }
            return strOptString2.lastIndexOf(".") != -1;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "https://" + str + "/";
    }

    public void e() {
        if (!jh.c().i() || this.m) {
            return;
        }
        this.m = true;
        qg.b.submit(new e());
    }

    /* compiled from: A */
    public enum h {
        AD_REQ("adRequest", 1),
        EXPOSURE_CGI_REQ("exposureCGIReq", 2),
        CLICK_CGI_REQ("clickCGIReq", 3);

        private String a;
        private int b;

        h(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public int b() {
            return this.b;
        }
    }

    /* compiled from: A */
    static class g extends LinkedHashMap<String, Integer> {
        private int a;

        public synchronized int a(String str) {
            Integer num;
            num = get(str);
            return num == null ? 0 : num.intValue();
        }

        public g(int i) {
            this.a = 32;
            if (i > 0) {
                this.a = i;
            }
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
            return size() > this.a;
        }

        public synchronized void a(String str, int i) {
            put(str, Integer.valueOf(i));
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            new dv().b();
        }

        e() {
        }
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        int i = f.a[hVar.ordinal()];
        if (i == 1) {
            this.c.set(0);
        } else if (i == 2) {
            this.e.set(0);
        } else {
            if (i != 3) {
                return;
            }
            this.f.set(0);
        }
    }

    public int b(h hVar, int i) {
        if (hVar == null) {
            return 0;
        }
        Pair<String, Integer> pairC = c(hVar, i);
        int iA = r1.d().f().a((String) pairC.first, ((Integer) pairC.second).intValue());
        return iA > 10000 ? com.qq.e.comm.plugin.b.c().a(i, String.valueOf(iA), ((Integer) pairC.second).intValue()) : iA;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.String, java.lang.Integer> c(com.qq.e.comm.plugin.s20.h r2, int r3) {
        /*
            r1 = this;
            com.qq.e.comm.plugin.s20$h r0 = com.qq.e.comm.plugin.s20.h.EXPOSURE_CGI_REQ
            if (r2 != r0) goto L56
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.SPLASH
            int r2 = r2.d()
            if (r3 != r2) goto L10
            java.lang.String r2 = "utfe"
            goto La9
        L10:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.NATIVEEXPRESSAD
            int r2 = r2.d()
            if (r3 != r2) goto L1c
            java.lang.String r2 = "eutfe"
            goto La9
        L1c:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_INTERSTITIAL
            int r2 = r2.d()
            if (r3 != r2) goto L28
            java.lang.String r2 = "ihutfe"
            goto La9
        L28:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_INTERSTITIAL_FULLSCREEN
            int r2 = r2.d()
            if (r3 != r2) goto L34
            java.lang.String r2 = "ifutfe"
            goto La9
        L34:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.REWARDVIDEOAD
            int r2 = r2.d()
            if (r3 != r2) goto L40
            java.lang.String r2 = "rvutfe"
            goto La9
        L40:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.NATIVEUNIFIEDAD
            int r2 = r2.d()
            if (r3 != r2) goto L4b
            java.lang.String r2 = "nutfe"
            goto La9
        L4b:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_BANNER
            int r2 = r2.d()
            if (r3 != r2) goto La7
            java.lang.String r2 = "butfe"
            goto La9
        L56:
            com.qq.e.comm.plugin.s20$h r0 = com.qq.e.comm.plugin.s20.h.CLICK_CGI_REQ
            if (r2 != r0) goto La7
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.SPLASH
            int r2 = r2.d()
            if (r3 != r2) goto L65
            java.lang.String r2 = "utfc"
            goto La9
        L65:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.NATIVEEXPRESSAD
            int r2 = r2.d()
            if (r3 != r2) goto L70
            java.lang.String r2 = "eutfc"
            goto La9
        L70:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_INTERSTITIAL
            int r2 = r2.d()
            if (r3 != r2) goto L7b
            java.lang.String r2 = "ihutfc"
            goto La9
        L7b:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_INTERSTITIAL_FULLSCREEN
            int r2 = r2.d()
            if (r3 != r2) goto L86
            java.lang.String r2 = "ifutfc"
            goto La9
        L86:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.REWARDVIDEOAD
            int r2 = r2.d()
            if (r3 != r2) goto L91
            java.lang.String r2 = "rvutfc"
            goto La9
        L91:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.NATIVEUNIFIEDAD
            int r2 = r2.d()
            if (r3 != r2) goto L9c
            java.lang.String r2 = "nutfc"
            goto La9
        L9c:
            com.qq.e.comm.plugin.e2 r2 = com.qq.e.comm.plugin.e2.UNIFIED_BANNER
            int r2 = r2.d()
            if (r3 != r2) goto La7
            java.lang.String r2 = "butfc"
            goto La9
        La7:
            java.lang.String r2 = ""
        La9:
            android.util.Pair r3 = new android.util.Pair
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.<init>(r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.s20.c(com.qq.e.comm.plugin.s20$h, int):android.util.Pair");
    }

    public void a(h hVar, int i) {
        if (hVar == null) {
            return;
        }
        int i2 = f.a[hVar.ordinal()];
        if (i2 == 1) {
            if (this.c.incrementAndGet() >= this.d) {
                t20.a(9130018);
            }
        } else {
            if (i2 != 2) {
                if (i2 == 3 && this.f.incrementAndGet() >= this.g) {
                    t20.a(9130018, i);
                    return;
                }
                return;
            }
            if (this.e.incrementAndGet() >= this.g) {
                t20.a(9130018, i);
            }
        }
    }

    public boolean c() {
        return this.b;
    }

    public boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        int i = f.a[hVar.ordinal()];
        if (i == 1) {
            if (this.d < 0) {
                this.d = r1.d().f().a("tdt", 2);
            }
            return this.c.get() >= this.d;
        }
        if (i == 2) {
            if (this.g < 0) {
                this.g = r1.d().f().a("tdtec", 1);
            }
            return this.e.get() >= this.g;
        }
        if (i != 3) {
            return false;
        }
        if (this.g < 0) {
            this.g = r1.d().f().a("tdtec", 1);
        }
        return this.f.get() >= this.g;
    }

    public int a(e2 e2Var, String str) {
        if (e2Var.l()) {
            return xc.a("sutoc", str, 0);
        }
        if (e2Var.g()) {
            return xc.a("eutoc", str, 0);
        }
        if (e2Var.i()) {
            return xc.a("ihsutoc", str, 0);
        }
        if (e2Var.h()) {
            return xc.a("ifsutoc", str, 0);
        }
        if (e2Var.k()) {
            return xc.a("rvutoc", str, 0);
        }
        if (e2Var.j()) {
            return xc.a("nutoc", str, 0);
        }
        if (e2Var.f()) {
            return xc.a("butoc", str, 0);
        }
        return 0;
    }

    public void b(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        if (e2VarK.l()) {
            xc.d().a(h4Var, "sutoc", 0).a();
        } else if (e2VarK.g()) {
            xc.d().a(h4Var, "eutoc", 0).a();
        } else if (e2VarK.i()) {
            xc.d().a(h4Var, "ihsutoc", 0).a();
        } else if (e2VarK.h()) {
            xc.d().a(h4Var, "ifsutoc", 0).a();
        } else if (e2VarK.k()) {
            xc.d().a(h4Var, "rvutoc", 0).a();
        } else if (e2VarK.j()) {
            xc.d().a(h4Var, "nutoc", 0).a();
        } else if (e2VarK.f()) {
            xc.d().a(h4Var, "butoc", 0).a();
        }
        a(h4Var);
    }

    private boolean b(e2 e2Var, String str) {
        return a(e2Var, str) > 1;
    }

    private boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public String a(h hVar, String str) {
        String strReplace;
        if (hVar == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(r1.d().f().b("sth", "{\"mi\":\"v2mi.gdt.qq.com\",\"c\":\"c3.gdt.qq.com\",\"v\":\"v3.gdt.qq.com\"}"));
            if (hVar == h.AD_REQ) {
                String strE = e(jSONObject.optString("mi", ""));
                if (!str.startsWith("https://mi.gdt.qq.com/") || TextUtils.isEmpty(strE) || str.startsWith(strE)) {
                    return "";
                }
                strReplace = str.replace("https://mi.gdt.qq.com/", strE);
            } else if (hVar == h.CLICK_CGI_REQ) {
                String strE2 = e(jSONObject.optString("c", ""));
                if (!str.startsWith("https://c2.gdt.qq.com/") || TextUtils.isEmpty(strE2) || str.startsWith(strE2)) {
                    return "";
                }
                strReplace = str.replace("https://c2.gdt.qq.com/", strE2);
            } else {
                if (hVar != h.EXPOSURE_CGI_REQ) {
                    return "";
                }
                String strE3 = e(jSONObject.optString("v", ""));
                if (!str.startsWith("https://v2.gdt.qq.com/") || TextUtils.isEmpty(strE3) || str.startsWith(strE3)) {
                    return "";
                }
                strReplace = str.replace("https://v2.gdt.qq.com/", strE3);
            }
            return strReplace;
        } catch (Exception unused) {
            return "";
        }
    }

    private void a(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        int iA = 0;
        if (e2VarK.l()) {
            iA = a("utocc", 0);
        } else if (e2VarK.g()) {
            iA = a("utoccfe", 0);
        } else if (e2VarK.k()) {
            iA = a("utoccfr", 0);
        } else if (e2VarK.i()) {
            iA = a("utoccfihs", 0);
        } else if (e2VarK.h()) {
            iA = a("utoccfifs", 0);
        } else if (e2VarK.f()) {
            iA = a("utoccfb", 0);
        } else if (e2VarK.j()) {
            iA = a("utoccfn", 0);
        }
        if (iA > 0) {
            a(h4Var, iA);
        }
    }

    public boolean a(e2 e2Var) {
        if (this.h.size() == 0) {
            String strB = r1.d().f().b("utat", "");
            if (!TextUtils.isEmpty(strB)) {
                synchronized (s20.class) {
                    this.h.addAll(Arrays.asList(strB.split(",")));
                }
            }
        }
        if (this.h.size() == 0) {
            return false;
        }
        return this.h.contains(String.valueOf(e2Var.c));
    }

    public boolean a(int i) {
        if (this.i.size() == 0) {
            String strB = r1.d().f().b("utatec", "");
            if (!TextUtils.isEmpty(strB)) {
                synchronized (s20.class) {
                    this.i.addAll(Arrays.asList(strB.split(",")));
                }
            }
        }
        if (this.i.size() == 0) {
            return false;
        }
        return this.i.contains(String.valueOf(i));
    }

    private void a(h4 h4Var, int i) {
        if (!TextUtils.isEmpty(h4Var.V0())) {
            this.j.a(h4Var.V0(), i);
        }
        if (!TextUtils.isEmpty(h4Var.c0())) {
            this.j.a(h4Var.c0(), i);
        }
        if (TextUtils.isEmpty(h4Var.d0())) {
            return;
        }
        this.j.a(h4Var.d0(), i);
    }

    public boolean a(h hVar, e2 e2Var, int i, String str) {
        if (hVar == null) {
            return false;
        }
        int i2 = f.a[hVar.ordinal()];
        if (i2 == 1) {
            return b(e2Var, str);
        }
        if (i2 != 2 && i2 != 3) {
            return false;
        }
        if (e2Var != null) {
            i = e2Var.d();
        }
        return b(hVar, i) >= 1;
    }

    public static s20 a() {
        if (n == null) {
            synchronized (s20.class) {
                if (n == null) {
                    n = new s20();
                }
            }
        }
        return n;
    }

    private int a(String str, int i) {
        int iA = r1.d().f().a(str, i);
        return iA > 10000 ? com.qq.e.comm.plugin.b.c().a(String.valueOf(iA), i) : iA;
    }
}

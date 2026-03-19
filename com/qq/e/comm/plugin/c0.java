package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c0 {
    private static volatile c0 i = null;
    private static String j = "bGlidGVuY2VudC1hdmlmLnNv";
    private static String k = "bGliZ2R0YXZpZi56aXA";
    private static String l = "eyJ2IjoyLCJhIjoxLCIzMiI6Imh0dHBzOi8vcXpzLmdkdGltZy5jb20vdW5pb24vcmVzL3VuaW9uX2Nkbi9wYWdlL290aGVyL2xpYnRlbmNlbnQtYXZpZl84Mzg2ZWEwZDJmZjU0ODU5YmE3NTExN2NkN2Y3ZjI2MC56aXAiLCI2NCI6Imh0dHBzOi8vcXpzLmdkdGltZy5jb20vdW5pb24vcmVzL3VuaW9uX2Nkbi9wYWdlL290aGVyL2xpYnRlbmNlbnQtYXZpZl8zYzdhNzI2ZGNhYmI3N2U0Nzg5YjExZjMzZWQwMzUwZC56aXAifQ==";
    private static volatile String[] m;
    private static final String n = r1.d().f().b("webppv", "imageView2/format/webp=");
    private static final String o = r1.d().f().b("apv", "imageView2/format/avif");
    private String a = "";
    private volatile boolean b = false;
    private volatile boolean c = false;
    private int d = 0;
    private final AtomicInteger e = new AtomicInteger(0);
    private int f = -1;
    private volatile int g = -1;
    private volatile int h = -1;

    private boolean i() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        pro.getVresult(543, 0, this);
    }

    public void a(boolean z) {
        pro.getVresult(544, 0, this, Boolean.valueOf(z));
    }

    public String d(String str) {
        if (Build.VERSION.SDK_INT < 31 || !c() || !l() || !g(str) || this.h <= 0) {
            return str;
        }
        String str2 = n;
        if (str.endsWith(str2)) {
            return str.replace(str2, o);
        }
        String str3 = o;
        if (str.endsWith(str3)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.contains("?") ? com.alipay.sdk.m.s.a.n : "?");
        sb.append(str3);
        return sb.toString();
    }

    public int d() {
        int iA = r1.d().f().a("rap", 0);
        return iA > 10000 ? com.qq.e.comm.plugin.b.c().a(String.valueOf(iA), 0) : iA;
    }

    private c0() {
        try {
            byte[] bArrDecode = Base64.decode(j, 10);
            Charset charset = d6.a;
            j = new String(bArrDecode, charset);
            k = new String(Base64.decode(k, 10), charset);
            l = new String(Base64.decode(l, 10), charset);
            if (m == null) {
                String strB = r1.d().f().b("sach", "pgdt.ugdtimg.com");
                if (!TextUtils.isEmpty(strB)) {
                    m = strB.split(",");
                } else {
                    m = new String[0];
                }
            }
        } catch (Exception unused) {
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        @Override // java.lang.Runnable
        public void run() {
            c0.e().a(this.a);
        }

        a(boolean z) {
            this.a = z;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            c0 c0Var = c0.this;
            if (c0Var.b(c0Var.a)) {
                c0.this.k();
                xo.a((Runnable) new a());
            } else {
                c0 c0Var2 = c0.this;
                c0Var2.c(c0Var2.a);
            }
            c0.this.m();
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.b = false;
            }
        }
    }

    public boolean j() {
        return this.c;
    }

    public boolean f(String str) {
        if (f() || !c()) {
            return false;
        }
        if (!j()) {
            a(false);
            d0.a(9130067);
            return false;
        }
        return g(str);
    }

    private boolean l() {
        if (this.g < 0) {
            this.g = r1.d().f().a("nuaas", 0);
        }
        return this.g > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() throws JSONException {
        if (this.h >= 0 || Build.VERSION.SDK_INT < 31 || !l()) {
            return;
        }
        try {
            byte[] bArrDecode = Base64.decode("AAAAIGZ0eXBhdmlmAAAAAGF2aWZtaWYxbWlhZk1BMUIAAADybWV0YQAAAAAAAAAoaGRscgAAAAAAAAAAcGljdAAAAAAAAAAAAAAAAGxpYmF2aWYAAAAADnBpdG0AAAAAAAEAAAAeaWxvYwAAAABEAAABAAEAAAABAAABGgAAAhQAAAAoaWluZgAAAAAAAQAAABppbmZlAgAAAAABAABhdjAxQ29sb3IAAAAAamlwcnAAAABLaXBjbwAAABRpc3BlAAAAAAAAADYAAAAwAAAAEHBpeGkAAAAAAwgICAAAAAxhdjFDgQAMAAAAABNjb2xybmNseAACAAIAAoAAAAAXaXBtYQAAAAAAAAABAAEEAQKDBAAAAhxtZGF0EgAKBhgVdbywCDKHBBbABxxxxgAgYAEA3SuoYUMphnnI38E6dVIb9oOdyi//beMUXIww4GZgZUG5fKvt4N3A/X+qgkSvHCtciXtQThCsi5UPd2vfWyHsJg1/XvhsAkzVhraqmLXmntRZNa2rUUI9LqP6ypIS3rlSNm4ZlOGOg2SvBOdPevl806f/BQ6ugskO8Jxup744i6FkJFb+UmjWhsC/i06LRoLneAOvNiIF7RC7+cXs1X/AK85pyRrCMudPN13f1LIIpeWD9Iqr19DPVMlbf1sMM40palTrTkwjKiZN2iSGFumrxj9rsbv/l1hKrwvkbPiw+8SVP6I5s3EJvnHoyfrl2CcCK5CPsQW/XKOTAc1zBSQAcScUh78mDmQkR+vgPmgb7bK6NEG3+rpXYn59RO9Xuclu9v7I5xXGJXU3JD8gV24OPJFQcP5hyb65br2pF65xkxrktBdk1v4OSBXN0ZOtEpqokgzKgNW4g4p6p7ivOduil+h3rzsSlr1goQtc321DW3BIGHlFkSpBYkgfiYeNg2wJD1IR8nC7/nblk0fmxsQpp6yKSxD36To2a15//PO4TLzpNzvMxZIV9lM5tGUIj81I8mAYm50Dpa6au0n6ETmEs0o0DvAtxO8ZP88ErZJjAkpkp3NBOzK1MFB6AJByh6n/txh3etOsS2JkFmutqL2Sl/twejG396rNJwZJgA==", 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 0) {
                this.h = 1;
            } else {
                this.h = 0;
                d0.a(9130069, 1);
            }
        } catch (Exception e) {
            this.h = 0;
            ja jaVar = new ja();
            jaVar.a("data", Log.getStackTraceString(e));
            d0.a(9130069, 2, jaVar);
        }
    }

    public boolean g() {
        return d() == 2;
    }

    public boolean h() {
        return d() == 3;
    }

    private String e(String str) {
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

    public static c0 e() {
        if (i == null) {
            synchronized (c0.class) {
                if (i == null) {
                    i = new c0();
                }
            }
        }
        return i;
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.c = true;
        }
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
                file.getAbsolutePath();
                if (c0.this.b(this.a)) {
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
            /* renamed from: com.qq.e.comm.plugin.c0$d$a$a, reason: collision with other inner class name */
            class RunnableC0703a implements Runnable {
                RunnableC0703a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c0.this.b = false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.k();
                xo.a((Runnable) new RunnableC0703a());
            }
        }

        /* compiled from: A */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.b = false;
            }
        }

        /* compiled from: A */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.b = false;
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            dbVar.b();
            xo.a((Runnable) new c());
            d0.a(9130063, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String strE = e(str);
        File file = new File(gu.n() + File.separator + k);
        if (file.exists()) {
            file.delete();
        }
        File fileN = gu.n();
        gb gbVarA = new gb.b().a(fileN).a(k).d(false).d(strE).b(false).a();
        fileN.getAbsolutePath();
        fb.a().a(gbVarA, new d(str));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("32");
            String strOptString2 = jSONObject.optString("64");
            this.d = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(strOptString) || strOptString.lastIndexOf(Config.replace) == -1 || strOptString.lastIndexOf(".") == -1 || TextUtils.isEmpty(strOptString2) || strOptString2.lastIndexOf(Config.replace) == -1) {
                return false;
            }
            return strOptString2.lastIndexOf(".") != -1;
        } catch (JSONException e) {
            e.toString();
            return false;
        }
    }

    public boolean f() {
        if (this.f < 0) {
            this.f = r1.d().f().a(com.baidu.mobads.container.landingpage.aq.b, 3);
        }
        return this.e.get() >= this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String strE = e(str);
        String strSubstring = strE.substring(strE.lastIndexOf(Config.replace) + 1, strE.lastIndexOf("."));
        File file = new File(gu.n() + File.separator + j);
        if (!file.exists()) {
            return false;
        }
        if (TextUtils.equals(gp.a(file), strSubstring)) {
            return true;
        }
        file.delete();
        d0.a(9130063, 1);
        return false;
    }

    private boolean g(String str) {
        if (m == null) {
            return false;
        }
        for (String str2 : m) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optInt("v") >= 2;
        } catch (JSONException e) {
            e.toString();
            return false;
        }
    }

    public void a() {
        this.e.set(0);
    }

    public void b() {
        if (this.e.incrementAndGet() >= this.f) {
            d0.a(9130064);
        }
    }

    private boolean c() {
        int iD = d();
        return iD == 1 || iD == 3;
    }
}

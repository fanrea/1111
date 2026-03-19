package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.cb;
import com.qq.e.comm.plugin.e5;
import com.qq.e.comm.plugin.ko;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class pm implements Runnable {
    private static final ConcurrentHashMap<String, Object> p = new ConcurrentHashMap<>();
    private static final cb q = new cb.b().a(false).a(10000).b(10000).a();
    private static final LruCache<String, SoftReference<Bitmap>> r = new LruCache<>(5);
    private static Boolean s = null;
    private static final String t = r1.d().f().b("webppv", "imageView2/format/webp=");
    private static final String u = r1.d().f().b("apv", "imageView2/format/avif");
    private String a;
    private final WeakReference<ImageView> b;
    private final nm c;
    private File d;
    private final boolean e;
    private final boolean f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean m;
    private boolean n;
    private String o;

    private void f() {
        ConcurrentHashMap<String, Object> concurrentHashMap = p;
        Object obj = concurrentHashMap.get(this.o);
        if (obj != null) {
            synchronized (obj) {
                Object obj2 = concurrentHashMap.get(this.o);
                if (obj2 != null) {
                    try {
                        obj2.wait(5000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private pm(ImageView imageView, nm nmVar, boolean z, boolean z2) {
        this.i = false;
        this.b = new WeakReference<>(imageView);
        this.c = nmVar;
        this.e = z;
        this.f = z2;
        if (s == null) {
            s = Boolean.valueOf(r1.d().f().a("eia", Build.VERSION.SDK_INT < 23 ? 0 : 1) == 1);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws JSONException {
        Bitmap bitmapE;
        f();
        if (!this.e && (bitmapE = e()) != null) {
            a(new ko.b().a(bitmapE), true);
            return;
        }
        if (this.d.exists() && b(true)) {
            return;
        }
        if (TextUtils.isEmpty(this.a)) {
            a(32768, new Exception());
            return;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = p;
        concurrentHashMap.putIfAbsent(this.o, new Object());
        Object obj = concurrentHashMap.get(this.o);
        synchronized (obj) {
            try {
                try {
                    b();
                    b(false);
                    concurrentHashMap.remove(this.o);
                } catch (db e) {
                    a(e.a(), e);
                    p.remove(this.o);
                }
                obj.notifyAll();
            } catch (Throwable th) {
                p.remove(this.o);
                obj.notifyAll();
                throw th;
            }
        }
    }

    public pm(File file, ImageView imageView, nm nmVar, boolean z, Bitmap bitmap) {
        this(imageView, nmVar, false, z);
        this.d = file;
        this.o = file.getAbsolutePath();
        a(imageView, bitmap);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Exception b;

        a(int i, Exception exc) {
            this.a = i;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pm.this.c != null) {
                pm.this.c.a(pm.this.a, this.a, this.b);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ ko.b a;

        b(ko.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = (ImageView) pm.this.b.get();
            ko koVarA = this.a.a();
            pm.this.a(imageView, koVarA);
            if (pm.this.c != null) {
                pm.this.c.a(pm.this.a, imageView, koVarA);
            }
        }
    }

    public pm(String str, ImageView imageView, nm nmVar, boolean z, boolean z2, Bitmap bitmap, String str2) {
        this(imageView, nmVar, z, z2);
        this.a = str;
        this.j = str.contains(t);
        File file = new File(gu.b(), gu.d(str));
        this.d = file;
        this.o = file.getAbsolutePath();
        a(imageView, bitmap);
        this.g = str2;
    }

    private void b() throws JSONException, db {
        this.h = a(this.a);
        dq dqVar = new dq(this.h, this.d, 1, q, false, this.g);
        int iD = d();
        b10.a(1402201, null, Integer.valueOf(iD));
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zI = dqVar.i();
        if (zI) {
            if (this.m) {
                if (e5.c(this.d)) {
                    this.n = true;
                } else {
                    this.n = false;
                    ja jaVar = new ja();
                    jaVar.a("rs", this.h);
                    b10.a(9130068, null, Integer.valueOf(iD), null, jaVar);
                }
            }
            if (iD > 100) {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis2 > 1000) {
                    jCurrentTimeMillis2 = 1000;
                }
                b10.a(9130065, null, Integer.valueOf(iD), Integer.valueOf((int) (jCurrentTimeMillis2 / 10)), null);
            }
        }
        if (!zI) {
            throw new db(dqVar.b(), dqVar.a());
        }
    }

    private int d() {
        int i;
        if (TextUtils.isEmpty(this.h) || !this.h.endsWith(u)) {
            i = this.j ? 1 : 2;
        } else {
            i = 3;
        }
        int iD = c0.e().d();
        if (iD > 1) {
            iD *= 100;
        }
        return iD + (i * 10) + (this.e ? 1 : 0);
    }

    private Bitmap e() {
        String strC = c();
        LruCache<String, SoftReference<Bitmap>> lruCache = r;
        SoftReference<Bitmap> softReference = lruCache.get(strC);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        lruCache.remove(strC);
        return null;
    }

    private String a(String str) {
        if (!this.i && c0.e().f(str)) {
            String str2 = t;
            if (str.endsWith(str2)) {
                str = str.replace(str2, u);
                this.j = false;
            } else {
                String str3 = u;
                if (!str.endsWith(str3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str.contains("?") ? com.alipay.sdk.m.s.a.n : "?");
                    sb.append(str3);
                    str = sb.toString();
                }
            }
        }
        if (str.endsWith(u)) {
            this.m = true;
        }
        return str;
    }

    private String c() {
        e5.a aVarA = e5.a(this.b.get(), 0, 0);
        return this.o + Config.replace + aVarA.b() + Config.replace + aVarA.a();
    }

    private boolean b(boolean z) throws Throwable {
        if (this.e) {
            a(new ko.b(), z);
            return true;
        }
        try {
            ko.b bVarA = a();
            if (bVarA != null) {
                a(bVarA, z);
                return true;
            }
            if (z) {
                this.d.delete();
                return false;
            }
            a(102, new Exception("DecodeFailed"));
            return true;
        } catch (Exception unused) {
            a(102, new Exception("DecodeFailed"));
            return true;
        } catch (OutOfMemoryError e) {
            a(101, new Exception(e));
            return true;
        }
    }

    private ko.b a() throws Throwable {
        t tVarA;
        Movie movieB = e5.b(this.d);
        if (movieB != null) {
            return new ko.b().a(movieB);
        }
        if (s.booleanValue() && (tVarA = e5.a(this.d, this.a)) != null) {
            return new ko.b().a(tVarA);
        }
        Bitmap bitmapA = e5.a(this.d, this.b.get(), this.m && this.n);
        if (bitmapA == null) {
            return null;
        }
        r.put(c(), new SoftReference<>(bitmapA));
        return new ko.b().a(bitmapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ImageView imageView, ko koVar) {
        int iF;
        Object tag;
        if (imageView == 0 || (iF = koVar.f()) == 0) {
            return;
        }
        if (iF == 3) {
            imageView.setImageDrawable(koVar.c());
            return;
        }
        if (iF == 2 && (imageView instanceof nk)) {
            ((nk) imageView).a(koVar.e());
        } else if (iF == 1 && (tag = imageView.getTag(2131755010)) != null && tag.equals(this.o)) {
            imageView.setImageBitmap(koVar.b());
        }
    }

    private void a(ko.b bVar, boolean z) {
        bVar.a(this.d);
        bVar.b(z);
        bVar.c(this.j);
        bVar.a(this.m);
        if (this.f && this.c != null) {
            ko koVarA = bVar.a();
            this.c.a(this.a, this.b.get(), koVarA);
            return;
        }
        xo.a((Runnable) new b(bVar));
    }

    private void a(int i, Exception exc) throws JSONException {
        nm nmVar;
        ja jaVar = new ja();
        jaVar.a("rs", this.a);
        b10.a(1402202, null, Integer.valueOf(d()), Integer.valueOf(i), jaVar);
        if (this.f && (nmVar = this.c) != null) {
            nmVar.a(this.a, i, exc);
        } else {
            xo.a((Runnable) new a(i, exc));
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView == null) {
            return;
        }
        Object tag = imageView.getTag(2131755010);
        if (tag == null || !tag.equals(this.o)) {
            imageView.setImageBitmap(bitmap);
            imageView.setTag(2131755010, this.o);
        }
    }
}

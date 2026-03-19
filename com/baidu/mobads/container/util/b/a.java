package com.baidu.mobads.container.util.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.b.a.b;
import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.util.b.a.l;
import com.baidu.mobads.container.util.b.a.n;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.d.d;
import com.component.lottie.bc;
import com.component.lottie.t;
import com.component.lottie.u;
import com.component.player.s;
import com.component.player.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final int a = 8;
    public static final int b = 6;
    public static final int d = 73400320;
    public static final int e = 73400320;
    public static final int f = 5242880;
    public static final int g = -1;
    private static final String h = "CacheEngine";
    private static volatile a i;
    private LruCache<String, f<?>> m;
    private LruCache<String, t> n;
    private g o;
    private g p;
    private g q;
    private final Map<String, g> r = new ConcurrentHashMap();
    private s s;
    private final String t;
    public static final int c = 31457280;
    private static int j = c;
    private static int k = 73400320;
    private static int l = 73400320;

    public interface c<T> {
        T b(File file);

        <D> T b(D d);
    }

    public static a a(Context context) {
        if (i == null) {
            synchronized (a.class) {
                if (i == null && context != null) {
                    i = new a(context.getApplicationContext());
                }
            }
        }
        return i;
    }

    public static void a(int i2) {
        if (i2 < 30000000 || i2 > 150000000) {
            i2 = 73400320;
        }
        a(k, i2);
    }

    public static void a(int i2, int i3) {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    k = i2;
                    l = i3;
                }
            }
            return;
        }
        if (i2 != k) {
            i.o.trimToSize(i2);
        }
        if (i3 != l) {
            if (i.p != null) {
                i.p.trimToSize(i3);
            }
            if (i.s != null) {
                i.s.a(i3);
            }
        }
    }

    private a(Context context) {
        this.t = bw.j(context);
    }

    public void b(Context context) {
        this.m = new LruCache<>(8);
        this.n = new LruCache<>(6);
        String str = this.t + com.baidu.mobads.container.util.d.d.a;
        String str2 = this.t + com.baidu.mobads.container.util.d.d.b;
        String str3 = this.t + com.baidu.mobads.container.util.d.d.c;
        this.q = g.a(str, j);
        this.o = g.a(str2, k);
        if (w.a().b()) {
            w.a().a(context, str3, l);
            this.p = null;
            this.s = w.a().c();
        } else {
            this.s = null;
            this.p = g.a(str3, l);
            w.a().a(str3);
        }
    }

    public f<?> a(com.baidu.mobads.container.util.b.a.b bVar, boolean z) {
        bVar.k = true;
        bVar.l = z;
        return a(bVar, (k.a) null);
    }

    public f<?> a(com.baidu.mobads.container.util.b.a.b bVar, k.a aVar) {
        try {
            return new com.baidu.mobads.container.util.b.a.a(a(bVar), 0, bVar).a(bVar, new com.baidu.mobads.container.util.b.b(this, aVar));
        } catch (IOException e2) {
            com.baidu.mobads.container.l.g.e(h, e2);
            if (aVar != null) {
                aVar.a(bVar.d, bVar.a, com.baidu.mobads.container.util.d.c.i);
                return null;
            }
            return null;
        }
    }

    public boolean a(String str, d.e eVar) {
        return a(new b.a(str).a(eVar).a(), false) != null;
    }

    public boolean a(String str, String str2) {
        return a(new b.a(str).a(d.e.CUSTOM).a(str2).a(-1L).a(), false) != null;
    }

    public File b(String str, d.e eVar) {
        f<?> fVarA = a(new b.a(str).a(eVar).a(), true);
        if (fVarA != null && (fVarA.b() instanceof File)) {
            File file = (File) fVarA.b();
            if (file.exists()) {
                return file;
            }
            return null;
        }
        return null;
    }

    public void c(String str, d.e eVar) {
        try {
            com.baidu.mobads.container.util.b.a.b bVarA = new b.a(str).a(eVar).a();
            this.m.remove(bVarA.d);
            g gVarA = a(eVar);
            if (gVarA != null) {
                boolean zExists = gVarA.a(bVarA.d) != null;
                if (!zExists && !gVarA.a) {
                    zExists = new File(gVarA.a() + bVarA.d).exists();
                }
                if (zExists) {
                    gVarA.c(bVarA.d);
                    return;
                }
                return;
            }
            if (eVar == d.e.VIDEO && this.s != null) {
                this.s.f(bVarA.d);
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(h, th);
        }
    }

    private List<com.baidu.mobads.container.util.b.a.k> a(com.baidu.mobads.container.util.b.a.b bVar) {
        ArrayList arrayList = new ArrayList();
        if (!bVar.l) {
            arrayList.add(new l(this.m));
        }
        arrayList.add(b(bVar));
        if (bVar.k) {
            arrayList.add(new n());
        } else {
            arrayList.add(new com.baidu.mobads.container.util.b.a.i());
        }
        return arrayList;
    }

    private com.baidu.mobads.container.util.b.a.k b(com.baidu.mobads.container.util.b.a.b bVar) {
        com.baidu.mobads.container.util.b.a.g gVarA = com.baidu.mobads.container.util.b.a.g.a();
        d.e eVar = bVar.b;
        if (d.e.VIDEO.equals(eVar)) {
            if (this.p != null) {
                return new com.baidu.mobads.container.util.b.a.d(this.p);
            }
            if (this.s != null) {
                return new com.baidu.mobads.container.util.b.a.h(this.s);
            }
            return gVarA;
        }
        if (d.e.COMMON.equals(eVar)) {
            return new com.baidu.mobads.container.util.b.a.d(this.q);
        }
        if (d.e.CUSTOM.equals(eVar)) {
            if (!TextUtils.isEmpty(bVar.e)) {
                return new com.baidu.mobads.container.util.b.a.d(a(bVar.e, (int) bVar.f));
            }
            return gVarA;
        }
        return new com.baidu.mobads.container.util.b.a.d(this.o);
    }

    public g a(d.e eVar) {
        switch (e.a[eVar.ordinal()]) {
            case 1:
                return this.q;
            case 2:
                return this.p;
            default:
                return this.o;
        }
    }

    public g a(String str, int i2) {
        g gVar = this.r.get(str);
        if (gVar != null) {
            if (gVar.e() != i2 && i2 != -1) {
                gVar.trimToSize(i2);
                return gVar;
            }
            return gVar;
        }
        String str2 = str + File.separator;
        if (i2 == -1) {
            i2 = 5242880;
        }
        g gVarA = g.a(str2, i2);
        this.r.put(str, gVarA);
        return gVarA;
    }

    /* renamed from: com.baidu.mobads.container.util.b.a$a, reason: collision with other inner class name */
    public static class C0134a implements c<Bitmap> {
        @Override // com.baidu.mobads.container.util.b.a.c
        public /* synthetic */ Bitmap b(Object obj) {
            return a((C0134a) obj);
        }

        @Override // com.baidu.mobads.container.util.b.a.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap b(File file) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        options.inPurgeable = true;
                        options.inInputShareable = true;
                        return BitmapFactory.decodeFile(file.getPath(), options);
                    }
                } catch (OutOfMemoryError e) {
                    bq.a().c(a.h, "图片请求失败，OOM");
                    return null;
                } catch (Throwable th) {
                    bq.a().c(a.h, "图片请求失败，解析异常");
                    return null;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <D> Bitmap a(D d) {
            if (d instanceof Bitmap) {
                return (Bitmap) d;
            }
            return null;
        }
    }

    public static class b implements c<File> {
        @Override // com.baidu.mobads.container.util.b.a.c
        public /* synthetic */ File b(Object obj) {
            return a((b) obj);
        }

        @Override // com.baidu.mobads.container.util.b.a.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public File b(File file) {
            return file;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <D> File a(D d) {
            if (d instanceof File) {
                return (File) d;
            }
            return null;
        }
    }

    public String a(String str) {
        return this.t + str;
    }

    public bc<t> b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String strB = b(str);
                t tVar = this.n.get(strB);
                if (tVar != null) {
                    return new bc<>(new com.baidu.mobads.container.util.b.c(this, tVar));
                }
                File fileB = b(str2, d.e.COMMON);
                if (fileB.exists()) {
                    bc<t> bcVarA = u.a(new FileInputStream(fileB), str);
                    bcVarA.a(new d(this, strB));
                    return bcVarA;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            bq.a().d("Error loading lottie composition");
            return null;
        }
    }

    public int d(String str, d.e eVar) {
        f<?> fVarA = a(new b.a(str).a(eVar).a(), true);
        if (fVarA != null) {
            return fVarA.c();
        }
        return 0;
    }

    public void a() {
        this.m.evictAll();
        this.n.evictAll();
    }

    public void b() {
        this.m.evictAll();
        this.n.evictAll();
        this.o.c();
        if (this.o != null) {
            this.p.c();
        }
        if (this.s != null) {
            this.s.a();
        }
        Iterator<g> it = this.r.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public void a(f<?> fVar) {
        if (fVar != null) {
            fVar.d();
        }
    }

    public static String b(String str) {
        try {
            String strA = ap.a(str);
            if (TextUtils.isEmpty(strA)) {
                String strTrim = Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
                if (strTrim.length() > 50) {
                    return strTrim.substring(0, 50);
                }
                return strTrim;
            }
            return strA;
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                String strTrim2 = Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
                if (strTrim2.length() > 50) {
                    return strTrim2.substring(0, 50);
                }
                return strTrim2;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return "fixed";
            }
        }
    }
}

package com.baidu.mobads.container.util.b;

import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.mobads.container.util.bq;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g extends LruCache<String, f<File>> {
    private static final String b = g.class.getSimpleName();
    private static final boolean c = false;
    public volatile boolean a;
    private final List<a> d;
    private final String e;
    private HashMap<f<File>, Object> f;
    private long g;
    private int h;
    private long i;

    public interface a {
        void a(String str, f<File> fVar);

        void a(String str, f<File> fVar, com.baidu.mobads.container.util.d.c cVar);

        void b(String str, f<File> fVar);
    }

    static /* synthetic */ int b(g gVar) {
        int i = gVar.h;
        gVar.h = i + 1;
        return i;
    }

    static /* synthetic */ int c(g gVar) {
        int i = gVar.h;
        gVar.h = i - 1;
        return i;
    }

    public void a(a aVar) {
        this.d.add(aVar);
    }

    public void b(a aVar) {
        if (this.d.contains(aVar)) {
            this.d.remove(aVar);
        }
    }

    public void a(long j) {
        this.i = j;
    }

    public String a() {
        return this.e;
    }

    public g(int i, String str) {
        super(i);
        this.d = new CopyOnWriteArrayList();
        this.a = false;
        this.h = 0;
        this.i = 2592000000L;
        this.e = str;
        this.f = new HashMap<>();
    }

    public static g a(String str, int i) {
        g gVar = new g(i, str);
        gVar.a = false;
        com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) new h(str, gVar), 2);
        return gVar;
    }

    public void a(f<File> fVar, Object obj, boolean z) {
        if (fVar != null) {
            if (this.a) {
                b(fVar, obj, z);
            } else {
                this.f.put(fVar, obj);
            }
        }
    }

    private void b(f<File> fVar, Object obj, boolean z) {
        i iVar = new i(this, fVar, obj);
        if (z) {
            com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) iVar, 2);
        } else {
            iVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.Object r3, java.io.File r4) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.io.InputStream     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            r1 = 1
            if (r0 == 0) goto Lf
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            boolean r3 = com.baidu.mobads.container.util.au.a(r3, r4)     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            if (r3 == 0) goto L29
            goto L2a
        Lf:
            boolean r0 = r3 instanceof android.graphics.Bitmap     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            if (r0 == 0) goto L1c
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            boolean r3 = com.baidu.mobads.container.util.au.a(r3, r4)     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            if (r3 == 0) goto L29
            goto L2a
        L1c:
            boolean r0 = r3 instanceof byte[]     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            if (r0 == 0) goto L29
            byte[] r3 = (byte[]) r3     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            boolean r3 = com.baidu.mobads.container.util.au.a(r3, r4)     // Catch: java.lang.Throwable -> L2b java.net.SocketTimeoutException -> L2e java.io.FileNotFoundException -> L32
            if (r3 == 0) goto L29
            goto L2a
        L29:
            r1 = 0
        L2a:
            goto L35
        L2b:
            r3 = move-exception
            r1 = -1
            goto L35
        L2e:
            r3 = move-exception
            r1 = -3
            goto L35
        L32:
            r3 = move-exception
            r1 = -2
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.b.g.a(java.lang.Object, java.io.File):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.mobads.container.util.d.c a(int i) {
        if (i == -2) {
            return com.baidu.mobads.container.util.d.c.k;
        }
        if (i == -3) {
            return com.baidu.mobads.container.util.d.c.d;
        }
        return com.baidu.mobads.container.util.d.c.i;
    }

    public void a(String str, File file) {
        if (file.exists() && super.put(str, new f(file)) == null) {
            this.h++;
        }
    }

    public f<File> a(String str) {
        f<File> fVar = (f) super.get(str);
        if (fVar != null) {
            try {
                if (!fVar.b().exists()) {
                    super.remove(str);
                    this.h--;
                    return null;
                }
                fVar.b().setLastModified(System.currentTimeMillis());
                e("Fetch resource for " + str + ",\nStatus:" + f());
            } catch (Throwable th) {
                bq.a().a("Failed to update file. " + th);
            }
        }
        return fVar;
    }

    public void b(String str) {
        if (super.get(str) != null) {
            a((f<File>) super.remove(str));
        }
    }

    public void c(String str) {
        f fVar;
        if (super.get(str) != null && (fVar = (f) super.remove(str)) != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String name = ((File) fVar.b()).getName();
                this.h--;
                fVar.d();
                e("File deleted using " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms: " + name);
            } catch (Throwable th) {
                bq.a().a("Failed to delete file. " + th);
            }
        }
    }

    public boolean d(String str) {
        return a(str) != null && a(str).b().exists();
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i) {
        super.trimToSize(i);
    }

    private synchronized void g() {
        this.a = true;
        if (this.f != null) {
            for (f<File> fVar : this.f.keySet()) {
                b(fVar, this.f.get(fVar), true);
            }
            this.f.clear();
            this.f = null;
        }
    }

    public synchronized void b() {
        if (System.currentTimeMillis() - this.g < this.i) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Map mapSnapshot = super.snapshot();
            this.g = System.currentTimeMillis();
            for (String str : mapSnapshot.keySet()) {
                f fVar = (f) mapSnapshot.get(str);
                if (fVar.a(this.i)) {
                    ((File) ((f) super.remove(str)).b()).delete();
                    this.h--;
                } else if (((File) fVar.b()).lastModified() < this.g) {
                    this.g = ((File) fVar.b()).lastModified();
                }
            }
            e("Clear cache using " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms: ");
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private void a(f<File> fVar) {
        com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) new j(this, fVar), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
    }

    public void c() {
        super.evictAll();
    }

    public long d() {
        return super.size();
    }

    public long e() {
        return super.maxSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, f<File> fVar) {
        if (fVar == null) {
            return super.sizeOf(null, null);
        }
        return fVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new k(this));
            File file = (File) priorityQueue.peek();
            if (priorityQueue.size() > 0 && file != null) {
                this.g = file.lastModified();
            } else {
                this.g = System.currentTimeMillis();
            }
            priorityQueue.addAll(Arrays.asList(fileArr));
            while (!priorityQueue.isEmpty()) {
                File file2 = (File) priorityQueue.poll();
                if (file2 != null && !TextUtils.isEmpty(file2.getName())) {
                    a(file2.getName(), file2);
                }
            }
        }
        e("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void entryRemoved(boolean z, String str, f<File> fVar, f<File> fVar2) {
        super.entryRemoved(z, str, fVar, fVar2);
        if (z && fVar != null) {
            a(fVar);
        }
        if (z && !this.d.isEmpty()) {
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().b(str, fVar);
            }
        }
    }

    public String f() {
        int iHitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.h), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(iHitCount != 0 ? (hitCount() * 100) / iHitCount : 0));
    }
}

package com.bytedance.sdk.component.an.b.d;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b<K, V> {
    private int an;
    private int b;
    private int c;
    private final LinkedHashMap<K, SoftReference<V>> d;
    private int gb;
    private int h;
    private int hc;
    private int u;

    protected int hc(K k, V v) {
        return 1;
    }

    protected V hc(K k) {
        return null;
    }

    public b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.d = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V d(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.d.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.h++;
                    return v;
                }
                this.d.remove(k);
            } else {
                v = null;
            }
            this.gb++;
            V vHc = hc(k);
            if (vHc == null) {
                return null;
            }
            synchronized (this) {
                this.u++;
                SoftReference<V> softReferencePut = this.d.put(k, new SoftReference<>(vHc));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.d.put(k, softReferencePut);
                } else {
                    this.hc += b(k, vHc);
                }
            }
            if (v != null) {
                return v;
            }
            d(this.b);
            return vHc;
        }
    }

    public final V d(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V v2 = null;
        synchronized (this) {
            this.c++;
            this.hc += b(k, v);
            SoftReference<V> softReferencePut = this.d.put(k, new SoftReference<>(v));
            if (softReferencePut != null && (v2 = softReferencePut.get()) != null) {
                this.hc -= b(k, v2);
            }
        }
        d(this.b);
        return v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        com.bytedance.sdk.component.utils.mq.c("LruCache", "oom maybe occured, clear cache. size= " + r3.hc + ", maxSize: " + r4);
        r3.hc = 0;
        r3.d.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L7c
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.d     // Catch: java.lang.Throwable -> L7c
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L12
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L12
            goto L52
        L12:
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L7c
            if (r0 > r4) goto L18
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L18:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.d     // Catch: java.lang.Throwable -> L7c
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L7c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L7c
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L7c
            if (r0 != 0) goto L2c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L2c:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L7c
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.d     // Catch: java.lang.Throwable -> L7c
            r2.remove(r1)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L7c
            int r2 = r3.hc     // Catch: java.lang.Throwable -> L7c
            int r0 = r3.b(r1, r0)     // Catch: java.lang.Throwable -> L7c
            int r2 = r2 - r0
            r3.hc = r2     // Catch: java.lang.Throwable -> L7c
        L4a:
            int r0 = r3.an     // Catch: java.lang.Throwable -> L7c
            int r0 = r0 + 1
            r3.an = r0     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            goto L0
        L52:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7c
            int r2 = r3.hc     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = ", maxSize: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = r1.append(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            com.bytedance.sdk.component.utils.mq.c(r0, r4)     // Catch: java.lang.Throwable -> L7c
            r4 = 0
            r3.hc = r4     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.d     // Catch: java.lang.Throwable -> L7c
            r4.clear()     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L7c:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.an.b.d.b.d(int):void");
    }

    private int b(K k, V v) {
        int iHc = hc(k, v);
        if (iHc >= 0) {
            return iHc;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void d() {
        d(-1);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.h;
        i2 = this.gb + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.gb), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}

package com.bytedance.adsdk.lottie;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k<K, V> {
    private int an;
    private int b;
    private int c;
    private final LinkedHashMap<K, V> d;
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

    public k(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.d = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V d(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.d.get(k);
            if (v != null) {
                this.h++;
                return v;
            }
            this.gb++;
            V vHc = hc(k);
            if (vHc == null) {
                return null;
            }
            synchronized (this) {
                this.u++;
                vPut = this.d.put(k, vHc);
                if (vPut != null) {
                    this.d.put(k, vPut);
                } else {
                    this.hc += b(k, vHc);
                }
            }
            if (vPut != null) {
                return vPut;
            }
            d(this.b);
            return vHc;
        }
    }

    public final V d(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c++;
            this.hc += b(k, v);
            vPut = this.d.put(k, v);
            if (vPut != null) {
                this.hc -= b(k, vPut);
            }
        }
        d(this.b);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
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
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L6f
            if (r0 < 0) goto L4e
            java.util.LinkedHashMap<K, V> r0 = r3.d     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L11
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L4e
        L11:
            int r0 = r3.hc     // Catch: java.lang.Throwable -> L6f
            if (r0 <= r4) goto L4c
            java.util.LinkedHashMap<K, V> r0 = r3.d     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L1e
            goto L4c
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r3.d     // Catch: java.lang.Throwable -> L6f
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6f
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6f
            java.util.LinkedHashMap<K, V> r2 = r3.d     // Catch: java.lang.Throwable -> L6f
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6f
            int r2 = r3.hc     // Catch: java.lang.Throwable -> L6f
            int r0 = r3.b(r1, r0)     // Catch: java.lang.Throwable -> L6f
            int r2 = r2 - r0
            r3.hc = r2     // Catch: java.lang.Throwable -> L6f
            int r0 = r3.an     // Catch: java.lang.Throwable -> L6f
            int r0 = r0 + 1
            r3.an = r0     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L0
        L4c:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            return
        L4e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6f
            throw r4     // Catch: java.lang.Throwable -> L6f
        L6f:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.k.d(int):void");
    }

    private int b(K k, V v) {
        int iHc = hc(k, v);
        if (iHc >= 0) {
            return iHc;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.h;
        i2 = this.gb + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.gb), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}

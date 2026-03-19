package com.alliance.ssp.ad.s;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/* compiled from: MemoryCache.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements c {
    public LruCache<String, Bitmap> a;
    public final int b;

    /* compiled from: MemoryCache.java */
    public class a extends LruCache<String, Bitmap> {
        public a(e eVar, int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2.getHeight() * bitmap2.getRowBytes();
        }
    }

    public e() {
        long jMaxMemory = Runtime.getRuntime().maxMemory() / 8;
        if (10485760 > jMaxMemory) {
            this.b = (int) jMaxMemory;
        } else {
            this.b = 10485760;
        }
        a();
    }

    public final void a() {
        this.a = new a(this, this.b);
    }

    @Override // com.alliance.ssp.ad.s.c
    public Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.get(str);
    }

    @Override // com.alliance.ssp.ad.s.c
    public void a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(str, bitmap);
    }
}

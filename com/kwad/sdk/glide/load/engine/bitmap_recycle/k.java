package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.kwad.sdk.utils.ax;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k implements e {
    private static final Bitmap.Config bUN = Bitmap.Config.ARGB_8888;
    private static long bUX = 0;
    private static long bUY = 0;
    private final l bUO;
    private final Set<Bitmap.Config> bUP;
    private final long bUQ;
    private final a bUR;
    private long bUS;
    private int bUT;
    private int bUU;
    private int bUV;
    private int bUW;
    private long maxSize;

    interface a {
    }

    private k(long j, l lVar, Set<Bitmap.Config> set) {
        this.bUQ = j;
        this.maxSize = j;
        this.bUO = lVar;
        this.bUP = set;
        this.bUR = new b();
    }

    public k(long j) {
        this(j, aha(), ahb());
    }

    private long getMaxSize() {
        return this.maxSize;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final synchronized void e(Bitmap bitmap) {
        ax.checkNotNull(bitmap);
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable() && this.bUO.g(bitmap) <= this.maxSize && this.bUP.contains(bitmap.getConfig())) {
            int iG = this.bUO.g(bitmap);
            this.bUO.e(bitmap);
            this.bUV++;
            this.bUS += iG;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "[WEBP] Put bitmap in pool=" + this.bUO.f(bitmap));
            }
            dump();
            agY();
            return;
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.bUO.f(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.bUP.contains(bitmap.getConfig()));
        }
        bitmap.recycle();
    }

    private void agY() {
        bp(this.maxSize);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapH = h(i, i2, config);
        if (bitmapH != null) {
            bitmapH.eraseColor(0);
            return bitmapH;
        }
        try {
            return createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            Log.e("LruBitmapPool", "getDirty createBitmap oom");
            e.printStackTrace();
            clearMemory();
            System.gc();
            return createBitmap(i, i2, config);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final Bitmap g(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapH = h(i, i2, config);
        if (bitmapH != null) {
            return bitmapH;
        }
        try {
            return createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            Log.e("LruBitmapPool", "getDirty createBitmap oom");
            e.printStackTrace();
            clearMemory();
            System.gc();
            return createBitmap(i, i2, config);
        }
    }

    private static Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = bUN;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private static void b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private synchronized Bitmap h(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapB;
        b(config);
        bitmapB = this.bUO.b(i, i2, config != null ? config : bUN);
        if (bitmapB == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.bUO.c(i, i2, config));
            }
            this.bUU++;
        } else {
            this.bUT++;
            this.bUS -= this.bUO.g(bitmapB);
            i(bitmapB);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "[WEBP] bitmap=" + this.bUO.c(i, i2, config));
        }
        dump();
        return bitmapB;
    }

    private static void i(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        j(bitmap);
    }

    private static void j(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        bp(0L);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final void fV(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            bp(getMaxSize() / 2);
        }
    }

    private synchronized void bp(long j) {
        while (this.bUS > j) {
            Bitmap bitmapAgS = this.bUO.agS();
            if (bitmapAgS == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "[WEBP] Size mismatch, resetting");
                }
                this.bUS = 0L;
                return;
            } else {
                this.bUS -= this.bUO.g(bitmapAgS);
                this.bUW++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "[WEBP] Evicting bitmap=" + this.bUO.f(bitmapAgS));
                }
                dump();
                bitmapAgS.recycle();
            }
        }
    }

    private void dump() {
        Log.isLoggable("LruBitmapPool", 2);
    }

    private static l aha() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    private static Set<Bitmap.Config> ahb() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    static final class b implements a {
        b() {
        }
    }
}

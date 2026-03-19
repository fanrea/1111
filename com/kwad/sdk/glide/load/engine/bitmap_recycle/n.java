package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n implements l {
    private static final Bitmap.Config[] bUZ;
    private static final Bitmap.Config[] bVa;
    private static final Bitmap.Config[] bVb;
    private static final Bitmap.Config[] bVc;
    private static final Bitmap.Config[] bVd;
    private final b bVe = new b();
    private final h<a, Bitmap> bUy = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> bUJ = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        bUZ = configArr;
        bVa = configArr;
        bVb = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        bVc = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        bVd = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final void e(Bitmap bitmap) {
        a aVarD = this.bVe.d(com.kwad.sdk.glide.e.j.m(bitmap), bitmap.getConfig());
        this.bUy.a(aVarD, bitmap);
        NavigableMap<Integer, Integer> navigableMapC = c(bitmap.getConfig());
        Integer num = (Integer) navigableMapC.get(Integer.valueOf(aVarD.size));
        navigableMapC.put(Integer.valueOf(aVarD.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        a aVarA = a(com.kwad.sdk.glide.e.j.i(i, i2, config), config);
        Bitmap bitmapB = this.bUy.b((h<a, Bitmap>) aVarA);
        if (bitmapB != null) {
            a(Integer.valueOf(aVarA.size), bitmapB);
            bitmapB.reconfigure(i, i2, config);
        }
        return bitmapB;
    }

    private a a(int i, Bitmap.Config config) {
        a aVarD = this.bVe.d(i, config);
        for (Bitmap.Config config2 : d(config)) {
            Integer numCeilingKey = c(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return aVarD;
                        }
                    } else if (config2.equals(config)) {
                        return aVarD;
                    }
                }
                this.bVe.a(aVarD);
                return this.bVe.d(numCeilingKey.intValue(), config2);
            }
        }
        return aVarD;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final Bitmap agS() {
        Bitmap bitmapRemoveLast = this.bUy.removeLast();
        if (bitmapRemoveLast != null) {
            a(Integer.valueOf(com.kwad.sdk.glide.e.j.m(bitmapRemoveLast)), bitmapRemoveLast);
        }
        return bitmapRemoveLast;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapC = c(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapC.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + f(bitmap) + ", this: " + this);
        }
        if (num2.intValue() == 1) {
            navigableMapC.remove(num);
        } else {
            navigableMapC.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> c(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.bUJ.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.bUJ.put(config, treeMap);
        return treeMap;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final String f(Bitmap bitmap) {
        return b(com.kwad.sdk.glide.e.j.m(bitmap), bitmap.getConfig());
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final String c(int i, int i2, Bitmap.Config config) {
        return b(com.kwad.sdk.glide.e.j.i(i, i2, config), config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public final int g(Bitmap bitmap) {
        return com.kwad.sdk.glide.e.j.m(bitmap);
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.bUy).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.bUJ.entrySet()) {
            sbAppend.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.bUJ.isEmpty()) {
            sbAppend.replace(sbAppend.length() - 2, sbAppend.length(), "");
        }
        return sbAppend.append(")}").toString();
    }

    static class b extends d<a> {
        b() {
        }

        public final a d(int i, Bitmap.Config config) {
            a aVarAgW = agW();
            aVarAgW.c(i, config);
            return aVarAgW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: ahc, reason: merged with bridge method [inline-methods] */
        public a agV() {
            return new a(this);
        }
    }

    static final class a implements m {
        private Bitmap.Config bUA;
        private final b bVg;
        int size;

        public a(b bVar) {
            this.bVg = bVar;
        }

        public final void c(int i, Bitmap.Config config) {
            this.size = i;
            this.bUA = config;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public final void agT() {
            this.bVg.a(this);
        }

        public final String toString() {
            return n.b(this.size, this.bUA);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.size == aVar.size && com.kwad.sdk.glide.e.j.c(this.bUA, aVar.bUA)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = this.size * 31;
            Bitmap.Config config = this.bUA;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] d(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return bVa;
        }
        int i = AnonymousClass1.bVf[config.ordinal()];
        if (i == 1) {
            return bUZ;
        }
        if (i == 2) {
            return bVb;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : bVd;
        }
        return bVc;
    }

    /* renamed from: com.kwad.sdk.glide.load.engine.bitmap_recycle.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bVf;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            bVf = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bVf[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bVf[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bVf[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}

package com.lingku.xuanshang.xutils.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.lingku.xuanshang.xutils.ImageManager;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
import lkxssdk.s0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ImageManagerImpl implements ImageManager {
    public static final Object a = new Object();
    public static volatile ImageManagerImpl b;

    public class a implements Runnable {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;

        public a(ImageManagerImpl imageManagerImpl, ImageView imageView, String str) {
            this.a = imageView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.s0.a.a(this.a, this.b, null, 0, null);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageOptions c;

        public b(ImageManagerImpl imageManagerImpl, ImageView imageView, String str, ImageOptions imageOptions) {
            this.a = imageView;
            this.b = str;
            this.c = imageOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.s0.a.a(this.a, this.b, this.c, 0, null);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Callback.CommonCallback c;

        public c(ImageManagerImpl imageManagerImpl, ImageView imageView, String str, Callback.CommonCallback commonCallback) {
            this.a = imageView;
            this.b = str;
            this.c = commonCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.s0.a.a(this.a, this.b, null, 0, this.c);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImageOptions c;
        public final /* synthetic */ Callback.CommonCallback d;

        public d(ImageManagerImpl imageManagerImpl, ImageView imageView, String str, ImageOptions imageOptions, Callback.CommonCallback commonCallback) {
            this.a = imageView;
            this.b = str;
            this.c = imageOptions;
            this.d = commonCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.s0.a.a(this.a, this.b, this.c, 0, this.d);
        }
    }

    public static void registerInstance() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new ImageManagerImpl();
                }
            }
        }
        x.Ext.setImageManager(b);
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void bind(ImageView imageView, String str) {
        x.task().autoPost(new a(this, imageView, str));
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void bind(ImageView imageView, String str, Callback.CommonCallback<Drawable> commonCallback) {
        x.task().autoPost(new c(this, imageView, str, commonCallback));
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void bind(ImageView imageView, String str, ImageOptions imageOptions) {
        x.task().autoPost(new b(this, imageView, str, imageOptions));
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void bind(ImageView imageView, String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        x.task().autoPost(new d(this, imageView, str, imageOptions, commonCallback));
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void clearCacheFiles() {
        AtomicLong atomicLong = lkxssdk.s0.a.a;
        LruDiskCache.getDiskCache("xUtils_img").clearCacheFiles();
        ImageDecoder.g.clearCacheFiles();
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public void clearMemCache() {
        lkxssdk.s0.a.c.evictAll();
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public Callback.Cancelable loadDrawable(String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        AtomicLong atomicLong = lkxssdk.s0.a.a;
        if (!TextUtils.isEmpty(str)) {
            return lkxssdk.s0.a.a(new a.d(), str, imageOptions, 0, commonCallback);
        }
        lkxssdk.s0.a.a((ImageView) null, imageOptions, "url is null", commonCallback);
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.ImageManager
    public Callback.Cancelable loadFile(String str, ImageOptions imageOptions, Callback.CacheCallback<File> cacheCallback) {
        AtomicLong atomicLong = lkxssdk.s0.a.a;
        if (TextUtils.isEmpty(str)) {
            lkxssdk.s0.a.a((ImageView) null, imageOptions, "url is null", cacheCallback);
            return null;
        }
        return x.http().get(lkxssdk.s0.a.a(null, str, imageOptions), cacheCallback);
    }
}

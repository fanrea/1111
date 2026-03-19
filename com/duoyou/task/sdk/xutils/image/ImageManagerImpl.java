package com.duoyou.task.sdk.xutils.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.duoyou.task.sdk.xutils.ImageManager;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.x;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ImageManagerImpl implements ImageManager {
    private static volatile ImageManagerImpl instance;
    private static final Object lock = new Object();

    private ImageManagerImpl() {
    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ImageManagerImpl();
                }
            }
        }
        x.Ext.setImageManager(instance);
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void bind(final ImageView imageView, final String str) {
        x.task().autoPost(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.doBind(imageView, str, null, 0, null);
            }
        });
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void bind(final ImageView imageView, final String str, final ImageOptions imageOptions) {
        x.task().autoPost(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.doBind(imageView, str, imageOptions, 0, null);
            }
        });
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void bind(final ImageView imageView, final String str, final Callback.CommonCallback<Drawable> commonCallback) {
        x.task().autoPost(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.doBind(imageView, str, null, 0, commonCallback);
            }
        });
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void bind(final ImageView imageView, final String str, final ImageOptions imageOptions, final Callback.CommonCallback<Drawable> commonCallback) {
        x.task().autoPost(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.doBind(imageView, str, imageOptions, 0, commonCallback);
            }
        });
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public Callback.Cancelable loadDrawable(String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        return ImageLoader.doLoadDrawable(str, imageOptions, commonCallback);
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public Callback.Cancelable loadFile(String str, ImageOptions imageOptions, Callback.CacheCallback<File> cacheCallback) {
        return ImageLoader.doLoadFile(str, imageOptions, cacheCallback);
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void clearMemCache() {
        ImageLoader.clearMemCache();
    }

    @Override // com.duoyou.task.sdk.xutils.ImageManager
    public void clearCacheFiles() {
        ImageLoader.clearCacheFiles();
        ImageDecoder.clearCacheFiles();
    }
}

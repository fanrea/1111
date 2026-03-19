package com.duoyou.task.sdk.xutils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.image.ImageOptions;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ImageManager {
    void bind(ImageView imageView, String str);

    void bind(ImageView imageView, String str, Callback.CommonCallback<Drawable> commonCallback);

    void bind(ImageView imageView, String str, ImageOptions imageOptions);

    void bind(ImageView imageView, String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback);

    void clearCacheFiles();

    void clearMemCache();

    Callback.Cancelable loadDrawable(String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback);

    Callback.Cancelable loadFile(String str, ImageOptions imageOptions, Callback.CacheCallback<File> cacheCallback);
}

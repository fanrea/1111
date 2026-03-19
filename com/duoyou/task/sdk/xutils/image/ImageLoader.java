package com.duoyou.task.sdk.xutils.image;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.duoyou.task.sdk.xutils.cache.LruCache;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.task.Priority;
import com.duoyou.task.sdk.xutils.common.task.PriorityExecutor;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.ex.FileLockedException;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.image.ImageOptions;
import com.duoyou.task.sdk.xutils.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ImageLoader implements Callback.PrepareCallback<File, Drawable>, Callback.CacheCallback<Drawable>, Callback.ProgressCallback<Drawable>, Callback.TypedCallback<Drawable>, Callback.Cancelable {
    private static final String DISK_CACHE_DIR_NAME = "xUtils_img";
    private static final HashMap<String, FakeImageView> FAKE_IMG_MAP;
    private static final LruCache<MemCacheKey, Drawable> MEM_CACHE;
    private static final int MEM_CACHE_MIN_SIZE = 4194304;
    private static final Type loadType;
    private Callback.CacheCallback<Drawable> cacheCallback;
    private Callback.CommonCallback<Drawable> callback;
    private Callback.Cancelable httpCancelable;
    private MemCacheKey key;
    private ImageOptions options;
    private Callback.PrepareCallback<File, Drawable> prepareCallback;
    private Callback.ProgressCallback<Drawable> progressCallback;
    private WeakReference<ImageView> viewRef;
    private static final AtomicLong SEQ_SEEK = new AtomicLong(0);
    private static final Executor EXECUTOR = new PriorityExecutor(10, false);
    private int fileLockedExceptionRetryCount = 0;
    private final long seq = SEQ_SEEK.incrementAndGet();
    private volatile boolean stopped = false;
    private volatile boolean cancelled = false;
    private volatile boolean skipOnWaitingCallback = false;
    private volatile boolean skipOnFinishedCallback = false;
    private boolean hasCache = false;

    static {
        LruCache<MemCacheKey, Drawable> lruCache = new LruCache<MemCacheKey, Drawable>(4194304) { // from class: com.duoyou.task.sdk.xutils.image.ImageLoader.1
            private boolean deepClear = false;

            @Override // com.duoyou.task.sdk.xutils.cache.LruCache
            public int sizeOf(MemCacheKey memCacheKey, Drawable drawable) {
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap == null) {
                        return 0;
                    }
                    return bitmap.getByteCount();
                }
                if (drawable instanceof GifDrawable) {
                    return ((GifDrawable) drawable).getByteCount();
                }
                return super.sizeOf((AnonymousClass1) memCacheKey, (MemCacheKey) drawable);
            }

            @Override // com.duoyou.task.sdk.xutils.cache.LruCache
            public void trimToSize(int i) {
                if (i < 0) {
                    this.deepClear = true;
                }
                super.trimToSize(i);
                this.deepClear = false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.duoyou.task.sdk.xutils.cache.LruCache
            public void entryRemoved(boolean z, MemCacheKey memCacheKey, Drawable drawable, Drawable drawable2) {
                super.entryRemoved(z, (boolean) memCacheKey, drawable, drawable2);
                if (z && this.deepClear && (drawable instanceof ReusableDrawable)) {
                    ((ReusableDrawable) drawable).setMemCacheKey(null);
                }
            }
        };
        MEM_CACHE = lruCache;
        int memoryClass = (((ActivityManager) x.app().getSystemService("activity")).getMemoryClass() * 1048576) / 8;
        lruCache.resize(memoryClass >= 4194304 ? memoryClass : 4194304);
        FAKE_IMG_MAP = new HashMap<>();
        loadType = File.class;
    }

    private ImageLoader() {
    }

    public static void clearMemCache() {
        MEM_CACHE.evictAll();
    }

    public static void clearCacheFiles() {
        LruDiskCache.getDiskCache(DISK_CACHE_DIR_NAME).clearCacheFiles();
    }

    public static Callback.Cancelable doLoadDrawable(String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        if (TextUtils.isEmpty(str)) {
            postArgsException(null, imageOptions, "url is null", commonCallback);
            return null;
        }
        return doBind(new FakeImageView(), str, imageOptions, 0, commonCallback);
    }

    public static Callback.Cancelable doLoadFile(String str, ImageOptions imageOptions, Callback.CacheCallback<File> cacheCallback) {
        if (TextUtils.isEmpty(str)) {
            postArgsException(null, imageOptions, "url is null", cacheCallback);
            return null;
        }
        return x.http().get(createRequestParams(null, str, imageOptions), cacheCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.duoyou.task.sdk.xutils.common.Callback.Cancelable doBind(android.widget.ImageView r6, java.lang.String r7, com.duoyou.task.sdk.xutils.image.ImageOptions r8, int r9, com.duoyou.task.sdk.xutils.common.Callback.CommonCallback<android.graphics.drawable.Drawable> r10) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.image.ImageLoader.doBind(android.widget.ImageView, java.lang.String, com.duoyou.task.sdk.xutils.image.ImageOptions, int, com.duoyou.task.sdk.xutils.common.Callback$CommonCallback):com.duoyou.task.sdk.xutils.common.Callback$Cancelable");
    }

    private Callback.Cancelable doLoadRequest(ImageView imageView, String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        this.viewRef = new WeakReference<>(imageView);
        this.options = imageOptions;
        this.key = new MemCacheKey(str, imageOptions);
        this.callback = commonCallback;
        if (commonCallback instanceof Callback.ProgressCallback) {
            this.progressCallback = (Callback.ProgressCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.PrepareCallback) {
            this.prepareCallback = (Callback.PrepareCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.CacheCallback) {
            this.cacheCallback = (Callback.CacheCallback) commonCallback;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || imageOptions.isForceLoadingDrawable()) {
            drawable = imageOptions.getLoadingDrawable(imageView);
            imageView.setScaleType(imageOptions.getPlaceholderScaleType());
        }
        imageView.setImageDrawable(new AsyncDrawable(this, drawable));
        RequestParams requestParamsCreateRequestParams = createRequestParams(imageView.getContext(), str, imageOptions);
        if (imageView instanceof FakeImageView) {
            HashMap<String, FakeImageView> map = FAKE_IMG_MAP;
            synchronized (map) {
                map.put(imageView.hashCode() + str, (FakeImageView) imageView);
            }
        }
        Callback.Cancelable cancelable = x.http().get(requestParamsCreateRequestParams, this);
        this.httpCancelable = cancelable;
        return cancelable;
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
    public void cancel() {
        this.stopped = true;
        this.cancelled = true;
        Callback.Cancelable cancelable = this.httpCancelable;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.Cancelable
    public boolean isCancelled() {
        return this.cancelled || !validView4Callback(false);
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.ProgressCallback
    public void onWaiting() {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (this.skipOnWaitingCallback || (progressCallback = this.progressCallback) == null) {
            return;
        }
        progressCallback.onWaiting();
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.ProgressCallback
    public void onStarted() {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (!validView4Callback(true) || (progressCallback = this.progressCallback) == null) {
            return;
        }
        progressCallback.onStarted();
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.ProgressCallback
    public void onLoading(long j, long j2, boolean z) {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (!validView4Callback(true) || (progressCallback = this.progressCallback) == null) {
            return;
        }
        progressCallback.onLoading(j, j2, z);
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.TypedCallback
    public Type getLoadType() {
        return loadType;
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.PrepareCallback
    public Drawable prepare(File file) throws IOException {
        if (!validView4Callback(true)) {
            return null;
        }
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        try {
            Callback.PrepareCallback<File, Drawable> prepareCallback = this.prepareCallback;
            Drawable drawablePrepare = prepareCallback != null ? prepareCallback.prepare(file) : null;
            if (drawablePrepare == null) {
                drawablePrepare = ImageDecoder.decodeFileWithLock(file, this.options, this);
            }
            if (drawablePrepare != null && (drawablePrepare instanceof ReusableDrawable)) {
                ((ReusableDrawable) drawablePrepare).setMemCacheKey(this.key);
                MEM_CACHE.put(this.key, drawablePrepare);
            }
            return drawablePrepare;
        } catch (IOException e) {
            IOUtil.deleteFileOrDir(file);
            throw e;
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.CacheCallback
    public boolean onCache(Drawable drawable) {
        if (!validView4Callback(true) || drawable == null) {
            return false;
        }
        this.hasCache = true;
        setSuccessDrawable4Callback(drawable);
        Callback.CacheCallback<Drawable> cacheCallback = this.cacheCallback;
        if (cacheCallback != null) {
            return cacheCallback.onCache(drawable);
        }
        Callback.CommonCallback<Drawable> commonCallback = this.callback;
        if (commonCallback != null) {
            commonCallback.onSuccess(drawable);
        }
        return true;
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
    public void onSuccess(Drawable drawable) {
        if (validView4Callback(!this.hasCache) && drawable != null) {
            setSuccessDrawable4Callback(drawable);
            Callback.CommonCallback<Drawable> commonCallback = this.callback;
            if (commonCallback != null) {
                commonCallback.onSuccess(drawable);
            }
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
    public void onError(Throwable th, boolean z) {
        this.stopped = true;
        if (validView4Callback(false)) {
            int i = this.fileLockedExceptionRetryCount + 1;
            this.fileLockedExceptionRetryCount = i;
            if ((th instanceof FileLockedException) && i < 1000) {
                LogUtil.d("ImageFileLocked: " + this.key.url);
                x.task().postDelayed(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageLoader.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView = (ImageView) ImageLoader.this.viewRef.get();
                        if (imageView != null) {
                            ImageLoader.doBind(imageView, ImageLoader.this.key.url, ImageLoader.this.options, ImageLoader.this.fileLockedExceptionRetryCount, ImageLoader.this.callback);
                        } else {
                            ImageLoader.this.onFinished();
                        }
                    }
                }, 10L);
                this.skipOnFinishedCallback = true;
            } else {
                LogUtil.e(this.key.url, th);
                setErrorDrawable4Callback();
                Callback.CommonCallback<Drawable> commonCallback = this.callback;
                if (commonCallback != null) {
                    commonCallback.onError(th, z);
                }
            }
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
    public void onCancelled(Callback.CancelledException cancelledException) {
        Callback.CommonCallback<Drawable> commonCallback;
        this.stopped = true;
        if (validView4Callback(false) && (commonCallback = this.callback) != null) {
            commonCallback.onCancelled(cancelledException);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
    public void onFinished() {
        this.stopped = true;
        if (this.skipOnFinishedCallback) {
            return;
        }
        ImageView imageView = this.viewRef.get();
        if (imageView instanceof FakeImageView) {
            HashMap<String, FakeImageView> map = FAKE_IMG_MAP;
            synchronized (map) {
                map.remove(imageView.hashCode() + this.key.url);
            }
        }
        Callback.CommonCallback<Drawable> commonCallback = this.callback;
        if (commonCallback != null) {
            commonCallback.onFinished();
        }
    }

    private static RequestParams createRequestParams(Context context, String str, ImageOptions imageOptions) {
        ImageOptions.ParamsBuilder paramsBuilder;
        RequestParams requestParams = new RequestParams(str);
        if (context != null) {
            requestParams.setContext(context);
        }
        requestParams.setCacheDirName(DISK_CACHE_DIR_NAME);
        requestParams.setConnectTimeout(8000);
        requestParams.setPriority(Priority.BG_LOW);
        requestParams.setExecutor(EXECUTOR);
        requestParams.setCancelFast(true);
        requestParams.setUseCookie(false);
        return (imageOptions == null || (paramsBuilder = imageOptions.getParamsBuilder()) == null) ? requestParams : paramsBuilder.buildParams(requestParams, imageOptions);
    }

    private boolean validView4Callback(boolean z) {
        ImageView imageView = this.viewRef.get();
        if (imageView == null) {
            return false;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AsyncDrawable) {
            ImageLoader imageLoader = ((AsyncDrawable) drawable).getImageLoader();
            if (imageLoader == null || imageLoader == this) {
                return true;
            }
            if (this.seq > imageLoader.seq) {
                imageLoader.cancel();
                return true;
            }
            cancel();
            return false;
        }
        if (z) {
            cancel();
            return false;
        }
        return true;
    }

    private void setSuccessDrawable4Callback(Drawable drawable) {
        ImageView imageView = this.viewRef.get();
        if (imageView != null) {
            imageView.setScaleType(this.options.getImageScaleType());
            if (drawable instanceof GifDrawable) {
                if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
                imageView.setLayerType(1, null);
            }
            if (this.options.getAnimation() != null) {
                ImageAnimationHelper.animationDisplay(imageView, drawable, this.options.getAnimation());
            } else if (this.options.isFadeIn()) {
                ImageAnimationHelper.fadeInDisplay(imageView, drawable);
            } else {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    private void setErrorDrawable4Callback() {
        ImageView imageView = this.viewRef.get();
        if (imageView != null) {
            Drawable failureDrawable = this.options.getFailureDrawable(imageView);
            imageView.setScaleType(this.options.getPlaceholderScaleType());
            imageView.setImageDrawable(failureDrawable);
        }
    }

    private static void postArgsException(final ImageView imageView, final ImageOptions imageOptions, final String str, final Callback.CommonCallback<?> commonCallback) {
        x.task().autoPost(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageLoader.3
            @Override // java.lang.Runnable
            public void run() {
                Callback.CommonCallback commonCallback2;
                ImageOptions imageOptions2;
                try {
                    Callback.CommonCallback commonCallback3 = commonCallback;
                    if (commonCallback3 instanceof Callback.ProgressCallback) {
                        ((Callback.ProgressCallback) commonCallback3).onWaiting();
                    }
                    ImageView imageView2 = imageView;
                    if (imageView2 != null && (imageOptions2 = imageOptions) != null) {
                        imageView2.setScaleType(imageOptions2.getPlaceholderScaleType());
                        ImageView imageView3 = imageView;
                        imageView3.setImageDrawable(imageOptions.getFailureDrawable(imageView3));
                    }
                    Callback.CommonCallback commonCallback4 = commonCallback;
                    if (commonCallback4 != null) {
                        commonCallback4.onError(new IllegalArgumentException(str), false);
                    }
                    commonCallback2 = commonCallback;
                    if (commonCallback2 == null) {
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        Callback.CommonCallback commonCallback5 = commonCallback;
                        if (commonCallback5 != null) {
                            try {
                                commonCallback5.onError(th, true);
                            } catch (Throwable th2) {
                                LogUtil.e(th2.getMessage(), th2);
                            }
                        }
                        commonCallback2 = commonCallback;
                        if (commonCallback2 == null) {
                            return;
                        }
                    } catch (Throwable th3) {
                        Callback.CommonCallback commonCallback6 = commonCallback;
                        if (commonCallback6 != null) {
                            try {
                                commonCallback6.onFinished();
                            } catch (Throwable th4) {
                                LogUtil.e(th4.getMessage(), th4);
                            }
                        }
                        throw th3;
                    }
                }
                try {
                    commonCallback2.onFinished();
                } catch (Throwable th5) {
                    LogUtil.e(th5.getMessage(), th5);
                }
            }
        });
    }

    public static final class FakeImageView extends ImageView {
        private static final AtomicInteger hashCodeSeed = new AtomicInteger(0);
        private Drawable drawable;
        private final int hashCode;

        @Override // android.view.View
        public void setLayerType(int i, Paint paint) {
        }

        @Override // android.widget.ImageView
        public void setScaleType(ImageView.ScaleType scaleType) {
        }

        @Override // android.view.View
        public void startAnimation(Animation animation) {
        }

        public FakeImageView() {
            super(x.app());
            this.hashCode = hashCodeSeed.incrementAndGet();
        }

        public int hashCode() {
            return this.hashCode;
        }

        @Override // android.widget.ImageView
        public void setImageDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        @Override // android.widget.ImageView
        public Drawable getDrawable() {
            return this.drawable;
        }
    }
}

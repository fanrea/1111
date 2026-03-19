package lkxssdk.s0;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.lingku.xuanshang.xutils.cache.LruCache;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.task.Priority;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.ex.FileLockedException;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.image.AsyncDrawable;
import com.lingku.xuanshang.xutils.image.GifDrawable;
import com.lingku.xuanshang.xutils.image.ImageAnimationHelper;
import com.lingku.xuanshang.xutils.image.ImageDecoder;
import com.lingku.xuanshang.xutils.image.ImageOptions;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a implements Callback.PrepareCallback<File, Drawable>, Callback.CacheCallback<Drawable>, Callback.ProgressCallback<Drawable>, Callback.TypedCallback<Drawable>, Callback.Cancelable {
    public static final AtomicLong a = new AtomicLong(0);
    public static final Executor b = new PriorityExecutor(10, false);
    public static final LruCache<lkxssdk.s0.b, Drawable> c;
    public static final HashMap<String, d> d;
    public static final Type e;
    public lkxssdk.s0.b f;
    public ImageOptions g;
    public WeakReference<ImageView> h;
    public Callback.Cancelable o;
    public Callback.CommonCallback<Drawable> p;
    public Callback.PrepareCallback<File, Drawable> q;
    public Callback.CacheCallback<Drawable> r;
    public Callback.ProgressCallback<Drawable> s;
    public int i = 0;
    public final long j = a.incrementAndGet();
    public volatile boolean k = false;
    public volatile boolean l = false;
    public volatile boolean m = false;
    public volatile boolean n = false;
    public boolean t = false;

    /* renamed from: lkxssdk.s0.a$a, reason: collision with other inner class name */
    public class C0848a extends LruCache<lkxssdk.s0.b, Drawable> {
        public boolean i;

        public C0848a(int i) {
            super(i);
            this.i = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.lingku.xuanshang.xutils.cache.LruCache
        public void entryRemoved(boolean z, lkxssdk.s0.b bVar, Drawable drawable, Drawable drawable2) {
            super.entryRemoved(z, (boolean) bVar, drawable, drawable2);
            if (z && this.i && (drawable instanceof lkxssdk.s0.d)) {
                ((lkxssdk.s0.d) drawable).setMemCacheKey(null);
            }
        }

        @Override // com.lingku.xuanshang.xutils.cache.LruCache
        public int sizeOf(lkxssdk.s0.b bVar, Drawable drawable) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable instanceof GifDrawable ? ((GifDrawable) drawable).getByteCount() : super.sizeOf((C0848a) bVar, (lkxssdk.s0.b) drawable);
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getByteCount();
        }

        @Override // com.lingku.xuanshang.xutils.cache.LruCache
        public void trimToSize(int i) {
            if (i < 0) {
                this.i = true;
            }
            super.trimToSize(i);
            this.i = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = a.this.h.get();
            if (imageView == null) {
                a.this.onFinished();
            } else {
                a aVar = a.this;
                a.a(imageView, aVar.f.a, aVar.g, aVar.i, aVar.p);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Callback.CommonCallback a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ ImageOptions c;
        public final /* synthetic */ String d;

        public c(Callback.CommonCallback commonCallback, ImageView imageView, ImageOptions imageOptions, String str) {
            this.a = commonCallback;
            this.b = imageView;
            this.c = imageOptions;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Callback.CommonCallback commonCallback;
            ImageOptions imageOptions;
            try {
                Callback.CommonCallback commonCallback2 = this.a;
                if (commonCallback2 instanceof Callback.ProgressCallback) {
                    ((Callback.ProgressCallback) commonCallback2).onWaiting();
                }
                ImageView imageView = this.b;
                if (imageView != null && (imageOptions = this.c) != null) {
                    imageView.setScaleType(imageOptions.getPlaceholderScaleType());
                    ImageView imageView2 = this.b;
                    imageView2.setImageDrawable(this.c.getFailureDrawable(imageView2));
                }
                Callback.CommonCallback commonCallback3 = this.a;
                if (commonCallback3 != null) {
                    commonCallback3.onError(new IllegalArgumentException(this.d), false);
                }
                commonCallback = this.a;
                if (commonCallback == null) {
                    return;
                }
            } catch (Throwable th) {
                try {
                    Callback.CommonCallback commonCallback4 = this.a;
                    if (commonCallback4 != null) {
                        try {
                            commonCallback4.onError(th, true);
                        } catch (Throwable th2) {
                            LogUtil.e(th2.getMessage(), th2);
                        }
                    }
                    commonCallback = this.a;
                    if (commonCallback == null) {
                        return;
                    }
                } catch (Throwable th3) {
                    Callback.CommonCallback commonCallback5 = this.a;
                    if (commonCallback5 != null) {
                        try {
                            commonCallback5.onFinished();
                        } catch (Throwable th4) {
                            LogUtil.e(th4.getMessage(), th4);
                        }
                    }
                    throw th3;
                }
            }
            try {
                commonCallback.onFinished();
            } catch (Throwable th5) {
                LogUtil.e(th5.getMessage(), th5);
            }
        }
    }

    public static final class d extends ImageView {
        public static final AtomicInteger a = new AtomicInteger(0);
        public final int b;
        public Drawable c;

        public d() {
            super(x.app());
            this.b = a.incrementAndGet();
        }

        @Override // android.widget.ImageView
        public Drawable getDrawable() {
            return this.c;
        }

        public int hashCode() {
            return this.b;
        }

        @Override // android.widget.ImageView
        public void setImageDrawable(Drawable drawable) {
            this.c = drawable;
        }

        @Override // android.view.View
        public void setLayerType(int i, Paint paint) {
        }

        @Override // android.widget.ImageView
        public void setScaleType(ImageView.ScaleType scaleType) {
        }

        @Override // android.view.View
        public void startAnimation(Animation animation) {
        }
    }

    static {
        C0848a c0848a = new C0848a(4194304);
        c = c0848a;
        int memoryClass = (((ActivityManager) x.app().getSystemService("activity")).getMemoryClass() * 1048576) / 8;
        c0848a.resize(memoryClass >= 4194304 ? memoryClass : 4194304);
        d = new HashMap<>();
        e = File.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.lingku.xuanshang.xutils.common.Callback.Cancelable a(android.widget.ImageView r6, java.lang.String r7, com.lingku.xuanshang.xutils.image.ImageOptions r8, int r9, com.lingku.xuanshang.xutils.common.Callback.CommonCallback<android.graphics.drawable.Drawable> r10) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.s0.a.a(android.widget.ImageView, java.lang.String, com.lingku.xuanshang.xutils.image.ImageOptions, int, com.lingku.xuanshang.xutils.common.Callback$CommonCallback):com.lingku.xuanshang.xutils.common.Callback$Cancelable");
    }

    public static RequestParams a(Context context, String str, ImageOptions imageOptions) {
        ImageOptions.ParamsBuilder paramsBuilder;
        RequestParams requestParams = new RequestParams(str);
        if (context != null) {
            requestParams.setContext(context);
        }
        requestParams.setCacheDirName("xUtils_img");
        requestParams.setConnectTimeout(8000);
        requestParams.setPriority(Priority.BG_LOW);
        requestParams.setExecutor(b);
        requestParams.setCancelFast(true);
        requestParams.setUseCookie(false);
        return (imageOptions == null || (paramsBuilder = imageOptions.getParamsBuilder()) == null) ? requestParams : paramsBuilder.buildParams(requestParams, imageOptions);
    }

    public static void a(ImageView imageView, ImageOptions imageOptions, String str, Callback.CommonCallback<?> commonCallback) {
        x.task().autoPost(new c(commonCallback, imageView, imageOptions, str));
    }

    public final Callback.Cancelable a(ImageView imageView, String str, ImageOptions imageOptions, Callback.CommonCallback<Drawable> commonCallback) {
        this.h = new WeakReference<>(imageView);
        this.g = imageOptions;
        this.f = new lkxssdk.s0.b(str, imageOptions);
        this.p = commonCallback;
        if (commonCallback instanceof Callback.ProgressCallback) {
            this.s = (Callback.ProgressCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.PrepareCallback) {
            this.q = (Callback.PrepareCallback) commonCallback;
        }
        if (commonCallback instanceof Callback.CacheCallback) {
            this.r = (Callback.CacheCallback) commonCallback;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || imageOptions.isForceLoadingDrawable()) {
            drawable = imageOptions.getLoadingDrawable(imageView);
            imageView.setScaleType(imageOptions.getPlaceholderScaleType());
        }
        imageView.setImageDrawable(new AsyncDrawable(this, drawable));
        RequestParams requestParamsA = a(imageView.getContext(), str, imageOptions);
        if (imageView instanceof d) {
            HashMap<String, d> map = d;
            synchronized (map) {
                map.put(imageView.hashCode() + str, (d) imageView);
            }
        }
        Callback.Cancelable cancelable = x.http().get(requestParamsA, this);
        this.o = cancelable;
        return cancelable;
    }

    public final void a(Drawable drawable) {
        ImageView imageView = this.h.get();
        if (imageView != null) {
            imageView.setScaleType(this.g.getImageScaleType());
            if (drawable instanceof GifDrawable) {
                if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
                imageView.setLayerType(1, null);
            }
            if (this.g.getAnimation() != null) {
                ImageAnimationHelper.animationDisplay(imageView, drawable, this.g.getAnimation());
            } else if (this.g.isFadeIn()) {
                ImageAnimationHelper.fadeInDisplay(imageView, drawable);
            } else {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public final boolean a(boolean z) {
        ImageView imageView = this.h.get();
        if (imageView == null) {
            return false;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AsyncDrawable) {
            a imageLoader = ((AsyncDrawable) drawable).getImageLoader();
            if (imageLoader == null || imageLoader == this) {
                return true;
            }
            if (this.j > imageLoader.j) {
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

    @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
    public void cancel() {
        this.k = true;
        this.l = true;
        Callback.Cancelable cancelable = this.o;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.TypedCallback
    public Type getLoadType() {
        return e;
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.Cancelable
    public boolean isCancelled() {
        return this.l || !a(false);
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CacheCallback
    public boolean onCache(Drawable drawable) {
        if (!a(true) || drawable == null) {
            return false;
        }
        this.t = true;
        a(drawable);
        Callback.CacheCallback<Drawable> cacheCallback = this.r;
        if (cacheCallback != null) {
            return cacheCallback.onCache(drawable);
        }
        Callback.CommonCallback<Drawable> commonCallback = this.p;
        if (commonCallback != null) {
            commonCallback.onSuccess(drawable);
        }
        return true;
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onCancelled(Callback.CancelledException cancelledException) {
        Callback.CommonCallback<Drawable> commonCallback;
        this.k = true;
        if (a(false) && (commonCallback = this.p) != null) {
            commonCallback.onCancelled(cancelledException);
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onError(Throwable th, boolean z) {
        this.k = true;
        if (a(false)) {
            int i = this.i + 1;
            this.i = i;
            if ((th instanceof FileLockedException) && i < 1000) {
                LogUtil.d("ImageFileLocked: " + this.f.a);
                x.task().postDelayed(new b(), 10L);
                this.n = true;
                return;
            }
            LogUtil.e(this.f.a, th);
            ImageView imageView = this.h.get();
            if (imageView != null) {
                Drawable failureDrawable = this.g.getFailureDrawable(imageView);
                imageView.setScaleType(this.g.getPlaceholderScaleType());
                imageView.setImageDrawable(failureDrawable);
            }
            Callback.CommonCallback<Drawable> commonCallback = this.p;
            if (commonCallback != null) {
                commonCallback.onError(th, z);
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onFinished() {
        this.k = true;
        if (this.n) {
            return;
        }
        ImageView imageView = this.h.get();
        if (imageView instanceof d) {
            HashMap<String, d> map = d;
            synchronized (map) {
                map.remove(imageView.hashCode() + this.f.a);
            }
        }
        Callback.CommonCallback<Drawable> commonCallback = this.p;
        if (commonCallback != null) {
            commonCallback.onFinished();
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.ProgressCallback
    public void onLoading(long j, long j2, boolean z) {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (!a(true) || (progressCallback = this.s) == null) {
            return;
        }
        progressCallback.onLoading(j, j2, z);
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.ProgressCallback
    public void onStarted() {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (!a(true) || (progressCallback = this.s) == null) {
            return;
        }
        progressCallback.onStarted();
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onSuccess(Drawable drawable) {
        if (a(!this.t) && drawable != null) {
            a(drawable);
            Callback.CommonCallback<Drawable> commonCallback = this.p;
            if (commonCallback != null) {
                commonCallback.onSuccess(drawable);
            }
        }
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.ProgressCallback
    public void onWaiting() {
        Callback.ProgressCallback<Drawable> progressCallback;
        if (this.m || (progressCallback = this.s) == null) {
            return;
        }
        progressCallback.onWaiting();
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.PrepareCallback
    public Drawable prepare(File file) throws IOException {
        if (!a(true)) {
            return null;
        }
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        try {
            Callback.PrepareCallback<File, Drawable> prepareCallback = this.q;
            Drawable drawablePrepare = prepareCallback != null ? prepareCallback.prepare(file) : null;
            if (drawablePrepare == null) {
                drawablePrepare = ImageDecoder.a(file, this.g, this);
            }
            if (drawablePrepare != null && (drawablePrepare instanceof lkxssdk.s0.d)) {
                ((lkxssdk.s0.d) drawablePrepare).setMemCacheKey(this.f);
                c.put(this.f, drawablePrepare);
            }
            return drawablePrepare;
        } catch (IOException e2) {
            IOUtil.deleteFileOrDir(file);
            throw e2;
        }
    }
}

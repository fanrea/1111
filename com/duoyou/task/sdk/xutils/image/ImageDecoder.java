package com.duoyou.task.sdk.xutils.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.cache.DiskCacheFile;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.task.PriorityExecutor;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ImageDecoder {
    private static final int BITMAP_DECODE_MAX_WORKER;
    private static final AtomicInteger bitmapDecodeWorker = new AtomicInteger(0);
    private static final Object bitmapDecodeLock = new Object();
    private static final Object gifDecodeLock = new Object();
    private static final byte[] GIF_HEADER = {71, 73, 70};
    private static final Executor THUMB_CACHE_EXECUTOR = new PriorityExecutor(1, true);
    private static final LruDiskCache THUMB_CACHE = LruDiskCache.getDiskCache("xUtils_img_thumb");

    static {
        BITMAP_DECODE_MAX_WORKER = Runtime.getRuntime().availableProcessors() > 4 ? 2 : 1;
    }

    private ImageDecoder() {
    }

    public static void clearCacheFiles() {
        THUMB_CACHE.clearCacheFiles();
    }

    public static Drawable decodeFileWithLock(final File file, final ImageOptions imageOptions, Callback.Cancelable cancelable) {
        AtomicInteger atomicInteger;
        Movie movieDecodeGif;
        if (file == null || !file.exists() || file.length() < 1) {
            return null;
        }
        if (cancelable != null && cancelable.isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        if (!imageOptions.isIgnoreGif() && isGif(file)) {
            synchronized (gifDecodeLock) {
                movieDecodeGif = decodeGif(file, imageOptions, cancelable);
            }
            if (movieDecodeGif == null) {
                return null;
            }
            GifDrawable gifDrawable = new GifDrawable(movieDecodeGif, (int) file.length());
            gifDrawable.setRate(imageOptions.getGifRate());
            return gifDrawable;
        }
        try {
            synchronized (bitmapDecodeLock) {
                while (true) {
                    atomicInteger = bitmapDecodeWorker;
                    if (atomicInteger.get() < BITMAP_DECODE_MAX_WORKER || (cancelable != null && cancelable.isCancelled())) {
                        break;
                    }
                    try {
                        bitmapDecodeLock.wait();
                    } catch (InterruptedException unused) {
                        throw new Callback.CancelledException("cancelled during decode image");
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (cancelable != null && cancelable.isCancelled()) {
                throw new Callback.CancelledException("cancelled during decode image");
            }
            atomicInteger.incrementAndGet();
            final Bitmap thumbCache = imageOptions.isCompress() ? getThumbCache(file, imageOptions) : null;
            if (thumbCache == null && (thumbCache = decodeBitmap(file, imageOptions, cancelable)) != null && imageOptions.isCompress()) {
                THUMB_CACHE_EXECUTOR.execute(new Runnable() { // from class: com.duoyou.task.sdk.xutils.image.ImageDecoder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageDecoder.saveThumbCache(file, imageOptions, thumbCache);
                    }
                });
            }
            atomicInteger.decrementAndGet();
            Object obj = bitmapDecodeLock;
            synchronized (obj) {
                obj.notifyAll();
            }
            if (thumbCache != null) {
                return new ReusableBitmapDrawable(x.app().getResources(), thumbCache);
            }
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                bitmapDecodeWorker.decrementAndGet();
            }
            Object obj2 = bitmapDecodeLock;
            synchronized (obj2) {
                obj2.notifyAll();
                throw th;
            }
        }
    }

    public static boolean isGif(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zEquals = Arrays.equals(GIF_HEADER, IOUtil.readBytes(fileInputStream, 0L, 3));
            IOUtil.closeQuietly(fileInputStream);
            return zEquals;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                LogUtil.e(th.getMessage(), th);
                IOUtil.closeQuietly(fileInputStream2);
                return false;
            } catch (Throwable th3) {
                IOUtil.closeQuietly(fileInputStream2);
                throw th3;
            }
        }
    }

    public static Bitmap decodeBitmap(File file, ImageOptions imageOptions, Callback.Cancelable cancelable) throws IOException {
        if (file == null || !file.exists() || file.length() < 1) {
            return null;
        }
        if (imageOptions == null) {
            imageOptions = ImageOptions.DEFAULT;
        }
        if (imageOptions.getMaxWidth() <= 0 || imageOptions.getMaxHeight() <= 0) {
            imageOptions.optimizeMaxSize(null);
        }
        if (cancelable != null) {
            try {
                if (cancelable.isCancelled()) {
                    throw new Callback.CancelledException("cancelled during decode image");
                }
            } catch (Callback.CancelledException e) {
                throw e;
            } catch (IOException e2) {
                throw e2;
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
                return null;
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        options.inInputShareable = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int rotateAngle = 0;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = imageOptions.getConfig();
        int i = options.outWidth;
        int i2 = options.outHeight;
        int width = imageOptions.getWidth();
        int height = imageOptions.getHeight();
        if (imageOptions.isAutoRotate()) {
            rotateAngle = getRotateAngle(file.getAbsolutePath());
            if ((rotateAngle / 90) % 2 == 1) {
                i = options.outHeight;
                i2 = options.outWidth;
            }
        }
        if (!imageOptions.isCrop() && width > 0 && height > 0) {
            if ((rotateAngle / 90) % 2 == 1) {
                options.outWidth = height;
                options.outHeight = width;
            } else {
                options.outWidth = width;
                options.outHeight = height;
            }
        }
        options.inSampleSize = calculateSampleSize(i, i2, imageOptions.getMaxWidth(), imageOptions.getMaxHeight());
        if (cancelable != null && cancelable.isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (bitmapDecodeFile == null) {
            throw new IOException("decode image error");
        }
        if (cancelable != null && cancelable.isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        if (rotateAngle != 0) {
            bitmapDecodeFile = rotate(bitmapDecodeFile, rotateAngle, true);
        }
        if (cancelable != null && cancelable.isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        if (imageOptions.isCrop() && width > 0 && height > 0) {
            bitmapDecodeFile = cut2ScaleSize(bitmapDecodeFile, width, height, true);
        }
        if (bitmapDecodeFile == null) {
            throw new IOException("decode image error");
        }
        if (cancelable != null && cancelable.isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        if (imageOptions.isCircular()) {
            bitmapDecodeFile = cut2Circular(bitmapDecodeFile, true);
        } else if (imageOptions.getRadius() > 0) {
            bitmapDecodeFile = cut2RoundCorner(bitmapDecodeFile, imageOptions.getRadius(), imageOptions.isSquare(), true);
        } else if (imageOptions.isSquare()) {
            bitmapDecodeFile = cut2Square(bitmapDecodeFile, true);
        }
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new IOException("decode image error");
    }

    public static Movie decodeGif(File file, ImageOptions imageOptions, Callback.Cancelable cancelable) throws IOException {
        if (file == null || !file.exists() || file.length() < 1) {
            return null;
        }
        if (cancelable != null) {
            try {
                if (cancelable.isCancelled()) {
                    throw new Callback.CancelledException("cancelled during decode image");
                }
            } catch (Callback.CancelledException e) {
                throw e;
            } catch (IOException e2) {
                throw e2;
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
                return null;
            }
        }
        Movie movieDecodeFile = Movie.decodeFile(file.getAbsolutePath());
        if (movieDecodeFile != null) {
            return movieDecodeFile;
        }
        throw new IOException("decode image error");
    }

    public static int calculateSampleSize(int i, int i2, int i3, int i4) {
        int iRound;
        if (i > i3 || i2 > i4) {
            if (i > i2) {
                iRound = Math.round(i2 / i4);
            } else {
                iRound = Math.round(i / i3);
            }
            i = iRound >= 1 ? iRound : 1;
            while ((i * i2) / (i * i) > i3 * i4 * 2) {
                i++;
            }
        }
        return i;
    }

    public static Bitmap cut2Square(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        int iMin = Math.min(width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - iMin) / 2, (height - iMin) / 2, iMin, iMin);
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        if (z && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap cut2Circular(Bitmap bitmap, boolean z) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = iMin / 2;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (iMin - r0) / 2, (iMin - r1) / 2, paint);
        if (z) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap cut2RoundCorner(Bitmap bitmap, int i, boolean z, boolean z2) {
        int iMin;
        int i2;
        if (i <= 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (z) {
            iMin = Math.min(width, height);
            i2 = iMin;
        } else {
            iMin = width;
            i2 = height;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, i2, Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, iMin, i2), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (iMin - width) / 2, (i2 - height) / 2, paint);
        if (z2) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap cut2ScaleSize(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = i;
        float f2 = width;
        float f3 = f / f2;
        float f4 = i2;
        float f5 = height;
        float f6 = f4 / f5;
        if (f3 > f6) {
            float f7 = f4 / f3;
            height = (int) ((f5 + f7) / 2.0f);
            i4 = (int) ((f5 - f7) / 2.0f);
            i3 = 0;
        } else {
            float f8 = f / f6;
            i3 = (int) ((f2 - f8) / 2.0f);
            width = (int) ((f2 + f8) / 2.0f);
            f3 = f6;
            i4 = 0;
        }
        matrix.setScale(f3, f3);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i3, i4, width - i3, height - i4, matrix, true);
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        if (z && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap rotate(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmapCreateBitmap;
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        } else {
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        if (z && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static int getRotateAngle(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i = 270;
            }
            return i;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveThumbCache(File file, ImageOptions imageOptions, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Throwable th;
        DiskCacheFile diskCacheFileCreateDiskCacheFile;
        DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
        diskCacheEntity.setKey(file.getAbsolutePath() + "@" + file.lastModified() + imageOptions.toString());
        FileOutputStream fileOutputStream2 = null;
        try {
            diskCacheFileCreateDiskCacheFile = THUMB_CACHE.createDiskCacheFile(diskCacheEntity);
            if (diskCacheFileCreateDiskCacheFile != null) {
                try {
                    fileOutputStream = new FileOutputStream(diskCacheFileCreateDiskCacheFile);
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    th = th2;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    diskCacheFileCreateDiskCacheFile = diskCacheFileCreateDiskCacheFile.commit();
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        IOUtil.deleteFileOrDir(diskCacheFileCreateDiskCacheFile);
                        LogUtil.w(th.getMessage(), th);
                        return;
                    } finally {
                        IOUtil.closeQuietly(diskCacheFileCreateDiskCacheFile);
                        IOUtil.closeQuietly(fileOutputStream);
                    }
                }
            }
            IOUtil.closeQuietly(diskCacheFileCreateDiskCacheFile);
            IOUtil.closeQuietly(fileOutputStream2);
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            diskCacheFileCreateDiskCacheFile = null;
        }
    }

    private static Bitmap getThumbCache(File file, ImageOptions imageOptions) {
        DiskCacheFile diskCacheFile;
        try {
            diskCacheFile = THUMB_CACHE.getDiskCacheFile(file.getAbsolutePath() + "@" + file.lastModified() + imageOptions.toString());
            if (diskCacheFile != null) {
                try {
                    if (diskCacheFile.exists()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = false;
                        options.inPurgeable = true;
                        options.inInputShareable = true;
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeFile(diskCacheFile.getAbsolutePath(), options);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        LogUtil.w(th.getMessage(), th);
                        return null;
                    } finally {
                        IOUtil.closeQuietly(diskCacheFile);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            diskCacheFile = null;
        }
        return null;
    }
}

package com.lingku.xuanshang.xutils.image;

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
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.cache.DiskCacheFile;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import lkxssdk.s0.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ImageDecoder {
    public static final int a;
    public static final AtomicInteger b = new AtomicInteger(0);
    public static final Object c = new Object();
    public static final Object d = new Object();
    public static final byte[] e = {71, 73, 70};
    public static final Executor f = new PriorityExecutor(1, true);
    public static final LruDiskCache g = LruDiskCache.getDiskCache("xUtils_img_thumb");

    public class a implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ ImageOptions b;
        public final /* synthetic */ Bitmap c;

        public a(File file, ImageOptions imageOptions, Bitmap bitmap) {
            this.a = file;
            this.b = imageOptions;
            this.c = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DiskCacheFile diskCacheFile;
            FileOutputStream fileOutputStream;
            File file = this.a;
            ImageOptions imageOptions = this.b;
            Bitmap bitmap = this.c;
            int i = ImageDecoder.a;
            DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
            diskCacheEntity.setKey(file.getAbsolutePath() + "@" + file.lastModified() + imageOptions.toString());
            FileOutputStream fileOutputStream2 = null;
            try {
                DiskCacheFile diskCacheFileCreateDiskCacheFile = ImageDecoder.g.createDiskCacheFile(diskCacheEntity);
                if (diskCacheFileCreateDiskCacheFile != null) {
                    try {
                        fileOutputStream = new FileOutputStream(diskCacheFileCreateDiskCacheFile);
                    } catch (Throwable th) {
                        diskCacheFile = diskCacheFileCreateDiskCacheFile;
                        th = th;
                    }
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                        fileOutputStream.flush();
                        diskCacheFileCreateDiskCacheFile = diskCacheFileCreateDiskCacheFile.commit();
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable th2) {
                        diskCacheFile = diskCacheFileCreateDiskCacheFile;
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            IOUtil.deleteFileOrDir(diskCacheFile);
                            LogUtil.w(th.getMessage(), th);
                            IOUtil.closeQuietly(diskCacheFile);
                            IOUtil.closeQuietly(fileOutputStream2);
                        } catch (Throwable th3) {
                            IOUtil.closeQuietly(diskCacheFile);
                            IOUtil.closeQuietly(fileOutputStream2);
                            throw th3;
                        }
                    }
                }
                IOUtil.closeQuietly(diskCacheFileCreateDiskCacheFile);
            } catch (Throwable th4) {
                th = th4;
                diskCacheFile = null;
            }
            IOUtil.closeQuietly(fileOutputStream2);
        }
    }

    static {
        a = Runtime.getRuntime().availableProcessors() > 4 ? 2 : 1;
    }

    public static Bitmap a(File file, ImageOptions imageOptions) {
        DiskCacheFile diskCacheFile;
        try {
            diskCacheFile = g.getDiskCacheFile(file.getAbsolutePath() + "@" + file.lastModified() + imageOptions.toString());
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

    public static Drawable a(File file, ImageOptions imageOptions, Callback.Cancelable cancelable) {
        AtomicInteger atomicInteger;
        Movie movieDecodeGif;
        if (!file.exists() || file.length() < 1) {
            return null;
        }
        if (((lkxssdk.s0.a) cancelable).isCancelled()) {
            throw new Callback.CancelledException("cancelled during decode image");
        }
        if (!imageOptions.isIgnoreGif() && isGif(file)) {
            synchronized (d) {
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
            synchronized (c) {
                while (true) {
                    atomicInteger = b;
                    if (atomicInteger.get() < a || ((lkxssdk.s0.a) cancelable).isCancelled()) {
                        break;
                    }
                    try {
                        c.wait();
                    } catch (InterruptedException unused) {
                        throw new Callback.CancelledException("cancelled during decode image");
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (((lkxssdk.s0.a) cancelable).isCancelled()) {
                throw new Callback.CancelledException("cancelled during decode image");
            }
            atomicInteger.incrementAndGet();
            Bitmap bitmapA = imageOptions.isCompress() ? a(file, imageOptions) : null;
            if (bitmapA == null && (bitmapA = decodeBitmap(file, imageOptions, cancelable)) != null && imageOptions.isCompress()) {
                f.execute(new a(file, imageOptions, bitmapA));
            }
            atomicInteger.decrementAndGet();
            Object obj = c;
            synchronized (obj) {
                obj.notifyAll();
            }
            if (bitmapA != null) {
                return new c(x.app().getResources(), bitmapA);
            }
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                b.decrementAndGet();
            }
            Object obj2 = c;
            synchronized (obj2) {
                obj2.notifyAll();
                throw th;
            }
        }
    }

    public static int calculateSampleSize(int i, int i2, int i3, int i4) {
        float f2;
        float f3;
        if (i > i3 || i2 > i4) {
            if (i > i2) {
                f2 = i2;
                f3 = i4;
            } else {
                f2 = i;
                f3 = i3;
            }
            int iRound = Math.round(f2 / f3);
            i = iRound >= 1 ? iRound : 1;
            while ((i * i2) / (i * i) > i3 * i4 * 2) {
                i++;
            }
        }
        return i;
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
        float f2 = iMin / 2;
        canvas.drawCircle(f2, f2, f2, paint);
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
        float f2 = i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, iMin, i2), f2, f2, paint);
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
        float f2 = i;
        float f3 = width;
        float f4 = f2 / f3;
        float f5 = i2;
        float f6 = height;
        float f7 = f5 / f6;
        if (f4 > f7) {
            float f8 = f5 / f4;
            height = (int) ((f6 + f8) / 2.0f);
            i4 = (int) ((f6 - f8) / 2.0f);
            i3 = 0;
        } else {
            float f9 = f2 / f7;
            i3 = (int) ((f3 - f9) / 2.0f);
            width = (int) ((f3 + f9) / 2.0f);
            f4 = f7;
            i4 = 0;
        }
        matrix.setScale(f4, f4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i3, i4, width - i3, height - i4, matrix, true);
        if (bitmapCreateBitmap == null) {
            return bitmap;
        }
        if (z && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
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

    public static Bitmap decodeBitmap(File file, ImageOptions imageOptions, Callback.Cancelable cancelable) throws IOException {
        int i;
        if (file == null || !file.exists() || file.length() < 1) {
            return null;
        }
        if (imageOptions == null) {
            imageOptions = ImageOptions.DEFAULT;
        }
        if (imageOptions.getMaxWidth() <= 0 || imageOptions.getMaxHeight() <= 0) {
            imageOptions.a(null);
        }
        if (cancelable != null) {
            try {
                if (cancelable.isCancelled()) {
                    throw new Callback.CancelledException("cancelled during decode image");
                }
            } catch (Callback.CancelledException e2) {
                throw e2;
            } catch (IOException e3) {
                throw e3;
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
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int width = imageOptions.getWidth();
        int height = imageOptions.getHeight();
        if (imageOptions.isAutoRotate()) {
            rotateAngle = getRotateAngle(file.getAbsolutePath());
            if ((rotateAngle / 90) % 2 == 1) {
                i2 = options.outHeight;
                i3 = options.outWidth;
            }
        }
        if (!imageOptions.isCrop() && width > 0 && height > 0) {
            if ((rotateAngle / 90) % 2 == 1) {
                options.outWidth = height;
                i = width;
            } else {
                options.outWidth = width;
                i = height;
            }
            options.outHeight = i;
        }
        options.inSampleSize = calculateSampleSize(i2, i3, imageOptions.getMaxWidth(), imageOptions.getMaxHeight());
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
            } catch (Callback.CancelledException e2) {
                throw e2;
            } catch (IOException e3) {
                throw e3;
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

    public static int getRotateAngle(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return 0;
        }
    }

    public static boolean isGif(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            return Arrays.equals(e, IOUtil.readBytes(fileInputStream, 0L, 3));
        } catch (Throwable th2) {
            th = th2;
            try {
                LogUtil.e(th.getMessage(), th);
                IOUtil.closeQuietly(fileInputStream);
                return false;
            } finally {
                IOUtil.closeQuietly(fileInputStream);
            }
        }
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
}

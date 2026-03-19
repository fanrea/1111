package com.kwad.components.ct.widget.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final Paint baV = new Paint(6);
    private static final Paint baW = new Paint(7);
    private static final Paint baX;
    private static final Paint baY;
    private static final Set<String> baZ;
    private static final Lock bba;

    static {
        Lock aVar;
        Paint paint = new Paint(7);
        baY = paint;
        paint.setColor(Color.parseColor("#EAEAEA"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
        paint.setDither(true);
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        baZ = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            aVar = new ReentrantLock();
        } else {
            aVar = new a();
        }
        bba = aVar;
        Paint paint2 = new Paint(7);
        baX = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i, int i2) {
        int iMin = Math.min(i, i2);
        float f = iMin;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f / width, f / height);
        float f3 = width * fMax;
        float f4 = fMax * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapB = eVar.b(iMin, iMin, b(bitmap));
        bitmapB.setHasAlpha(true);
        Lock lock = bba;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapB);
            canvas.drawCircle(f2, f2, f2, baW);
            canvas.drawBitmap(bitmapA, (Rect) null, rectF, baX);
            canvas.drawCircle(f2, f2, f2 - 0.0f, baY);
            f(canvas);
            lock.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.e(bitmapA);
            }
            return bitmapB;
        } catch (Throwable th) {
            bba.unlock();
            throw th;
        }
    }

    private static Bitmap a(e eVar, Bitmap bitmap) {
        Bitmap.Config configB = b(bitmap);
        if (configB.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapB = eVar.b(bitmap.getWidth(), bitmap.getHeight(), configB);
        new Canvas(bitmapB).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapB;
    }

    private static Bitmap.Config b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    private static void f(Canvas canvas) {
        canvas.setBitmap(null);
    }

    static final class a implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public final void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public final boolean tryLock(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public final void unlock() {
        }

        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }
}

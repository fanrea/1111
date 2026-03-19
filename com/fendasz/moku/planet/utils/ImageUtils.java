package com.fendasz.moku.planet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ImageUtils {
    private static final String TAG = "ImageUtils";
    private static ImageUtils mImageUtils;

    public void toAlubm(Activity activity, int i, int i2) {
    }

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        if (mImageUtils == null) {
            mImageUtils = new ImageUtils();
        }
        return mImageUtils;
    }

    public void setImageView(final Context context, final String str, final Consumer<Bitmap> consumer, final Float f, final Float f2) {
        Log.d(TAG, "setImageView==>");
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.fendasz.moku.planet.utils.ImageUtils.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("setImageViewThread");
                return thread;
            }
        });
        threadPoolExecutor.execute(new Runnable() { // from class: com.fendasz.moku.planet.utils.ImageUtils.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00c0 A[Catch: all -> 0x01ce, InvocationTargetException -> 0x01d1, IllegalAccessException -> 0x01fb, NoSuchMethodException -> 0x0224, ClassNotFoundException -> 0x024d, TRY_ENTER, TryCatch #6 {IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01d1, blocks: (B:3:0x0008, B:4:0x0014, B:7:0x001a, B:12:0x002c, B:14:0x0059, B:16:0x005d, B:17:0x0068, B:25:0x00a2, B:28:0x00c0, B:30:0x0146, B:32:0x0162, B:35:0x0184, B:37:0x01a5, B:29:0x010a, B:19:0x006c, B:21:0x0070, B:23:0x0088, B:24:0x0094, B:10:0x0028), top: B:68:0x0008, outer: #5 }] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x010a A[Catch: all -> 0x01ce, InvocationTargetException -> 0x01d1, IllegalAccessException -> 0x01fb, NoSuchMethodException -> 0x0224, ClassNotFoundException -> 0x024d, TryCatch #6 {IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01d1, blocks: (B:3:0x0008, B:4:0x0014, B:7:0x001a, B:12:0x002c, B:14:0x0059, B:16:0x005d, B:17:0x0068, B:25:0x00a2, B:28:0x00c0, B:30:0x0146, B:32:0x0162, B:35:0x0184, B:37:0x01a5, B:29:0x010a, B:19:0x006c, B:21:0x0070, B:23:0x0088, B:24:0x0094, B:10:0x0028), top: B:68:0x0008, outer: #5 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 649
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.ImageUtils.AnonymousClass2.run():void");
            }
        });
    }

    public static Bitmap getDecodeBitmapFromFile(Context context, String str, Float f, Float f2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(context, options, f, f2);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile(str, options);
    }

    private static int calculateInSampleSize(Context context, BitmapFactory.Options options, Float f, Float f2) {
        float fFloatValue;
        float fFloatValue2;
        int i;
        float f3;
        float f4 = options.outHeight;
        float f5 = options.outWidth;
        if (f == null || f2 == null) {
            if (f == null && f2 == null) {
                PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
                float heightPixels = phoneScreenUtils.getHeightPixels(context);
                float widthPixels = phoneScreenUtils.getWidthPixels(context);
                if (f4 / f5 >= heightPixels / widthPixels) {
                    f3 = f4 / heightPixels;
                    i = (int) f3;
                } else {
                    i = ((int) (f5 / widthPixels)) * 2;
                }
            } else if (f != null) {
                fFloatValue2 = f.floatValue();
                i = (int) (f5 / fFloatValue2);
            } else {
                fFloatValue = f2.floatValue();
                f3 = f4 / fFloatValue;
                i = (int) f3;
            }
        } else if (f4 / f5 >= f2.floatValue() / f.floatValue()) {
            fFloatValue2 = f.floatValue();
            i = (int) (f5 / fFloatValue2);
        } else {
            fFloatValue = f2.floatValue();
            f3 = f4 / fFloatValue;
            i = (int) f3;
        }
        if (i < 1) {
            return 1;
        }
        return i;
    }

    public static File compressSize(String str, String str2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str2, options);
        options.inJustDecodeBounds = false;
        int i = ((float) options.outWidth) > 1080.0f ? (int) (options.outWidth / 1080.0f) : 1;
        options.inSampleSize = i > 0 ? i : 1;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2, options);
        Bitmap bitmapChangeImageLocate = bitmapDecodeFile != null ? changeImageLocate(str2, bitmapDecodeFile) : null;
        if (bitmapChangeImageLocate != null) {
            return compressImage(str, bitmapChangeImageLocate, str2);
        }
        return null;
    }

    private static Bitmap changeImageLocate(String str, Bitmap bitmap) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            LogUtils.logE("degree========ori====", attributeInt + "");
            int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
            LogUtils.logE("degree============", i + "");
            if (i != 0) {
                LogUtils.logE("degree============", "degree != 0");
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(1:11)(2:7|(1:9)(11:10|(2:14|(3:16|(2:19|17)|42))|20|(1:22)|23|(1:25)(2:26|(1:28)(2:29|(1:31)(1:32)))|33|40|34|38|39))|12|(0)|20|(0)|23|(0)(0)|33|40|34|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010d, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010e, code lost:
    
        r12.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File compressImage(java.lang.String r12, android.graphics.Bitmap r13, java.lang.String r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.ImageUtils.compressImage(java.lang.String, android.graphics.Bitmap, java.lang.String):java.io.File");
    }

    public static void recycleBitmap(Bitmap... bitmapArr) {
        if (bitmapArr == null) {
            return;
        }
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    public static String retrievePath(Context context, Intent intent, Intent intent2) {
        String scheme;
        if (intent2 != null) {
            Uri data = intent2.getData();
            path = data != null ? ContentUtil.getFilePathByUri(context, data) : null;
            if (ContentUtil.isFileExists(path)) {
                return path;
            }
        }
        if (intent != null) {
            Uri uri = (Uri) intent.getParcelableExtra("output");
            if (uri != null && (scheme = uri.getScheme()) != null && scheme.startsWith(n.z)) {
                path = uri.getPath();
            }
            if (!TextUtils.isEmpty(path)) {
                File file = new File(path);
                if (file.exists()) {
                    file.isFile();
                }
            }
        }
        return path;
    }
}

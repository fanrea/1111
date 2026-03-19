package com.bytedance.common.utility;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import com.component.c.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BitmapUtils {
    private static final int COMPRESS_QUALITY = 100;
    private static final int LOAD_QUALITY = 80;
    private static final int MAX_BYTE = 8192;
    private static final int MAX_OUT_HEIGHT = 4000;
    private static final int MAX_RATIO = 4;
    private static final int ROTATE_180 = 180;
    private static final int ROTATE_270 = 270;
    private static final int ROTATE_90 = 90;
    private static final int ROTATE_QUALITY = 50;
    private static final int SD_QUALITY = 100;
    private static final String TAG = "BitmapUtils";
    private static final int WIDTH_RANGE = 150;

    private BitmapUtils() {
    }

    public static Bitmap decodeBitmap(byte[] bArr, int i, int i2) {
        if (bArr != null && i >= 1 && i2 >= 1) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int i5 = 1;
                while (true) {
                    if (i3 / 2 < i && i4 / 2 < i2) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i5;
                        options2.inPurgeable = true;
                        options2.inPreferredConfig = Bitmap.Config.RGB_565;
                        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
                    }
                    i3 /= 2;
                    i4 /= 2;
                    i5 *= 2;
                }
            } catch (Exception e) {
                Logger.d("BitmapUtils", "decode image error: " + e);
            }
        }
        return null;
    }

    public static Bitmap decodeBitmap(File file, int i, int i2, Bitmap.Config config) throws Throwable {
        FileInputStream fileInputStream;
        BitmapFactory.Options options;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        if (file != null && i > 0 && i2 > 0) {
            try {
                if (!file.isFile()) {
                    return null;
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                fileInputStream = new FileInputStream(file);
                try {
                    BitmapFactory.decodeStream(fileInputStream, null, options2);
                    fileInputStream.close();
                    int i3 = options2.outWidth;
                    int i4 = options2.outHeight;
                    int i5 = 1;
                    while (true) {
                        if (i3 / 2 < i && i4 / 2 < i2) {
                            break;
                        }
                        i3 /= 2;
                        i4 /= 2;
                        i5 *= 2;
                    }
                    options = new BitmapFactory.Options();
                    options.inSampleSize = i5;
                    options.inPurgeable = true;
                    if (config != null) {
                        options.inPreferredConfig = config;
                    } else {
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    fileInputStream2 = new FileInputStream(file);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream3 = fileInputStream;
                }
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                    fileInputStream2.close();
                    return bitmapDecodeStream;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileInputStream2;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static Bitmap decodeBitmap(File file, int i) {
        return decodeBitmap(file, i, false);
    }

    public static Bitmap decodeBitmap(File file, int i, boolean z) throws IOException {
        BitmapFactory.Options options;
        Bitmap bitmapDecodeStream = null;
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (options.outWidth > 0 && options.outHeight > 0) {
            int i2 = 1;
            while (options.outWidth >= i * 2 && options.outHeight >= 4000) {
                options.outWidth /= 2;
                options.outHeight /= 2;
                i2 *= 2;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            options2.inPurgeable = true;
            options2.inPreferredConfig = z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            FileInputStream fileInputStream2 = new FileInputStream(file);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options2);
            fileInputStream2.close();
            if (bitmapDecodeStream == null) {
                file.delete();
            }
            return bitmapDecodeStream;
        }
        file.delete();
        return null;
    }

    public static Bitmap decodeBitmap(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                fileInputStream2.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return bitmapDecodeStream;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            try {
                fileInputStream.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    public static boolean saveBitmapToSD(Bitmap bitmap, String str, String str2) throws Throwable {
        if (!c.a.equals(Environment.getExternalStorageState())) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file + "/" + str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean saveImageData(byte[] bArr, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs() && !file.exists()) {
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Logger.d("BitmapUtils", "save image exception " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Deprecated
    public static void rotateImage(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        int i = -1;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = 270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i <= 0) {
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
        bitmapDecodeFile.recycle();
        ?? r1 = 0;
         = 0;
        ?? r12 = 0;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    r12 = 50;
                    r1 = 50;
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                    fileOutputStream.flush();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    r12 = fileOutputStream;
                    e.printStackTrace();
                    r1 = r12;
                    if (r12 != 0) {
                        try {
                            r12.close();
                            r1 = r12;
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            r1 = r12;
                            bitmapCreateBitmap.recycle();
                        }
                    }
                    bitmapCreateBitmap.recycle();
                } catch (IOException e4) {
                    e = e4;
                    r12 = fileOutputStream;
                    e.printStackTrace();
                    r1 = r12;
                    if (r12 != 0) {
                        try {
                            r12.close();
                            r1 = r12;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            r1 = r12;
                            bitmapCreateBitmap.recycle();
                        }
                    }
                    bitmapCreateBitmap.recycle();
                } catch (Throwable th) {
                    th = th;
                    r1 = fileOutputStream;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    bitmapCreateBitmap.recycle();
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            }
            try {
                fileOutputStream.close();
            } catch (IOException e9) {
                e = e9;
                e.printStackTrace();
                r1 = r12;
                bitmapCreateBitmap.recycle();
            }
            bitmapCreateBitmap.recycle();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int readPictureDegree(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3) {
        return getBitmapFromSD(str, i, i2, i3, null);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3, Bitmap.Config config) {
        try {
            File file = new File(str);
            if (!file.isFile()) {
                return null;
            }
            if (i3 > 0 && file.length() > i3) {
                file.delete();
                return null;
            }
            try {
                file.setLastModified(System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return decodeBitmap(file, i, i2, config);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2) {
        return getBitmapFromSD(str, i, i2, -1, null);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, Bitmap.Config config) {
        return getBitmapFromSD(str, i, i2, -1, config);
    }

    public static Bitmap getBitmapFromSD(String str, int i) {
        return getBitmapFromSD(str, i, false);
    }

    public static Bitmap getBitmapFromSD(String str, int i, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            file.setLastModified(System.currentTimeMillis());
        } catch (Exception unused) {
        }
        try {
            return decodeBitmap(file, i, z);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getBitmapFromSD(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return decodeBitmap(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        boolean z;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > i || height > i2) {
            if (width <= height || width <= i) {
                i = (int) (width * (i2 / height));
            } else {
                i2 = (int) (height * (i / width));
            }
            width = i;
            z = true;
        } else {
            z = false;
            i2 = height;
        }
        return z ? Bitmap.createScaledBitmap(bitmap, width, i2, true) : bitmap;
    }

    public static Bitmap loadBitmap(int i, String str) throws IOException {
        return loadBitmap(i, str, false);
    }

    public static Bitmap loadBitmap(int i, String str, boolean z) throws IOException {
        Bitmap bitmapFromSD = getBitmapFromSD(str, i, z);
        if (bitmapFromSD == null) {
            return null;
        }
        int width = bitmapFromSD.getWidth();
        int height = bitmapFromSD.getHeight();
        if (width > i + 150 || (width > i && height > 4000)) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapFromSD, i, (int) (((i * 1.0f) * height) / width), true);
            bitmapFromSD.recycle();
            if (bitmapCreateScaledBitmap == null) {
                return null;
            }
            bitmapFromSD = bitmapCreateScaledBitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapFromSD.compress(z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        bitmapFromSD.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inPreferredConfig = z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap decodeBitmap(ContentResolver contentResolver, Uri uri, int i, int i2) throws IOException {
        InputStream inputStreamOpenInputStream;
        byte[] byteArray = null;
        if (contentResolver == null || uri == null || i < 1 || i2 < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i3 = inputStreamOpenInputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return decodeBitmap(byteArray, i, i2);
    }

    public static Bitmap decodeBitmap(Context context, int i, int i2, int i3) {
        if (context != null && i != 0 && i2 > 0 && i3 > 0) {
            Resources resources = context.getResources();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(resources, i, options);
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                int i6 = 1;
                while (true) {
                    if (i4 / 2 < i2 && i5 / 2 < i3) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i6;
                        options2.inPurgeable = true;
                        options2.inPreferredConfig = Bitmap.Config.RGB_565;
                        return BitmapFactory.decodeResource(resources, i, options2);
                    }
                    i4 /= 2;
                    i5 /= 2;
                    i6 *= 2;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Bitmap compressBitmap(Bitmap bitmap, long j) {
        int iSqrt;
        if (bitmap == null) {
            return null;
        }
        if (j <= 0) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Logger.d("BitmapUtils", "bitmap size is " + (bitmap.getRowBytes() * bitmap.getHeight()));
        double dRound = Math.round(r1 / j);
        if (dRound >= 2.0d && dRound < 4.0d) {
            config = Bitmap.Config.RGB_565;
        } else {
            iSqrt = (int) Math.sqrt(dRound);
            if (iSqrt == 0) {
            }
            if (iSqrt != 1 && config == Bitmap.Config.ARGB_8888) {
                return bitmap;
            }
            Logger.d("BitmapUtils", "compress sample size is " + iSqrt);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = iSqrt;
            options.inPurgeable = true;
            options.inPreferredConfig = config;
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        }
        iSqrt = 1;
        if (iSqrt != 1) {
        }
        Logger.d("BitmapUtils", "compress sample size is " + iSqrt);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = iSqrt;
        options2.inPurgeable = true;
        options2.inPreferredConfig = config;
        return BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length, options2);
    }
}

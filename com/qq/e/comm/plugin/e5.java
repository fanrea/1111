package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e5 {
    public static Bitmap b(File file, ImageView imageView) {
        return a(file, imageView, false);
    }

    public static boolean d(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte b;
        boolean z = false;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            file.getAbsolutePath();
            return false;
        }
        if (file.length() < 6) {
            file.getAbsolutePath();
            file.length();
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[6];
                    if (fileInputStream.read(bArr) < 6) {
                        file.getAbsolutePath();
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        return false;
                    }
                    if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (((b = bArr[4]) == 55 || b == 57) && bArr[5] == 97)) {
                        z = true;
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                    return z;
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.getMessage();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                            e4.getMessage();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e5.getMessage();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }

    public static boolean c(File file) throws Throwable {
        FileInputStream fileInputStream;
        boolean z = false;
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            file.getAbsolutePath();
            return false;
        }
        if (file.length() < 12) {
            file.getAbsolutePath();
            file.length();
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[12];
                    if (fileInputStream.read(bArr) < 12) {
                        file.getAbsolutePath();
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        return false;
                    }
                    if (bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112 && ((bArr[8] == 97 || bArr[9] == 118) && bArr[10] == 105 && bArr[11] == 102)) {
                        z = true;
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                    return z;
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.getMessage();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                            e4.getMessage();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e5.getMessage();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Movie b(java.io.File r11) throws java.io.IOException {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            boolean r2 = d(r11)
            r3 = 0
            if (r2 == 0) goto Lcb
            r2 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L44
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L44
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L40
            r6 = 1024(0x400, float:1.435E-42)
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L40
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L3e
        L1a:
            int r7 = r4.read(r6)     // Catch: java.lang.Throwable -> L3e
            if (r7 <= 0) goto L24
            r5.write(r6, r2, r7)     // Catch: java.lang.Throwable -> L3e
            goto L1a
        L24:
            r5.flush()     // Catch: java.lang.Throwable -> L3e
            byte[] r6 = r5.toByteArray()     // Catch: java.lang.Throwable -> L3e
            int r7 = r6.length     // Catch: java.lang.Throwable -> L3e
            android.graphics.Movie r6 = android.graphics.Movie.decodeByteArray(r6, r2, r7)     // Catch: java.lang.Throwable -> L3e
            r4.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r4 = move-exception
            r4.getMessage()
        L38:
            r5.close()     // Catch: java.lang.Exception -> L3c
            goto L62
        L3c:
            r4 = move-exception
            goto L5d
        L3e:
            r6 = move-exception
            goto L48
        L40:
            r5 = move-exception
            r6 = r5
            r5 = r3
            goto L48
        L44:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r5 = r4
        L48:
            r6.getMessage()     // Catch: java.lang.Throwable -> Lb5
            if (r4 == 0) goto L55
            r4.close()     // Catch: java.lang.Exception -> L51
            goto L55
        L51:
            r4 = move-exception
            r4.getMessage()
        L55:
            if (r5 == 0) goto L61
            r5.close()     // Catch: java.lang.Exception -> L5b
            goto L61
        L5b:
            r4 = move-exception
            r6 = r3
        L5d:
            r4.getMessage()
            goto L62
        L61:
            r6 = r3
        L62:
            if (r6 == 0) goto Lb3
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            long r0 = r11.length()
            float r0 = (float) r0
            r1 = 1149239296(0x44800000, float:1024.0)
            float r0 = r0 / r1
            int r1 = r6.width()
            int r7 = r6.height()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            int r10 = r6.duration()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.io.File r11 = r11.getAbsoluteFile()
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r2] = r0
            r0 = 1
            r5[r0] = r8
            r0 = 2
            r5[r0] = r9
            r0 = 3
            r5[r0] = r10
            r0 = 4
            r5[r0] = r4
            r0 = 5
            r5[r0] = r11
            java.lang.String r11 = "![%.2fKB, %d*%d, len=%dms, cost=%dms](%s)"
            java.lang.String.format(r11, r5)
            if (r1 == 0) goto Lcb
            if (r7 != 0) goto Lb3
            goto Lcb
        Lb3:
            r3 = r6
            goto Lcb
        Lb5:
            r11 = move-exception
            if (r4 == 0) goto Lc0
            r4.close()     // Catch: java.lang.Exception -> Lbc
            goto Lc0
        Lbc:
            r0 = move-exception
            r0.getMessage()
        Lc0:
            if (r5 == 0) goto Lca
            r5.close()     // Catch: java.lang.Exception -> Lc6
            goto Lca
        Lc6:
            r0 = move-exception
            r0.getMessage()
        Lca:
            throw r11
        Lcb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e5.b(java.io.File):android.graphics.Movie");
    }

    public static byte[] a(Bitmap bitmap, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return byteArray;
    }

    /* compiled from: A */
    public static class a {
        private int a;
        private int b;
        private boolean c;

        public final int b() {
            return this.a;
        }

        public final int a() {
            return this.b;
        }
    }

    private static int a(int i, int i2, int i3, int i4) {
        if (i > i3 || i2 > i4) {
            return Math.max(Math.round((i * 1.0f) / i3), Math.round((i2 * 1.0f) / i4));
        }
        return 1;
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        return a(options.outWidth, options.outHeight, i, i2);
    }

    public static Bitmap a(File file, ImageView imageView, boolean z) throws Throwable {
        if (z || c(file)) {
            Bitmap bitmapA = a(file, imageView);
            if (bitmapA != null) {
                return bitmapA;
            }
            if (Build.VERSION.SDK_INT < 31 || r1.d().f().a("ausl", 0) == 0) {
                return null;
            }
        }
        return a(file.getAbsolutePath(), imageView);
    }

    private static Bitmap a(String str, ImageView imageView) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(str, options);
        a aVarA = a(imageView, options.outWidth, options.outHeight);
        options.inSampleSize = a(options, aVarA.a, aVarA.b);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (aVarA.c) {
            bitmapDecodeFile = a(bitmapDecodeFile, aVarA.a, aVarA.b);
        }
        if (bitmapDecodeFile != null && c0.e().g()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis2 > 1000) {
                jCurrentTimeMillis2 = 1000;
            }
            b10.a(9130066, null, 2, Integer.valueOf((int) (jCurrentTimeMillis2 / 10)), null);
        }
        return bitmapDecodeFile;
    }

    public static Bitmap a(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            try {
                return BitmapFactory.decodeByteArray(bArr, 0, length);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }

    public static Bitmap a(Context context, int i) {
        if (i <= 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(context.getResources(), i);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static t a(File file, String str) {
        if (file != null && file.exists() && v.a(file)) {
            return t.a(file, str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0060 A[PHI: r2 r3
  0x0060: PHI (r2v1 int) = (r2v0 int), (r2v2 int), (r2v2 int), (r2v2 int), (r2v2 int), (r2v2 int), (r2v2 int) binds: [B:5:0x0014, B:14:0x0024, B:15:0x0026, B:26:0x0045, B:28:0x0049, B:30:0x004d, B:25:0x0040] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r3v5 int) = (r3v4 int), (r3v6 int), (r3v6 int), (r3v6 int), (r3v6 int), (r3v6 int), (r3v7 int) binds: [B:5:0x0014, B:14:0x0024, B:15:0x0026, B:26:0x0045, B:28:0x0049, B:30:0x004d, B:25:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qq.e.comm.plugin.e5.a a(android.widget.ImageView r7, int r8, int r9) {
        /*
            com.qq.e.comm.plugin.e5$a r0 = new com.qq.e.comm.plugin.e5$a
            r0.<init>()
            r1 = 0
            if (r7 == 0) goto L62
            int r2 = r7.getWidth()
            int r3 = r7.getHeight()
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L60
            if (r2 > 0) goto L1d
            int r4 = r7.width
            if (r4 <= 0) goto L1d
            r2 = r4
        L1d:
            if (r3 > 0) goto L24
            int r4 = r7.height
            if (r4 <= 0) goto L24
            r3 = r4
        L24:
            if (r8 <= 0) goto L60
            if (r9 <= 0) goto L60
            r4 = 1
            r5 = -2
            if (r2 <= 0) goto L45
            int r6 = r7.width
            if (r6 == r5) goto L45
            int r6 = r7.height
            if (r6 != r5) goto L45
            int r9 = r9 * r2
            float r7 = (float) r9
            float r9 = (float) r8
            float r7 = r7 / r9
            int r7 = java.lang.Math.round(r7)
            if (r8 <= r2) goto L40
            r1 = 1
        L40:
            com.qq.e.comm.plugin.e5.a.a(r0, r1)
            r3 = r7
            goto L60
        L45:
            if (r3 <= 0) goto L60
            int r6 = r7.height
            if (r6 == r5) goto L60
            int r7 = r7.width
            if (r7 != r5) goto L60
            int r8 = r8 * r3
            float r7 = (float) r8
            float r8 = (float) r9
            float r7 = r7 / r8
            int r7 = java.lang.Math.round(r7)
            if (r9 <= r3) goto L5b
            r1 = 1
        L5b:
            com.qq.e.comm.plugin.e5.a.a(r0, r1)
            r1 = r7
            goto L63
        L60:
            r1 = r2
            goto L63
        L62:
            r3 = 0
        L63:
            com.qq.e.comm.plugin.r1 r7 = com.qq.e.comm.plugin.r1.d()
            android.content.Context r7 = r7.a()
            if (r1 > 0) goto L71
            int r1 = com.qq.e.comm.plugin.yu.c(r7)
        L71:
            if (r3 > 0) goto L77
            int r3 = com.qq.e.comm.plugin.yu.a(r7)
        L77:
            com.qq.e.comm.plugin.e5.a.a(r0, r1)
            com.qq.e.comm.plugin.e5.a.b(r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e5.a(android.widget.ImageView, int, int):com.qq.e.comm.plugin.e5$a");
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || i == 0 || i2 == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && i2 == height) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df  */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.tencent.libavif.AvifDecoder] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.tencent.libavif.AvifDecoder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(java.io.File r7, android.widget.ImageView r8) throws java.lang.Throwable {
        /*
            com.qq.e.comm.plugin.c0 r0 = com.qq.e.comm.plugin.c0.e()
            boolean r0 = r0.j()
            r1 = 0
            if (r0 == 0) goto Le3
            com.qq.e.comm.plugin.c0 r0 = com.qq.e.comm.plugin.c0.e()
            boolean r0 = r0.f()
            if (r0 != 0) goto Le3
            long r2 = java.lang.System.currentTimeMillis()
            byte[] r7 = a(r7)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb8
            com.tencent.libavif.AvifDecoder r7 = com.tencent.libavif.AvifDecoder.fromByteArray(r7)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb8
            int r0 = r7.nextImage()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            if (r0 != 0) goto L9d
            int r0 = r7.getWidth()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            int r4 = r7.getHeight()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            com.qq.e.comm.plugin.e5$a r8 = a(r8, r0, r4)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            int r5 = com.qq.e.comm.plugin.e5.a.a(r8)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            int r6 = com.qq.e.comm.plugin.e5.a.b(r8)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            int r5 = a(r0, r4, r5, r6)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            r6 = 1
            if (r5 >= r6) goto L43
            r5 = 1
        L43:
            int r0 = r0 / r5
            int r4 = r4 / r5
            com.tencent.libavif.AvifImage r0 = r7.getScaledImage(r0, r4)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            android.graphics.Bitmap r4 = r0.getBitmap(r6)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            boolean r5 = com.qq.e.comm.plugin.e5.a.c(r8)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            if (r5 == 0) goto L5f
            int r5 = com.qq.e.comm.plugin.e5.a.a(r8)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            int r8 = com.qq.e.comm.plugin.e5.a.b(r8)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            android.graphics.Bitmap r4 = a(r4, r5, r8)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
        L5f:
            if (r4 == 0) goto L8a
            com.qq.e.comm.plugin.c0 r8 = com.qq.e.comm.plugin.c0.e()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            boolean r8 = r8.h()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            if (r8 == 0) goto L8a
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            long r5 = r5 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L77
            r5 = r2
        L77:
            r8 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            r2 = 10
            long r5 = r5 / r2
            int r2 = (int) r5     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            r3 = 9130066(0x8b5052, float:1.2793947E-38)
            com.qq.e.comm.plugin.b10.a(r3, r1, r8, r2, r1)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
        L8a:
            com.qq.e.comm.plugin.c0 r8 = com.qq.e.comm.plugin.c0.e()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            r8.a()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> Ld3
            r7.reset()
            r7.destroy()
            r0.destroy()
            return r4
        L9b:
            r8 = move-exception
            goto Lbb
        L9d:
            r7.getDiag()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            com.qq.e.comm.plugin.c0 r8 = com.qq.e.comm.plugin.c0.e()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            r8.b()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb2
            r7.reset()
            r7.destroy()
            goto Le3
        Lae:
            r8 = move-exception
            r0 = r1
        Lb0:
            r1 = r7
            goto Ld5
        Lb2:
            r8 = move-exception
            r0 = r1
            goto Lbb
        Lb5:
            r8 = move-exception
            r0 = r1
            goto Ld5
        Lb8:
            r8 = move-exception
            r7 = r1
            r0 = r7
        Lbb:
            r8.toString()     // Catch: java.lang.Throwable -> Ld3
            com.qq.e.comm.plugin.c0 r8 = com.qq.e.comm.plugin.c0.e()     // Catch: java.lang.Throwable -> Ld3
            r8.b()     // Catch: java.lang.Throwable -> Ld3
            if (r7 == 0) goto Lcd
            r7.reset()
            r7.destroy()
        Lcd:
            if (r0 == 0) goto Le3
            r0.destroy()
            goto Le3
        Ld3:
            r8 = move-exception
            goto Lb0
        Ld5:
            if (r1 == 0) goto Ldd
            r1.reset()
            r1.destroy()
        Ldd:
            if (r0 == 0) goto Le2
            r0.destroy()
        Le2:
            throw r8
        Le3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e5.a(java.io.File, android.widget.ImageView):android.graphics.Bitmap");
    }

    private static byte[] a(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}

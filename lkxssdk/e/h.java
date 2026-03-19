package lkxssdk.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class h {
    public Handler a = new Handler(Looper.getMainLooper());
    public int b;
    public int c;
    public Bitmap d;
    public String e;
    public boolean f;

    public interface a {
    }

    public static class b {
        public String a;
        public int b;
        public int c;
        public String d;
        public long e;
        public int f;

        public String a(String str) {
            String str2 = str + ",filePath:" + this.a + ",height:" + this.c + ",width:" + this.b + ",rotation:" + this.f + ",rate:" + this.e + ",size:" + this.d;
            lkxssdk.h0.c.b(str2);
            return str2;
        }
    }

    public interface c {
    }

    public h(Bitmap bitmap, int i, int i2) {
        this.d = bitmap;
        this.b = i;
        this.c = i2;
    }

    public final Bitmap a(Bitmap bitmap, String str) {
        int attributeInt;
        lkxssdk.h0.c.b(" getBitmap 3  ");
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
        if (i > 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        if (this.d == null) {
            return bitmap;
        }
        int iMin = (int) ((Math.min(bitmap.getWidth(), bitmap.getHeight()) * 4) / 15.0f);
        Rect rect = new Rect(bitmap.getWidth() - iMin, bitmap.getHeight() - iMin, bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap2 = this.d;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Log.e("tag", "rect1.left==" + rect.left + ",rect1.right==" + rect.right);
        Log.e("tag", "rect1.top==" + rect.top + ",rect1.bottom==" + rect.bottom);
        canvas.drawBitmap(bitmap2, (Rect) null, rect, paint);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public final b a(String str) throws IOException {
        b bVar = new b();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                bVar.a = str;
                mediaMetadataRetriever.setDataSource(str);
                bVar.c = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
                bVar.b = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
                bVar.e = Long.valueOf(mediaMetadataRetriever.extractMetadata(20)).longValue();
                bVar.f = Integer.valueOf(mediaMetadataRetriever.extractMetadata(24)).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bVar;
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final byte[] a(boolean z, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
            int i = 100;
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            if (this.c > 0) {
                while (i > 40 && byteArrayOutputStream.toByteArray().length / 1024 > this.c) {
                    byteArrayOutputStream.reset();
                    i -= 5;
                    bitmap.compress(compressFormat, i, byteArrayOutputStream);
                }
            }
            bitmap.recycle();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.graphics.Bitmap r12) {
        /*
            r11 = this;
            boolean r0 = r11.f
            if (r0 == 0) goto L66
            if (r12 == 0) goto L66
            int r0 = r12.getHeight()
            int r9 = r12.getWidth()
            int r1 = r9 * r0
            int[] r10 = new int[r1]
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r12
            r2 = r10
            r4 = r9
            r7 = r9
            r8 = r0
            r1.getPixels(r2, r3, r4, r5, r6, r7, r8)
            lkxssdk.n.h r12 = new lkxssdk.n.h
            r12.<init>(r9, r0, r10)
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            lkxssdk.n.e r1 = lkxssdk.n.e.CHARACTER_SET
            java.lang.String r2 = "UTF8"
            r0.put(r1, r2)
            lkxssdk.n.e r1 = lkxssdk.n.e.TRY_HARDER
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.put(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            lkxssdk.n.a r2 = lkxssdk.n.a.QR_CODE
            r1.add(r2)
            lkxssdk.n.e r2 = lkxssdk.n.e.POSSIBLE_FORMATS
            r0.put(r2, r1)
            lkxssdk.n.c r1 = new lkxssdk.n.c
            lkxssdk.o.e r2 = new lkxssdk.o.e
            r2.<init>(r12)
            r1.<init>(r2)
            lkxssdk.q.a r12 = new lkxssdk.q.a
            r12.<init>()
            lkxssdk.n.j r12 = r12.a(r1, r0)     // Catch: lkxssdk.n.f -> L58 lkxssdk.n.d -> L5a lkxssdk.n.g -> L5c
            goto L61
        L58:
            r12 = move-exception
            goto L5d
        L5a:
            r12 = move-exception
            goto L5d
        L5c:
            r12 = move-exception
        L5d:
            r12.printStackTrace()
            r12 = 0
        L61:
            if (r12 == 0) goto L66
            java.lang.String r12 = r12.a
            goto L68
        L66:
            java.lang.String r12 = ""
        L68:
            r11.e = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.e.h.b(android.graphics.Bitmap):void");
    }

    public final Bitmap a(Bitmap bitmap) {
        Rect rect;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect2 = new Rect(0, 0, width, height);
        if (height > width) {
            int i = this.b;
            rect = new Rect(0, 0, (int) (width * (i / height)), i);
        } else {
            int i2 = this.b;
            rect = new Rect(0, 0, i2, (int) (height * (i2 / width)));
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_4444);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, rect2, rect, new Paint(2));
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0052 A[PHI: r1
  0x0052: PHI (r1v6 int) = (r1v5 int), (r1v7 int) binds: [B:30:0x004f, B:23:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(java.lang.String r8, int r9, int r10) {
        /*
            r7 = this;
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L65
            r0.<init>()     // Catch: java.lang.Exception -> L65
            int r1 = r9 % 2
            r2 = 1
            if (r1 != r2) goto Lc
            int r9 = r9 + 1
        Lc:
            int r1 = r10 % 2
            if (r1 != r2) goto L12
            int r10 = r10 + 1
        L12:
            int r1 = java.lang.Math.max(r9, r10)     // Catch: java.lang.Exception -> L65
            int r9 = java.lang.Math.min(r9, r10)     // Catch: java.lang.Exception -> L65
            float r9 = (float) r9     // Catch: java.lang.Exception -> L65
            float r10 = (float) r1     // Catch: java.lang.Exception -> L65
            float r9 = r9 / r10
            r10 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            r3 = 4603241769126068224(0x3fe2000000000000, double:0.5625)
            if (r10 > 0) goto L42
            double r5 = (double) r9     // Catch: java.lang.Exception -> L65
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 <= 0) goto L42
            r9 = 1664(0x680, float:2.332E-42)
            if (r1 >= r9) goto L2f
            goto L5e
        L2f:
            r9 = 4990(0x137e, float:6.992E-42)
            if (r1 >= r9) goto L35
            r2 = 2
            goto L5e
        L35:
            if (r1 <= r9) goto L3d
            r9 = 10240(0x2800, float:1.4349E-41)
            if (r1 >= r9) goto L3d
            r2 = 4
            goto L5e
        L3d:
            int r1 = r1 / 1280
            if (r1 != 0) goto L52
            goto L5e
        L42:
            double r9 = (double) r9     // Catch: java.lang.Exception -> L65
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 > 0) goto L54
            r3 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 <= 0) goto L54
            int r1 = r1 / 1280
            if (r1 != 0) goto L52
            goto L5e
        L52:
            r2 = r1
            goto L5e
        L54:
            double r1 = (double) r1     // Catch: java.lang.Exception -> L65
            r3 = 4653344314980564992(0x4094000000000000, double:1280.0)
            double r3 = r3 / r9
            double r1 = r1 / r3
            double r9 = java.lang.Math.ceil(r1)     // Catch: java.lang.Exception -> L65
            int r2 = (int) r9     // Catch: java.lang.Exception -> L65
        L5e:
            r0.inSampleSize = r2     // Catch: java.lang.Exception -> L65
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeFile(r8, r0)     // Catch: java.lang.Exception -> L65
            return r8
        L65:
            r8 = move-exception
            r8.printStackTrace()
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.e.h.a(java.lang.String, int, int):android.graphics.Bitmap");
    }
}

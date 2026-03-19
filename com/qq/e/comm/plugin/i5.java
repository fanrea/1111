package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.ko;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i5 {
    private static final String a = "com.qq.e.comm.plugin.i5";
    private static final LruCache<String, SoftReference<Bitmap>> b = new LruCache<>(5);

    /* compiled from: A */
    public interface c {
        void a(ko koVar);
    }

    /* compiled from: A */
    class a implements nm {
        final /* synthetic */ String a;
        final /* synthetic */ float b;
        final /* synthetic */ c c;

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
        }

        a(String str, float f, c cVar) {
            this.a = str;
            this.b = f;
            this.c = cVar;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            i5.b(true, this.a, koVar.b(), this.b, this.c);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ Bitmap a;
        final /* synthetic */ float b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;
        final /* synthetic */ c e;

        b(Bitmap bitmap, float f, String str, boolean z, c cVar) {
            this.a = bitmap;
            this.b = f;
            this.c = str;
            this.d = z;
            this.e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Bitmap bitmapB = i5.b(this.a, this.b);
            String unused = i5.a;
            System.currentTimeMillis();
            wt wtVar = new wt(2130002);
            wtVar.b(System.currentTimeMillis() - jCurrentTimeMillis);
            b10.a(wtVar);
            if (this.d) {
                i5.b.put(this.c, new SoftReference(bitmapB));
            }
            xo.a((Runnable) new a(bitmapB));
        }

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ Bitmap a;

            a(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.e.a(new ko.b().a(this.a).b(false).a());
            }
        }
    }

    public static void a(Object obj, Bitmap bitmap, float f, c cVar) {
        if (!(obj instanceof String) && !(obj instanceof File)) {
            b(false, null, bitmap, f, cVar);
        } else {
            b(true, a(obj, f), bitmap, f, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(android.graphics.Bitmap r8, float r9) {
        /*
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            int r0 = java.lang.Math.min(r0, r1)
            if (r0 <= 0) goto L18
            float r0 = (float) r0
            r1 = 1125515264(0x43160000, float:150.0)
            float r1 = r1 / r0
            goto L1a
        L18:
            r1 = 1065353216(0x3f800000, float:1.0)
        L1a:
            r0 = 1048576000(0x3e800000, float:0.25)
            float r0 = java.lang.Math.min(r1, r0)
            r5.preScale(r0, r0)
            int r3 = r8.getWidth()
            int r4 = r8.getHeight()
            r1 = 0
            r2 = 0
            r6 = 0
            r0 = r8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            r2 = 1
            android.graphics.Bitmap r2 = r0.copy(r1, r2)
            int r3 = r2.getWidth()
            int r4 = r2.getHeight()
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r3, r4, r1)
            r8.getWidth()
            r8.getHeight()
            r1.getWidth()
            r1.getHeight()
            int r8 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r8 >= r3) goto L59
            return r1
        L59:
            r8 = 0
            com.qq.e.comm.plugin.r1 r3 = com.qq.e.comm.plugin.r1.d()     // Catch: java.lang.Throwable -> La5
            android.content.Context r3 = r3.a()     // Catch: java.lang.Throwable -> La5
            android.renderscript.RenderScript r3 = android.renderscript.RenderScript.create(r3)     // Catch: java.lang.Throwable -> La5
            android.renderscript.Allocation r4 = android.renderscript.Allocation.createFromBitmap(r3, r2)     // Catch: java.lang.Throwable -> La0
            android.renderscript.Allocation r5 = android.renderscript.Allocation.createFromBitmap(r3, r1)     // Catch: java.lang.Throwable -> L9d
            android.renderscript.Element r6 = r4.getElement()     // Catch: java.lang.Throwable -> L97
            android.renderscript.ScriptIntrinsicBlur r8 = android.renderscript.ScriptIntrinsicBlur.create(r3, r6)     // Catch: java.lang.Throwable -> L97
            r8.setRadius(r9)     // Catch: java.lang.Throwable -> L97
            r8.setInput(r4)     // Catch: java.lang.Throwable -> L97
            r8.forEach(r5)     // Catch: java.lang.Throwable -> L97
            r5.copyTo(r1)     // Catch: java.lang.Throwable -> L97
            if (r3 == 0) goto L87
            r3.destroy()
        L87:
            r0.recycle()
            r2.recycle()
            r4.destroy()
            r5.destroy()
            r8.destroy()
            goto Lc7
        L97:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r3
            r3 = r7
            goto Laa
        L9d:
            r9 = move-exception
            r5 = r8
            goto La3
        La0:
            r9 = move-exception
            r4 = r8
            r5 = r4
        La3:
            r8 = r3
            goto La8
        La5:
            r9 = move-exception
            r4 = r8
            r5 = r4
        La8:
            r3 = r9
            r9 = r5
        Laa:
            r3.getMessage()     // Catch: java.lang.Throwable -> Lc8
            if (r8 == 0) goto Lb2
            r8.destroy()
        Lb2:
            r0.recycle()
            r2.recycle()
            if (r4 == 0) goto Lbd
            r4.destroy()
        Lbd:
            if (r5 == 0) goto Lc2
            r5.destroy()
        Lc2:
            if (r9 == 0) goto Lc7
            r9.destroy()
        Lc7:
            return r1
        Lc8:
            r1 = move-exception
            if (r8 == 0) goto Lce
            r8.destroy()
        Lce:
            r0.recycle()
            r2.recycle()
            if (r4 == 0) goto Ld9
            r4.destroy()
        Ld9:
            if (r5 == 0) goto Lde
            r5.destroy()
        Lde:
            if (r9 == 0) goto Le3
            r9.destroy()
        Le3:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.i5.b(android.graphics.Bitmap, float):android.graphics.Bitmap");
    }

    public static void a(String str, float f, c cVar) throws JSONException {
        Bitmap bitmap;
        String strA = a(str, f);
        SoftReference<Bitmap> softReference = b.get(strA);
        if (softReference != null && (bitmap = softReference.get()) != null) {
            cVar.a(new ko.b().a(bitmap).b(true).a());
        } else {
            mm.a().a(str, (ImageView) null, new a(strA, f, cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, String str, Bitmap bitmap, float f, c cVar) {
        SoftReference<Bitmap> softReference;
        Bitmap bitmap2;
        if (bitmap == null) {
            return;
        }
        if (z && (softReference = b.get(str)) != null && (bitmap2 = softReference.get()) != null) {
            cVar.a(new ko.b().a(bitmap2).b(true).a());
        } else {
            qg.b.submit(new b(bitmap, f, str, z, cVar));
        }
    }

    private static String a(Object obj, float f) {
        String strA;
        if (obj instanceof String) {
            strA = gp.a((String) obj);
        } else {
            strA = obj instanceof File ? gp.a(((File) obj).getAbsolutePath()) : "";
        }
        return strA + Config.replace + f;
    }
}

package com.bytedance.sdk.component.adexpress.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap d(android.content.Context r5, android.graphics.Bitmap r6, int r7) {
        /*
            r0 = 0
            boolean r1 = com.bytedance.sdk.component.adexpress.c.d()     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto Le
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L8c
            r2 = 26
            if (r1 >= r2) goto Le
            return r0
        Le:
            if (r6 == 0) goto L8b
            boolean r1 = r6.isRecycled()     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L18
            goto L8b
        L18:
            int r1 = r6.getWidth()     // Catch: java.lang.Throwable -> L8c
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L8c
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Throwable -> L8c
            int r3 = r6.getHeight()     // Catch: java.lang.Throwable -> L8c
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L8c
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)     // Catch: java.lang.Throwable -> L8c
            r3 = 0
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r1, r2, r3)     // Catch: java.lang.Throwable -> L8c
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6)     // Catch: java.lang.Throwable -> L8c
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch: java.lang.Throwable -> L8c
            if (r5 != 0) goto L44
            if (r5 == 0) goto L43
            r5.destroy()
        L43:
            return r0
        L44:
            android.renderscript.Element r2 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.Throwable -> L83
            android.renderscript.ScriptIntrinsicBlur r2 = android.renderscript.ScriptIntrinsicBlur.create(r5, r2)     // Catch: java.lang.Throwable -> L83
            android.renderscript.Allocation r6 = android.renderscript.Allocation.createFromBitmap(r5, r6)     // Catch: java.lang.Throwable -> L7f
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r5, r1)     // Catch: java.lang.Throwable -> L78
            float r7 = (float) r7
            r2.setRadius(r7)     // Catch: java.lang.Throwable -> L76
            r2.setInput(r6)     // Catch: java.lang.Throwable -> L76
            r2.forEach(r3)     // Catch: java.lang.Throwable -> L76
            r3.copyTo(r1)     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L66
            r6.destroy()
        L66:
            if (r3 == 0) goto L6b
            r3.destroy()
        L6b:
            if (r2 == 0) goto L70
            r2.destroy()
        L70:
            if (r5 == 0) goto L75
            r5.destroy()
        L75:
            return r1
        L76:
            r7 = move-exception
            goto L7a
        L78:
            r7 = move-exception
            r3 = r0
        L7a:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L91
        L7f:
            r6 = move-exception
            r7 = r0
            r3 = r7
            goto L87
        L83:
            r6 = move-exception
            r7 = r0
            r2 = r7
            r3 = r2
        L87:
            r4 = r6
            r6 = r5
            r5 = r4
            goto L91
        L8b:
            return r0
        L8c:
            r5 = move-exception
            r6 = r0
            r7 = r6
            r2 = r7
            r3 = r2
        L91:
            com.bytedance.sdk.component.utils.mq.d(r5)     // Catch: java.lang.Throwable -> La9
            if (r7 == 0) goto L99
            r7.destroy()
        L99:
            if (r3 == 0) goto L9e
            r3.destroy()
        L9e:
            if (r2 == 0) goto La3
            r2.destroy()
        La3:
            if (r6 == 0) goto La8
            r6.destroy()
        La8:
            return r0
        La9:
            r5 = move-exception
            if (r7 == 0) goto Laf
            r7.destroy()
        Laf:
            if (r3 == 0) goto Lb4
            r3.destroy()
        Lb4:
            if (r2 == 0) goto Lb9
            r2.destroy()
        Lb9:
            if (r6 == 0) goto Lbe
            r6.destroy()
        Lbe:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.c.hc.d(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}

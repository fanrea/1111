package com.alliance.ssp.ad.o0;

/* compiled from: BitmapUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000e, B:10:0x001a, B:11:0x0030, B:13:0x0036, B:15:0x003a, B:17:0x0040), top: B:23:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.ref.WeakReference r2, android.widget.ImageView r3, java.lang.String r4, float r5) {
        /*
            r0 = 17
            if (r2 == 0) goto L30
            java.lang.Object r1 = r2.get()     // Catch: java.lang.Exception -> L50
            if (r1 == 0) goto L30
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L50
            if (r1 < r0) goto L56
            java.lang.Object r0 = r2.get()     // Catch: java.lang.Exception -> L50
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L50
            boolean r0 = r0.isDestroyed()     // Catch: java.lang.Exception -> L50
            if (r0 != 0) goto L56
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L50
            android.app.Activity r2 = (android.app.Activity) r2     // Catch: java.lang.Exception -> L50
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch: java.lang.Exception -> L50
            com.bumptech.glide.RequestBuilder r2 = r2.load(r4)     // Catch: java.lang.Exception -> L50
            com.bumptech.glide.RequestBuilder r2 = r2.thumbnail(r5)     // Catch: java.lang.Exception -> L50
            r2.into(r3)     // Catch: java.lang.Exception -> L50
            goto L56
        L30:
            android.app.Activity r2 = com.alliance.ssp.ad.o0.b.b()     // Catch: java.lang.Exception -> L50
            if (r2 == 0) goto L56
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L50
            if (r1 < r0) goto L56
            boolean r0 = r2.isDestroyed()     // Catch: java.lang.Exception -> L50
            if (r0 != 0) goto L56
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch: java.lang.Exception -> L50
            com.bumptech.glide.RequestBuilder r2 = r2.load(r4)     // Catch: java.lang.Exception -> L50
            com.bumptech.glide.RequestBuilder r2 = r2.thumbnail(r5)     // Catch: java.lang.Exception -> L50
            r2.into(r3)     // Catch: java.lang.Exception -> L50
            goto L56
        L50:
            r2 = move-exception
            r2.getMessage()
            int r2 = com.alliance.ssp.ad.o0.l.a
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.o0.d.a(java.lang.ref.WeakReference, android.widget.ImageView, java.lang.String, float):void");
    }
}

package com.bytedance.bdtracker;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w1 extends l1 {
    public final Context e;
    public final d f;

    public w1(d dVar, Context context) {
        super(true, false);
        this.f = dVar;
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Display";
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    @Override // com.bytedance.bdtracker.l1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r6 = this;
            android.content.Context r0 = r6.e
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.densityDpi
            switch(r0) {
                case 120: goto L1e;
                case 240: goto L1b;
                case 260: goto L18;
                case 280: goto L18;
                case 300: goto L18;
                case 320: goto L18;
                case 340: goto L15;
                case 360: goto L15;
                case 400: goto L15;
                case 420: goto L15;
                case 440: goto L15;
                case 480: goto L15;
                case 560: goto L12;
                case 640: goto L12;
                default: goto Lf;
            }
        Lf:
            java.lang.String r1 = "mdpi"
            goto L20
        L12:
            java.lang.String r1 = "xxxhdpi"
            goto L20
        L15:
            java.lang.String r1 = "xxhdpi"
            goto L20
        L18:
            java.lang.String r1 = "xhdpi"
            goto L20
        L1b:
            java.lang.String r1 = "hdpi"
            goto L20
        L1e:
            java.lang.String r1 = "ldpi"
        L20:
            java.lang.String r2 = "density_dpi"
            r7.put(r2, r0)
            java.lang.String r0 = "display_density"
            r7.put(r0, r1)
            android.content.Context r0 = r6.e
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r2 = 0
            if (r0 == 0) goto L50
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L88
            r4 = 17
            if (r3 < r4) goto L50
            r0.getRealMetrics(r1)     // Catch: java.lang.Throwable -> L88
            int r0 = r1.widthPixels     // Catch: java.lang.Throwable -> L88
            int r1 = r1.heightPixels     // Catch: java.lang.Throwable -> L4e
            goto L83
        L4e:
            r1 = move-exception
            goto L8a
        L50:
            java.lang.Class<android.view.Display> r1 = android.view.Display.class
            java.lang.String r3 = "getRawHeight"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L88
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L88
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawWidth"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L88
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L88
            if (r3 == 0) goto L73
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L88
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch: java.lang.Throwable -> L88
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L88
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L88
            goto L74
        L73:
            r3 = r2
        L74:
            if (r1 == 0) goto L96
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L85
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch: java.lang.Throwable -> L85
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L85
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L85
            r0 = r3
        L83:
            r3 = r0
            goto L97
        L85:
            r1 = move-exception
            r0 = r3
            goto L8a
        L88:
            r1 = move-exception
            r0 = r2
        L8a:
            com.bytedance.bdtracker.d r3 = r6.f
            com.bytedance.applog.log.IAppLogLogger r3 = r3.D
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "Get screen pixels failed"
            r3.error(r5, r1, r4)
            r3 = r0
        L96:
            r1 = r2
        L97:
            r0 = 2
            int[] r0 = new int[r0]
            r0[r2] = r3
            r3 = 1
            r0[r3] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = r0[r3]
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = "x"
            java.lang.StringBuilder r1 = r1.append(r4)
            r0 = r0[r2]
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "resolution"
            r7.put(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w1.a(org.json.JSONObject):boolean");
    }
}

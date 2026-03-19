package com.alliance.ssp.ad.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

/* compiled from: MemoryAndDiskCache.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements c {
    public e a;
    public a b;

    public d(Context context) {
        try {
            this.a = new e();
            this.b = new a(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:12:0x001c, B:14:0x0020), top: B:19:0x0001 }] */
    @Override // com.alliance.ssp.ad.s.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            com.alliance.ssp.ad.s.e r1 = r3.a     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L18
            r1.getClass()     // Catch: java.lang.Exception -> L25
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L25
            if (r2 == 0) goto Lf
            goto L18
        Lf:
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r1 = r1.a     // Catch: java.lang.Exception -> L25
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Exception -> L25
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch: java.lang.Exception -> L25
            goto L19
        L18:
            r1 = r0
        L19:
            if (r1 == 0) goto L1c
            return r1
        L1c:
            com.alliance.ssp.ad.s.a r1 = r3.b     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L29
            android.graphics.Bitmap r4 = r1.a(r4)     // Catch: java.lang.Exception -> L25
            return r4
        L25:
            r4 = move-exception
            r4.printStackTrace()
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.s.d.a(java.lang.String):android.graphics.Bitmap");
    }

    @Override // com.alliance.ssp.ad.s.c
    public void a(String str, Bitmap bitmap) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e eVar = this.a;
            if (eVar != null && !TextUtils.isEmpty(str)) {
                eVar.a.put(str, bitmap);
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(str, bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
